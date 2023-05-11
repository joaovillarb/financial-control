package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public String add(@RequestBody BudgetDto budgetDto) {
        return useCaseBudget.add(budgetDto);
    }

}
