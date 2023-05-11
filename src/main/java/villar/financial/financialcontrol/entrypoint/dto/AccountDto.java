package villar.financial.financialcontrol.entrypoint.dto;

import java.math.BigDecimal;

public record AccountDto(
        String login,
        String password,
        BigDecimal salary,
        PersonDto person) {
}
