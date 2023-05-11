package villar.financial.financialcontrol.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import villar.financial.financialcontrol.dataprovider.database.entity.Person;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
