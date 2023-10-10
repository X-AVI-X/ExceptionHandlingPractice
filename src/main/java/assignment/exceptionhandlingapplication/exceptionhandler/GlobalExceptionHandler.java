package assignment.exceptionhandlingapplication.exceptionhandler;

import assignment.exceptionhandlingapplication.customexception.CustomException;
import assignment.exceptionhandlingapplication.customexception.ActionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ActionResponse> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ActionResponse> handleNullPointerException(NullPointerException ex){
        return new ResponseEntity<>(new ActionResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ActionResponse> handleArithmeticException(ArithmeticException ex){
        return new ResponseEntity<>(new ActionResponse(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }


}


