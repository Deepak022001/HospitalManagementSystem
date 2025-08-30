package com.example.youtube.hospitalManagement;
import com.example.youtube.hospitalManagement.entity.Patient;
import com.example.youtube.hospitalManagement.entity.type.BloodGroupType;
import com.example.youtube.hospitalManagement.repository.PatientRepository;
import com.example.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
//        List<Patient>patientList=patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
        List<Patient>patientList=patientRepository.findByBornAfterDate(LocalDate.of(2000,3,15));
        for(Patient patient1:patientList){
            System.out.println("abcd"+patient1.getName());
        }
        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType(BloodGroupType.A_POSITIVE);
        for (Object[] row : bloodGroupList) {
            System.out.println("BloodGroup: " + row[0] + " Count: " + row[1]);
        }
        List<Patient>patients=patientRepository.findAllPatients();
        System.out.println("ans is"+patients);

        int rowsUpdated=patientRepository.updatedNameWithId("Amit Kumar",1L);
        System.out.println("rows updatedd"+ rowsUpdated);

    }
}
