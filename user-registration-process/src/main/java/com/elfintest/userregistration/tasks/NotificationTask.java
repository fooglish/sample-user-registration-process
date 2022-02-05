package com.elfintest.userregistration.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class NotificationTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Logger logger = LoggerFactory.getLogger(NotificationTask.class);
        final Boolean decision = (Boolean) delegateExecution.getVariable("decision");

        if(decision) {
            logger.info("Заявка на регистрацию пользователя {} одобрена.",
                    delegateExecution.getVariable("username"));
        }
    }
}

