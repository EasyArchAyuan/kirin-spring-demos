package com.kirin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloFormatTemplate {

    @Autowired
    private FormatProcessor formatProcessor;

    public HelloFormatTemplate(FormatProcessor formatProcessor) {
        this.formatProcessor = formatProcessor;
    }

    public <T> String doFormat(T obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Execute format:").append("\n").append("Obj format result:").append(formatProcessor.format(obj)).append("\n");
        return stringBuilder.toString();
    }
}