package com.jobtracker.jobapp.repository;

import com.jobtracker.jobapp.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
