package vn.iotstar.security.model;

import lombok.Data;

@Data
public class LoginDto {


        private String usernameOrEmail;
        private String password;

}
