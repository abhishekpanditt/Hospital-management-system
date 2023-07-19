package com.example.Hospital.management.system.controller;

import com.example.Hospital.management.system.entity.Nurse;
import com.example.Hospital.management.system.service.NurseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {


    NurseService nurseService = new NurseService();


    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){

        String ans = nurseService.addNurse(nurse);

        return ans;
    }

    @GetMapping("/getByAge")
    public List<Nurse> getNursesGreaterThanAge(@RequestParam("age")Integer age){

        List<Nurse> nurseList = nurseService.getNursesGreaterThanAge(age);
        return nurseList;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNursesByQualification(@RequestParam("qualification")String qualification){

        List<Nurse> nurses =nurseService.getNursesWithQualification(qualification);
        return nurses;
    }

    @GetMapping("getAll")
    public List<Nurse> getAllNurses(){

        List<Nurse> nurses = nurseService.getAllNurses();

        return nurses;
    }

    @DeleteMapping("deleteNurse")
    public String deleteNurse(@RequestParam("nurseId") String nurseId){

        String ans = nurseService.deleteNurse(nurseId);

        return ans;
    }


}
