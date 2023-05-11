package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import villar.financial.financialcontrol.core.usecase.account.UseCaseAccount;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;

@RestController
@RequestMapping("account")
public class AccountApi {

    private final UseCaseAccount useCaseAccount;

    public AccountApi(UseCaseAccount useCaseAccount) {
        this.useCaseAccount = useCaseAccount;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody AccountDto accountDto) {
        return this.useCaseAccount.save(accountDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody AccountDto accountDto) {
        return this.useCaseAccount.update(accountDto);
    }
}
