package com.kal.activitiwithspring;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ActivitiController {
    private static final Logger logger = LoggerFactory.getLogger(ActivitiController.class);

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/process/definition/get")
    public Object testDefinitionGet(@RequestParam String processDefinitionId) {
//        securityUtil.logInAs("f1");
        ProcessDefinition processDefinition = processRuntime
                .processDefinition(processDefinitionId);

        return processDefinition;
    }

    @RequestMapping("/process/instance/get")
    public Object testInstanceGet(@RequestParam String processInstanceId) {
//        securityUtil.logInAs("f1");
        org.activiti.api.process.model.ProcessInstance processInstance = processRuntime
                .processInstance(processInstanceId);

        return processInstance;
    }

    @GetMapping("/start-process")
    public String startProcess() {
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("load-data");

        return "Process started with id = " +  pi.getId();
    }

    @GetMapping("/get-tasks/{processInstanceId}")
    public List<TaskRepresentation> getTasks(@PathVariable String processInstanceId) {
        List<Task> usertasks = taskService.createTaskQuery()
          .processInstanceId(processInstanceId)
          .list();

        return usertasks.stream()
          .map(task -> new TaskRepresentation(task.getId(), task.getName(), task.getProcessInstanceId()))
          .collect(Collectors.toList());
    }

    @GetMapping("/complete-task1/{processInstanceId}")
    public void completeTaskA(@PathVariable String processInstanceId) {
        Task task = taskService.createTaskQuery()
          .processInstanceId(processInstanceId)
          .singleResult();
        taskService.complete(task.getId());
        logger.info("Task completed");
    }
}
