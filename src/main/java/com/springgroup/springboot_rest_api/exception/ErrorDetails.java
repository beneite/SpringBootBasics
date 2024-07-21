package com.springgroup.springboot_rest_api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private LocalDateTime timeStamp;
    private String errorCode;
    private String errorMessage;
    private String path;
}
