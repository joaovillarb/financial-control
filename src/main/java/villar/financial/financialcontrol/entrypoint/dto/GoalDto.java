package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Goal;

import java.math.BigDecimal;

public record GoalDto(
        BigDecimal mustSpentPercentage,
        AccountDto account,
        CategoryDto category) {
    public GoalDto(Goal goal) {
        this(
                goal.getMustSpentPercentage(),
                null,
                new CategoryDto(goal.getCategory())
        );
    }
}
