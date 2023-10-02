package villar.financial.financialcontrol.dataprovider.database.gateway;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import villar.financial.financialcontrol.core.exceptions.AccountNotFoundException;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.gateway.abstracts.AbstractGatewayImpl;
import villar.financial.financialcontrol.dataprovider.database.repository.AccountRepository;

import java.util.UUID;

public class AccountGatewayImpl extends AbstractGatewayImpl<AccountRepository, Account, UUID> implements AccountGateway {

    public AccountGatewayImpl(AccountRepository repository) {
        super(repository);
    }

    @Cacheable(value = "getAccountByLogin", key = "#login")
    public Account find(final String login) {
        return this.repository.findByLogin(login)
                .orElseThrow(() -> new AccountNotFoundException(login));
    }

    @Override
    @CacheEvict(value = "getAccountByLogin", key = "#account.getLogin()")
    public Account save(Account account) {
        return super.save(account);
    }
}
