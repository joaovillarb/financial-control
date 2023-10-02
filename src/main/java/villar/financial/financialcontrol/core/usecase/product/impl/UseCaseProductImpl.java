package villar.financial.financialcontrol.core.usecase.product.impl;

import villar.financial.financialcontrol.core.gateway.ProductGateway;
import villar.financial.financialcontrol.core.usecase.product.UseCaseProduct;
import villar.financial.financialcontrol.dataprovider.database.entity.Product;

import java.util.List;
import java.util.Optional;

public class UseCaseProductImpl implements UseCaseProduct {

    private final ProductGateway productGateway;

    public UseCaseProductImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<Product> getAll() {
        return productGateway.getAll();
    }

    public Optional<Product> byId(Long id) {
        return productGateway.byId(id);
    }

    public Product save(Product product) {
        return productGateway.save(product);
    }
}
