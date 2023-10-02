package villar.financial.financialcontrol.dataprovider.security;


import villar.financial.financialcontrol.entrypoint.dto.AuthenticationRequest;
import villar.financial.financialcontrol.entrypoint.dto.AuthenticationResponse;

public interface SecurityGateway {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
