package com.spring;

import java.util.Calendar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SprigbootDemoSchedulerApplication{

	public static void main(String[] args) {
		SpringApplication.run(SprigbootDemoSchedulerApplication.class, args);
	}

	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void run() {
		System.out.println("Scheduler Executed at:- "+ Calendar.getInstance().getTime());
		
	}
	@Scheduled(cron = "0 15 10 15 * ?") // 0 15 10 15 * ?	Fire at 10:15 AM on the 15th day of every month
	public void run1() {
		System.out.println("Scheduler Executed at:- "+ Calendar.getInstance().getTime());
		
	}
}


