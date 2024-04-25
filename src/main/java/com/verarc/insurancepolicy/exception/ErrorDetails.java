package com.verarc.insurancepolicy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    LocalDateTime timeStamp;
    String message;
    String description;
}
