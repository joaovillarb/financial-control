package villar.financial.financialcontrol.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import villar.financial.financialcontrol.core.gateway.*;
import villar.financial.financialcontrol.core.gateway.PersonGateway;
import villar.financial.financialcontrol.dataprovider.database.gateway.*;
import villar.financial.financialcontrol.dataprovider.database.repository.*;
import villar.financial.financialcontrol.dataprovider.security.SecurityGateway;
import villar.financial.financialcontrol.dataprovider.security.impl.SecurityGatewayImpl;
import villar.financial.financialcontrol.infrastructure.security.JwtService;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;
    private final CategoryRepository categoryRepository;
    private final BudgetRepository budgetRepository;
    private final GoalRepository goalRepository;
    private final ProductRepository productRepository;
    private final WalletRepository walletRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Bean
    @ConditionalOnMissingBean(AccountGateway.class)
    public AccountGateway accountGateway() {
        return new AccountGatewayImpl(
                this.accountRepository);
    }

    @Bean
    @ConditionalOnMissingBean(PersonGateway.class)
    public PersonGateway personGateway() {
        return new PersonGatewayImpl(
                this.personRepository);
    }

    @Bean
    @ConditionalOnMissingBean(CategoryGateway.class)
    public CategoryGateway categoryGateway() {
        return new CategoryGatewayImpl(
                this.categoryRepository);
    }

    @Bean
    @ConditionalOnMissingBean(BudgetGateway.class)
    public BudgetGateway budgetGateway() {
        return new BudgetGatewayImpl(
                this.budgetRepository);
    }

    @Bean
    @ConditionalOnMissingBean(GoalGateway.class)
    public GoalGateway goalGateway() {
        return new GoalGatewayImpl(
                this.goalRepository);
    }

    @Bean
    @ConditionalOnMissingBean(ProductGateway.class)
    public ProductGateway productGateway() {
        return new ProductGatewayImpl(
                this.productRepository);
    }

    @Bean
    @ConditionalOnMissingBean(WalletGateway.class)
    public WalletGateway walletGateway() {
        return new WalletGatewayImpl(
                this.walletRepository);
    }

    @Bean
    @ConditionalOnMissingBean(SecurityGateway.class)
    public SecurityGateway securityGateway() {
        return new SecurityGatewayImpl(
                this.authenticationManager, this.jwtService
        );
    }
}
