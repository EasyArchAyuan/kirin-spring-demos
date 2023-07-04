package com.kirin.spring.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressParam {

    @NotEmpty(message = "could not be empty")
    private String addressNo;

    @NotEmpty(message = "could not be empty")
    private String addressInfo;
}
