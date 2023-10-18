
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private LocalDateTime time;
    private String from;
    private String to;
    private String message;

    public Message() {
    }

    public Message(LocalDateTime time, String  from, String to, String text) {
        this.time = time;
        this.from = from;
        this.to = to;
        this.message = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        return time.format(formatter);
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (time != null ? !time.equals(message.time) : message.time != null) return false;
        if (from != null ? !from.equals(message.from) : message.from != null) return false;
        if (to != null ? !to.equals(message.to) : message.to != null) return false;
        return this.message != null ? this.message.equals(message.message) : message.message == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", from=" + from +
                ", to=" + to +
                ", text='" + message + '\'' +
                '}';
    }
}