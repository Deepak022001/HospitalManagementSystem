package com.example.youtube.hospitalManagement.entity;
import com.example.youtube.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name", nullable = true, length = 48)
    private String name;

    private LocalDate birthDate;

    @Column(unique = true, nullable = true)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING) // store enum as string in DB
    private BloodGroupType bloodGroup;

    @OneToOne()
    @JoinColumn(name = "patient_insurance_id") //ownind side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;

}
