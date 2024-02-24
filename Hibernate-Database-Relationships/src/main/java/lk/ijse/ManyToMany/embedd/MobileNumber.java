package lk.ijse.ManyToMany.embedd;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MobileNumber {
    @Column(name = "mobile_Number_Typ")
    private String typ;
    @Column(name = "mobile_No")
    private String mobileNo;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public MobileNumber(){}
    public MobileNumber(String typ, String mobileNo) {
        this.typ = typ;
        this.mobileNo = mobileNo;
    }
}
