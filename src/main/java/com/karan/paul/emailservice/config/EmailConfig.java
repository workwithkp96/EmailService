package com.karan.paul.emailservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

@Configuration
@Data
public class EmailConfig {

    @Value("${spring.mail.username}")
    public String from;

    @Value("${spring.mail.password}")
    public String password;

    @Bean
    public Properties setProperties(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
        props.put("mail.smtp.port", "587");            // TLS Port
        props.put("mail.smtp.auth", "true");           // Enable authentication
        props.put("mail.smtp.starttls.enable", "true");// Enable STARTTLS
        return props;
    }

    @Bean
    public Authenticator setAuthenticationObject(){
        // Create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            // Override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password); // App password
            }
        };
        return auth;
    }
}
