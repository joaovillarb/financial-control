package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.gateway.GoalGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;
import villar.financial.financialcontrol.dataprovider.database.repository.GoalRepository;

public class GoalGatewayImpl implements GoalGateway {

    private final GoalRepository repository;

    public GoalGatewayImpl(GoalRepository repository) {
        this.repository = repository;
    }

    public Goal save(Goal entity) {
        return this.repository.saveAndFlush(entity);
    }
}
