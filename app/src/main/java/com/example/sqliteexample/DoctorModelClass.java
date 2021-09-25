package com.example.doctormanagement;



public class DoctorModelClass {

    Integer id;
    String name;
    String email;
    String hospital;
    String specialization;
    String contactnumber;


    public DoctorModelClass(String name, String email, String hospital,String specialization,String contactnumber) {
        this.name = name;
        this.email = email;
        this.hospital=hospital;
        this.specialization=specialization;
        this.contactnumber=contactnumber;
    }

    public DoctorModelClass(Integer id, String name, String email,String hospital, String specialization, String contactnumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hospital=hospital;
        this.specialization=specialization;
        this.contactnumber=contactnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }


}


