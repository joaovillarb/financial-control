package villar.financial.financialcontrol.entrypoint.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record Resume(
        UUID accountId,
        List<ResumeBudgetDto> budgets,
        BigDecimal totalSpent,
        BigDecimal totalMustSpent,
        BigDecimal utilized) {
}
