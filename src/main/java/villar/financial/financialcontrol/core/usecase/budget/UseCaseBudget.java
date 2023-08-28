package villar.financial.financialcontrol.core.usecase.budget;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;

import java.time.YearMonth;

public interface UseCaseBudget {
    BudgetDto add(BudgetDto budgetDto);

    Page<BudgetDto> pageBy(Pageable pageable);

    Page<BudgetDto> pageByLogin(String accountLogin, Pageable pageable);

    Page<BudgetDto> pageByLoginAndDate(String accountLogin, YearMonth yearMonth, Pageable pageable);
}
