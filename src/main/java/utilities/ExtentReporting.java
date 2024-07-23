package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	
	static ExtentReports extentReports;
	
	public static ExtentReports getReports() {
		String file= System.getProperty("user.dir")+"\\reports\\reports.html";
		ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(file);
		extentSparkReporter.config().setDocumentTitle("This is the reports of automation test scripts of orangeHRM");
		extentSparkReporter.config().setReportName("Automation Scripts");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Author", "Amit kumar");
		extentReports.setSystemInfo("Operating System", "10");
		
		return extentReports;
	}

}
