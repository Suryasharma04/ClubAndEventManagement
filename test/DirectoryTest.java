package test;

import org.junit.jupiter.api.Test;

import main.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

    @Test
    void testConstructor() {
        Directory directory = new Directory();

        // Equivalence case: Directory initialized with empty sets
        assertNotNull(directory.getAllMembers());
        assertNotNull(directory.getAllEvents());
        assertNotNull(directory.getAllClubs());
        assertEquals(0, directory.getAllMembers().size());
        assertEquals(0, directory.getAllEvents().size());
        assertEquals(0, directory.getAllClubs().size());
    }

    @Test
    void testMemberMethods() {
        Directory directory = new Directory();
        Member member1 = new Member("John", "Doe", "john@example.com", "123456");
       // Member member2 = new Member("Jane", "Smith", "jane@example.com", "654321");

        // Equivalence case: Add member to directory
        directory.addMember(member1);
        assertEquals(1, directory.getAllMembers().size());
        assertTrue(directory.getAllMembers().contains(member1));

        // Equivalence case: Remove member from directory
        directory.removeMember(member1);
        assertEquals(0, directory.getAllMembers().size());
        assertFalse(directory.getAllMembers().contains(member1));
        
        // Border case: Adding null member
        assertThrows(IllegalArgumentException.class, () -> directory.addMember(null));

        // Border case: Removing null member
        assertThrows(IllegalArgumentException.class, () -> directory.removeMember(null));
    }

    @Test
    void testEventMethods() {
        Directory directory = new Directory();
        Club club1 = new Club("IC Music Club", "2020", "Joe Doe");
       // Club club2 = new Club("Paint Club", "2021", "Alice Cooper");
        Event event1 = new Event("Event1", "Location1", club1, "2024-01-01", "12:00 PM");
        //Event event2 = new Event("Event2", "Location2", club2, "2024-01-02", "1:00 PM");

        // Equivalence case: Add event to directory
        directory.addEvent(event1);
        assertEquals(1, directory.getAllEvents().size());
        assertTrue(directory.getAllEvents().contains(event1));

        // Equivalence case: Remove event from directory
        directory.removeEvent(event1);
        assertEquals(0, directory.getAllEvents().size());
        assertFalse(directory.getAllEvents().contains(event1));

        // Border case: Adding null event
        assertThrows(IllegalArgumentException.class, () -> directory.addEvent(null));

        // Border case: Removing null event
        assertThrows(IllegalArgumentException.class, () -> directory.removeEvent(null));
    }

    @Test
    void testClubMethods() {
        Directory directory = new Directory();
        Club club1 = new Club("Music Club", "2020", "Alice Cooper");
       // Club club2 = new Club("Dance Club", "2021", "John Doe");

        // Equivalence case: Add club to directory
        directory.addClub(club1);
        assertEquals(1, directory.getAllClubs().size());
        assertTrue(directory.getAllClubs().contains(club1));

        // Equivalence case: Remove club from directory
        directory.removeClub(club1);
        assertEquals(0, directory.getAllClubs().size());
        assertFalse(directory.getAllClubs().contains(club1));

        // Border case: Adding null club
        assertThrows(IllegalArgumentException.class, () -> directory.addClub(null));

        // Border case: Removing null club
        assertThrows(IllegalArgumentException.class, () -> directory.removeClub(null));
    }

    @Test
    void testGetAllAttendees() {
        Directory directory = new Directory();
        Club club1 = new Club("Music Club", "2020", "Alice Cooper");
        Member member1 = new Member("John", "Doe", "john@example.com", "123456");
        Member member2 = new Member("Jane", "Smith", "jane@example.com", "654321");
        Event event1 = new Event("Jazzy Nights", "Whalen", club1, "2024-01-01", "12:00 PM");
        Event event2 = new Event("Acapella Night", "Ford Hall", club1, "2024-01-02", "1:00 PM");

        // Equivalence case: Add attendees to events and retrieve all attendees
        event1.addAttendee(member1);
        event1.addAttendee(member2);
        event2.addAttendee(member1);
        directory.addEvent(event1);
        directory.addEvent(event2);

        Set<Member> allAttendees = directory.getAllAttendees();
        assertEquals(2, allAttendees.size());
        assertTrue(allAttendees.contains(member1));
        assertTrue(allAttendees.contains(member2));
    }
}
