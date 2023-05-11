package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Category;

public interface CategoryGateway {

    Category find(final String name);

    Category save(Category entity);
}
