package villar.financial.financialcontrol.dataprovider.database.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import villar.financial.financialcontrol.core.gateway.BudgetGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.repository.BudgetRepository;

import java.time.LocalDateTime;

public class BudgetGatewayImpl implements BudgetGateway {

    private final BudgetRepository repository;

    public BudgetGatewayImpl(BudgetRepository repository) {
        this.repository = repository;
    }

    public Budget save(Budget entity) {
        return this.repository.saveAndFlush(entity);
    }

    public Page<Budget> page(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<Budget> pageByLogin(String accountLogin, Pageable pageable) {
        return this.repository.findByAccountLogin(accountLogin, pageable);
    }

    public Page<Budget> pageByLoginAndDate(String accountLogin, LocalDateTime startOfMonth, LocalDateTime endOfMonth, Pageable pageable) {
        return this.repository.findByAccountLoginAndDateBetween(accountLogin, startOfMonth, endOfMonth, pageable);
    }
}
