package villar.financial.financialcontrol.core.usecase.goal.impl;

import jakarta.transaction.Transactional;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.core.gateway.GoalGateway;
import villar.financial.financialcontrol.core.usecase.goal.UseCaseGoal;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;
import villar.financial.financialcontrol.entrypoint.dto.GoalDto;

public class UseCaseGoalImpl implements UseCaseGoal {

    private final GoalGateway goalGateway;
    private final AccountGateway accountGateway;
    private final CategoryGateway categoryGateway;

    public UseCaseGoalImpl(GoalGateway goalGateway, AccountGateway accountGateway,
                           CategoryGateway categoryGateway) {
        this.goalGateway = goalGateway;
        this.accountGateway = accountGateway;
        this.categoryGateway = categoryGateway;
    }


    @Transactional
    public String update(GoalDto dto) {
        Account account = accountGateway.find(dto.account().login())
                .orElseThrow(() -> new RuntimeException());
        Category category = categoryGateway.find(dto.category().name())
                .orElseThrow(() -> new RuntimeException());
        final Goal entity = new Goal(dto, account, category);
        return this.goalGateway.save(entity).getId();
    }
}
