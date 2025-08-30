package com.example.youtube.hospitalManagement;

import com.example.youtube.hospitalManagement.entity.Patient;
import com.example.youtube.hospitalManagement.repository.PatientRepository;
import com.example.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class patienttest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
    @Test
    public void testPatientRepository(){
        List<Patient> patientList=patientRepository.findAll();
        System.out.println(patientList.getFirst().getName());

        Patient p1= new Patient();
        patientRepository.save(p1);
    }
    @Test
    public void testTransactionMethods(){
        Patient patient = patientRepository.findByName("Amit Kumar");
        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(
                LocalDate.of(1995, 5, 12),
                "amit.kumar@example.com"
        );
        if (patientList.isEmpty()) {
            throw new RuntimeException("No patient found with given criteria");
        }
        for (Patient patient1:patientList){
            System.out.println("Result is"+patient1.getName());
        }
    }
}
