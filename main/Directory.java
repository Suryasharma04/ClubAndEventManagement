package main;

import java.util.*;

/**
 * Represents a directory that stores information about members, events, and clubs.
 */
public class Directory {
    protected Set<Member> allMembers; // Set of all members
    protected Set<Event> allEvents; // Set of all events
    protected Set<Club> allClubs; // Set of all clubs

    /**
     * Constructs a Directory object.
     * Initializes sets for members, events, and clubs.
     */
    public Directory() {
        allMembers = new HashSet<>();
        allEvents = new HashSet<>();
        allClubs = new HashSet<>();
    }

    // Methods for managing members

    /**
     * Retrieves all members in the directory.
     * @return Set of all members.
     */
    public Set<Member> getAllMembers() {
        return allMembers;
    }

    /**
     * Adds a member to the directory.
     * @param member The member to add.
     */
    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        allMembers.add(member);
    }

    /**
     * Removes a member from the directory.
     * @param member The member to remove.
     */
    public void removeMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        allMembers.remove(member);
    }

    // Methods for managing events

    /**
     * Retrieves all events in the directory.
     * @return Set of all events.
     */
    public Set<Event> getAllEvents() {
        return allEvents;
    }

    /**
     * Adds an event to the directory.
     * @param event The event to add.
     */
    public void addEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        allEvents.add(event);
    }

    /**
     * Removes an event from the directory.
     * @param event The event to remove.
     */
    public void removeEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        allEvents.remove(event);
    }

    // Methods for managing clubs

    /**
     * Retrieves all clubs in the directory.
     * @return Set of all clubs.
     */
    public Set<Club> getAllClubs() {
        return allClubs;
    }

    /**
     * Adds a club to the directory.
     * @param club The club to add.
     */
    public void addClub(Club club) {
        if (club == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        allClubs.add(club);
    }

    /**
     * Removes a club from the directory.
     * @param club The club to remove.
     */
    public void removeClub(Club club) {
        if (club == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        allClubs.remove(club);
    }
    
    // Method for retrieving all attendees across all events

    /**
     * Retrieves all attendees across all events in the directory.
     * @return Set of all attendees.
     */
    public Set<Member> getAllAttendees() {
        Set<Member> allAttendees = new HashSet<>();
        for (Event event : allEvents) {
            allAttendees.addAll(event.getAttendees());
        }
        return allAttendees;
    }
}
