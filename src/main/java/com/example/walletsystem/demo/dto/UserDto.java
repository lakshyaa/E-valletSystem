package com.example.walletsystem.demo.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import com.example.walletsystem.demo.UniqueUserName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty(message="Please enter your firstname")
    private String firstname;
    @NotEmpty(message="Please enter your lastname")
    private String lastname;
    @NotEmpty(message="Please enter a username")
    @UniqueUserName
    private String username;
    @NotEmpty(message="Please enter an email")
    @Email(message="Email is not valid")
    private String email;
    @NotEmpty(message="Please enter in a password")
    private String password;
    @NotEmpty(message="Please confirm your password")
    private String confirmPassword;

}
