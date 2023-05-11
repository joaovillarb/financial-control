package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BudgetDto(LocalDateTime date,
                        BigDecimal spent,
                        String description,
                        AccountDto account,
                        CategoryDto category) {
    public BudgetDto(Budget budget) {
        this(
                budget.getDate(),
                budget.getSpent(),
                budget.getDescription(),
                null,
                new CategoryDto(budget.getCategory())
        );
    }
}
