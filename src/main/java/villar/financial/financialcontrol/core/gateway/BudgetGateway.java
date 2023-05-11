package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Budget;

public interface BudgetGateway {

    Budget save(Budget entity);
}
