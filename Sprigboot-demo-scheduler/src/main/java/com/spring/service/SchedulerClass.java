package com.spring.service;

import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;

public class SchedulerClass {
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void run() {
		System.out.println("Scheduler Executed at:- "+ Calendar.getInstance().getTime());
		
	}
}
