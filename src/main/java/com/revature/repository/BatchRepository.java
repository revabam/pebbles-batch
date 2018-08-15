package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Batch;

@Repository 
public interface BatchRepository extends JpaRepository<Batch, Integer>{
	
	 Batch findBatchById(Integer id);
	 Batch findBatchByName(String name);
	 
	 @Query("from Batch b WHERE b.trainer_id = :trainer_id")
	 Batch findBatchByTrainerId(@Param("trainer_id") Integer trainerId);
	 
	 
	 }


