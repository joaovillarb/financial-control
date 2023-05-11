package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Category;

public record CategoryDto(
        String name,
        String description) {
    public CategoryDto(Category category) {
        this(
                category.getName(),
                category.getDescription()
        );
    }
}
