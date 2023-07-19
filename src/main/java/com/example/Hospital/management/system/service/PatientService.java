package com.example.Hospital.management.system.service;

import com.example.Hospital.management.system.entity.Nurse;
import com.example.Hospital.management.system.entity.Patient;
import com.example.Hospital.management.system.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    PatientRepository patientRepository = new PatientRepository();

    public String addPatient1(Patient patient) {

        if(patient.getPatientId()<0){
            return "Enter a valid doctorId";
        }

        if(patient.getName().equals(null)){
            return "Name should not be null";
        }

        //Saving it to the database
        String ans = patientRepository.addPatient1(patient);
        return ans;
    }

    public String addPatient(Integer patientId, String name, Integer age, String disease) {

        if(patientId<0){
            return "Enter a valid doctorId";
        }

        if(name == null){
            return "Name should not be null";
        }

        if(age == null){
            return "age should not be null";
        }

        if(disease == null){
            return "Please mention disease!";
        }

        String ans = patientRepository.addPatient(patientId, name, age, disease);
        return ans;
    }

    public Patient getPatientInfo(Integer patientId) {

        Patient patient = patientRepository.getPatientInfo(patientId);

        return patient;
    }


    public List<Patient> getPatient(Integer age, String disease) {

        List<Patient> patients = patientRepository.getPatient(age, disease);

        return patients;
    }

    public List<Patient> getAllPatients() {

        List<Patient> patients = patientRepository.getAllPatients();

        return patients;
    }

    public String updateDisease(Integer patientId, String disease) {

        String ans = patientRepository.updateDisease(patientId, disease);

        return ans;
    }

    public String deletePatient(Integer patientId) {

        String ans = patientRepository.deletePatient(patientId);

        return ans;
    }
}
