package com.kirin;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

@Component
public class JsonFormatProcessor implements FormatProcessor {
    public <T> String format(T obj) {
        return "JsonFormatProcess:" + JSON.toJSONString(obj);
    }
}