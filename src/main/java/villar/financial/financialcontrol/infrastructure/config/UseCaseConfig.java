package villar.financial.financialcontrol.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import villar.financial.financialcontrol.core.gateway.*;
import villar.financial.financialcontrol.core.usecase.account.UseCaseAccount;
import villar.financial.financialcontrol.core.usecase.account.impl.UseCaseAccountImpl;
import villar.financial.financialcontrol.core.usecase.budget.UseCaseBudget;
import villar.financial.financialcontrol.core.usecase.budget.impl.UseCaseBudgetImpl;
import villar.financial.financialcontrol.core.usecase.category.UseCaseCategory;
import villar.financial.financialcontrol.core.usecase.category.impl.UseCaseCategoryImpl;
import villar.financial.financialcontrol.core.usecase.goal.UseCaseGoal;
import villar.financial.financialcontrol.core.usecase.goal.impl.UseCaseGoalImpl;
import villar.financial.financialcontrol.core.usecase.product.UseCaseProduct;
import villar.financial.financialcontrol.core.usecase.product.impl.UseCaseProductImpl;
import villar.financial.financialcontrol.core.usecase.wallet.UseCaseWallet;
import villar.financial.financialcontrol.core.usecase.wallet.impl.UseCaseWalletImpl;

@Configuration
@RequiredArgsConstructor
public class UseCaseConfig {

    private final AccountGateway accountGateway;
    private final CategoryGateway categoryGateway;
    private final BudgetGateway budgetGateway;
    private final GoalGateway goalGateway;
    private final ProductGateway productGateway;
    private final WalletGateway walletGateway;

    @Bean
    @ConditionalOnMissingBean(UseCaseGoal.class)
    public UseCaseGoal useCaseGoal() {
        return new UseCaseGoalImpl(
                this.goalGateway,
                this.categoryGateway);
    }

    @Bean
    @ConditionalOnMissingBean(UseCaseBudget.class)
    public UseCaseBudget useCaseBudget() {
        return new UseCaseBudgetImpl(
                this.budgetGateway,
                this.categoryGateway);
    }

    @Bean
    @ConditionalOnMissingBean(UseCaseAccount.class)
    public UseCaseAccount useCaseAccount() {
        return new UseCaseAccountImpl(
                this.accountGateway);
    }

    @Bean
    @ConditionalOnMissingBean(UseCaseCategory.class)
    public UseCaseCategory useCaseCategory() {
        return new UseCaseCategoryImpl(
                this.categoryGateway);
    }

    @Bean
    @ConditionalOnMissingBean(UseCaseProduct.class)
    public UseCaseProduct useCaseProduct() {
        return new UseCaseProductImpl(
                this.productGateway);
    }

    @Bean
    @ConditionalOnMissingBean(UseCaseWallet.class)
    public UseCaseWallet useCaseWallet() {
        return new UseCaseWalletImpl(
                this.walletGateway);
    }

}
