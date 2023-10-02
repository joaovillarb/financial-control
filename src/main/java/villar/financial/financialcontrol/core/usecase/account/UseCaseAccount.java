package villar.financial.financialcontrol.core.usecase.account;

import villar.financial.financialcontrol.entrypoint.dto.AccountDto;

public interface UseCaseAccount {

    AccountDto save(final AccountDto accountDto);

    AccountDto patch(final AccountDto accountDto);

    AccountDto getByLogin(String login);



}
