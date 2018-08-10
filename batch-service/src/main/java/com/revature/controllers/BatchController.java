package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.BatchNotFoundException;
import com.revature.models.Batch;
import com.revature.models.BatchErrorResponse;
import com.revature.services.BatchService;

@CrossOrigin 
@RestController
@RequestMapping(value="/batches")
public class BatchController {
	
	@Autowired 
	BatchService batchService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> findAll(){
		
		System.out.println("[DEBUG] - In BatchController.findAll()");
		List<Batch> allBatches = batchService.findAll();
		return new ResponseEntity<List<Batch>>(allBatches, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> findBatchById(@PathVariable Integer id) {
		
		System.out.println("[DEBUG] - In BatchController.findBatchById");
		Batch batch = batchService.findBatchById(id);
		
		if(batch == null) {
			return new ResponseEntity<Batch>(batch, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value="/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> findBatchByName(@PathVariable String name) {
		
		System.out.println("[DEBUG] - In BatchController.findBatchByName");
		Batch batch = batchService.findBatchByName(name);
		
		if(batch == null) {
			return new ResponseEntity<Batch>(batch, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{trainerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> findBatchByTrainerId(@PathVariable Integer trainerId) {
		
		System.out.println("[DEBUG] - In BatchController.findBatchByTrainerId");
		Batch batch = batchService.findBatchByTrainerId(trainerId);
		
		if (batch == null) {
			return new ResponseEntity<Batch>(batch, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		}
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> addBatch(@RequestBody Batch batch){
		
		System.out.println("[DEBUG] - In BatchController.addBatch");
		Batch newBatch = batchService.addBatch(batch);
		return new ResponseEntity<Batch>(newBatch, HttpStatus.CREATED);
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch){
		
		System.out.println("[DEBUG] - In BatchController.updateBatch");
		Batch updatedBatch = batchService.updateBatch(batch);
		
		if(updatedBatch == null) {
			return new ResponseEntity<Batch>(updatedBatch, HttpStatus.NOT_FOUND);
		}else {
		return new ResponseEntity<Batch>(updatedBatch, HttpStatus.OK);
		}
	}
	
	@ExceptionHandler
	public ResponseEntity<BatchErrorResponse> HandleException(BatchNotFoundException e){
		
		BatchErrorResponse error = new BatchErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<BatchErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	

}
