package villar.financial.financialcontrol.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findByLogin(String login);

    boolean existsByLogin(String login);
}
