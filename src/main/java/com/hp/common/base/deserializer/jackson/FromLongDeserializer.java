package com.hp.common.base.deserializer.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

/**
 * This deserializer is primarily used when deserializing objects serialized by Spring Data using JSON.
 *
 * @author hp
 */
public final class FromLongDeserializer {

    public static class ToLocalDateTime extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Optional.ofNullable(p.readValueAs(Long.class)).map(l -> LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault())).orElse(null);
        }
    }

    public static class ToInstant extends JsonDeserializer<Instant> {

        @Override
        public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Optional.ofNullable(p.readValueAs(Long.class)).map(Instant::ofEpochMilli).orElse(null);
        }
    }

}
