package villar.financial.financialcontrol.core.usecase.account.impl;

import org.springframework.transaction.annotation.Transactional;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.core.usecase.account.UseCaseAccount;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;

public class UseCaseAccountImpl implements UseCaseAccount {

    private final AccountGateway accountGateway;

    public UseCaseAccountImpl(final AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Transactional
    public String save(final AccountDto accountDto) {
        final Account account = new Account(accountDto);
        return this.accountGateway.save(account).getId();
    }

    @Transactional
    public String update(final AccountDto accountDto) {
        final Account accountFounded = this.accountGateway.find(accountDto.login())
                .orElseThrow(() -> new RuntimeException())
                .update(accountDto);
        final Account account = this.accountGateway.save(accountFounded);
        return account.getId();
    }
}
