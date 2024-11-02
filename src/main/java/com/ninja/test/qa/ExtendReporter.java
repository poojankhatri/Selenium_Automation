package com.ninja.test.qa;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReporter {

	public static void generateExtendReport() {
		
		ExtentReports extentReport = new ExtentReports(); 
		File extendReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html"); 
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extendReportFile); 
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		
		
		
		
		
	}
}
