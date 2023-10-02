package villar.financial.financialcontrol.dataprovider.database.gateway.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import villar.financial.financialcontrol.dataprovider.database.entity.BaseEntity;

public abstract class AbstractGatewayImpl<R extends JpaRepository<E, T>, E extends BaseEntity, T> {

    protected R repository;

    protected AbstractGatewayImpl(R repository) {
        this.repository = repository;
    }

    @Transactional
    public E save(E entity) {
        return this.repository.saveAndFlush(entity);
    }

}
