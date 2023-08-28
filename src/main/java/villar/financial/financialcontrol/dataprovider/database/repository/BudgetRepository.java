package villar.financial.financialcontrol.dataprovider.database.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;

import java.time.LocalDateTime;
import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {
    Page<Budget> findByAccountLogin(String accountLogin, Pageable pageable);

    Page<Budget> findByAccountLoginAndDateBetween(String accountLogin, LocalDateTime startOfMonth, LocalDateTime endOfMonth, Pageable pageable);
}
