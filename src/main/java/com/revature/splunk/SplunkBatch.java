package com.revature.splunk;

import com.splunk.Args;
import com.splunk.Receiver;
import com.splunk.Service;
import com.splunk.ServiceArgs;

/**
 * This is a class that makes a connection to Splunk Enterprise,
 * then the connection is tested.  loginArgs will need to match 
 * current developers information.
 * 
 * @author Obosa Nosa-Igiebor, Eddie Grays, Batch: 1806-spark, Trainer: Steven Kelsey
 */
public class SplunkBatch {
	
	public static void thing() {
		ServiceArgs loginArgs = new ServiceArgs();
        loginArgs.setUsername("XXXX");
        loginArgs.setPassword("XXXX");
        loginArgs.setHost("XXXX");
        loginArgs.setPort(8089);
        loginArgs.setScheme("https");
		
		Service batchService = Service.connect(loginArgs);
		
		Receiver receiver = batchService.getReceiver();
		
		Args logArgs = new Args();
		logArgs.put("sourcetype", "splunkBatch");
		
		for (int i =0; i < 20; i++) {
			receiver.log("main", logArgs, "SplunkBatch Events");
		}
		
	}

}
