package PracticePakageSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class flipkartExcelstorePrice {
    public static void main(String[] args) throws IOException {
        // Set the path for the WebDriver
       
        WebDriver driver = new ChromeDriver();

        // Navigate to Flipkart
        driver.get("https://www.flipkart.com");

        // Close the login popup if it appears
        try {
            WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closeButton.click();
        } catch (Exception e) {
            // Handle exception if the popup does not appear
        }

        // Search for a product
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        // Wait for results to load and fetch product details
        WebElement product = driver.findElement(By.xpath("//div[contains(@class, '_1AtVbE')]/div[2]"));
        String productName = product.findElement(By.xpath(".//a[contains(@class, 'IRpwTa')]")).getText();
        String productPrice = product.findElement(By.xpath(".//div[contains(@class, '_30jeq3')]")).getText();

        // Create an Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Flipkart Products");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Product Name");
        headerRow.createCell(1).setCellValue("Product Price");

        // Write product data to the sheet
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(productName);
        dataRow.createCell(1).setCellValue(productPrice);

        // Write the output to an Excel file
        try (FileOutputStream fileOut = new FileOutputStream("./TestData/flipkart.xlsx")) {
            workbook.write(fileOut);
        }

        // Close the workbook and driver
        workbook.close();
        driver.quit();
    }
}
