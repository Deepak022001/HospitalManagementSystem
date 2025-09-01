package com.example.youtube.hospitalManagement;

import com.example.youtube.hospitalManagement.entity.Patient;
import com.example.youtube.hospitalManagement.entity.type.BloodGroupType;
import com.example.youtube.hospitalManagement.repository.PatientRepository;
import com.example.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        if (!patientList.isEmpty()) {
            System.out.println("First Patient: " + patientList.get(0).getName());
        }

        Patient p1 = new Patient();
        p1.setName("Test User");
        patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethods() {
        Patient patient = patientRepository.findByName("Amit Kumar");

        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(2000, 3, 15));
        for (Patient patient1 : patientList) {
            System.out.println("abcd " + patient1.getName());
        }

        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
        for (Object[] row : bloodGroupList) {
            System.out.println("BloodGroup: " + row[0] + " Count: " + row[1]);
        }

        Page<Patient> patients = patientRepository.findAllPatients(PageRequest.of(0, 2));
        patients.forEach(p -> System.out.println("Paged Patient: " + p.getName()));

        int rowsUpdated = patientRepository.updateNameWithId("Amit Kumar", 1L);
        System.out.println("Rows updated: " + rowsUpdated);
    }
}
