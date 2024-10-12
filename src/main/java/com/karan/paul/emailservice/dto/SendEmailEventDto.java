package com.karan.paul.emailservice.dto;

import lombok.Data;

@Data
public class SendEmailEventDto {
    private String to;
    private String from;
    private String subject;
    private String body;
}
