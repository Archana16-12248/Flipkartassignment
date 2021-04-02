package seleniumflipkart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVWriter;


public class FlipkartSearchPage {

	
	WebDriver driver;
	public FlipkartSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	static CSVWriter writer;

	public static String removeSpclCharFromNumber(String originalStr) {
		String resltStr = "";
		// loop execute till the length of the string
		for (int i = 0; i < originalStr.length(); i++)
		{
			// comparing alphabets with their corresponding ASCII value
			if (originalStr.charAt(i) >= 48 && originalStr.charAt(i) <= 57) //  when both conditions are true,returned value is true																			// true
			{
				
				resltStr = resltStr + originalStr.charAt(i); // add characters into empty string
			}
		}
		System.out.println("String after removing special characters: " + resltStr);

		return resltStr;
	}

	public static void writeDataToCSVFile(int count, String Price, String ModelName, String Review) throws IOException {
		
		
		try {
			
			if (count == 1)
			{		
				// first create file object for file placed at location
				File file = new File("D:\\Eclipse workspace 2020-09\\Flipkartassignment\\CSV\\flipkart.csv");
			
			FileWriter outputfile = new FileWriter(file); // create FileWriter object with file as parameter

			writer = new CSVWriter(outputfile); // create CSVWriter object fileWriter object as parameter

						
				String[] header = { "ModelName", "Price","Review" }; // adding header to csv
				writer.writeNext(header);
			}
		
			String[] data1 = { ModelName, Price, Review };	// add data to csv
			writer.writeNext(data1);

			// closing writer connection

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getPriceModuleNameReview() throws InterruptedException, IOException {
		Thread.sleep(3000);

		List<WebElement> AllPrices = driver.findElements(By.xpath("//div[@class='_30jeq3']"));

		List<WebElement> modelNames = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		
		List<WebElement> AllReviews = driver.findElements(By.xpath("//span[@class='_2_R_DZ']"));
		
		int count = 0;
		for (int i = 0; i <= AllPrices.size() - 1; i++) {

			String price = AllPrices.get(i).getText();
			
			String price1 = removeSpclCharFromNumber(price);
			
			int priceInInt = Integer.parseInt(price1);  //string to int

			if (priceInInt <= 40000) {				
				
				String modelName = modelNames.get(i).getText();
				
				if(modelName.startsWith("APPLE iPhone")) {
					count=count+1;
					
					String Review = AllReviews.get(count).getText();			
					
					writeDataToCSVFile(count, price, modelName,Review);
				}
			}

		}

		writer.close();
	}
}
