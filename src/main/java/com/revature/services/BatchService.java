package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Batch;
import com.revature.repository.BatchRepository;

@Transactional 
@Service 
public class BatchService {
	
	private static final Logger logger = LogManager.getLogger(BatchService.class);
	
	@Autowired
	BatchRepository batchRepository;

	// Service method to call the repository findAll() method
	public List<Batch> findAll(){
		logger.info("[DEBUG] - In BatchService.findAll()");
		return batchRepository.findAll();
	}
	
	// Service method to call the repository findBatchById() method
	public Batch findBatchById(Integer id) {
		logger.info("[DEBUG] - In BatchService.findBatchById()");
		return batchRepository.findBatchById(id);
	}
	
	// Service method to call the repository findBatchByName() method
	public List<Batch> findBatchByName(String name) {
		logger.info("[DEBUG] - In BatchService.findBatchByName()");
		return batchRepository.findBatchesByName(name);
	}
	
	// Service method to call the repository findBatchesByTrainerId() method
	public List<Batch> findBatchesByTrainerId(Integer trainerId) {
		logger.info("[DEBUG] - In BatchService.findBatchByTrainerId()");
		return batchRepository.findBatchesByTrainerId(trainerId);
	}
	
	// Service method to call the repository addBatch() method
	public Batch addBatch(Batch batch) {
		logger.info("[DEBUG] - In BatchService.addBatch()");
		return batchRepository.save(batch);
	}
	
	// Service method to call the repository updateBatch() method
	public Batch updateBatch(Batch batch) {
		logger.info("[DEBUG] - In BatchService.updateBatch()");
		
		if(batch == null) {
			return null;
		}else {
			return batchRepository.save(batch);
		}
	}

}
