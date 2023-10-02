package villar.financial.financialcontrol.dataprovider.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import villar.financial.financialcontrol.core.exceptions.InvalidCredentialsException;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.security.SecurityGateway;
import villar.financial.financialcontrol.entrypoint.dto.AuthenticationRequest;
import villar.financial.financialcontrol.entrypoint.dto.AuthenticationResponse;
import villar.financial.financialcontrol.infrastructure.security.JwtService;

@RequiredArgsConstructor
public class SecurityGatewayImpl implements SecurityGateway {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            final var authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.login(),
                            request.password()
                    )
            );

            var user = (Account) authentication.getPrincipal();
            final var token = jwtService.generateToken(user);

            return new AuthenticationResponse(token);
        } catch (BadCredentialsException ex) {
            throw new InvalidCredentialsException();
        }
    }
}
