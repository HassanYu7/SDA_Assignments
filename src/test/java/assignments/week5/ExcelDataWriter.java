package assignments.week5;

import assignments.TestBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataWriter extends TestBase {

    //Store the path of the file as string and open the file.
    //Open the workbook.
    //Open the first worksheet.
    //Go to the first row.
    //Create a cell on the 3rd column (2nd index) on the first row.
    //Write “POPULATION” on that cell.
    //Create a cell on the 2nd row 3rd cell(index2), and write data.
    //Create a cell on the 3rd row 3rd cell(index2), and write data.
    //Create a cell on the 4th row 3rd cell(index2), and write data.
    //Write and save the workbook.
    //Close the file.
    //Close the workbook.
    //The 3rd column on excel file must be empty before running.
    // Otherwise, new data will be written on the old data

    private static final String FILE_PATH = "src/test/resources/testData/demoExcel.xlsx";

    @Test
    public void writeDataToExcel() throws IOException {
        // Store the path of the file as a string and open the file.
        FileInputStream fs = new FileInputStream(FILE_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);

        // Open the first worksheet.
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Go to the first row.
        Row firstRow = sheet.getRow(0);
        // If the first row doesn't exist, create it.
        if (firstRow == null) {
            firstRow = sheet.createRow(0);
        }

        // Create a cell on the 3rd column (2nd index) on the first row.
        Cell populationCell = firstRow.createCell(2);

        // Write “POPULATION” on that cell.
        populationCell.setCellValue("POPULATION");

        // Create cells on the 2nd, 3rd, and 4th rows of the 3rd column and write data.
        for (int i = 1; i <= 3; i++) {
            Row dataRow = sheet.getRow(i);
            // If the data row doesn't exist, create it.
            if (dataRow == null) {
                dataRow = sheet.createRow(i);
            }
            // Create a cell on the 3rd column (2nd index) of the data row.
            Cell dataCell = dataRow.createCell(2);
            // Write data to the cell.
            dataCell.setCellValue("Data " + i);
        }

        // Write and save the workbook.
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)) {
            workbook.write(fileOut);
        }

        // Close the file.
        fs.close();

        // Close the workbook.
        workbook.close();
    }
}


