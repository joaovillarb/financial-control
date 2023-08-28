package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Account;

public record BudgetAccountDto(
        String uuid,
        String login) {
    public BudgetAccountDto(Account account) {
        this(
                account.getId(),
                account.getLogin()
        );
    }

    public BudgetAccountDto(String login) {
        this(
                null, login
        );
    }
}
