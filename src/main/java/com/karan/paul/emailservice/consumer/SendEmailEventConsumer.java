package com.karan.paul.emailservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karan.paul.emailservice.config.EmailConfig;
import com.karan.paul.emailservice.dto.SendEmailEventDto;
import com.karan.paul.emailservice.utils.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.Session;

@Service
@RequiredArgsConstructor
public class SendEmailEventConsumer {
    private final ObjectMapper objectMapper;
    private final EmailConfig emailConfig;

    @KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void handleSendEmailEvent(String message) throws JsonProcessingException {
        SendEmailEventDto event = objectMapper.readValue(message, SendEmailEventDto.class);

        String to = event.getTo();
        String body = event.getBody();
        String subject = event.getSubject();

        Session session = Session.getInstance(emailConfig.setProperties(), emailConfig.setAuthenticationObject());

        EmailUtil.sendEmail(session, to, emailConfig.getFrom(), subject, body);
    }
}
