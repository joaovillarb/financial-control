package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Account;

public interface AccountGateway {

    Account find(final String login);

    Account save(Account account);
}
