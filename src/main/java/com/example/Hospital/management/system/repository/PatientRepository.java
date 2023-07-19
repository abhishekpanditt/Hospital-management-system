package com.example.Hospital.management.system.repository;

import com.example.Hospital.management.system.entity.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientRepository {

    HashMap<Integer, Patient> patientDb = new HashMap<>();

    public String addPatient1(Patient patient) {

        int patientId = patient.getPatientId();
        patientDb.put(patientId, patient);

        return "Patient added successfully";
    }

    public String addPatient(Integer patientId, String name, Integer age, String disease) {

        Patient patient = new Patient(patientId,name,disease,age);
        patientDb.put(patientId,patient);

        return "Patient added successfully!";
    }

    public Patient getPatientInfo(Integer patientId) {

        Patient patient = patientDb.get(patientId);
        return patient;
    }

    public List<Patient> getPatient(Integer age, String disease) {

        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDb.values()){

            if(p.getAge()>=age && p.getDisease().equals(disease)){
                patients.add(p);
            }
        }
        return patients;
    }

    public List<Patient> getAllPatients() {

        List<Patient> patients = patientDb.values().stream().toList();

        return patients;
    }

    public String updateDisease(Integer patientId, String disease) {

        if(patientDb.containsKey(patientId)){

            Patient patient = patientDb.get(patientId);
            patient.setDisease(disease);
            patientDb.put(patientId,patient);

            return "Updated successfully!";
        }
        else {
            return "Patient does not exist";
        }
    }

    public String deletePatient(Integer patientId) {

        patientDb.remove(patientId);

        return "Patient deleted successfully";
    }
}
