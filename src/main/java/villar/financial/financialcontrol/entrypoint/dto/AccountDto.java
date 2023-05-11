package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public record AccountDto(
        String login,
        String password,
        BigDecimal salary,
        PersonDto person,
        List<BudgetDto> budgetList,
        List<GoalDto> goalList) {
    public AccountDto(Account account) {
        this(
                account.getLogin(),
                account.getPassword(),
                account.getSalary(),
                new PersonDto(account.getPerson()),
                account.getBudgets().stream()
                        .map(BudgetDto::new)
                        .toList(),
                account.getGoals().stream()
                        .map(GoalDto::new)
                        .toList()
        );
    }
}
