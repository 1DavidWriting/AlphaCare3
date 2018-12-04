
package alphacare;

import java.util.Date;


public class Permissions implements java.io.Serializable {
    
    int userID;
    boolean canViewEHR;
    boolean canUpdateData;
    boolean canCreateSOAP;
    boolean canRunReport;

    
    /**
     * This constructor requires a role of patient, administrator, physician, or care giver
     * @param role
     */
    public Permissions(String role) {
        if (role.equalsIgnoreCase("Patient")){canViewEHR = true; canUpdateData = true; canCreateSOAP = false; canRunReport = false;} //patient
        else if (role.equalsIgnoreCase("Administrator")){canViewEHR = true; canUpdateData = true; canCreateSOAP = false; canRunReport = true;} // administrator
        else if (role.equalsIgnoreCase("Physician")){canViewEHR = true; canUpdateData = true; canCreateSOAP = true; canRunReport = false;} // physician
        else if (role.equalsIgnoreCase("Caregiver")){canViewEHR = true; canUpdateData = true; canCreateSOAP = false; canRunReport = false;} // caregiver
        else {
            System.out.println ("Role not found for creating permissions, all permissions set to false");
            canViewEHR = false; canUpdateData = false; canCreateSOAP = false; canRunReport = false;        
        }        
    }
    
}
