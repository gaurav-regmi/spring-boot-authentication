package com.business.intelligence.exception;

import com.business.intelligence.builder.ResponseBuilder;
import com.business.intelligence.builder.ResponseMsg;
import com.business.intelligence.constant.MsgConstant;
import com.business.intelligence.dto.GenericResponse;
import com.business.intelligence.dto.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        ServerResponse serverResponse = ResponseMsg.failed(MsgConstant.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(ResponseBuilder.buildResponse(serverResponse), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<?> handleGeneralException(InvalidDataException ex) {
        GenericResponse response = ResponseBuilder.buildFailedResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleAuthenticationException(BadCredentialsException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ResponseBuilder.buildFailedResponse(MsgConstant.User.INVALID_CREDENTIALS));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handleAuthenticationException(UnauthorizedException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ResponseBuilder.buildFailedResponse("Authentication failed: " + ex.getMessage()));
    }
}
