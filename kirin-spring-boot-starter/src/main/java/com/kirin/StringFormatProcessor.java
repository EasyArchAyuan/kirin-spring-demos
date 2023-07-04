package com.kirin;

import org.springframework.stereotype.Component;

@Component
public class StringFormatProcessor implements FormatProcessor {
    public <T> String format(T obj) {
        return "StringFormatProcessor:" + obj;
    }
}