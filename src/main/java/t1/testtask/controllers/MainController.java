package t1.testtask.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import t1.testtask.models.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import t1.testtask.services.StringFrequencyCounter;
import t1.testtask.util.exceptions.EmptyInputDataException;
import t1.testtask.util.exceptions.EmptyInputDataResponse;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@RestController
@Tag(name = "Counter Controller", description = "Contains one method, which counts char`s frequency in inputted String")
public class MainController {
    @Operation(
            summary = "Counts char`s frequency",
            description = "Get a JSON object of model Payload, paste data from it to the service, returns JSON, which " +
                    "represents each character and ones frequency ordered by last one in decreasing order"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = EmptyInputDataResponse.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/countFrequency")
    public List<String> getCharFrequency(@RequestBody Payload payload){
        if (payload.getStringToOperate() == null){
            throw new EmptyInputDataException("Inputted string is empty");
        }
        System.out.println(payload.getStringToOperate());
        return StringFrequencyCounter.count(payload.getStringToOperate());
    }

    @ExceptionHandler
    private ResponseEntity<EmptyInputDataResponse> emptyDataExceptionHandler(EmptyInputDataException e){
        EmptyInputDataResponse emptyInputDataResponse = new EmptyInputDataResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(emptyInputDataResponse, HttpStatus.BAD_REQUEST);

    }

}
