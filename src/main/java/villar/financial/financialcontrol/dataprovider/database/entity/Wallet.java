package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import villar.financial.financialcontrol.entrypoint.dto.WalletDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Wallet extends BaseEntity {

    private LocalDateTime dateOfMonth;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Wallet(WalletDto dto, Account account) {
        this(
                dto.dateOfMonth(),
                dto.amount(),
                account
        );
    }
}
