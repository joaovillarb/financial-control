package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Category;

import java.util.Optional;

public interface CategoryGateway {

    Optional<Category> find(final String name);

    Category save(Category entity);
}
