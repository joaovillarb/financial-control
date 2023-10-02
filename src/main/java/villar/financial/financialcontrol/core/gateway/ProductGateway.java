package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {
    List<Product> getAll();

    Optional<Product> byId(Long id);

    Product save(Product product);
}
