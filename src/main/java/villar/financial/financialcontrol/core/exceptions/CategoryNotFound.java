package villar.financial.financialcontrol.core.exceptions;

public class CategoryNotFound extends NotFoundException {
    public CategoryNotFound(String name) {
        super(String.format("Category=[%s] not found", name));
    }
}
