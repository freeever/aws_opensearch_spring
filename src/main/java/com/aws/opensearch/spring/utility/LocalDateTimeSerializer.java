package com.aws.opensearch.spring.utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private static final Logger log = LoggerFactory.getLogger(LocalDateTimeSerializer.class);

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        try {
            String s = value.format(DateUtils.DEFAULT_DATETIME_PATTERN);
            gen.writeString(s);
        } catch (DateTimeParseException e) {
            log.error("Failed to serialize datetime", e);
            gen.writeString("");
        }
    }
}
