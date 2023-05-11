package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import villar.financial.financialcontrol.entrypoint.dto.PersonDto;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {

    private String name;
    @OneToOne
    private Account account;

    public Person(PersonDto person, Account account) {
        this.name = person.name();
        this.account = account;
    }
}
