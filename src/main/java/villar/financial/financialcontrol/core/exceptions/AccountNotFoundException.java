package villar.financial.financialcontrol.core.exceptions;

public class AccountNotFoundException extends NotFoundException {
    public AccountNotFoundException(String login) {
        super(String.format("Account with login=[%s] not found", login));
    }
}
