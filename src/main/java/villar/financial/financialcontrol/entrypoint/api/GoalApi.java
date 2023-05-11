package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import villar.financial.financialcontrol.core.usecase.goal.UseCaseGoal;
import villar.financial.financialcontrol.entrypoint.dto.GoalDto;

@RestController
@RequestMapping("goal")
class GoalApi {

    private final UseCaseGoal useCaseGoal;

    GoalApi(UseCaseGoal useCaseGoal) {
        this.useCaseGoal = useCaseGoal;
    }

    @PutMapping
    public String update(@RequestBody GoalDto dto) {
        return useCaseGoal.update(dto);
    }

}
