package com.example.Hospital.management.system.service;

import com.example.Hospital.management.system.entity.Doctor;
import com.example.Hospital.management.system.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    DoctorRepository doctorRepository = new DoctorRepository();

    public String addDoctor(Doctor doctor){

        //We should write some logic :
        //Validations
        if(doctor.getDoctorId()<0){
            return "Enter a valid doctorId";
        }

        if(doctor.getName().equals(null)){
            return "Name should not be null";
        }

        //Saving it to the database
        String ans = doctorRepository.addDoctor(doctor);
        return ans;
    }

    public List<Doctor> getDoctorBySpecialisation(String specialisation) {

        List<Doctor> doctors = doctorRepository.getDoctorBySpecialisation(specialisation);

        return doctors;
    }

    public Doctor getDoctorById(Integer doctorId) {

        Doctor doctor = doctorRepository.getDoctorById(doctorId);

        return doctor;
    }

    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = doctorRepository.getAllDoctors();

        return doctors;
    }
}
