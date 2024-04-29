package com.jobtracker.jobapp.dto;

import com.jobtracker.jobapp.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
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
public class EducationDto {
    private Long idEducation;

    @NotEmpty(message = "School should not be empty")
    private String school;

    @NotEmpty(message = "Degree should not be empty")
    private String degree;

    private LocalDate startDate;

    private LocalDate endDate;

    private int user_id;

}
