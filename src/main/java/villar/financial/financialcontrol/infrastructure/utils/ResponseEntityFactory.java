package villar.financial.financialcontrol.infrastructure.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import villar.financial.financialcontrol.entrypoint.advice.CustomResponse;

@Slf4j
public class ResponseEntityFactory {

    public ResponseEntity<CustomResponse> factory(Throwable throwable, HttpStatus status) {
        CustomResponse response = new CustomResponse(throwable, status.value());
        return new ResponseEntity<>(response, status);
    }

    public ResponseEntity<CustomResponse> factory(Throwable throwable, String message, HttpStatus status) {
        CustomResponse response = new CustomResponse(throwable, message, status.value());
        return new ResponseEntity<>(response, status);
    }
}
