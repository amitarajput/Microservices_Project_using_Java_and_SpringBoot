package com.amita.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // to build the object of the class
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
