package com.business.intelligence.builder;

import com.business.intelligence.constant.CommonConstant;
import com.business.intelligence.dto.ServerResponse;

public class ResponseMsg {
    public static ServerResponse success(String msg) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(CommonConstant.Status.SUCCESS);
        serverResponse.setSuccess(true);
        serverResponse.setMsg(msg);

        return serverResponse;
    }

    public static ServerResponse success(Object obj, String msg) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(CommonConstant.Status.SUCCESS);
        serverResponse.setSuccess(true);
        serverResponse.setMsg(msg);
        serverResponse.setData(obj);

        return serverResponse;
    }

    public static ServerResponse failed(String msg) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(CommonConstant.Status.FAILED);
        serverResponse.setSuccess(false);
        serverResponse.setMsg(msg);

        return serverResponse;
    }
}
