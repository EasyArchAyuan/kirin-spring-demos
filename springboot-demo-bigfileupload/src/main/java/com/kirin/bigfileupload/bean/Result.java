package com.kirin.bigfileupload.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private Integer code;

    private String message;

    private Object data;
}
