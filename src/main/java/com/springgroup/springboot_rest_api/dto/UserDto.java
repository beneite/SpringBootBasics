package com.springgroup.springboot_rest_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    // validate the firstName should not be null/empty
    @NotEmpty(message = "firstName should not be null or empty")
    private String firstName;

    // validate the lastName should not be null/empty
    @NotEmpty(message = "lastName should not be null or empty")
    private String lastName;

    // validate the lastName should not be null/empty
    // validate email is having valid format
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email should be Formatted")
    private String email;
}
