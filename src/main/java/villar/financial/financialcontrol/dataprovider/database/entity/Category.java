package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Budget> budgets;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Goal> goals;

    public Category(CategoryDto categoryDto) {
        this.name = categoryDto.name();
        this.description = categoryDto.description();
    }

    public Category update(CategoryDto categoryDto) {
        if (Objects.nonNull(categoryDto.name())) {
            this.name = categoryDto.name();
        }
        if (Objects.nonNull(categoryDto.description())) {
            this.name = categoryDto.description();
        }
        return this;
    }
}
