package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.exceptions.AccountNotFoundException;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.repository.AccountRepository;

public class AccountGatewayImpl implements AccountGateway {

    private final AccountRepository repository;

    public AccountGatewayImpl(AccountRepository repository) {
        this.repository = repository;
    }

    public Account find(final String login) {
        return this.repository.findByLogin(login)
                .orElseThrow(() -> new AccountNotFoundException(login));
    }

    public Account save(Account account) {
        return this.repository.saveAndFlush(account);
    }
}
