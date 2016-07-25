import org.junit.Test;
import ru.sbt.model.Person;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testMarryIsNull() {
        Person person1 = new Person("aaa", true);
        Person person2 = new Person("bbb", false);
        person1.marry(person2);
        assertEquals(person1, person2.getSpouse());
        assertEquals(person2, person1.getSpouse());
    }

    @Test
    public void testMarryFailedIsNotNull() {
        Person person1 = new Person("aaa", true);
        Person person2 = new Person("bbb", false);
        person1.marry(person2);

        Person person3 = new Person("ccc", true);

        assertEquals(false, person3.marry(person1));
    }

    @Test
    public void testMarryIsNotNull() {
        Person person1 = new Person("aaa", true);
        Person person2 = new Person("bbb", false);
        person1.marry(person2);

        Person person3 = new Person("ccc", true);
        person3.marry(person2);

        assertEquals(person2, person3.getSpouse());
        assertEquals(person3, person2.getSpouse());
        assertNull(person1.getSpouse());
    }

    @Test
    public void testMaryPersonsAndDivorcePersons() {
        Person person1 = new Person("aaa", true);
        Person person2 = new Person("bbb", false);
        person1.marry(person2);

        person2.divorce();

        assertNull(person1.getSpouse());
        assertNull(person2.getSpouse());
    }
}

