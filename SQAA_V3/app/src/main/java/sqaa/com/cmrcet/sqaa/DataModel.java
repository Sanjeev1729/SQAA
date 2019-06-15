package sqaa.com.cmrcet.sqaa;

/**
 * Created by KH9198 on 4/8/2017.
 */

public class DataModel {

    String InstitutionName;

    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionName(String institutionName) {
        InstitutionName = institutionName;
    }

    public String getInstitutionStatus() {
        return InstitutionStatus;
    }

    public void setInstitutionStatus(String institutionStatus) {
        InstitutionStatus = institutionStatus;
    }

    String InstitutionStatus;


    public DataModel(String name, String status ) {
        this.InstitutionName=name;
        this.InstitutionStatus=status;
    }



}