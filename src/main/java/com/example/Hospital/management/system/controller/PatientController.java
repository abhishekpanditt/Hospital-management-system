package com.example.Hospital.management.system.controller;

import com.example.Hospital.management.system.entity.Patient;
import com.example.Hospital.management.system.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    PatientService patientService = new PatientService();

    @PostMapping("/addViaRequestBody")
    public String addPatient1(@RequestBody Patient patient){

        String patient1 = patientService.addPatient1(patient);

        return patient1;
    }

    @PostMapping("/addViaParamaters")
    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name")String name,
                             @RequestParam("age")Integer age,@RequestParam("disease")String disease){

        String patient = patientService.addPatient(patientId, name, age, disease);

        return patient;
    }

    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getPatientInfo(@PathVariable("patientId")Integer patientId){

        Patient patient = patientService.getPatientInfo(patientId);

        return patient;
    }

    @GetMapping("/getPatients/{age}/{disease}")
    public List<Patient> getPatients(@PathVariable("age")Integer age,@PathVariable("disease")String disease){

        List<Patient> patients = patientService.getPatient(age, disease);

        return patients;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){

        List<Patient> patients = patientService.getAllPatients();

        return patients;
    }

    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientId")Integer patientId,@RequestParam("disease")String disease){

        String ans = patientService.updateDisease(patientId, disease);

        return ans;
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId")Integer patientId){

        String ans = patientService.deletePatient(patientId);

        return ans;
    }

}
