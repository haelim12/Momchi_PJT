package com.momchi.back.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
     ErrorHTTPStatus httpStatus;
}
