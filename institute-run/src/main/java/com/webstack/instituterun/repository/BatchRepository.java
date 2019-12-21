package com.webstack.instituterun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstack.instituterun.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>{

}
