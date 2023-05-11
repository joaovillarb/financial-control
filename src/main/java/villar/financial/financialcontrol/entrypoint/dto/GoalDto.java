package villar.financial.financialcontrol.entrypoint.dto;

import java.math.BigDecimal;

public record GoalDto(
        BigDecimal value,
        AccountDto account,
        CategoryDto category) {
}
