package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Batch;
import com.revature.repository.BatchRepository;

/**
 * This is the service that calls repository methods from BatchRepository to implement Batch CRUD functionality.  
 * It implements CRUD functionality for Batches.
 * There is no functionality to delete records from the database.
 * The methods in this class are called from the BatchController class methods. They call repository methods to carry out CRUD functionality.
 * @author John Beineke, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
 */

@Transactional 
@Service 
public class BatchService {
	
	@Autowired
	BatchRepository batchRepository;

	// Service method to call the repository findAll() method
	public List<Batch> findAll(){
		System.out.println("[DEBUG] - In BatchService.findAll()");
		return batchRepository.findAll();
	}
	
	// Service method to call the repository findBatchById() method
	public Batch findBatchById(Integer id) {
		System.out.println("[DEBUG] - In BatchService.findBatchById()");
		return batchRepository.findBatchById(id);
	}
	
	// Service method to call the repository findBatchByName() method
	public List<Batch> findBatchByName(String name) {
		System.out.println();
		return batchRepository.findBatchesByName(name);
	}
	
	// Service method to call the repository findBatchesByTrainerId() method
	public List<Batch> findBatchesByTrainerId(Integer trainerId) {
		System.out.println("[DEBUG] - In BatchService.findBatchByTrainerId()");
		return batchRepository.findBatchesByTrainerId(trainerId);
	}
	
	// Service method to call the repository addBatch() method
	public Batch addBatch(Batch batch) {
		System.out.println("[DEBUG] - In BatchService.addBatch()");
		return batchRepository.save(batch);
	}
	
	// Service method to call the repository updateBatch() method
	public Batch updateBatch(Batch batch) {
		System.out.println("[DEBUG] - In BatchService.updateBatch()");
		
		if(batch == null) {
			return null;
		}else {
			return batchRepository.save(batch);
		}
	}

}
