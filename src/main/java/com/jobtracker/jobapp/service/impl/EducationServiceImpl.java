package com.jobtracker.jobapp.service.impl;

import com.jobtracker.jobapp.dto.EducationDto;
import com.jobtracker.jobapp.entity.Education;
import com.jobtracker.jobapp.repository.EducationRepository;
import com.jobtracker.jobapp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository eduRepo;

    public EducationServiceImpl(EducationRepository eduRepo) {
        this.eduRepo=eduRepo;
    }

    @Override
    public void create(EducationDto eduDto) {
        Education edu = new Education();
        edu.setIdEducation(eduDto.getIdEducation());
        edu.setDegree(eduDto.getDegree());
        edu.setSchool(eduDto.getSchool());
        edu.setStartDate(eduDto.getStartDate());
        edu.setEndDate(eduDto.getEndDate());
        edu.setUser_id(eduDto.getUser_id());
        eduRepo.save(edu);
    }

    @Override
    public Optional<Education> findById(Long idEducation) {
        return eduRepo.findById(idEducation);
    }

    @Override
    public List<EducationDto> findAll() {
        List<Education> edus = eduRepo.findAll();
        List<EducationDto> edu_dto = new ArrayList<>();
        for(Education e:edus){
            EducationDto eduDto = new EducationDto();
            eduDto.setIdEducation(e.getIdEducation());
            eduDto.setDegree(e.getDegree());
            eduDto.setSchool(e.getSchool());
            eduDto.setUser_id(e.getUser_id());
            eduDto.setStartDate(e.getStartDate());
            eduDto.setEndDate(e.getEndDate());
            edu_dto.add(eduDto);
        }
        return edu_dto;
    }

    @Override
    public void update(Education edu) {
        eduRepo.save(edu);
    }

    @Override
    public void delete(Long idEducation) {
        eduRepo.deleteById(idEducation);
    }
}
