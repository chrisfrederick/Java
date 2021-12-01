package com.company;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAAComplaintUser, HIPAAComplaintAdmin{
    //... imports class definition...

    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();

    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
        super(id);
        this.role = role;
    }

    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return this.getSecurityIncidents();
    }


    @Override
    public boolean assignPin(int pin) {
        if(pin<7){
            return false;
        }else {
            this.setPin(pin);
            return true;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if(this.getId().equals(confirmedAuthID)){
            return true;
        }else {
            this.authIncident();
            return false;
        }
    }



    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
//        System.out.println(this.securityIncidents);
        this.securityIncidents.add(report);
    }



    // TO DO: Setters & Getters

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return this.securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}
