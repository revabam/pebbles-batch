package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

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


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin 
@RestController
@RequestMapping
public class BatchController {
	
	
	
	@Autowired 
	BatchService batchService;
	
	private static final Logger logger = LogManager.getLogger(BatchController.class);
	
	/**
	*<This method will retrieve all batches>
	*@param no parameters are taken in
	*@return ResponseEntity<List<Batch>> <Returns a list of all batches>
	*		 and an http status code of OK or NOT_FOUND>
	*@author <John Beineke><1806-jun18-java-usf><Wezley Singleton>
	*/
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> findAll(){
		
		logger.info("[DEBUG] - In BatchController.findAll()");
		
		
		
		List<Batch> allBatches = batchService.findAll();
		return new ResponseEntity<List<Batch>>(allBatches, HttpStatus.OK);
	}
	
	
	/**
	*<This method will retrieve a batch by its id>
	*@param takes in a numeric parameter that represents a batches' id
	*@return ResponseEntity<Batch> <Returns the batch with the corresponding name
	*		 and an http status code of OK or NOT_FOUND>
	*@author <John Beineke><1806-jun18-java-usf><Wezley Singleton>
	*/
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> findBatchById(@PathVariable Integer id) {
		
		logger.info("[DEBUG] - In BatchController.findBatchById");
		Batch batch = batchService.findBatchById(id);
		
		if(batch == null) {
			return new ResponseEntity<Batch>(batch, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		}
		
	}
	
	/**
	*<This method will retrieve a batch by its name>
	*@param takes in a string parameter that represents a batches' name
	*@return ResponseEntity<Batch> <Returns the batch with the corresponding id
	*		and an http status code of OK or NOT_FOUND>
	*@author <John Beineke><1806-jun18-java-usf><Wezley Singleton>
	*/
	@GetMapping(value="/name/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> findBatchesByName(@PathVariable String name) {

		logger.info("[DEBUG] - In BatchController.findBatchByName");
		
		List<Batch> batches = batchService.findBatchByName(name);
		
		if(batches == null) {
			return new ResponseEntity<List<Batch>>(batches, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Batch>>(batches, HttpStatus.OK);
		}
	}
	
	/**
	*<This method will retrieve all batches with the specified trainer's user id>
	*@param takes in a numeric parameter that represents a trainer's user id
	*@return ResponseEntity<List<Batch>> <Returns the batches with the corresponding trainer's id
	*		 and an http status code of OK or NOT_FOUND>
	*@author <John Beineke><1806-jun18-java-usf><Wezley Singleton>
	*/
	@GetMapping(value="/trainer/{trainerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> findBatchesByTrainerId(@PathVariable Integer trainerId) {
		
		logger.info("[DEBUG] - In BatchController.findBatchByTrainerId");
		List<Batch> batches = batchService.findBatchesByTrainerId(trainerId);
		
		if (batches == null) {
			return new ResponseEntity<List<Batch>>(batches, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Batch>>(batches, HttpStatus.OK);
		}
	}
	
	/**
	*<This method will add a batch>
	*@param takes in a batch object and checks for valid field values
	*@return ResponseEntity<Batch> <Returns the batch that was just created 
	*		 and an http status code of CREATED>
	*@author <John Beineke><1806-jun18-java-usf><Wezley Singleton>
	*/
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> addBatch(@Valid @RequestBody Batch batch){
		
		logger.info("[DEBUG] - In BatchController.addBatch");
		Batch newBatch = batchService.addBatch(batch);
		return new ResponseEntity<Batch>(newBatch, HttpStatus.CREATED);
	}
	
	/**
	*<This method will update an existing batch>
	*@param takes in a batch object and checks for valid field values
	*@return ResponseEntity<Batch> <Returns the updated batch unless that batch was not found, then
	*		 it will return the attempted batch, and an http status code of OK or NOT_FOUND>
	*@author <John Beineke><1806-jun18-java-usf><Wezley Singleton>
	*/
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> updateBatch(@Valid @RequestBody Batch batch){
		
		logger.info("[DEBUG] - In BatchController.updateBatch");
		Batch updatedBatch = batchService.updateBatch(batch);
		
		if(updatedBatch == null) {
			return new ResponseEntity<Batch>(batch, HttpStatus.NOT_FOUND);
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
