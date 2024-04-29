package com.jobtracker.jobapp.repository;

import com.jobtracker.jobapp.dto.JobDto;
import com.jobtracker.jobapp.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Jobs,Long> {

    @Query(value = "SELECT * FROM jobs WHERE user_id = ?1", nativeQuery = true)
    List<JobDto> findJobsByUserId(Long user_id);

    //@Query(value = "SELECT * FROM jobs WHERE id_job = ?1", nativeQuery = true)
    //List<JobDto> findJobById(Long idJob);
}
