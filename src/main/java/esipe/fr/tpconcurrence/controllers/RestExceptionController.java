package esipe.fr.tpconcurrence.controllers;

import esipe.fr.tpconcurrence.entities.ErrorDefinition;
import esipe.fr.tpconcurrence.entities.ErrorDefinitionErrors;
import esipe.fr.tpconcurrence.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<ErrorDefinition> handleApiException(ApiException ex){
        ErrorDefinition errorDefinition = new ErrorDefinition();
        errorDefinition.setErrorType(ErrorDefinition.ErrorTypeEnum.TECHNICAL);
        ErrorDefinitionErrors error = new ErrorDefinitionErrors();
        error.setErrorCode(Integer.toString(ex.getCode()));
        error.setErrorMessage(ex.getMessage());
        errorDefinition.addErrorsItem(error);
        return new ResponseEntity<ErrorDefinition>(errorDefinition, HttpStatus.resolve(ex.getCode()));
    }


}
