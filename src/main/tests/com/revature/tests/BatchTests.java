package com.revature.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.revature.models.Batch;

import io.restassured.RestAssured;

public class BatchTests {

	// Set the url where we can find the exposed endpoints
		static String url = "http://localhost:9997";
		
		// This test retrieves all batches
	    @Test
	    public void canGetAllBatches() {
	    	
	        RestAssured.get(url).prettyPrint();
	    }
	    
	    // 
	    @Test
		public void canGetBatchById() {
	    	
	    	Batch testBatch = new Batch(1, "1806-June18-USF-Java4", new Date(1537224472690l), new Date(1545090592690l), 1, 1);
	    	Batch batch = RestAssured.get(url+"/1").body().as(Batch.class);
			
			assertEquals(testBatch, batch);
			
		}
	    
	    
	    // Test to retrieve a Batch by Id 1
	    @Test
	    public void canGetBatchId1() {
	    	
	    	int batchId = RestAssured.get(url + "/1").as(Batch.class).getId();
	    	
	    	// assertEquals(expected, value)
	    	assertEquals(1, batchId);
	    }
	    
	 // Test to retrieve a Batch by Id 2
	    @Test
	    public void canGetBatchId2() {
	    	
	    	// Same thing as above method, just different syntax
	    	RestAssured.get(url + "/2").then().assertThat().body("id", equalTo(2));
	    }
	    
	 // Test to retrieve a Batch by trainer Id 2
	    @Test
	    public void canGetBatchesByTrainerId2() {
	    	
	    	Batch[] batches = RestAssured.get(url + "/trainer/2").as(Batch[].class);
	    	int batchId = batches[0].getId();
	    	
	    	assertEquals(2, batchId);
	    }
	    
	    // Test to retrieve a Batch by name
	    @Test
	    public void canGetBatchesByName() {
	    	
	    	Batch[] batches = RestAssured.get(url + "/name/1806-June18-USF-Java2").as(Batch[].class);
	    	int batchId = batches[0].getId();
	    	// assertEquals(expected, value)
	    	assertEquals(3, batchId);
	    }
	    
	    
	    @Test
	    public void canAddBatch() {
	    	
	    	System.out.println("In RestAssuredBatchServiceTests.java");
	    	
	    	Batch newBatch = new Batch(10, "1806-June12-USF-Pega", new Date(1637224472690l), new Date(1937224472690l), 2, 2);
			
			int status = RestAssured.given().contentType("application/json").body(newBatch).post(url).getStatusCode();
			
			assertEquals(201, status);
	    }
	    
	    @Test
	    public void canAddBatchAndCompareBody() {
	    	System.out.println("In RestAssuredBatchServiceTests.java");
	    	
	    	Batch newBatch = new Batch(6, "1806-June12-USF-Pega", new Date(1637224472690l), new Date(1937224472690l), 2, 2);
			
			Batch batch = RestAssured.given().contentType("application/json").body(newBatch).post(url).as(Batch.class);
			
			assertEquals(newBatch, batch);
	    }
	    
	    // This tests if updating a batch works 
	    @Test
		public void canUpdateBatch() {
			Batch updatedBatch = new Batch(2, "1806-June12-USF-Pega", new Date(1637224472690l), new Date(1937224472690l), 2, 2);
			
			
				// This is not necessary, we can declare the content type below for automatic conversion
//			JsonObject json = new JsonObject();
//			json.addProperty("batch", updatedBatch.toString());
			
			Batch batch = RestAssured.given().contentType("application/json").body(updatedBatch).put(url).as(Batch.class);
			
			assertEquals(updatedBatch, batch);
		}	  
}
