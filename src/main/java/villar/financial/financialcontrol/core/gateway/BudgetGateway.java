package villar.financial.financialcontrol.core.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;

import java.time.LocalDateTime;

public interface BudgetGateway {

    Budget save(Budget entity);

    Page<Budget> page(Pageable pageable);

    Page<Budget> pageByLogin(String accountLogin, Pageable pageable);

    Page<Budget> pageByLoginAndDate(String accountLogin, LocalDateTime startOfMonth, LocalDateTime endOfMonth, Pageable pageable);
}
