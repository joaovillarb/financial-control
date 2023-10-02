package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Account;

public record AccountDto(
        String login,
        String password,
        PersonDto person,
        Resume resume) {
    public AccountDto(Account account, Resume resume) {
        this(
                account.getLogin(),
                account.getPassword(),
                new PersonDto(account.getPerson()),
                resume
        );
    }

    public AccountDto(Account account) {
        this(account.getLogin(),
                account.getPassword(),
                new PersonDto(account.getPerson()),
                null);
    }

    public AccountDto(String login) {
        this(login, null, null, null);
    }
}
