package com.jobtracker.jobapp.service;

import com.jobtracker.jobapp.dto.JobDto;
import com.jobtracker.jobapp.entity.Jobs;

import java.util.List;
import java.util.Optional;

public interface JobService {
    void createJob(JobDto jobDto);

    Optional<Jobs> findJobById(Long idJob);

    List<JobDto> findJobsByUserId(Long user_id);

    List<JobDto> findJobsByUsername(String username);

    List<JobDto> findAllJob();

    void updateJob(Jobs job);

    void deleteJob(Long idJob);
}
