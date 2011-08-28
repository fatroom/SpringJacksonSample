package org.noisyteam.samples.spring.jackson.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.annotation.PostConstruct;

@Component
public class JacksonConfigurator {
    @Autowired
    private AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter;
    @Autowired
    private CustomObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        HttpMessageConverter<?>[] messageConverters = annotationMethodHandlerAdapter.getMessageConverters();
        for (HttpMessageConverter<?> messageConverter : messageConverters) {
            if (messageConverter instanceof MappingJacksonHttpMessageConverter) {
                MappingJacksonHttpMessageConverter m = (MappingJacksonHttpMessageConverter) messageConverter;
                m.setObjectMapper(objectMapper);
            }
        }
    }
}
