package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import villar.financial.financialcontrol.core.usecase.budget.UseCaseBudget;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;

import java.time.YearMonth;

@RestController
@RequestMapping("budget")
class BudgetApi {

    private final UseCaseBudget useCaseBudget;

    BudgetApi(UseCaseBudget useCaseBudget) {
        this.useCaseBudget = useCaseBudget;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BudgetDto add(@RequestBody BudgetDto budgetDto) {
        return useCaseBudget.add(budgetDto);
    }

    @GetMapping("page")
    public Page<BudgetDto> pageBy(@PageableDefault Pageable pageable) {
        return this.useCaseBudget.pageBy(pageable);
    }
    @GetMapping("page/login")
    public Page<BudgetDto> pageByLogin(@RequestParam("accountLogin") String accountLogin,
                                       @PageableDefault Pageable pageable) {
        return this.useCaseBudget.pageByLogin(accountLogin, pageable);
    }
    @GetMapping("page/login/month")
    public Page<BudgetDto> pageByLogin(@RequestParam("accountLogin") String accountLogin,
                                       @RequestParam(name = "yearMonth") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth,
                                       @PageableDefault Pageable pageable) {
        return this.useCaseBudget.pageByLoginAndDate(accountLogin,yearMonth, pageable);
    }
}
