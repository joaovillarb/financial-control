package villar.financial.financialcontrol.entrypoint.advice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import villar.financial.financialcontrol.infrastructure.utils.StringUtil;

import java.time.OffsetDateTime;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {

    @JsonIgnore
    private Throwable exception;
    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String message;

    public CustomResponse(Throwable throwable,
                          String message,
                          int status) {
        this.exception = throwable;
        this.timestamp = OffsetDateTime.now();
        this.status = status;
        setMessage(message, throwable);
    }

    public CustomResponse(Throwable throwable, int status) {
        this.exception = throwable;
        this.timestamp = OffsetDateTime.now();
        this.status = status;
        setMessage(null, throwable);
    }

    public void setMessage(String message, Throwable causaRaiz) {
        if (isNull(message)) {
            this.message = makeMessage(causaRaiz);
        } else {
            this.message = message;
        }
    }

    private String makeMessage(Throwable throwable) {
        if (nonNull(throwable) && StringUtil.hasValue(throwable.getMessage())) {
            return throwable.getMessage();
        }
        return getError();
    }

}
