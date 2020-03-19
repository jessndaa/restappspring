package com.developper.restapp.object;

/**
 * HttpOkResponse
 */
public class HttpResponse {

    int status;
    String message;

    public HttpResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus(){
        return status;
    }
    public String getMessage(){
        return message;
    }
}