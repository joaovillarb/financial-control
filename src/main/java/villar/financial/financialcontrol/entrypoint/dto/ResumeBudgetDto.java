package villar.financial.financialcontrol.entrypoint.dto;

import java.math.BigDecimal;

public record ResumeBudgetDto(String name,
                              BigDecimal spent,
                              BigDecimal mustSpent,
                              BigDecimal percentUsed,
                              BigDecimal percentTotal) {
}
