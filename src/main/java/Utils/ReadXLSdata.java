package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

    // DataProvider method to provide test data for TestNG tests
    @DataProvider(name = "testdata")
    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
        // Get the name of the Excel sheet based on the test method name
        String excelSheetName = m.getName();
        // Path to the Excel file
        String filePath = "src\\main\\resources\\testdata.xlsx";
        // Create a file object
        File f = new File(filePath);
        // Read the Excel file
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        // Get the sheet with the same name as the test method
        Sheet sheetName = wb.getSheet(excelSheetName);

        // Get the total number of rows in the sheet
        int totalRows = sheetName.getLastRowNum() + 1; // Add 1 to include the header row
        // List to store test data
        List<String[]> testDataList = new ArrayList<>();

        // DataFormatter to format cell values
        DataFormatter format = new DataFormatter();
        // Iterate over each row starting from the second row (index 1)
        for (int i = 1; i < totalRows; i++) {
            Row row = sheetName.getRow(i);
            // Check if the Execution Required column is "Yes" for the current test case
            String executionRequired = format.formatCellValue(row.getCell(1)); // Assuming Execution Required column is the second column (index 1)
            if (executionRequired.equalsIgnoreCase("Yes")) {
                // Create an array to store test data
                String[] testData = new String[1];
                // Assuming username is in the first column (index 0)
                testData[0] = format.formatCellValue(row.getCell(0));
                // Add test data to the list
                testDataList.add(testData);
            }
        }

        // Convert the list of arrays to a two-dimensional array
        String[][] testDataArray = new String[testDataList.size()][1];
        testDataArray = testDataList.toArray(testDataArray);

        return testDataArray; // Return the test data array
    }
}
