package com.karan.paul.emailservice.utils;

import lombok.extern.log4j.Log4j2;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Log4j2
public class EmailUtil {
    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param fromEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(Session session, String toEmail, String fromEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(fromEmail, "Team Karan Paul"));

            msg.setReplyTo(InternetAddress.parse(fromEmail, false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);

            log.info("Message sent successfully to {}",toEmail);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
