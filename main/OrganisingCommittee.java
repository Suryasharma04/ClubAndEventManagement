package main;
import java.util.Set;

/**
 * Represents an organizing committee with the authority to manage members, events, and clubs in the directory.
 */
public class OrganisingCommittee extends Directory {

    /**
     * Constructs an OrganizingCommittee object.
     * Initializes sets for members, events, and clubs.
     */
    public OrganisingCommittee() {
        super();
    }

    /**
     * Adds a member to the directory.
     * @param member The member to add.
     */
    public void addMember(Member member) {
        super.addMember(member);
    }

    /**
     * Removes a member from the directory.
     * @param member The member to remove.
     */
    public void removeMember(Member member) {
        super.removeMember(member);
    }

    /**
     * Adds an event to the directory.
     * @param event The event to add.
     */
    public void addEvent(Event event) {
        super.addEvent(event);
    }

    /**
     * Removes an event from the directory.
     * @param event The event to remove.
     */
    public void removeEvent(Event event) {
        super.removeEvent(event);
    }

    /**
     * Adds a club to the directory.
     * @param club The club to add.
     */
    public void addClub(Club club) {
        super.addClub(club);
    }

    /**
     * Removes a club from the directory.
     * @param club The club to remove.
     */
    public void removeClub(Club club) {
        super.removeClub(club);
    }

    /**
     * Retrieves all members in the directory.
     * @return A set containing all members.
     */
    public Set<Member> getAllMembers() {
        return super.getAllMembers();
    }

    /**
     * Retrieves all events in the directory.
     * @return A set containing all events.
     */
    public Set<Event> getAllEvents() {
        return super.getAllEvents();
    }

    /**
     * Retrieves all clubs in the directory.
     * @return A set containing all clubs.
     */
    public Set<Club> getAllClubs() {
        return super.getAllClubs();
    }
}
