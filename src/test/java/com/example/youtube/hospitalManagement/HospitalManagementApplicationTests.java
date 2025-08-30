package com.example.youtube.hospitalManagement;

import com.example.youtube.hospitalManagement.entity.Patient;
import com.example.youtube.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PatientRepositoryTest {

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void testFindAllPatients() {
		List<Patient> patientList = patientRepository.findAll();
		System.out.println("Patients: " + patientList.getFirst().getName());
	}
}
