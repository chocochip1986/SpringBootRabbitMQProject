package rabbitmq.events.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rabbitmq.entities.Person;
import rabbitmq.enums.Gender;
import rabbitmq.events.BaseEvent;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PersonCreatedEvent extends BaseEvent {
    private String firstName;
    private String lastName;
    private Gender gender;

    public PersonCreatedEvent(String firstName, String lastName, Gender gender) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @Override
    public void process() {
        Person.createPerson(this);
    }
}
