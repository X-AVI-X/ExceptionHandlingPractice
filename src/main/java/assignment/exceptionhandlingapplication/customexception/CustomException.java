package assignment.exceptionhandlingapplication.customexception;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class CustomException extends Exception{

    private ActionResponse errorResponse;
    public CustomException(String message){
        errorResponse = new ActionResponse(message);
    }
}
