package villar.financial.financialcontrol;

import org.springframework.test.context.ActiveProfiles;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import static villar.financial.financialcontrol.ConstantsTest.*;

@ActiveProfiles("test")
public abstract class BaseTest {

    public Category createCategoryEntity() {
        Category category = new Category(
                CATEGORY_NAME,
                CATEGORY_DESCRIPTION,
                Collections.emptyList(),
                Collections.emptyList()
        );
        category.setUuid(UUID.randomUUID());
        category.prePersist();
        return category;
    }

    public Account createAccountEntity() {
        Account account = new Account(
                EMAIL_TEST,
                PASSWORD_TEST,
                null,
                null,
                null,
                null
        );
        account.setUuid(UUID.randomUUID());
        account.prePersist();
        return account;
    }

    public Budget createBudgetEntity() {
        Budget budget = new Budget(
                LocalDateTime.now(),
                BigDecimal.TEN,
                "Compra aleatória",
                createAccountEntity(),
                createCategoryEntity()
        );
        budget.setUuid(UUID.randomUUID());
        budget.prePersist();
        return budget;
    }

    public Goal createGoalEntity() {
        Goal goal = new Goal(
                BigDecimal.valueOf(1000L),
                createAccountEntity(),
                createCategoryEntity()
        );
        goal.setUuid(UUID.randomUUID());
        goal.prePersist();
        return goal;
    }
}
