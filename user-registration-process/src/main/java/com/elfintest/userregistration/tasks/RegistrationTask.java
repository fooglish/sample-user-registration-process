package com.elfintest.userregistration.tasks;

import com.elfintest.userregistration.model.User;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RegistrationTask implements JavaDelegate {
    RestTemplate restTemplate = new RestTemplate();
    String dbUrl = "http://localhost:8081/users";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        String password = (String) delegateExecution.getVariable("password");
        String email = (String) delegateExecution.getVariable("email");
        Long phone = (Long) delegateExecution.getVariable("phone");

        register(username, password, email, phone);
    }

    public void register(String username, String password, String email, Long phone) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        User user = new User(username, password, email, phone);
        HttpEntity<Object> requestEntity = new HttpEntity<>(user, headers);

        restTemplate.exchange(dbUrl + "/add", HttpMethod.POST, requestEntity, String.class);
    }
}
