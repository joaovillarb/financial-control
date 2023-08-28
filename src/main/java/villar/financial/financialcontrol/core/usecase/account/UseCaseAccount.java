package villar.financial.financialcontrol.core.usecase.account;

import villar.financial.financialcontrol.entrypoint.dto.AccountDto;
import villar.financial.financialcontrol.entrypoint.dto.Resume;

public interface UseCaseAccount {

    String save(final AccountDto accountDto);

    AccountDto patch(final AccountDto accountDto);

    AccountDto getByLogin(String login);

    Resume getDetailAccountByLogin(String login);
}
