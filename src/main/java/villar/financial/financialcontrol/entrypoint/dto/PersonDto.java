package villar.financial.financialcontrol.entrypoint.dto;

import villar.financial.financialcontrol.dataprovider.database.entity.Person;

public record PersonDto(String name) {
    public PersonDto(Person person) {
        this(person.getName());
    }
}
