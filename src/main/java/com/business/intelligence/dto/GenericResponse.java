package com.business.intelligence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse {
    private String code;
    private boolean success;
    private String msg;
    private Object data;
}
