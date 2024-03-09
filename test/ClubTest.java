package test;

import org.junit.jupiter.api.Test;
import main.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClubTest {

    @Test
    void testConstructor() {
        // Equivalence class: Valid inputs
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        assertEquals("Paint Club", club.getClubName());
        assertEquals("2020", club.getEstablished());
        assertTrue(club.getMembers().isEmpty());
        assertTrue(club.getEboardMembers().isEmpty());
        assertTrue(club.getEvents().isEmpty());

        // Equivalence class: Null club name
        assertThrows(IllegalArgumentException.class, () -> new Club(null, "2020", "Alice Cooper"));

        // Equivalence class: Null establishment year
        assertThrows(IllegalArgumentException.class, () -> new Club("Paint Club", null, "Alice Cooper"));

        // Equivalence class: Null advisor name
        assertThrows(IllegalArgumentException.class, () -> new Club("Paint Club", "2020", null));
    }

    @Test
    void testAddAndRemoveMemberBorderCases() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Member member = new Member("John", "Doe", "john@example.com", "123456");

        // Border case: Add member when the club has no members
        club.addMember(member);
        assertTrue(club.getMembers().contains(member));

        // Border case: Remove member when the club has only one member
        club.removeMember(member);
        assertTrue(club.getMembers().isEmpty());
    }

    @Test
    void testAddAndRemoveEboardMemberBorderCases() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Member eboardMember = new Member("Jane", "Smith", "jane@example.com", "654321");

        // Border case: Add executive board member when the club has no executive board members
        club.addEboardMember(eboardMember);
        assertTrue(club.getEboardMembers().contains(eboardMember));

        // Border case: Remove executive board member when the club has only one executive board member
        club.removeEboardMember(eboardMember);
        assertTrue(club.getEboardMembers().isEmpty());
    }

    @Test
    void testAddAndRemoveEventBorderCases() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Event event = new Event("Paint and Sip", "Lyon Hall", club, "2024-03-10", "10:00 AM");

        // Border case: Add event when the club has no events
        club.addEvent(event);
        assertTrue(club.getEvents().contains(event));

        // Border case: Remove event when the club has only one event
        club.removeEvent(event);
        assertTrue(club.getEvents().isEmpty());
    }

    @Test
    void testAddAndRemoveMemberEquivalenceCases() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Member member1 = new Member("John", "Doe", "john@example.com", "123456");
        Member member2 = new Member("Jane", "Smith", "jane@example.com", "654321");

        // Equivalence case: Add multiple members
        club.addMember(member1);
        club.addMember(member2);
        assertEquals(2, club.getMembers().size());
        assertTrue(club.getMembers().contains(member1));
        assertTrue(club.getMembers().contains(member2));

        // Equivalence case: Remove one member out of multiple members
        club.removeMember(member1);
        assertEquals(1, club.getMembers().size());
        assertFalse(club.getMembers().contains(member1));
        assertTrue(club.getMembers().contains(member2));
    }

    @Test
    void testAddAndRemoveEboardMemberEquivalenceCases() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Member eboardMember1 = new Member("John", "Doe", "john@example.com", "123456");
        Member eboardMember2 = new Member("Jane", "Smith", "jane@example.com", "654321");

        // Equivalence case: Add multiple executive board members
        club.addEboardMember(eboardMember1);
        club.addEboardMember(eboardMember2);
        assertEquals(2, club.getEboardMembers().size());
        assertTrue(club.getEboardMembers().contains(eboardMember1));
        assertTrue(club.getEboardMembers().contains(eboardMember2));

        // Equivalence case: Remove one executive board member out of multiple executive board members
        club.removeEboardMember(eboardMember1);
        assertEquals(1, club.getEboardMembers().size());
        assertFalse(club.getEboardMembers().contains(eboardMember1));
        assertTrue(club.getEboardMembers().contains(eboardMember2));
    }

    @Test
    void testAddAndRemoveEventEquivalenceCases() {
        Club club = new Club("Paint Club", "2020", "Alice Cooper");
        Event event1 = new Event("Paint and Sip", "Lyon Hall", club, "2024-03-10", "10:00 AM");
        Event event2 = new Event("Origami with Paper", "Terrace 2", club, "2024-03-15", "2:00 PM");

        // Equivalence case: Add multiple events
        club.addEvent(event1);
        club.addEvent(event2);
        assertEquals(2, club.getEvents().size());
        assertTrue(club.getEvents().contains(event1));
        assertTrue(club.getEvents().contains(event2));

        // Equivalence case: Remove one event out of multiple events
        club.removeEvent(event1);
        assertEquals(1, club.getEvents().size());
    }
}
