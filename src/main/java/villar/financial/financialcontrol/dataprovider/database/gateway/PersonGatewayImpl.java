package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.gateway.PersonGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Person;
import villar.financial.financialcontrol.dataprovider.database.repository.PersonRepository;

public class PersonGatewayImpl implements PersonGateway {

    private final PersonRepository personRepository;

    public PersonGatewayImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return this.personRepository.saveAndFlush(person);
    }
}
