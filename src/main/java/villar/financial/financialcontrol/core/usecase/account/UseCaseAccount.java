package villar.financial.financialcontrol.core.usecase.account;

import villar.financial.financialcontrol.entrypoint.dto.AccountDto;

public interface UseCaseAccount {

    String save(final AccountDto accountDto);

    String update(final AccountDto accountDto);
}
