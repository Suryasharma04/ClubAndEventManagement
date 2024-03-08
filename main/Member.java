package main;

// Class representing a member of an organization
public class Member {
    // Member attributes
    private String firstName; // First name of the member
    private String lastName; // Last name of the member
    private String email; // Email address of the member
    private String studentID; // Student ID of the member

    // Constructor for creating a Member object
    public Member(String firstName, String lastName, String email, String studentID){
        if (firstName == null || lastName == null || email == null || studentID == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentID = studentID;
    }

    // Getter method for retrieving the first name of the member
    public String getFirstName() {
        return firstName;
    }
    
    // Setter method for updating the first name of the member
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for retrieving the last name of the member
    public String getLastName() {
        return lastName;
    }
    
    // Setter method for updating the last name of the member
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter method for retrieving the email address of the member
    public String getEmail() {
        return email;
    }
    
    // Setter method for updating the email address of the member
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method for retrieving the student ID of the member
    public String getStudentID() {
        return studentID;
    }
    
    // Setter method for updating the student ID of the member
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Method to convert the Member object to a string representation
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
