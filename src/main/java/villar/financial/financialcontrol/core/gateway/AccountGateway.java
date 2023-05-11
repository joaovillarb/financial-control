package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Account;

import java.util.Optional;

public interface AccountGateway {

    Optional<Account> find(final String login);

    Account save(Account account);

    Account update(Account account);

    boolean exists(final String login);
}
