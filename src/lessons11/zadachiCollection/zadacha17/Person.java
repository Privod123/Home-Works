package lessons11.zadachiCollection.zadacha17;

/**
 * Created by Hello on 15.11.2018.
 */
public class Person implements RepkaItem <Person> {
    private String name;
    private String person;

    public Person(String name, String person) {
        this.name = name;
        this.person = person;
    }

    @Override
    public void pull(Person person) {
        System.out.println( this.name + " за " + person.person);
    }
}
