package villar.financial.financialcontrol.core.usecase.goal.impl;

import jakarta.transaction.Transactional;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.core.gateway.GoalGateway;
import villar.financial.financialcontrol.core.usecase.goal.UseCaseGoal;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
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
        final Account account = this.accountGateway.find(dto.account().login());
        final Category category = this.categoryGateway.find(dto.category().name());
        final Goal entity = new Goal(dto, account, category);
        return this.goalGateway.save(entity).getId();
    }
}
