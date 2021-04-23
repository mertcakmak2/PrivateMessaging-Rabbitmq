package com.springdata.privatemessage.Dtos.UserDtos;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String email;
    private String password;
}
