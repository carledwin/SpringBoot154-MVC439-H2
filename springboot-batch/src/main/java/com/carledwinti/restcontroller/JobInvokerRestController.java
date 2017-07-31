package com.carledwinti.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobInvokerRestController {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job processJob;
	
	private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	
	@RequestMapping("/invokeJob")
	public String handle() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
		jobLauncher.run(processJob, jobParameters);
		return "BATCH JOB HAS BEEN INVOKED at " + format.format(Calendar.getInstance().getTime()) +" ....";
	}
	
}
