package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

public class ExtentManager {
    // ExtentReports object to manage the reporting
    private static ExtentReports extent;

    // Method to get the singleton instance of ExtentReports
    public static ExtentReports getInstance() {
        // If extent is null, create a new instance
        if (extent == null) {
            // Create an instance with the default file name
            createInstance("Reports/Exit_Test_Report.html");
        }
        return extent;
    }

    // Method to create a new instance of ExtentReports with a specified file name
    public static ExtentReports createInstance(String fileName) {
        // Create the reports directory if it doesn't exist
        File reportDir = new File("Reports");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Create an ExtentSparkReporter with the specified file name
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        
        // Configure the HTML report theme, title, encoding, and report name
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Test Results");

        // Initialize the ExtentReports instance and attach the ExtentSparkReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Return the initialized ExtentReports instance
        return extent;
    }
}
