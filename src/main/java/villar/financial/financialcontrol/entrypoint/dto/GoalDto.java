package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Goal;

import java.math.BigDecimal;

public record GoalDto(
        BigDecimal mustSpent,
        AccountDto account,
        CategoryDto category) {
    public GoalDto(Goal goal) {
        this(
                goal.getMustSpent(),
                null,
                new CategoryDto(goal.getCategory())
        );
    }
}
