package villar.financial.financialcontrol.entrypoint.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import villar.financial.financialcontrol.infrastructure.utils.ResponseEntityFactory;

import java.lang.annotation.Annotation;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private final ResponseEntityFactory factory = new ResponseEntityFactory();

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomResponse> handleAllExceptions(Exception ex) {
        HttpStatus status = null;

        Annotation exceptionAnnotationHttpStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        if (Objects.nonNull(exceptionAnnotationHttpStatus)) {
            status = (HttpStatus) AnnotationUtils.getValue(exceptionAnnotationHttpStatus);
        }

        if (Objects.isNull(status)) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ResponseEntity<CustomResponse> responseEntity = factory.factory(ex, status);
        log.error(ex.getMessage(), ex);
        return responseEntity;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomResponse> handleNullPointerException(Exception ex) {
        if (ex.getStackTrace().length > 0 && !ex.getStackTrace()[0].getClassName().contains(Objects.class.getSimpleName())) {
            String message = String.format("Error: %s - Class: %s - Method: %s - Line: %s ",
                    ex, ex.getStackTrace()[0].getClassName(), ex.getStackTrace()[0].getMethodName(), ex.getStackTrace()[0].getLineNumber());

            log.error(message, ex);
            return factory.factory(ex, message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.error(ex.getMessage(), ex);
        return factory.factory(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
