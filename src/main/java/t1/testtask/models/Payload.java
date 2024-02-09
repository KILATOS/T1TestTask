package t1.testtask.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Payload {
    @Getter
    @Setter
    private String stringToOperate;
}
