package org.noisyteam.samples.spring.jackson.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.annotation.PostConstruct;

@Component
public class JacksonFix {
    private AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter;
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

    // this will exist due to the <mvc:annotation-driven/> bean
    @Autowired
    public void setAnnotationMethodHandlerAdapter(AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter) {
        this.annotationMethodHandlerAdapter  = annotationMethodHandlerAdapter;
    }

    @Autowired
    public void setObjectMapper(CustomObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}