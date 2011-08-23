package org.noisyteam.samples.spring.jackson.json;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class NullSerializer extends JsonSerializer<Object> {
    public void serialize(Object value, JsonGenerator jgen,
                          SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeString("");
    }
}
