package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Batch;
import com.revature.repository.BatchRepository;

/**
 * This is the service that calls repository methods from BatchRepository to
 * implement Batch CRUD functionality. It implements CRUD functionality for
 * Batches. There is no functionality to delete records from the database. The
 * methods in this class are called from the BatchController class methods. They
 * call repository methods to carry out CRUD functionality.
 * 
 * @author John Beineke, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
 */

@Transactional
@Service
public class BatchService {

	@Autowired
	BatchRepository batchRepository;

	/**
	 * This methods returns all batches in the database
	 * 
	 * @return List<Batch>
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	public List<Batch> findAll() {
		return batchRepository.findAll();
	}

	/**
	 * This method returns the batch that corresponds with the given id parameter
	 * 
	 * @param int id
	 * @return Batch
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public Batch findBatchById(int id) {
		return batchRepository.findBatchById(id);
	}

	/**
	 * This method returns a list of batches from the database based on the given
	 * batch name
	 * 
	 * @param String name
	 * @return List<Batch>
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	public List<Batch> findBatchByName(String name) {
		return batchRepository.findBatchesByName(name);
	}

	/**
	 * This method returns a list of batches from the database that correspond with
	 * the given trainer id
	 * 
	 * @param int trainerId
	 * @return List<batch>
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public List<Batch> findBatchesByTrainerId(int trainerId) {
		return batchRepository.findBatchesByTrainerId(trainerId);
	}

	/**
	 * This method takes in a Batch object and persists it into the database
	 * 
	 * @param Batch batch
	 * @return Returns the persisted batch object
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	public Batch addBatch(Batch batch) {
		return batchRepository.save(batch);
	}

	/**
	 * This method takes in a Batch object and updates that object in the database
	 * 
	 * @param Batch batch
	 * @return Returns the updated Batch object, if no object exists in the database returns null
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey        
	 */
	public Batch updateBatch(Batch updateBatch) {
		Batch batch = batchRepository.findBatchById(updateBatch.getId());
		if (batch != null) {
			return batchRepository.save(updateBatch);
		} 
		return null;
	}

}
