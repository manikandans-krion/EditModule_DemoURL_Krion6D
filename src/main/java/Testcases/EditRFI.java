package Testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class EditRFI {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.RFILocators RFI;
	public Locators.Issue_Locators ISS;
	public ExcelDataManager excelDataManager=ExcelDataManager.getInstance();

	 @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
     }
	
	public EditRFI() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver= CustomWebDriverManager.getDriver();
		this.RFI= new Locators.RFILocators(driver);
		this.ISS= new Locators.Issue_Locators(driver);
	}
	
	
	@Then("filtering the required RFI and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_rfi_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
		try {
			List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet Details :"+testdata);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(1000);
			ISS.ClickOnDesignProject();
			String projectcode=testdata.get(rownumber).get("Project Code");
	    	Thread.sleep(2000);
	    	RFI.Navigateproject();
	    	Thread.sleep(4000);
	    	RFI.EnterOnSearchBox(projectcode);
	    	Thread.sleep(2000);
	    	RFI.clickOnProject(projectcode);
	    	Thread.sleep(3000);
	    	driver.navigate().refresh();
	    	Thread.sleep(3000);
	    	RFI.viewMenu();
	    	RFI.routingRFI();
			Thread.sleep(4000);
			String RFIcode=testdata.get(rownumber).get("OldRFI code");
			System.out.println("Code"+RFIcode);
			Thread.sleep(4000);
			RFI.SelectStatusclick();
			Thread.sleep(4000);
			String status=testdata.get(rownumber).get("Status");
			System.out.println("Status"+status);
			RFI.SelectStatusType(status);
			Thread.sleep(4000);
			RFI.EnterOnSearchRFI(RFIcode);
			Thread.sleep(4000);
			RFI.clickOnEdit();
			Thread.sleep(2000);
			}
			catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Edit RFI");
				throw e;
			}
	}
	
	@Then("Changing the required field in RFI using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_rfi_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
		try {
			List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
			System.out.println("sheet details: " + testdata);
			String code=testdata.get(rownumber).get("Update RFIcode");
			String RFIname=testdata.get(rownumber).get("Updated RFIname");
			String question=testdata.get(rownumber).get("Question");
			String ans=testdata.get(rownumber).get("Answer");
			String Duedate=testdata.get(rownumber).get("Due Date");
			String Duemonth=testdata.get(rownumber).get("Due Month");
			String Dueyear=testdata.get(rownumber).get("Due Year");
			String loc=testdata.get(rownumber).get("Location");
			String type=testdata.get(rownumber).get("Type");
			String discipline=testdata.get(rownumber).get("Discipline");
			String category=testdata.get(rownumber).get("Category");
			String wf=testdata.get(rownumber).get("Workflow");
			String priority=testdata.get(rownumber).get("Priority");
			String imgpath=testdata.get(rownumber).get("Imagepath");
			String attachfile=testdata.get(rownumber).get("Attachfile");
			String Filename=testdata.get(rownumber).get("File Name");
			
			if(code!=null && !code.isEmpty()) {
				RFI.clearcode();
				Thread.sleep(1000);
				System.out.println("Code"+code);
				RFI.enterCode(code);
			}
			
			if(RFIname!=null && !RFIname.isEmpty()) {
				RFI.clearname();
				Thread.sleep(1000);
				System.out.println("Updatedname"+RFIname);
				RFI.entername(RFIname);
			}
			
			if(question!=null && !question.isEmpty()) {
				RFI.clearquestion();
				Thread.sleep(1000);
				System.out.println("question"+question);
				RFI.enterquestion(question);
			}
			if(ans!=null && !ans.isEmpty()) {
				RFI.clearanswer();
				Thread.sleep(1000);
				System.out.println("answer"+ans);
				RFI.enteranswer(ans);
			}
			
			if ((Duedate != null && !Duedate.isEmpty()) && (Duemonth != null && !Duemonth.isEmpty())
					&& (Dueyear != null && !Dueyear.isEmpty())) {
				if(Duedate.matches("\\d+\\.0")) {
					Duedate=Duedate.substring(0,Duedate.indexOf(".0"));
				}
				if(Duemonth.matches("\\d+\\.0")) {
					Duemonth=Duemonth.substring(0,Duemonth.indexOf(".0"));
				}
				if(Dueyear.matches("\\d+\\.0")) {
					Dueyear=Dueyear.substring(0,Dueyear.indexOf(".0"));
				}
				System.out.println(Duedate);
				System.out.println(Duemonth);
				System.out.println(Dueyear);
				String formattedDate = String.format("%02d/%02d/%d", Integer.parseInt(Duemonth), Integer.parseInt(Duedate), Integer.parseInt(Dueyear));
				System.out.println(formattedDate);
				RFI.cleardate();
				RFI.enterduedate(formattedDate);
			}
			
			if(loc!=null && !loc.isEmpty()) {
				RFI.clearlocation();
				Thread.sleep(1000);
				RFI.enterLocation(loc);
			}
			
			if(type!=null && !type.isEmpty()) {
				RFI.Typedropdownclick();
				Thread.sleep(1000);
				RFI.SelectTypedropdown(type);
			}
			
			Thread.sleep(3000);
			RFI.scrolling(150);
			Thread.sleep(3000);
			
			if(discipline!=null && !discipline.isEmpty()) {
				RFI.Disciplinedropdownclick();
				Thread.sleep(1000);
				RFI.SelectDisciplinedropdown(discipline);
			}
			
			if(category!=null && !category.isEmpty()) {
				RFI.Categorydropdownclick();
				Thread.sleep(1000);
				RFI.SelectCategorydropdown(category);
			}
			
			if(wf!=null && !wf.isEmpty()) {
				Thread.sleep(1000);
				RFI.workflowselection(wf);
			}
			
			if(priority!=null && !priority.isEmpty()) {
				RFI.prioritydropdownclick();
				Thread.sleep(1000);
				RFI.SelectPrioritydropdown(priority);
			}
			
			if(imgpath!=null && !imgpath.isEmpty()) {
				Thread.sleep(1000);
				System.out.println(imgpath);
				RFI.Imageupload(imgpath);
			}
			
			if((attachfile!=null && !attachfile.isEmpty()) && Filename !=null && !Filename.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Attachfile" + attachfile);
				System.out.println("filename" + Filename);
				RFI.selectfiletype(attachfile);
				Thread.sleep(3000);
				RFI.searchfile(Filename);
				Thread.sleep(3000);
				RFI.fileattach();
				RFI.attachedbtnclick();
				
			}
			
			Thread.sleep(4000);
			RFI.ClickOnUpdate();
			
		}catch(Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
		
	    
	}
	

}