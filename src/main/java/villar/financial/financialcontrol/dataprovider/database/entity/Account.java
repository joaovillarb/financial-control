package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;
import villar.financial.financialcontrol.infrastructure.config.ApplicationConfig;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity implements UserDetails {

    private String login;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "account")
    private List<Wallet> wallets;

    @OneToMany(mappedBy = "account")
    private List<Budget> budgets;

    @OneToMany(mappedBy = "account")
    private List<Goal> goals;

    public Account(AccountDto accountDto) {
        this.login = accountDto.login();
        this.password = ApplicationConfig.passwordEncoder().encode(accountDto.password());
        this.person = new Person(accountDto.person(), this);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getUsername() {
        return this.login;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public Account patch(AccountDto accountDto) {
        if (Objects.nonNull(accountDto.password())) {
            this.password = ApplicationConfig.passwordEncoder().encode(accountDto.password());
        }
        return this;
    }
}
