package io.murad.email_sender_platform.model;

public class EmailModel {
    String subject;
    String body;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public EmailModel(){

    }

    public EmailModel(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }
}
