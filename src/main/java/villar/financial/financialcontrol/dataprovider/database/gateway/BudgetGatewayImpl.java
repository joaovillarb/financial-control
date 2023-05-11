package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.gateway.BudgetGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.repository.BudgetRepository;

public class BudgetGatewayImpl implements BudgetGateway {

    private final BudgetRepository repository;

    public BudgetGatewayImpl(BudgetRepository repository) {
        this.repository = repository;
    }

    public Budget save(Budget entity) {
        return this.repository.saveAndFlush(entity);
    }
}
