package vn.iotstar.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {
    private String token;
    private Long expiresIn  ;
    public String getToken() {
        return token;
    }
}
