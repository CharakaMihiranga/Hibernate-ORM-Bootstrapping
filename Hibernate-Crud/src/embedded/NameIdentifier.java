package embedded;

import javax.persistence.Embeddable;

@Embeddable
public class NameIdentifier {

    private String firstName;
    private String middleName;
    private String LastName;

    public NameIdentifier(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        LastName = lastName;
    }

    public NameIdentifier() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "NameIdentifier{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
