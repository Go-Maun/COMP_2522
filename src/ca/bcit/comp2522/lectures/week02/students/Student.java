package ca.bcit.comp2522.lectures.week02.students;

/**
 * Represents a BCIT student.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class Student {

    private final String firstName;
    private final String lastName;
    private final Address homeAddress;
    private final Address schoolAddress;

    /**
     * Constructs a Student object that contains the specified values.
     *
     * @param firstName  a String representing the usefulclasses name
     * @param lastName   a String representing the last name
     * @param homeAddress   an Address object containing the home address
     * @param schoolAddress an Address object containing the school address
     */
    public Student(final String firstName,
                   final String lastName,
                   final Address homeAddress,
                   final Address schoolAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.schoolAddress = schoolAddress;
    }

    /**
     * Returns a String description of this Student object.
     *
     * @return description a String
     */
    public String toString() {
        String result;
        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress;
        return result;
    }
}

