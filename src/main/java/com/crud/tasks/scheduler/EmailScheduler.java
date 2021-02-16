package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    private String getMessage(){
        long size = taskRepository.count();
        String MESSAGE;
        if (size == 1) {
            MESSAGE = "Currently in database you got: " + size + " task";
        } else MESSAGE ="Currently in database you got: " + size + " tasks";
        return MESSAGE;
    }

    @Scheduled(fixedDelay = 10000)
    public void sendInformationEmail() {



        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        getMessage(),
                        null
                )
        );
    }
}