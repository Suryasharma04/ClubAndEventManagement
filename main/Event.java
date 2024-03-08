package main;

import java.util.*;

/**
 * Represents an event in a club.
 */
public class Event {
    private String eventName; // Name of the event
    private String location; // Location of the event
    private String date; // Date of the event
    private String time; // Time of the event
    private Club organizer; // Organizer of the event
    private Set<Member> attendees; // Set of attendees for the event

    /**
     * Constructs an Event object with the specified attributes.
     * @param eventName The name of the event.
     * @param location The location of the event.
     * @param clubName The name of the club hosting the event.
     * @param organizer The organizer of the event.
     * @param date The date of the event.
     * @param time The time of the event.
     */
    public Event(String eventName, String location, Club organizer, String date, String time){
        if (eventName == null || location == null || organizer == null || date == null || time == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        this.eventName = eventName;
        this.location = location;
        this.organizer = organizer;
        this.date = date;
        this.time = time;
        this.attendees = new HashSet<>(); // Initialize attendees set
    }

    // Getters and setters for event attributes

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Club getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Club organizer) {
        this.organizer = organizer;
    }

    public Set<Member> getAttendees() {
        return attendees;
    }

    /**
     * Adds an attendee to the event.
     * @param attendee The attendee to add.
     */
    public void addAttendee(Member attendee) {
        attendees.add(attendee);
    }

    /**
     * Removes an attendee from the event.
     * @param attendee The attendee to remove.
     */
    public void removeAttendee(Member attendee) {
        attendees.remove(attendee);
    }

    /**
     * Registers an attendee for the event.
     * Adds the attendee to the event's attendee list and the directory.
     * @param attendee The attendee to register.
     */
    public void registerAttendee(Member attendee) {
        Directory directory = new Directory();
        directory.addMember(attendee); // Add attendee to directory for record-keeping
        addAttendee(attendee); // Add attendee to event
    }
}

