package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Wallet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record WalletDto(
        String id,
        BigDecimal amount,
        LocalDateTime dateOfMonth,
        AccountDto accountDto) {

    public WalletDto(Wallet wallet) {
        this(
                wallet.getId(),
                wallet.getAmount(),
                wallet.getDateOfMonth(),
                new AccountDto(wallet.getAccount())
        );
    }
}
