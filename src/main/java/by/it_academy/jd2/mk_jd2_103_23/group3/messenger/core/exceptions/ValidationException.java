package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationException extends IllegalArgumentException {

    private List<String> errorsMessages;

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(List<String> errorsMessages) {
        super(errorsMessages.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining("<br>", "", "")));
        this.errorsMessages = errorsMessages;
    }

    public List<String> getErrorsMessages() {
        return this.errorsMessages;
    }
}
