package com.moviefy.backend.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailNotification {
    public static void sendEmail(String recipientEmail, String subject, String message) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        String username = "tt8462403@gmail.com";
        String password = "Test123#";

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message emailMessage = new MimeMessage(session);
        emailMessage.setFrom(new InternetAddress(username));
        emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        emailMessage.setSubject(subject);
        emailMessage.setText(message);

        Transport.send(emailMessage);
    }
}
