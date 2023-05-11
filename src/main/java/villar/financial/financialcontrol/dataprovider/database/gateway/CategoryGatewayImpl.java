package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.dataprovider.database.repository.CategoryRepository;

import java.util.Optional;

public class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository repository;

    public CategoryGatewayImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    public Optional<Category> find(final String name) {
        return this.repository.findByName(name);
    }

    public Category save(Category entity) {
        return this.repository.saveAndFlush(entity);
    }
}
