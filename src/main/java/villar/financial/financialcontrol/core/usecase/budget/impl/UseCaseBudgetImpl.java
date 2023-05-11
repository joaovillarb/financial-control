package villar.financial.financialcontrol.core.usecase.budget.impl;

import jakarta.transaction.Transactional;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.core.gateway.BudgetGateway;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.core.usecase.budget.UseCaseBudget;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;

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
    public String add(BudgetDto budgetDto) {
        final Account account = accountGateway.find(budgetDto.account().login());
        final Category category = categoryGateway.find(budgetDto.category().name());
        final Budget budget = new Budget(budgetDto, account, category);
        return this.budgetGateway.save(budget).getId();
    }
}
