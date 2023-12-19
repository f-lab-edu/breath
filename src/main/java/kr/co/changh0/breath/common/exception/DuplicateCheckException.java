package kr.co.changh0.breath.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateCheckException extends RuntimeException {
    public DuplicateCheckException(String message) {
        super(message);
    }
}
