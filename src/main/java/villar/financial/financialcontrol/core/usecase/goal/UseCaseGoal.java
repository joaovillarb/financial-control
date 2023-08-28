package villar.financial.financialcontrol.core.usecase.goal;

import villar.financial.financialcontrol.entrypoint.dto.GoalDto;

import java.util.List;

public interface UseCaseGoal {

    GoalDto update(GoalDto dto);

    List<GoalDto> getAll(String login);
}
