package com.treelog.treeback.Exception;

import com.treelog.treeback.Util.ErrorHTTPStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorResponseEntity {
    private int status;
    private String code;
    private String message;

    public static ResponseEntity<ErrorResponseEntity> toResponseEntity(ErrorHTTPStatus e){
        return ResponseEntity
                .status(e.getCode())
                .body(ErrorResponseEntity.builder()
                        .status(e.getCode())
                        .code(e.name())
                        .message(e.getMessage())
                        .build());
    }
}
