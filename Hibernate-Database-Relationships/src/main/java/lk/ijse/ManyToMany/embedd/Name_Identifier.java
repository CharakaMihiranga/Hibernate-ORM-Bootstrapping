package lk.ijse.ManyToMany.embedd;

import javax.persistence.Embeddable;

@Embeddable
public class Name_Identifier {
    private String first_Name;
    private String second_Name;
    private String last_Name;

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getSecond_Name() {
        return second_Name;
    }

    public void setSecond_Name(String second_Name) {
        this.second_Name = second_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Name_Identifier() {
    }

    public Name_Identifier(String first_Name, String second_Name, String last_Name) {
        this.first_Name = first_Name;
        this.second_Name = second_Name;
        this.last_Name = last_Name;
    }

    @Override
    public String toString() {
        return "Name_Identifier{" +
                "first_Name='" + first_Name + '\'' +
                ", second_Name='" + second_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                '}';
    }
}
