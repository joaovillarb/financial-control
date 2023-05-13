package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import villar.financial.financialcontrol.core.usecase.budget.UseCaseBudget;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;

@RestController
@RequestMapping("budget")
class BudgetApi {

    private final UseCaseBudget useCaseBudget;

    BudgetApi(UseCaseBudget useCaseBudget) {
        this.useCaseBudget = useCaseBudget;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody BudgetDto budgetDto) {
        return useCaseBudget.add(budgetDto);
    }

}
