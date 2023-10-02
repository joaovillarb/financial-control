package villar.financial.financialcontrol.infrastructure.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.infrastructure.exception.UserNotLoggedInException;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static Account getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Account accountUser) {
            return accountUser;
        }

        throw new UserNotLoggedInException();
    }
}
