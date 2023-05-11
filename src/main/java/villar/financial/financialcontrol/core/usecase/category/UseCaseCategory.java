package villar.financial.financialcontrol.core.usecase.category;

import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;

public interface UseCaseCategory {

    String save(final CategoryDto categoryDto);

    String update(final CategoryDto categoryDto);
}
