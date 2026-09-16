package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import basepkg.RedBusBaseClass;
import pages.RedBusPage;
import utils.ExcelUtil;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;
import org.testng.Assert;

public class RedBusTests extends RedBusBaseClass {

    static ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void startReport() {

        extent = ExtentReportManager.getReportObject();
    }

    @AfterSuite
    public void endReport() {

        extent.flush();
    }

    @DataProvider(name = "busData")
    public Object[][] getData() throws Exception {

        return ExcelUtil.getTestData(
                "src/main/resources/testdata.xlsx",
                "Sheet1");
    }

    @Test(dataProvider = "busData")
    public void searchBus(String from, String to) throws Exception {

        test = extent.createTest("Search Bus: " + from + " to " + to);

        RedBusPage redBus = new RedBusPage(driver);

        // From
        redBus.enterFrom(from);

        Thread.sleep(10000);

        // From dropdown manually select

        // To
        redBus.enterTo(to);

        Thread.sleep(10000);


        // Date
        redBus.clickDate();

        Thread.sleep(1000);

        // Select 20th
        redBus.selectDate();

        Thread.sleep(2000);

        // Search
        redBus.clickSearchBuses();

        Thread.sleep(5000);
        
     // Assertion
        Assert.assertTrue(driver.getCurrentUrl().contains("redbus"),
                "RedBus results page did not open");

     // Screenshot
        ScreenshotUtil.takeScreenshot(driver, "BusResults_" + from + "_" + to);

        test.pass("Bus search completed successfully");
    }
}