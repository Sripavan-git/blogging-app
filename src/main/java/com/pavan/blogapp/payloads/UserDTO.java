package com.pavan.blogapp.payloads;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {


    private Long id;

    @NotEmpty
    @Size(min = 4, message = "Name must be minimum of 4 Characters long")
    private String name;

    @Email(message = "Email Address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be minimum of 3 and maximum of 10 Characters long")
    private String password;

    @NotEmpty
    @Size(min = 5, message = "About must be minimum of 5 characters long")
    private String about;
}
