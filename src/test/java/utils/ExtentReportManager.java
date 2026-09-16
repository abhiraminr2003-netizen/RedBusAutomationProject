package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports getReportObject() {

        String path = "./reports/RedBusReport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("RedBus Automation Report");
        reporter.config().setDocumentTitle("RedBus Test Results");

        ExtentReports extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Project", "RedBus Automation");
        extent.setSystemInfo("Tester", "Abhirami");

        return extent;
    }
}