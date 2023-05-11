package villar.financial.financialcontrol.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findByName(String name);
}
