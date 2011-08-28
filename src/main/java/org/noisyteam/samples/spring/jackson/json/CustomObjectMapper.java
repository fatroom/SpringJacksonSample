package org.noisyteam.samples.spring.jackson.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StdSerializerProvider sp = new StdSerializerProvider();
        sp.setNullValueSerializer(new NullSerializer());
        this.setSerializerProvider(sp);
        this.getSerializationConfig().setDateFormat(format);
    }
}
