package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import villar.financial.financialcontrol.core.usecase.category.UseCaseCategory;
import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;

@RestController
@RequestMapping("category")
class CategoryApi {

    private final UseCaseCategory useCaseCategory;

    CategoryApi(UseCaseCategory useCaseCategory) {
        this.useCaseCategory = useCaseCategory;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody CategoryDto dto) {
        return this.useCaseCategory.save(dto);
    }
}
