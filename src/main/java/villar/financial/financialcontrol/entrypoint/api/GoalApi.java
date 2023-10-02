package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.web.bind.annotation.*;
import villar.financial.financialcontrol.core.usecase.goal.UseCaseGoal;
import villar.financial.financialcontrol.entrypoint.dto.GoalDto;

import java.util.List;

@RestController
@RequestMapping("goal")
class GoalApi {

    private final UseCaseGoal useCaseGoal;

    GoalApi(UseCaseGoal useCaseGoal) {
        this.useCaseGoal = useCaseGoal;
    }

    @PutMapping
    public GoalDto update(@RequestBody GoalDto dto) {
        return useCaseGoal.update(dto);
    }

    @GetMapping
    public List<GoalDto> getAllGoals() {
        return useCaseGoal.getAll();
    }

}
