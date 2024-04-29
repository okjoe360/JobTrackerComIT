package com.jobtracker.jobapp.service.impl;

import com.jobtracker.jobapp.dto.JobDto;
import com.jobtracker.jobapp.entity.Jobs;
import com.jobtracker.jobapp.repository.JobRepository;
import com.jobtracker.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository){ //no need for one constructor to have @Autowired annotation.
        this.jobRepository=jobRepository;
    }

    @Override
    public void createJob(JobDto jobDto) {
        Jobs job = new Jobs();
        job.setJobTitle(jobDto.getJobTitle());
        job.setJobDate(jobDto.getJobDate());
        job.setJobWebsite(jobDto.getJobWebsite());
        job.setJobDesc(jobDto.getJobDesc());
        job.setCompanyHr(jobDto.getCompanyHr());
        job.setCompanyEmail(jobDto.getCompanyEmail());
        job.setCompanyName(jobDto.getCompanyName());
        job.setCompanyWebsite(jobDto.getCompanyWebsite());
        job.setUser_id(jobDto.getUser_id());
        jobRepository.save(job);
    }

    @Override
    public Optional<Jobs> findJobById(Long idJob) {
        return jobRepository.findById(idJob);
    }

    @Override
    public List<JobDto> findJobsByUserId(Long user_id) {
        return jobRepository.findJobsByUserId(user_id);
    }

    @Override
    public List<JobDto> findJobsByUsername(String username) {
        return List.of();
    }

    @Override
    public List<JobDto> findAllJob() {
        List<Jobs> jobs = jobRepository.findAll();
        List<JobDto> job_dto = new ArrayList<>();
        for(Jobs job:jobs){
            JobDto jobDto = new JobDto();
            jobDto.setIdJob(job.getIdJob());
            jobDto.setJobDate(job.getJobDate());
            jobDto.setJobDesc(job.getJobDesc());
            jobDto.setJobTitle(job.getJobTitle());
            jobDto.setJobWebsite(job.getJobWebsite());
            jobDto.setIdJob(job.getIdJob());
            jobDto.setCompanyHr(job.getCompanyHr());
            jobDto.setCompanyEmail(job.getCompanyEmail());
            jobDto.setCompanyName(job.getCompanyName());
            jobDto.setCompanyWebsite(job.getCompanyWebsite());
            job_dto.add(jobDto);
        }
        return job_dto;
    }

    @Override
    public void updateJob(Jobs job) {
        jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long idJob) {
        jobRepository.deleteById(idJob);
    }
}
