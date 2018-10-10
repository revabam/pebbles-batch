package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.revature.errorResponse.BatchErrorResponse;
import com.revature.exceptions.BatchNotFoundException;
import com.revature.models.Batch;
import com.revature.services.BatchService;

/**
 * This is the controller containing the endpoints to hit for batch CRUD
 * functionality. There is no functionality to delete records from the database.
 * The methods in this class are ran when the mapping endpoints are hit. They
 * call a batch service class which calls methods to implement the CRUD
 * functionality and finally return a ResponseEntity to the client
 * 
 * @author author John Beineke batch: 1806-jun18-usf-java trainer: Wezley
 *         Singleton
 */

@CrossOrigin
@RestController
@RequestMapping("/batches")
public class BatchController {

	@Autowired
	BatchService batchService;

	/**
	 * This method Returns all Batches in the database
	 * 
	 * @param no parameters are taken
	 * @return Returns a list of all Batches in the database and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	@GetMapping
	public ResponseEntity<List<Batch>> findAll() {
		List<Batch> allBatches = batchService.findAll();
		return new ResponseEntity<>(allBatches, HttpStatus.OK);
	}

	/**
	 * This method Returns the Batch that corresponds with the id parameter
	 * 
	 * @param an int id parameter is taken in
	 * @return Returns a response entity containing a Batch that corresponds with
	 *         the id parameter and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Batch> findBatchById(@PathVariable int id) {
		Batch batch = batchService.findBatchById(id);
		if (batch == null) {
			return new ResponseEntity<>(batch, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(batch, HttpStatus.OK);
		}
	}

	/**
	 * This method Returns the Batch that corresponds with the name parameter
	 * 
	 * @param a String name parameter is taken in
	 * @return Returns a response entity containing a Batch that corresponds with
	 *         the name parameter and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Batch>> findBatchesByName(@PathVariable String name) {
		List<Batch> batches = batchService.findBatchByName(name);
		if (batches == null) {
			return new ResponseEntity<>(batches, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(batches, HttpStatus.OK);
		}
	}

	/**
	 * This method Returns a list of batches that correspond with the Trainer id
	 * parameter
	 * 
	 * @param an int id parameter is taken in that represents a trainer's id
	 * @return Returns a response entity containing a list of the batches that
	 *         correspond with the Trainer id parameter and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	@GetMapping("/trainer/{trainerId}")
	public ResponseEntity<List<Batch>> findBatchesByTrainerId(@PathVariable int trainerId) {
		List<Batch> batches = batchService.findBatchesByTrainerId(trainerId);
		if (batches == null) {
			return new ResponseEntity<>(batches, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(batches, HttpStatus.OK);
		}
	}

	/**
	 * This method Takes a Batch object from a request body, and persists it to a
	 * database.
	 * 
	 * @param a Batch is taken in as the request body
	 * @return The Batch that was added to the database with its generated id, and a
	 *         corresponding http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	@PostMapping
	public ResponseEntity<Batch> addBatch(@Valid @RequestBody Batch batch) {
		Batch newBatch = batchService.addBatch(batch);
		return new ResponseEntity<>(newBatch, HttpStatus.CREATED);
	}

	/**
	 * This method Takes a Batch object from a request body, and updates it in a
	 * database.
	 * 
	 * @param a Batch is taken in as the request body
	 * @return The updated Batch object as it exist in the database, and a
	 *         corresponding Http Status Code in a ResponseEntity
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey  
	 */
	@PutMapping
	public ResponseEntity<Batch> updateBatch(@Valid @RequestBody Batch batch) {
		Batch updatedBatch = batchService.updateBatch(batch);
		if (updatedBatch == null) {
			return new ResponseEntity<>(batch, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(updatedBatch, HttpStatus.OK);
		}
	}

	/**
	 * This method takes any runtime exception and returns an error message 
	 * with a corresponding HttpStatus code
	 * 
	 * @param A runtime exception parameter is taken in
	 * @return Returns a ResponseEntity that contains an error message and a 
	 * 		   corresponding Http Status Code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 */
	@ExceptionHandler
	public ResponseEntity<BatchErrorResponse> handleException(BatchNotFoundException e) {
		BatchErrorResponse error = new BatchErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
