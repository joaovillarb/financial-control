package villar.financial.financialcontrol.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;

import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {
}
