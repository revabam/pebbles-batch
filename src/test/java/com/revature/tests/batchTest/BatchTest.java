package com.revature.tests.batchTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.Application;
import com.revature.models.Batch;
import com.revature.tests.TestDriver;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestDriver.class, properties = "/pebbles-batch/src/test/resources/application.properties", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class)
public class BatchTest extends TestDriver {

	private static final Logger logger = LogManager.getLogger(BatchTest.class);

	static String url = "http://localhost:9997";

	@Test
	public void canGetAllBatches() {

		RestAssured.get(url).prettyPrint();
	}

	@Test
	public void canGetBatchId1() {

		RestAssured.get(url + "/1").then().assertThat().body("id", equalTo(1));
		RestAssured.get(url + "/1").then().assertThat().body("name", equalTo("1806-June18-USF-Java4"));
	}

	@Test
	public void canGetBatchesByTrainerId2() {

		Batch[] batches = RestAssured.get(url + "/trainer/2").as(Batch[].class);
		int batchId = batches[0].getId();

		assertEquals(2, batchId);
	}

	@Test
	public void canGetBatchesByName() {

		Batch[] batches = RestAssured.get(url + "/name/1806-June18-USF-Java2").as(Batch[].class);
		int batchId = batches[0].getId();
		assertEquals(3, batchId);
	}

	@Test
	public void canAddBatch() {

		logger.info("In RestAssuredBatchServiceTests.java");

		Batch newBatch = new Batch(10, "1806-June12-USF-Pega", new Date(1637224472690l), new Date(1937224472690l), 2,
				2);

		int status = RestAssured.given().contentType("application/json").body(newBatch).post(url).getStatusCode();

		assertEquals(201, status);
	}

	@Test
	public void canAddBatchAndCompareBody() {
		logger.info("In RestAssuredBatchServiceTests.java");

		Batch newBatch = new Batch(6, "1806-June12-USF-Pega", new Date(1637224472690l), new Date(1937224472690l), 2, 2);

		Batch batch = RestAssured.given().contentType("application/json").body(newBatch).post(url).as(Batch.class);

		assertEquals(newBatch, batch);
	}

	@Test
	public void canUpdateBatch() {
		Batch updatedBatch = new Batch(2, "1806-June12-USF-Pega", new Date(1637224472690l), new Date(1937224472690l), 2,
				2);

		Batch batch = RestAssured.given().contentType("application/json").body(updatedBatch).put(url).as(Batch.class);

		assertEquals(updatedBatch, batch);
	}
}
