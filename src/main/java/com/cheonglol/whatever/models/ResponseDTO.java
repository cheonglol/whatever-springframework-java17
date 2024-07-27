package com.cheonglol.whatever.models;

public class ResponseDTO {

    private boolean success;
    private Object data;
    private String message;

    public ResponseDTO(boolean isSuccessful, Object data, String message) {
        this.success = isSuccessful;
        this.data = data;
        this.message = message;
    }

    // GET SET SHIT
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}