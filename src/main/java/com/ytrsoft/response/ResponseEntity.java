package com.ytrsoft.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
@Getter
public class ResponseEntity<T> implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private int statusCode = ResponseStatus.SUCCEED.code();

    private String statusMessage = ResponseStatus.SUCCEED.message();

    public static <T> ResponseEntity<T> succeed() {
        return new ResponseEntity<>();
    }

    public static <T> ResponseEntity<T> succeed(T data) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setData(data);
        return entity;
    }

    public static <T> ResponseEntity<T> succeed(T data, String statusMessage) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setData(data);
        entity.setStatusMessage(statusMessage);
        return entity;
    }

    public static <T> ResponseEntity<T> failed(int code, String statusMessage) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatusCode(code);
        entity.setStatusMessage(statusMessage);
        return entity;
    }

    public static <T> ResponseEntity<T> status(ResponseStatus status) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatusCode(status.code());
        entity.setStatusMessage(status.message());
        return entity;
    }

}
