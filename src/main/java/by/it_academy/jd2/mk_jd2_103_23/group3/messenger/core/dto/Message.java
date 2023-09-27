
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime time;
    private User from;
    private User to;
    private String text;

    public Message() {
    }

    public Message(LocalDateTime time, User from, User to, String text) {
        this.time = time;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (time != null ? !time.equals(message.time) : message.time != null) return false;
        if (from != null ? !from.equals(message.from) : message.from != null) return false;
        if (to != null ? !to.equals(message.to) : message.to != null) return false;
        return text != null ? text.equals(message.text) : message.text == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", from=" + from +
                ", to=" + to +
                ", text='" + text + '\'' +
                '}';
    }
}