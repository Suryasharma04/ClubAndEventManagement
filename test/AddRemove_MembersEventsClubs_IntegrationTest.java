package test;

import main.*;
import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddRemove_MembersEventsClubs_IntegrationTest {
    /** Creating a new Directory, and then adding members to the Member Directory. New Clubs are created and then added to the club
     * directory. Then events created by different clubs are stored. Here the 
     */

    @Test
    void testIntegration() {
        Directory directory = new Directory();

        // Adding members to the directory
        Member member1 = new Member("John", "Doe", "john@example.com", "123456");
        Member member2 = new Member("Jane", "Smith", "jane@example.com", "654321");
        directory.addMember(member1);
        directory.addMember(member2);

        // Creating and adding clubs to the directory
        Club club1 = new Club("Paint Club", "2020", "Alice Cooper");
        Club club2 = new Club("Music Club", "2018", "Bob Marley");
        directory.addClub(club1);
        directory.addClub(club2);

        // Adding members to the executive board of clubs
        club1.addEboardMember(member1);
        club2.addEboardMember(member2);

        // Creating and adding events to the clubs
        Event event1 = new Event("Paint and Sip", "Lyon Hall", club1, "2024-03-10", "10:00 AM");
        Event event2 = new Event("Origami with Paper", "Terrace 2", club1, "2024-03-15", "2:00 PM");
        Event event3 = new Event("Concert Night", "Auditorium", club2, "2024-03-20", "7:00 PM");
        directory.addEvent(event1);
        directory.addEvent(event2);
        directory.addEvent(event3);

        Member member3 = new Member("Lara", "Cooper", "lara@example.com", "645376");
        Member member4 = new Member("Sam", "Doe", "sam@example.com", "654879");
        directory.addMember(member3);
        directory.addMember(member4);

        // Adding attendees to events
        event1.addAttendee(member3);
        event1.addAttendee(member4);
        event2.addAttendee(member3);
        event3.addAttendee(member4);

        // Retrieving all members from the directory and verifying the count and presence of sample members
        Set<Member> allMembers = directory.getAllMembers();
        assertEquals(4, allMembers.size());
        assertTrue(allMembers.contains(member3));
        assertTrue(allMembers.contains(member4));
        assertTrue(allMembers.contains(member1));
        assertTrue(allMembers.contains(member2));

        // Retrieving all clubs from the directory and verifying the count and presence of the created clubs
        Set<Club> allClubs = directory.getAllClubs();
        assertEquals(2, allClubs.size());
        assertTrue(allClubs.contains(club1));
        assertTrue(allClubs.contains(club2));

        // Retrieving all events from the directory and verifying the count and presence of the created events
        Set<Event> allEvents = directory.getAllEvents();
        assertEquals(3, allEvents.size());
        assertTrue(allEvents.contains(event1));
        assertTrue(allEvents.contains(event2));
        assertTrue(allEvents.contains(event3));

        // Retrieving all attendees from the directory and verifying the count and presence of the sample attendees
        Set<Member> allAttendees = directory.getAllAttendees();
        assertEquals(2, allAttendees.size());
        assertTrue(allAttendees.contains(member3));
        assertTrue(allAttendees.contains(member4));

        // Removing an event from the directory and verifying its absence
        directory.removeEvent(event2);
        assertFalse(directory.getAllEvents().contains(event2));

        // Removing a club from the directory and verifying its absence
        directory.removeClub(club2);
        assertFalse(directory.getAllClubs().contains(club2));
    }
}
