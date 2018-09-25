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

	public List<Batch> findAll() {
		return batchRepository.findAll();
	}

	public Batch findBatchById(Integer id) {
		return batchRepository.findBatchById(id);
	}

	public List<Batch> findBatchByName(String name) {
		return batchRepository.findBatchesByName(name);
	}

	public List<Batch> findBatchesByTrainerId(Integer trainerId) {
		return batchRepository.findBatchesByTrainerId(trainerId);
	}

	public Batch addBatch(Batch batch) {
		return batchRepository.save(batch);
	}

	public Batch updateBatch(Batch batch) {

		if (batch == null) {
			return null;
		} else {
			return batchRepository.save(batch);
		}
	}

}
