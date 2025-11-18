package com.flipkart;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TvPurchase {
	
	static long start;

	
@BeforeClass
	public static void browserLaunch() {
		System.out.println("Browser Launch");
	}

@AfterClass
	public static void browserQuit() {
		System.out.println("Browser Quit");
	}

@BeforeMethod
	public void startTime() {
		start = System.currentTimeMillis();
		System.out.println("Before");
	}

@AfterMethod
public void endTime() {
	long end = System.currentTimeMillis();
	System.out.println("Running time "+(end - start));
}

@Test (priority =1)
	public void admissionForm() {
		System.out.println("Admission form received");
	}

@Test (priority = 0, groups ="smoke")
	public void paymentProcess() {
		System.out.println("Payment is processed");
	}

@Test (priority = 2, groups ="smoke")
	public void studentEnrollment() {
		System.out.println("Student Enrollment Completed");
	}

@Test (priority = 4, invocationCount =2)
	public void className() {
		System.out.println("Class Rooms Alloted");
	}

@Test (priority = 3, enabled= false)
	public void hostelName() {
		System.out.println("Hostel Rooms Alloted");
	}
	
}