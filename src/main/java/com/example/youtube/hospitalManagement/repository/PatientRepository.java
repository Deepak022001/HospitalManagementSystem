package com.example.youtube.hospitalManagement.repository;

import com.example.youtube.hospitalManagement.entity.Patient;
import com.example.youtube.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    //    Jpa query methods
    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("SELECT  p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate>:birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);


    @Query("SELECT p.bloodGroup, COUNT(p) FROM Patient p GROUP BY p.bloodGroup")
    List<Object[]> countEachBloodGroupType(@Param("bloodGroup") BloodGroupType bloodGroupType);

    @Query(value = "SELECT *from patient ",nativeQuery = true)
    List<Patient> findAllPatients();

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.name =:name where p.id=:id")
    int updatedNameWithId(@Param("name") String name ,@Param("id")Long id);

}
