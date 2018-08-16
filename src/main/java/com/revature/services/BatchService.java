package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Batch;
import com.revature.repository.BatchRepository;

@Transactional 
@Service 
public class BatchService {
	
	@Autowired
	BatchRepository batchRepository;
	
	public List<Batch> findAll(){
		System.out.println("[DEBUG] - In BatchService.findAll()");
		return batchRepository.findAll();
	}
	
	public Batch findBatchById(Integer id) {
		System.out.println("[DEBUG] - In BatchService.findBatchById()");
		return batchRepository.findBatchById(id);
	}
	
	public List<Batch> findBatchByName(String name) {
		System.out.println();
		return batchRepository.findBatchByName(name);
	}
	
	public Batch findBatchByTrainerId(Integer trainerId) {
		System.out.println("[DEBUG] - In BatchService.findBatchByTrainerId()");
		return batchRepository.findBatchByTrainerId(trainerId);
	}
	
	public Batch addBatch(Batch batch) {
		System.out.println("[DEBUG] - In BatchService.addBatch()");
		return batchRepository.save(batch);
	}
	
	public Batch updateBatch(Batch batch) {
		System.out.println("[DEBUG] - In BatchService.updateBatch()");
		
		if(batch == null) {
			return null;
		}else {
			return batchRepository.save(batch);
		}
	}

}
