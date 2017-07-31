package com.carledwinti.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobCompletionListener implements JobExecutionListener {

	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}

	public void beforeJob(JobExecution arg0) {
		// DO NOTHING
	}

}
