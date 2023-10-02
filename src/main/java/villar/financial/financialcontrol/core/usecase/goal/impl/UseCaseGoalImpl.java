package villar.financial.financialcontrol.core.usecase.goal.impl;

import jakarta.transaction.Transactional;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.core.gateway.GoalGateway;
import villar.financial.financialcontrol.core.usecase.goal.UseCaseGoal;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;
import villar.financial.financialcontrol.entrypoint.dto.GoalDto;
import villar.financial.financialcontrol.infrastructure.utils.SecurityUtils;

import java.util.List;
import java.util.Objects;

public class UseCaseGoalImpl implements UseCaseGoal {

    private final GoalGateway goalGateway;
    private final CategoryGateway categoryGateway;

    public UseCaseGoalImpl(GoalGateway goalGateway,
                           CategoryGateway categoryGateway) {
        this.goalGateway = goalGateway;
        this.categoryGateway = categoryGateway;
    }

    @Transactional
    public GoalDto update(GoalDto dto) {
        final Account account = SecurityUtils.getLoggedInUser();
        final Category category = this.categoryGateway.find(dto.category().name());
        final Goal entity = account.getGoals().stream()
                .filter(goal -> Objects.equals(goal.getCategory(), category))
                .findFirst()
                .orElse(new Goal(dto, account, category));

        entity.setMustSpentPercentage(dto.mustSpentPercentage());

        final Goal savedGoal = this.goalGateway.save(entity);
        return new GoalDto(savedGoal);
    }

    public List<GoalDto> getAll() {
        final Account account = SecurityUtils.getLoggedInUser();
        final List<Goal> goals = this.goalGateway.getAllByAccount(account);
        return goals.stream().map(GoalDto::new).toList();
    }
}
