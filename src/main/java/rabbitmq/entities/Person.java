package rabbitmq.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rabbitmq.enums.Gender;
import rabbitmq.events.person.PersonCreatedEvent;
import rabbitmq.events.person.PersonUpdateDetailsEvent;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String firstName;

    private String lastName;

    private Gender gender;

    public static Person updatePerson(PersonUpdateDetailsEvent event) {
        Person person = event.getOriginalPerson();
        person.setFirstName(event.getFirstName());
        person.setLastName(event.getLastName());
        person.setGender(event.getGender());
        return person;
    }

    public static Person createPerson(PersonCreatedEvent event) {
        return create(event.getFirstName(), event.getLastName(), event.getGender());
    }

    private static Person create(String firstName, String lastName, Gender gender) {
        return Person.builder().firstName(firstName).lastName(lastName).gender(gender).build();
    }
}
