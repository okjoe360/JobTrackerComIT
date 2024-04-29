package com.jobtracker.jobapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private Long idJob;

    @NotEmpty(message = "Job Title should not be empty")
    private String jobTitle;

    private String jobDesc;

    private LocalDate jobDate;

    private String jobWebsite;

    @NotEmpty(message = "Company name should not be empty")
    private String companyName;

    private String companyWebsite;

    @NotEmpty(message = "Company Email should not be empty")
    private String companyEmail;

    private String companyHr;

    private Long user_id;

    //private User user;
}
