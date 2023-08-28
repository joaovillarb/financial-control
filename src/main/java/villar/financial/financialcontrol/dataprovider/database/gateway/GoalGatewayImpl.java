package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.gateway.GoalGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;
import villar.financial.financialcontrol.dataprovider.database.repository.GoalRepository;

import java.util.List;

public class GoalGatewayImpl implements GoalGateway {

    private final GoalRepository repository;

    public GoalGatewayImpl(GoalRepository repository) {
        this.repository = repository;
    }

    public Goal save(Goal entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public List<Goal> getAllByAccount(Account account) {
        return this.repository.findAllByAccount(account);
    }
}
