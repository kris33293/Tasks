package com.crud.tasks.domain;


import lombok.Getter;


public class Mail {

    private final String mailTo;
    private final String subject;
    private final String message;
    private final String mailCc;

    public static class MailBuilder {
        private String mailTo;
        private String subject;
        private String message;
        private String mailCc;

        public MailBuilder mailTo(String mailTo) {
            this.mailTo = mailTo;
            return this;
        }

        public MailBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public MailBuilder message(String message) {
            this.message = message;
            return this;
        }

        public MailBuilder mailCc(String mailCc) {
            this.mailCc = mailCc;
            return this;
        }

        public Mail build() {
            return new Mail(mailTo,subject,message,mailCc);
        }
    }

    public Mail(final String mailTo,final String subject,final String message,final String mailCc) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.mailCc = mailCc;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getMailCc() {
        return mailCc;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "mailTo='" + mailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", mailCc='" + mailCc + '\'' +
                '}';
    }
}