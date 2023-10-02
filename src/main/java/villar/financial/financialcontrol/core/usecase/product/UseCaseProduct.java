package villar.financial.financialcontrol.core.usecase.product;


import villar.financial.financialcontrol.dataprovider.database.entity.Product;

import java.util.List;
import java.util.Optional;

public interface UseCaseProduct {

    List<Product> getAll();

    Optional<Product> byId(Long id);

    Product save(Product product);
}
