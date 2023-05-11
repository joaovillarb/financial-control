package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.repository.AccountRepository;

import java.util.Optional;

public class AccountGatewayImpl implements AccountGateway {

    private final AccountRepository repository;

    public AccountGatewayImpl(AccountRepository repository) {
        this.repository = repository;
    }

    public Optional<Account> find(final String login) {
        return this.repository.findByLogin(login);
    }

    public boolean exists(final String login) {
        return this.repository.existsByLogin(login);
    }

    public Account save(Account account) {
        return this.repository.saveAndFlush(account);
    }

    public Account update(Account account) {
        return this.repository.save(account);
    }
}
