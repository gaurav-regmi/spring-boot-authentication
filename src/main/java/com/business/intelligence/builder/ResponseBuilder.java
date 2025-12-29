package com.business.intelligence.builder;

import com.business.intelligence.constant.CommonConstant;
import com.business.intelligence.dto.GenericResponse;
import com.business.intelligence.dto.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    public static ResponseEntity<GenericResponse> response(ServerResponse serverResponse) {
        GenericResponse response = new GenericResponse();

        if (serverResponse.isSuccess()) {
            response.setCode(serverResponse.getCode());
            response.setMsg(serverResponse.getMsg());
            response.setSuccess(true);
            response.setData(serverResponse.getData());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setCode(serverResponse.getCode());
            response.setMsg(serverResponse.getMsg());
            response.setSuccess(false);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static GenericResponse buildResponse(ServerResponse serverResponse) {
        GenericResponse response = new GenericResponse();

        if (serverResponse.isSuccess()) {
            response.setCode(serverResponse.getCode());
            response.setMsg(serverResponse.getMsg());
            response.setSuccess(true);
            response.setData(serverResponse.getData());
        } else {
            response.setCode(serverResponse.getCode());
            response.setMsg(serverResponse.getMsg());
            response.setSuccess(false);
        }

        return response;
    }

    public static GenericResponse buildFailedResponse(String msg) {
        GenericResponse response = new GenericResponse();
        response.setCode(CommonConstant.Status.FAILED);
        response.setMsg(msg);
        response.setSuccess(false);

        return response;
    }
}
