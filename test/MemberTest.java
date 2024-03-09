package test;

import org.junit.jupiter.api.Test;
import main.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    void testConstructor() {
        // Equivalence case: Valid inputs
        Member member = new Member("John", "Doe", "john@example.com", "123456");
        assertEquals("John", member.getFirstName());
        assertEquals("Doe", member.getLastName());
        assertEquals("john@example.com", member.getEmail());
        assertEquals("123456", member.getStudentID());

        // Border case: Null first name
        assertThrows(IllegalArgumentException.class, () -> new Member(null, "Doe", "john@example.com", "123456"));

        // Border case: Null last name
        assertThrows(IllegalArgumentException.class, () -> new Member("John", null, "john@example.com", "123456"));

        // Border case: Null email
        assertThrows(IllegalArgumentException.class, () -> new Member("John", "Doe", null, "123456"));

        // Border case: Null student ID
        assertThrows(IllegalArgumentException.class, () -> new Member("John", "Doe", "john@example.com", null));
    }

    @Test
    void testSetters() {
        Member member = new Member("John", "Doe", "john@example.com", "123456");

        // Equivalence case: Set first name
        member.setFirstName("Jane");
        assertEquals("Jane", member.getFirstName());

        // Equivalence case: Set last name
        member.setLastName("Smith");
        assertEquals("Smith", member.getLastName());

        // Equivalence case: Set email
        member.setEmail("jane@example.com");
        assertEquals("jane@example.com", member.getEmail());

        // Equivalence case: Set student ID
        member.setStudentID("654321");
        assertEquals("654321", member.getStudentID());
    }
}
