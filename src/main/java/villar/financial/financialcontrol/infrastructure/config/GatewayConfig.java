package villar.financial.financialcontrol.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import villar.financial.financialcontrol.core.gateway.AccountGateway;
import villar.financial.financialcontrol.core.gateway.BudgetGateway;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.core.gateway.GoalGateway;
import villar.financial.financialcontrol.core.usecase.person.PersonGateway;
import villar.financial.financialcontrol.dataprovider.database.gateway.*;
import villar.financial.financialcontrol.dataprovider.database.repository.*;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;
    private final CategoryRepository categoryRepository;
    private final BudgetRepository budgetRepository;
    private final GoalRepository goalRepository;

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
}
