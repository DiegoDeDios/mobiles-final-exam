package com.example.finalexam;

public class Appointment {

        String  patientName,
                patientLastName,
                patientSecondLastName,
                gender,
                allergic,
                healthProblems;

        Integer age;

    public Appointment() {}

    public Appointment(String patientName, String patientLastName, String patientSecondLastName, String gender, String allergic, String healthProblems, Integer age) {
        this.patientName = patientName;
        this.patientLastName = patientLastName;
        this.patientSecondLastName = patientSecondLastName;
        this.gender = gender;
        this.allergic = allergic;
        this.healthProblems = healthProblems;
        this.age = age;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientSecondLastName() {
        return patientSecondLastName;
    }

    public void setPatientSecondLastName(String patientSecondLastName) {
        this.patientSecondLastName = patientSecondLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }

    public String getHealthProblems() {
        return healthProblems;
    }

    public void setHealthProblems(String healthProblems) {
        this.healthProblems = healthProblems;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
