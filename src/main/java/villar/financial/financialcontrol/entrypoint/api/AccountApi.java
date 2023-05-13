package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import villar.financial.financialcontrol.core.usecase.account.UseCaseAccount;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;
import villar.financial.financialcontrol.entrypoint.dto.Resume;

@RestController
@RequestMapping("account")
class AccountApi {

    private final UseCaseAccount useCaseAccount;

    AccountApi(UseCaseAccount useCaseAccount) {
        this.useCaseAccount = useCaseAccount;
    }

    @GetMapping("detail")
    public Resume getDetailAccountByLogin(@RequestParam String login) {
        return this.useCaseAccount.getDetailAccountByLogin(login);
    }

    @GetMapping("login")
    public AccountDto getByLogin(@RequestParam String login) {
        return this.useCaseAccount.getByLogin(login);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody AccountDto accountDto) {
        return this.useCaseAccount.save(accountDto);
    }

    @PatchMapping
    public String patch(@RequestBody AccountDto accountDto) {
        return this.useCaseAccount.patch(accountDto);
    }
}
