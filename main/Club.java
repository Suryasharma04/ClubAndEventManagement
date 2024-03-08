package main;
import java.util.*;

/**
 * Represents a club with a name, establishment year, executive board members, and events.
 */
public class Club {
    private String clubName; // Name of the club
    private String established; // Establishment year of the club
    private Set<Member> members; // Set of club members
    private Set<Member> eboardMembers; // Set of executive board members
    private List<Event> events; // List of events associated with the club
    private String advisorName;

    /**
     * Constructs a Club object with the specified attributes.
     * @param clubName The name of the club.
     * @param established The establishment year of the club.
     * @param advisorName The name of the club advisor.
     */
    public Club(String clubName, String established, String advisorName) {
        if (clubName == null) {
            throw new IllegalArgumentException("Club name cannot be null.");
        }
        if (advisorName == null) {
            throw new IllegalArgumentException("Advisor name cannot be null.");
        }
        if (established == null) {
            throw new IllegalArgumentException("Year cannot be null.");
        }
        
        this.clubName = clubName;
        this.established = established;
        this.members = new HashSet<>();
        this.eboardMembers = new HashSet<>();
        this.events = new ArrayList<>();
    }

    // Getter and setter methods

    /**
     * Retrieves the name of the club.
     * @return The name of the club.
     */
    public String getClubName() {
        return clubName;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    /**
     * Sets the name of the club.
     * @param clubName The name of the club.
     */
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    /**
     * Retrieves the establishment year of the club.
     * @return The establishment year of the club.
     */
    public String getEstablished() {
        return established;
    }

    /**
     * Sets the establishment year of the club.
     * @param established The establishment year of the club.
     */
    public void setEstablished(String established) {
        this.established = established;
    }

    /**
     * Retrieves the set of club members.
     * @return The set of club members.
     */
    public Set<Member> getMembers() {
        return members;
    }

    /**
     * Adds a member to the club.
     * @param member The member to add.
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Removes a member from the club.
     * @param member The member to remove.
     */
    public void removeMember(Member member) {
        members.remove(member);
    }

    /**
     * Retrieves the set of executive board members.
     * @return The set of executive board members.
     */
    public Set<Member> getEboardMembers() {
        return eboardMembers;
    }

    /**
     * Adds an executive board member to the club.
     * @param member The executive board member to add.
     */
    public void addEboardMember(Member member) {
        eboardMembers.add(member);
    }

    /**
     * Removes an executive board member from the club.
     * @param member The executive board member to remove.
     */
    public void removeEboardMember(Member member) {
        eboardMembers.remove(member);
    }

    /**
     * Retrieves the list of events associated with the club.
     * @return The list of events associated with the club.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Adds an event to the club's list of events.
     * @param event The event to add.
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Removes an event from the club's list of events.
     * @param event The event to remove.
     */
    public void removeEvent(Event event) {
        events.remove(event);
    }
}
