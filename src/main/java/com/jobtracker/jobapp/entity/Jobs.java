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
@Table(name="jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJob;

    @Column(nullable = false, length = 155)
    private String jobTitle;

    @Column(length = 555)
    private String jobDesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate jobDate;

    @Column(length = 1000)
    private String jobWebsite;

    @Column(nullable = false, length = 155)
    private String companyName;

    @Column(length = 155)
    private String companyWebsite;

    @Column(nullable = false, length = 155)
    private String companyEmail;

    @Column(length = 155)
    private String companyHr;

    @Column(nullable = false)
    private Long user_id;

    @Override
    public String toString() {
        return String.format(
                "Job [idJob=%s, jobTitle=%s, companyName=%s]",
                idJob, jobTitle, companyName);
    }

}
