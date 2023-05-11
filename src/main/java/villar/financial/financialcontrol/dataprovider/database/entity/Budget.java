package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Budget extends BaseEntity {

    private LocalDateTime date;
    private BigDecimal spent;
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Budget(BudgetDto budgetDto, Account account, Category category) {
        this.date = budgetDto.date();
        this.spent = budgetDto.spent();
        this.description = budgetDto.description();
        this.account = account;
        this.category = category;
    }
}
