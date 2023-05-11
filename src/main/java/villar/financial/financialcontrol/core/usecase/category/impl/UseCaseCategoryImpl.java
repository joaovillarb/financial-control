package villar.financial.financialcontrol.core.usecase.category.impl;

import org.springframework.transaction.annotation.Transactional;
import villar.financial.financialcontrol.core.gateway.CategoryGateway;
import villar.financial.financialcontrol.core.usecase.category.UseCaseCategory;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;

public class UseCaseCategoryImpl implements UseCaseCategory {

    private final CategoryGateway categoryGateway;

    public UseCaseCategoryImpl(final CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Transactional
    public String save(CategoryDto categoryDto) {
        final Category category = new Category(categoryDto);
        return this.categoryGateway.save(category).getId();
    }

    @Transactional
    public String update(CategoryDto categoryDto) {
        final Category categoryFounded = this.categoryGateway.find(categoryDto.name())
                .orElseThrow(() -> new RuntimeException())
                .update(categoryDto);
        final Category category = this.categoryGateway.save(categoryFounded);
        return category.getId();
    }
}
