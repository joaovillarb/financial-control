package villar.financial.financialcontrol.core.usecase.account;

import villar.financial.financialcontrol.entrypoint.dto.AccountDto;
import villar.financial.financialcontrol.entrypoint.dto.Resume;

public interface UseCaseAccount {

    String save(final AccountDto accountDto);

    String patch(final AccountDto accountDto);

    AccountDto getByLogin(String login);

    Resume getDetailAccountByLogin(String login);

}
