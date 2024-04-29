package com.jobtracker.jobapp.service;

import com.jobtracker.jobapp.dto.EducationDto;
import com.jobtracker.jobapp.dto.JobDto;
import com.jobtracker.jobapp.entity.Education;
import com.jobtracker.jobapp.entity.Jobs;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    void create(EducationDto eduDto);

    Optional<Education> findById(Long idEducation);

    List<EducationDto> findAll();

    void update(Education edu);

    void delete(Long idEducation);
}
