package pl.edu.agh.tai.application.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.edu.agh.tai.application.exception.MissingDataException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MissingDataException.class)
    public ResponseEntity<?> handleMissingDataException(MissingDataException exception) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
    }

}
