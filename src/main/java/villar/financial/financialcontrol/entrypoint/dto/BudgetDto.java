package villar.financial.financialcontrol.entrypoint.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BudgetDto(LocalDateTime date,
                        BigDecimal spent,
                        String description,
                        AccountDto account,
                        CategoryDto category) {
}
