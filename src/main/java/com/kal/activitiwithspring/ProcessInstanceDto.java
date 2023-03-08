package com.kal.activitiwithspring;

import java.util.HashMap;



public class ProcessInstanceDto {
    private String user;
    private String processDefinitionKey;
    private String processInstanceName;
    private String businessKey;
    private HashMap variables;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getProcessInstanceName() {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public HashMap getVariables() {
        return variables;
    }

    public void setVariables(HashMap variables) {
        this.variables = variables;
    }
}
