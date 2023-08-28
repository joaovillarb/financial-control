package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;

import java.util.List;

public interface GoalGateway {

    Goal save(Goal entity);

    List<Goal> getAllByAccount(Account account);
}
