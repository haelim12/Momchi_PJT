package com.treelog.treeback.Exception;

import com.treelog.treeback.Util.ErrorHTTPStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    ErrorHTTPStatus httpStatus;
}
