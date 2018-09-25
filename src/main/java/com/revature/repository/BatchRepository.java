package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Batch;

/**
 * This is the repository that implements CRUD functionality directly to the Batch table in the database.  
 * The methods in this class are called from the BatchService class methods. You can create custom methods here, 
 * or use the built-in JPA methods available by extending the JPA repository such as findAll() and save().
 * @author John Beineke, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
 */

@Repository 
public interface BatchRepository extends JpaRepository<Batch, Integer>{
	
	// Also using CRUD repository findAll() and  save() methods
	
	 Batch findBatchById(Integer id);
	 
	 List<Batch> findBatchesByName(String name);
	 
//	 @Query("from Batch b WHERE b.trainer_id = :trainer_id")
	 List<Batch> findBatchesByTrainerId(Integer trainerId);
	 	 
	 }
