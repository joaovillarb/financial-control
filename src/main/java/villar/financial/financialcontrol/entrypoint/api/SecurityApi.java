package villar.financial.financialcontrol.entrypoint.api;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import villar.financial.financialcontrol.dataprovider.security.SecurityGateway;
import villar.financial.financialcontrol.entrypoint.dto.AuthenticationRequest;
import villar.financial.financialcontrol.entrypoint.dto.AuthenticationResponse;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class SecurityApi {

    private final SecurityGateway useCase;

    @PostMapping("signin")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(useCase.authenticate(authenticationRequest));
    }

}
