package villar.financial.financialcontrol.core.usecase.budget.impl;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.core.gateway.BudgetGateway;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.core.usecase.budget.UseCaseBudget;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;

public class UseCaseBudgetImpl implements UseCaseBudget {

    private final BudgetGateway budgetGateway;
    private final AccountGateway accountGateway;
    private final CategoryGateway categoryGateway;

    public UseCaseBudgetImpl(BudgetGateway budgetRepository, AccountGateway accountGateway,
                             CategoryGateway categoryGateway) {
        this.budgetGateway = budgetRepository;
        this.accountGateway = accountGateway;
        this.categoryGateway = categoryGateway;
    }

    @Transactional
    public BudgetDto add(BudgetDto budgetDto) {
        final Account account = accountGateway.find(budgetDto.account().login());
        final Category category = categoryGateway.find(budgetDto.category().name());
        Budget budget = new Budget(budgetDto, account, category);
        budget = this.budgetGateway.save(budget);
        return new BudgetDto(budget);
    }

    public Page<BudgetDto> pageBy(Pageable pageable) {
        return this.budgetGateway.page(pageable)
                .map(BudgetDto::new);
    }

    @Override
    public Page<BudgetDto> pageByLogin(String accountLogin, Pageable pageable) {
        return this.budgetGateway.pageByLogin(accountLogin, pageable)
                .map(BudgetDto::new);
    }

    @Override
    public Page<BudgetDto> pageByLoginAndDate(String accountLogin, YearMonth yearMonth, Pageable pageable) {

        LocalDateTime startOfMonth = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime endOfMonth = yearMonth.atEndOfMonth().atTime(LocalTime.MAX);

        return this.budgetGateway.pageByLoginAndDate(
                        accountLogin, startOfMonth, endOfMonth, pageable)
                .map(BudgetDto::new);
    }
}
