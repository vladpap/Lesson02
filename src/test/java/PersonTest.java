import org.junit.BeforeClass;
import org.junit.Test;
import ru.sbt.model.Person;

import static org.junit.Assert.*;

public class PersonTest {
    private Person person1;
    private Person person2;
    private Person person3;

    public void testInitPerson() {
        person1 = new Person("aaa", true);
        person2 = new Person("bbb", false);
        person3 = new Person("ccc", true);
    }

    @Test
    public void testMarryIsNull() {
        testInitPerson();

        person1.marry(person2);
        assertEquals(person1, person2.getSpouse());
        assertEquals(person2, person1.getSpouse());
    }

    @Test
    public void testMarryFailedIsNotNull() {
        testInitPerson();

        person1.marry(person2);

        assertEquals(false, person3.marry(person1));
    }

    @Test
    public void testMarryIsNotNull() {
        testInitPerson();

        person1.marry(person2);
        person3.marry(person2);

        assertEquals(person2, person3.getSpouse());
        assertEquals(person3, person2.getSpouse());
        assertNull(person1.getSpouse());
    }

    @Test
    public void testMaryPersonsAndDivorcePersons() {
        testInitPerson();

        person1.marry(person2);
        person2.divorce();

        assertNull(person1.getSpouse());
        assertNull(person2.getSpouse());
    }
}

