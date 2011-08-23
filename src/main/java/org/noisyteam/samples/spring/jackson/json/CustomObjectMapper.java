package org.noisyteam.samples.spring.jackson.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        StdSerializerProvider sp = new StdSerializerProvider();
        sp.setNullValueSerializer(new NullSerializer());
        this.setSerializerProvider(sp);
    }
}
