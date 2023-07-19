package com.example.Hospital.management.system.service;

import com.example.Hospital.management.system.repository.NurseRepository;
import com.example.Hospital.management.system.entity.Nurse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse){

        //We should write some logic :
        //Validations
        if(nurse.getNurseId()<0){
            return "Enter a valid nurseId";
        }

        if(nurse.getName().equals(null)){
            return "Name should not be null";
        }

        //Saving it to the database
        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getNursesGreaterThanAge(int age){

        //Calling all the nurses from database

        List<Nurse> nurses = nurseRepository.getAllNurses();

        //Now I am writing the logic to extract required
        List<Nurse> finalList = new ArrayList<>();

        for(Nurse nurse : nurses){
            if(nurse.getAge()>age){
                finalList.add(nurse);
            }
        }
        return finalList;
    }

    public List<Nurse> getNursesWithQualification(String qualification){

        List<Nurse> nurseList = nurseRepository.getAllNurses();

        //Logic to filter based on qualification
        List<Nurse> nurses = new ArrayList<>();
        for(Nurse nurse : nurseList){
            if (nurse.getQualification() == qualification) {
                nurses.add(nurse);
            }
        }
        return nurses;
    }

    public String deleteNurse(String nurseId){

        String ans = nurseRepository.deleteNurse(nurseId);

        return ans;
    }

    public List<Nurse> getAllNurses() {

        return nurseRepository.getAllNurses();
    }
}
