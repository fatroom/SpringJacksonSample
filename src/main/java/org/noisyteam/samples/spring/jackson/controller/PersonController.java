package org.noisyteam.samples.spring.jackson.controller;

import org.noisyteam.samples.spring.jackson.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Handles requests for the application home page.
 *
 * @author Roman Romanchuk (fatroom@gmail.com)
 */
@Controller
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private static final String DEFAULT_VIEW = "WEB-INF/views/home.jsp";

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home() {
        logger.trace("Passing through...");
        return DEFAULT_VIEW;
    }

    @RequestMapping(value="/json", method=RequestMethod.GET)
    @ResponseBody
    public Person getPersonObject() {
        logger.trace("Generating person object for JSON output");
        Person person = new Person();
        person.setName("John Doe");
        person.setBirthday(new Date());
        return person;
    }
}
