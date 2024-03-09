package test;

import org.junit.jupiter.api.Test;

import main.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    @Test
    void testConstructor() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");

        // Equivalence class: Valid inputs
        Event event = new Event("Paint and Sip", "Lyon Hall", club, "2024-03-10", "10:00 AM");
        assertEquals("Paint and Sip", event.getEventName());
        assertEquals("Lyon Hall", event.getLocation());
        assertEquals(club, event.getOrganizer());
        assertEquals("2024-03-10", event.getDate());
        assertEquals("10:00 AM", event.getTime());
        assertTrue(event.getAttendees().isEmpty());

        // Border case: Null event name
        assertThrows(IllegalArgumentException.class, () -> new Event(null, "Lyon Hall", club, "2024-03-10", "10:00 AM"));

        // Border case: Null location
        assertThrows(IllegalArgumentException.class, () -> new Event("Paint and Sip", null, club, "2024-03-10", "10:00 AM"));

        // Border case: Null club
        assertThrows(IllegalArgumentException.class, () -> new Event("Paint and Sip", "Lyon Hall", null, "2024-03-10", "10:00 AM"));

        // Border case: Null date
        assertThrows(IllegalArgumentException.class, () -> new Event("Paint and Sip", "Lyon Hall", club, null, "10:00 AM"));

        // Border case: Null time
        assertThrows(IllegalArgumentException.class, () -> new Event("Paint and Sip", "Lyon Hall", club, "2024-03-10", null));
    }

    @Test
    void testAddAndRemoveAttendee() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Event event = new Event("Paint and Sip", "Lyon Hall", club, "2024-03-10", "10:00 AM");
        Member attendee1 = new Member("John", "Doe", "john@example.com", "123456");
        Member attendee2 = new Member("Jane", "Smith", "jane@example.com", "654321");

        // Equivalence case: Add single attendee
        event.addAttendee(attendee1);
        assertTrue(event.getAttendees().contains(attendee1));

        // Equivalence case: Add multiple attendees
        event.addAttendee(attendee2);
        assertTrue(event.getAttendees().contains(attendee2));

        // Equivalence case: Remove single attendee
        event.removeAttendee(attendee1);
        assertFalse(event.getAttendees().contains(attendee1));

        // Equivalence case: Remove attendee not in the list
        assertFalse(event.getAttendees().contains(attendee1));
        event.removeAttendee(attendee1);
        assertFalse(event.getAttendees().contains(attendee1));

        // Equivalence case: Add attendee after removal
        event.addAttendee(attendee1);
        assertTrue(event.getAttendees().contains(attendee1));
    }

    @Test
    void testRegisterAttendee() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Event event = new Event("Paint and Sip", "Lyon Hall", club, "2024-03-10", "10:00 AM");
        Member attendee = new Member("John", "Doe", "john@example.com", "123456");

        event.registerAttendee(attendee);
        assertTrue(event.getAttendees().contains(attendee));
    }
}
