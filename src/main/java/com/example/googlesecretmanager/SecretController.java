package com.example.googlesecretmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController {

    @Value("${some-secret}")
    private String someSecret;

    @RequestMapping(value = "secret", method = RequestMethod.GET)
    public @ResponseBody String getSomeSecret() {
        return this.someSecret;
    }
}
