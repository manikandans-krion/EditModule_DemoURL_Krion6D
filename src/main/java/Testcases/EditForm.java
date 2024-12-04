package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class EditForm {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.FormLocators FL;
	public Locators.Issue_Locators ISS;
	public ExcelDataManager excelDataManager= ExcelDataManager.getInstance();
		
	 @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
     }
	
	public EditForm() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver=CustomWebDriverManager.getDriver();
		this.FL=new Locators.FormLocators(driver);
		this.ISS= new Locators.Issue_Locators(driver);
	}
		
	@Then("filtering the required Form and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_form_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	    try {
	    	List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
	    	String projectcode=testdata.get(rownumber).get("Project Code");
	    	ISS.ClickOnDesignProject();
	    	Thread.sleep(2000);
	    	FL.Navigateproject();
	    	Thread.sleep(4000);
	    	FL.EnterOnSearchBox(projectcode);
	    	Thread.sleep(2000);
	    	FL.clickOnProject(projectcode);
	    	Thread.sleep(3000);
	    	driver.navigate().refresh();
	    	Thread.sleep(3000);
	    	FL.viewMenu();
	    	FL.routingForm();
			String Formname=testdata.get(rownumber).get("Formname");
			System.out.println("Name"+Formname);
			FL.selectformtype(Formname);
			Thread.sleep(4000);
			FL.SelectStatusclick();
			Thread.sleep(4000);
			String status=testdata.get(rownumber).get("Status");
			System.out.println("Status"+status);
			FL.SelectStatusType(status);
			Thread.sleep(4000);
			//FL.EnterOnSearchBox(Formname);
			Thread.sleep(4000);
			FL.clickOnEdit();
			Thread.sleep(2000);
	    	
	    }catch(Exception e) {
	    	ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
	    }
	}
	
	@Then("Changing the required field in Form using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_form_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	    try {
	    	List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
	    	System.out.println("sheet details :"+testdata);
	    	String startdate=testdata.get(rownumber).get("Start Date");
	    	String startmonth=testdata.get(rownumber).get("Start Month");
	    	String startyear=testdata.get(rownumber).get("Start Year");
	    	String duedate=testdata.get(rownumber).get("Due Date");
	    	String duemonth=testdata.get(rownumber).get("Due Month");
	    	String dueyear=testdata.get(rownumber).get("Due Year");
	    	String loc=testdata.get(rownumber).get("Location");
	    	//String Workflow=testdata.get(rownumber).get("Workflow");
	    	String desc=testdata.get(rownumber).get("Description");
	    	
	    	String crew=testdata.get(rownumber).get("Crew");
	    	String workers=testdata.get(rownumber).get("Workers");
	    	String totalhrs=testdata.get(rownumber).get("Total Hours");
	    	String workperformed=testdata.get(rownumber).get("Work performed");
	    	
	    	String material=testdata.get(rownumber).get("Material");
	    	String quantity1=testdata.get(rownumber).get("Quantity1");
	    	String unit=testdata.get(rownumber).get("Unit");
	    	String comment=testdata.get(rownumber).get("Comment");
	    	
	    	String equipment=testdata.get(rownumber).get("Equipment");
	    	String quantity2=testdata.get(rownumber).get("Quantity2");
	    	String hrsused=testdata.get(rownumber).get("Hours used");
	    	String cmnts=testdata.get(rownumber).get("Comments");
	    	
	    	String notes=testdata.get(rownumber).get("Notes");
	    	
	    	if ((startdate != null && !startdate.isEmpty())
					&& (startmonth != null && !startmonth.isEmpty())
					&& (startyear != null && !startyear.isEmpty()))
				{
					if(startdate !=null && startdate.matches("\\d+\\.0")) {
						startdate= startdate.substring(0,startdate.indexOf(".0"));
					}
					
					if(startmonth !=null && startmonth.matches("\\d+\\.0")) {
						startmonth= startmonth.substring(0,startmonth.indexOf(".0"));
					}
					
					if(startyear !=null && startyear.matches("\\d+\\.0")) {
						startyear= startyear.substring(0,startyear.indexOf(".0"));
					}
						Thread.sleep(1000);
						System.out.println("Date"+startdate);
						System.out.println("Month"+startmonth);
						System.out.println("Year"+startyear);
						String formatteddate=String.format("%02d/%02d/%d",Integer.parseInt(startmonth),Integer.parseInt(startdate),Integer.parseInt(startyear));
						FL.clearfromdate();
						FL.selectingfromdate(formatteddate);
						
				}
	    	
	    	if ((duedate != null && !duedate.isEmpty())
					&& (duemonth != null && !duemonth.isEmpty())
					&& (dueyear != null && !dueyear.isEmpty()))
				{
					if(duedate !=null && duedate.matches("\\d+\\.0")) {
						duedate= duedate.substring(0,duedate.indexOf(".0"));
					}
					
					if(duemonth !=null && duemonth.matches("\\d+\\.0")) {
						duemonth= duemonth.substring(0,duemonth.indexOf(".0"));
					}
					
					if(dueyear !=null && dueyear.matches("\\d+\\.0")) {
						dueyear= dueyear.substring(0,dueyear.indexOf(".0"));
					}
						Thread.sleep(1000);
						System.out.println("Date"+duedate);
						System.out.println("Month"+duemonth);
						System.out.println("Year"+dueyear);
						String formatteddate=String.format("%02d/%02d/%d",Integer.parseInt(duemonth),Integer.parseInt(duedate),Integer.parseInt(dueyear));
						FL.clearduedate();
						FL.selectingduedate(formatteddate);
						
				}
	    	
	    	if(loc !=null && !loc.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.clearlocation();
	    		FL.enterlocation(loc);
	    	}
	    	
	    	if(desc!=null && !desc.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.cleardescription();
	    		FL.enterdescription(desc);
	    	}
	    	
	    	FL.ClickOnWorklogeditbtn();
	    	
	    	if(crew!=null && !crew.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.clearcrew();
	    		FL.entercrew(crew);
	    	}
	    	
	    	if(workers!=null && !workers.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.clearworkers();
	    		Thread.sleep(1000);
	    		FL.enterworker(workers);
	    	}
	    	
	    	if(totalhrs!=null && !totalhrs.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.cleartotalhrs();
	    		FL.entertotalhr(totalhrs);
	    	}
	    	
	    	if(workperformed!=null && !workperformed.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.clearworkperoformed();
	    		FL.enterworkperformed(workperformed);
	    	}
	    	
	    	FL.worksave();
	    	
	    	FL.ClickOnMaterialeditbtn();
	    	
	    	if(material!=null && !material.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearaddmaterial();
	    		FL.entermaterial(material);
	    	}
	    	
	    	if(quantity1!=null && !quantity1.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearquantity();
	    		FL.enterquantity(quantity1);
	    	}
	    	
	    	if(unit!=null && !unit.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearunit();
	    		FL.enterunit(unit);
	    	}
	    	
	    	if(comment!=null && !comment.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearcomment();
	    		FL.entercomment(comment);
	    	}
	    	
	    	FL.materialsave();
	    	
	    	FL.ClickonEquipmenteditbtn();
	    	
	    	if(equipment!=null && !equipment.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearequipmentname();
	    		FL.enterequipmentname(equipment);
	    	}
	    	
	    	if(quantity2!=null && !quantity2.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearequipmentqty();
	    		FL.entereqpquantity(quantity2);
	    		
	    	}
	    	
	    	if(hrsused!=null && !hrsused.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearhoursused();
	    		FL.entereqphours(hrsused);
	    	}
	    	
	    	if(cmnts!=null  && !cmnts.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Cleareqpcomment();
	    		FL.entereqpcomment(cmnts);
	    		
	    	}
	    	
	    	FL.equipmentsave();
	    	
	    	if(notes!=null && !notes.isEmpty()) {
	    		Thread.sleep(1000);
	    		FL.Clearnotes();
	    		FL.enternotes(notes);
	    	}
	    	
	    	FL.clickcreate();
	    	
	    	
	    }catch(Exception e) {
	    	ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
	    }
	}
	

}