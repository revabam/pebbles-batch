package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Batch;

@Repository 
public interface BatchRepository extends JpaRepository<Batch, Integer>{
	
	// Also using CRUD repository findAll() and  save() methods
	
	 Batch findBatchById(Integer id);
	 
	 List<Batch> findBatchesByName(String name);
	 
	 @Query("from Batch b WHERE b.trainer_id = :trainer_id")
	 List<Batch> findBatchesByTrainerId(@Param("trainer_id") Integer trainerId);
	 
	 
	 }

