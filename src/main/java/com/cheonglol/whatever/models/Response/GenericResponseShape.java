package com.cheonglol.whatever.models.Response;

public class GenericResponseShape {

    private boolean success;
    private Object data;
    private String message;

    public GenericResponseShape(boolean isSuccessful, Object data, String message) {

        this.success = isSuccessful;
        this.data = data;

        if (message.equals(null) || message.isEmpty()) {
            this.message = "";
        } else {
            this.message = message;
        }

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

    // MAGIC SHIT
    // public HashMap<String, Object> buildResponseHashMap() {
    // return new HashMap<String, Object>() {{
    // put("success", );
    // put(message, data);
    // put(message, data);
    // }};
    // }
}