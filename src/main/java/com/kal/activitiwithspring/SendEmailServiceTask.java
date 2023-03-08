package com.kal.activitiwithspring;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SendEmailServiceTask implements JavaDelegate {

    public void execute(DelegateExecution execution) {
        //logic to sent email confirmation
        System.out.println("email has been sent");
    }

}
