package com.example.Hospital.management.system.repository;

import com.example.Hospital.management.system.entity.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorRepository{

    HashMap<Integer, Doctor> doctorDb = new HashMap<>();

    public String addDoctor(Doctor doctor) {

        int doctorId = doctor.getDoctorId();
        doctorDb.put(doctorId, doctor);

        return "Doctor added successfully";
    }

    public List<Doctor> getDoctorBySpecialisation(String specialisation) {

        List<Doctor> doctors = new ArrayList<>();

        for(Doctor doctor: doctorDb.values()){

            if(doctor.getSpecialization().equals(specialisation)){
                doctors.add(doctor);
            }
        }
        return doctors;
    }

    public Doctor getDoctorById(Integer doctorId) {

        return doctorDb.get(doctorId);
    }

    public List<Doctor> getAllDoctors(){

        return doctorDb.values().stream().toList();

    }
}

