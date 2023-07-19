package com.example.Hospital.management.system.controller;

import com.example.Hospital.management.system.entity.Doctor;
import com.example.Hospital.management.system.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    DoctorService doctorService = new DoctorService();

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){

        String ans = doctorService.addDoctor(doctor);

        return ans;
    }

    @GetMapping("getBySpecialisation")
    public List<Doctor> getDoctorBySpecialisation(@RequestParam("specialisation") String specialisation){

        List<Doctor> doctors = doctorService.getDoctorBySpecialisation(specialisation);
        return doctors;
    }

    @GetMapping("getById")
    public Doctor getDoctorById(@RequestParam("doctorId") Integer doctorId){

        Doctor doctor = doctorService.getDoctorById(doctorId);

        return doctor;
    }

    @GetMapping("getAllDoctors")
    public List<Doctor> getAllDoctors(){

        List<Doctor> doctors = doctorService.getAllDoctors();

        return doctors;
    }
}
