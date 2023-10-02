package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.web.bind.annotation.*;
import villar.financial.financialcontrol.core.usecase.product.UseCaseProduct;
import villar.financial.financialcontrol.dataprovider.database.entity.Product;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductApi {

    private final UseCaseProduct useCaseProduct;

    public ProductApi(UseCaseProduct useCaseProduct) {
        this.useCaseProduct = useCaseProduct;
    }

    @GetMapping("find-all")
    public List<Product> getAll() {
        return useCaseProduct.getAll();
    }

    @GetMapping("{id}")
    public Optional<Product> byId(@PathVariable Long id) {
        return useCaseProduct.byId(id);
    }

    @PostMapping("insert")
    public Product insert(@RequestBody Product product) {
        return useCaseProduct.save(product);
    }

}
