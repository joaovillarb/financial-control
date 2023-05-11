package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

    private String login;
    private String password;
    private BigDecimal salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "account")
    private List<Budget> budgets;

    @OneToMany(mappedBy = "account")
    private List<Goal> goals;

    public Account(AccountDto accountDto) {
        this.login = accountDto.login();
        this.password = accountDto.password();
        this.salary = accountDto.salary();
        this.person = new Person(accountDto.person(), this);
    }

    public Account patch(AccountDto accountDto) {
        if (Objects.nonNull(accountDto.salary())) {
            this.salary = accountDto.salary();
        }
        if (Objects.nonNull(accountDto.password())) {
            this.password = accountDto.password();
        }
        return this;
    }
}
