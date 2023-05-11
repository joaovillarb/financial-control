package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import villar.financial.financialcontrol.entrypoint.dto.GoalDto;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Goal extends BaseEntity {

    private BigDecimal mustSpent;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Goal(GoalDto goalDto, Account account, Category category) {
        this.mustSpent = goalDto.mustSpent();
        this.account = account;
        this.category = category;
    }
}
