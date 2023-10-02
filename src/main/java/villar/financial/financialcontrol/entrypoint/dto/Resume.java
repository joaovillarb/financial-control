package villar.financial.financialcontrol.entrypoint.dto;

import java.math.BigDecimal;
import java.util.List;

public record Resume(
        List<ResumeBudgetDto> budgets,
        BigDecimal totalSpent,
        BigDecimal totalMustSpent,
        BigDecimal utilized) {
}
