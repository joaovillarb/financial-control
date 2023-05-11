package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.exceptions.CategoryNotFound;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.dataprovider.database.repository.CategoryRepository;

public class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository repository;

    public CategoryGatewayImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category find(final String name) {
        return this.repository.findByName(name)
                .orElseThrow(() -> new CategoryNotFound(name));
    }

    public Category save(Category entity) {
        return this.repository.saveAndFlush(entity);
    }
}
