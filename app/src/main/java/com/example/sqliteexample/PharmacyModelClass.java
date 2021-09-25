package com.example.sqliteexample;


public class PharmacyModelClass {

    Integer id;
    String p_Name;
    String p_Address;
    String p_Mobile;
    String p_PharmacyName;
    String p_PrescriptionName;


    public PharmacyModelClass(String p_Name, String p_Address, String p_Mobile, String p_PharmacyName, String p_PrescriptionName) {
        this.p_Name = p_Name;
        this.p_Address = p_Address;
        this.p_Mobile = p_Mobile;
        this.p_PharmacyName = p_PharmacyName;
        this.p_PrescriptionName = p_PrescriptionName;
    }

    public PharmacyModelClass(Integer id, String p_Name, String p_Address, String p_Mobile, String p_PharmacyName, String p_PrescriptionName) {
        this.id = id;
        this.p_Name = p_Name;
        this.p_Address = p_Address;
        this.p_Mobile = p_Mobile;
        this.p_PharmacyName = p_PharmacyName;
        this.p_PrescriptionName = p_PrescriptionName;
    }
//get
    public Integer getId() {
        return id;
    }
    
//set
    public void setId(Integer id) {
        this.id = id;
    }
    
    
//get
    public String getpName() {
        return p_Name;
    }
    
//set
    public void setpName(String pName) {
        this.p_Name = p_Name;
    }
    
    
//get
    public String getpAddress() {
        return p_Address;
    }
    
//set
    public void setpAddress(String pAddress) {
        this.p_Address = p_Address;
    }
    
    
 //get
    public String getpMobile() {
        return p_Mobile;
    }
    
//set
    public void setpMobile(String pMobile) {
        this.p_Mobile = p_Mobile;
    }
    
    
//get
    public String getpPharmacyName() {
        return p_PharmacyName;
    }
    
//set
    public void setpPharmacyName(String pPharmacyName) {
        this.p_PharmacyName = p_PharmacyName;
    }
    
    
//get
    public String getpPrescriptionName() {
        return p_PrescriptionName;
    }
    
//set
    public void setpPrescriptionName(String pPrescriptionName) {
        this.p_PrescriptionName = p_PrescriptionName;
    }
}
