package villar.financial.financialcontrol.core.usecase.account.impl;

import org.springframework.transaction.annotation.Transactional;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.core.usecase.account.UseCaseAccount;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;
import villar.financial.financialcontrol.entrypoint.dto.Resume;
import villar.financial.financialcontrol.entrypoint.dto.ResumeBudgetDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class UseCaseAccountImpl implements UseCaseAccount {

    private final AccountGateway accountGateway;

    public UseCaseAccountImpl(final AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    public AccountDto getByLogin(String login) {
        final Account account = this.accountGateway.find(login);
        return createAccountDto(account);
    }

    @Transactional
    public AccountDto save(final AccountDto accountDto) {
        final Account account = new Account(accountDto);
        Account savedAccount = this.accountGateway.save(account);
        return createAccountDto(savedAccount);
    }

    @Transactional
    public AccountDto patch(final AccountDto accountDto) {
        final Account account = this.accountGateway.find(accountDto.login())
                .patch(accountDto);
        final Account savedAccount = this.accountGateway.save(account);
        return createAccountDto(savedAccount);
    }

    private <T> BigDecimal sumList(List<T> list, Function<T, BigDecimal> function,
                                   Predicate<T> predicate) {
        return list.stream()
                .filter(Optional.ofNullable(predicate).orElse(x -> true))
                .map(function)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getPercentBetweenTwoValues(BigDecimal dividend, BigDecimal divisor) {
        return dividend.compareTo(BigDecimal.ZERO) != 0
                ? divisor.divide(dividend, 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;
    }

    private Resume createResume(Account account) {
        final List<Budget> budgetList = account.getBudgets();
        final List<Goal> goalList = account.getGoals();

        if (Objects.isNull(budgetList)) {
            return new Resume(
                    List.of(),
                    BigDecimal.ZERO,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO
            );
        }

        final BigDecimal totalSpent = sumList(budgetList, Budget::getSpent, null);
        final BigDecimal totalMustSpent = account.getWallets().get(0).getAmount();

        final BigDecimal percentTotalResume = getPercentBetweenTwoValues(totalMustSpent, totalSpent);

        List<ResumeBudgetDto> list = goalList.stream().map(goal -> {
            final Category category = goal.getCategory();
            final BigDecimal spent = sumList(budgetList, Budget::getSpent, budget -> budget.getCategory().equals(category));
            final BigDecimal mustSpentPercentage = goal.getMustSpentPercentage();
            final BigDecimal salary = account.getWallets().get(0).getAmount();
            final BigDecimal mustSpent = salary.multiply(mustSpentPercentage);
            final BigDecimal percentUsed = getPercentBetweenTwoValues(mustSpent, spent);
            final BigDecimal percentTotal = getPercentBetweenTwoValues(salary, spent);
            return new ResumeBudgetDto(
                    category.getName(),
                    spent,
                    mustSpent,
                    percentUsed,
                    percentTotal
            );
        }).toList();
        return new Resume(
                list,
                totalSpent,
                totalMustSpent,
                percentTotalResume
        );
    }

    private AccountDto createAccountDto(Account account) {
//        final Resume resume = createResume(account);
        return new AccountDto(account);
    }
}
