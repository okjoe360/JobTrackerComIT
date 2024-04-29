package com.jobtracker.jobapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducation;

    @Column(nullable = false, length = 155)
    private String school;

    @Column(nullable = false, length = 155)
    private String degree;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(nullable = false)
    private int user_id;

    //@Column(nullable = false)
    //private Long user_id;

    @Override
    public String toString() {
        return String.format(
                "Education [idEducation=%s, school=%s, degree=%s]",
                idEducation, school, degree);
    }
}
