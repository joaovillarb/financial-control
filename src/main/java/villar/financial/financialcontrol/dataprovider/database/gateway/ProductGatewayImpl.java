package villar.financial.financialcontrol.dataprovider.database.gateway;


import villar.financial.financialcontrol.core.gateway.ProductGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Product;
import villar.financial.financialcontrol.dataprovider.database.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductGatewayImpl implements ProductGateway {

    private final ProductRepository productRepository;

    public ProductGatewayImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Optional<Product> byId(Long id) {
        return this.productRepository.findById(id);
    }

    public Product save(Product product) {
        return this.productRepository.save(product);
    }
}
