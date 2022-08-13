package com.aws.opensearch.spring.utility;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class LocalDatetimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final Logger log = LoggerFactory.getLogger(LocalDatetimeDeserializer.class);

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctx)
        throws IOException {
        String str = p.getText();
        try {
            return StringUtils.isBlank(str) ? null
                : LocalDateTime.parse(str, DateUtils.DEFAULT_DATETIME_PATTERN);
        } catch (DateTimeParseException e) {
            log.error("Failed to parse datetime " + str, e);
            return null;
        }
    }
}
