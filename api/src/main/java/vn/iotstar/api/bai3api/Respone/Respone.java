package vn.iotstar.api.bai3api.Respone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respone {
    private Boolean status;
    private String message;
    private Object body;
}
