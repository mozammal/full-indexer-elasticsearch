package com.mozammal.fullindexerelasticsearch.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class JsonDateTimeSerializer extends JsonSerializer<ZonedDateTime> {
  @Override
  public void serialize(ZonedDateTime date, JsonGenerator generator, SerializerProvider arg)
      throws IOException, JsonProcessingException {
    final String dateString = date.format(ISO_OFFSET_DATE_TIME);
    generator.writeString(dateString);
  }
}
