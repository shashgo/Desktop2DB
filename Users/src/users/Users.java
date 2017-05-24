/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author SG
 */
public class Users {

    /**
     * @param args the command line arguments
     */
    
    String accNo, accType, name, address, sex, dob, occupation, balance;

    public Users(String AccNo, String AccType, String Name, String Address, String Sex, String DOB, String Occupation, String Balance) {
        this.accNo=AccNo;
        this.accType=AccType;
        this.name=Name;
        this.address=Address;
        this.sex=Sex;
        this.dob=DOB;
        this.occupation=Occupation;
        this.balance=Balance;
        
    }

    public String getAccNo() {
        return accNo;
    }

    public String getAccType() {
        return accType;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getDob() {
        return dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getBalance() {
        return balance;
    }

    
}
