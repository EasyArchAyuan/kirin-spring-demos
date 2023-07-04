package com.kirin;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FormatAutoConfiguration.class)
@Configuration
public class HelloAutoConfiguration {
    public HelloFormatTemplate helloFormatTemplate(FormatProcessor formatProcessor) {
        return new HelloFormatTemplate(formatProcessor);
    }
}