package Testcases;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Locators.Issue_Locators;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class EditIssue {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.Issue_Locators ISS;
	public Locators.SubmittalsLocators S;
	 private ExtentTest test;
	public ExcelDataManager excelDataManager=ExcelDataManager.getInstance();
		
	 @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
     }
	
	public EditIssue() {
		System.setProperty("Webdriver.chrome.log", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboselogging", "true");
		this.driver=CustomWebDriverManager.getDriver();
		this.ISS=new Locators.Issue_Locators(driver);
		this.S=new Locators.SubmittalsLocators(driver);
	}
	
	@Then("filtering the required Issue and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_issue_and_clickin_on_it_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet Details :" + testdata);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(1000);
			ISS.ClickOnDesignProject();
			String projectcode = testdata.get(rownumber).get("Project Code");
			String status = testdata.get(rownumber).get("Status");
			String issuecode = testdata.get(rownumber).get("OldIssue code");
			System.out.println("Code" + issuecode);
			System.out.println("Status" + status);

			Thread.sleep(2000);
			S.Navigateproject();
			Thread.sleep(4000);
			ISS.EnterOnSearchBox(projectcode);
			Thread.sleep(2000);
			S.clickOnProject(projectcode);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			ISS.viewMenu();
			ISS.Issueclick();
			Thread.sleep(4000);
			ISS.SelectStatusclick();
			Thread.sleep(4000);
			ISS.SelectStatusType(status);
			Thread.sleep(4000);
			ISS.EnterOnSearchissue(issuecode);
			Thread.sleep(4000);
			ISS.clickOnEdit();
			Thread.sleep(2000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Issue");
			throw e;
		}
	}
	
	@Then("Changing the required fields in Issue using sheetname {string} and rownumber {int}")
	public void changing_the_required_fields_in_issue_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
		try {
			List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
			System.out.println("sheet details: " + testdata);
			String issuecode=testdata.get(rownumber).get("UpdateIssue Code");
			String issuename=testdata.get(rownumber).get("Updated name");
			String desc=testdata.get(rownumber).get("Description");
			String IssueStartDate = testdata.get(rownumber).get("Start Date");
			String IssueStartMonth = testdata.get(rownumber).get("Start Month");
			String IssueStartYear = testdata.get(rownumber).get("Start Year");
			String IssueDueDate = testdata.get(rownumber).get("Due Date");
			String IssueDueMonth = testdata.get(rownumber).get("Due Month");
			String IssueDueYear = testdata.get(rownumber).get("Due Year");
			String type=testdata.get(rownumber).get("Type");
			String placement=testdata.get(rownumber).get("Placement");
			String rootcause=testdata.get(rownumber).get("Root Cause");
			String wf=testdata.get(rownumber).get("Workflow");
			String loc=testdata.get(rownumber).get("Location");
			String estimatecost=testdata.get(rownumber).get("Estimate Cost");
			String actualcost=testdata.get(rownumber).get("Actual Cost");
			String Uploadimg=testdata.get(rownumber).get("Upload images");
			String attachfile=testdata.get(rownumber).get("Attach file");
			String filename=testdata.get(rownumber).get("File Name");
			
			if(issuecode!= null && !issuecode.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("code"+issuecode);
				ISS.ClickOnIssueCode();
				ISS.ClearOnIssueCode();
				Thread.sleep(1000);
				ISS.EnterOnIssueCode(issuecode);
			}
			
			if(issuename!=null && !issuename.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("name"+issuename);
				ISS.ClearOnName();
				Thread.sleep(1000);
				ISS.EnterOnName(issuename);
			}
			
			if(desc!=null && !desc.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Description"+desc);
				ISS.ClearOnDescription();
				Thread.sleep(1000);
				ISS.EnterOnDescription(desc);
			}
			
			if ((IssueStartDate != null && !IssueStartDate.isEmpty())
				&& (IssueStartMonth != null && !IssueStartMonth.isEmpty())
				&& (IssueStartYear != null && !IssueStartYear.isEmpty()))
			{
				if(IssueStartDate !=null && IssueStartDate.matches("\\d+\\.0")) {
					IssueStartDate= IssueStartDate.substring(0,IssueStartDate.indexOf(".0"));
				}
				
				if(IssueStartMonth !=null && IssueStartMonth.matches("\\d+\\.0")) {
					IssueStartMonth= IssueStartMonth.substring(0,IssueStartMonth.indexOf(".0"));
				}
				
				if(IssueStartYear !=null && IssueStartYear.matches("\\d+\\.0")) {
					IssueStartYear= IssueStartYear.substring(0,IssueStartYear.indexOf(".0"));
				}
					Thread.sleep(1000);
					System.out.println("Date"+IssueStartDate);
					System.out.println("Month"+IssueStartMonth);
					System.out.println("Year"+IssueStartYear);
					ISS.ClickOnStartDate();
					ISS.ClearOnStartDate();
					ISS.EnterOnStartDate(IssueStartMonth);
					ISS.EnterOnStartDate(IssueStartDate);
					ISS.EnterOnStartDate(IssueStartYear);
			}
			
			
			if ((IssueDueDate != null && !IssueDueDate.isEmpty())
					&& (IssueDueMonth != null && !IssueDueMonth.isEmpty())
					&& (IssueDueYear != null && !IssueDueYear.isEmpty()))
				{	
					if (IssueDueDate != null && IssueDueDate.matches("\\d+\\.0")) {
						IssueDueDate = IssueDueDate.substring(0, IssueDueDate.indexOf(".0"));
					}

					if (IssueDueMonth != null && IssueDueMonth.matches("\\d+\\.0")) {
						IssueDueMonth = IssueDueMonth.substring(0, IssueDueMonth.indexOf(".0"));
					}
					if (IssueDueYear != null && IssueDueYear.matches("\\d+\\.0")) {
						IssueDueYear = IssueDueYear.substring(0, IssueDueYear.indexOf(".0"));
					}
					Thread.sleep(1000);
					System.out.println("Enddate" + IssueDueDate);
					System.out.println("Endmonth" + IssueDueMonth);
					System.out.println("Endyear" + IssueDueYear);
					ISS.ClickOnDueDate();
					ISS.ClearOnDueDate();
					ISS.EnterOnDueDate(IssueDueMonth);
					ISS.EnterOnDueDate(IssueDueDate);
					ISS.EnterOnDueDate(IssueDueYear);

				}
			
			if(type !=null && !type.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Type"+type);
				ISS.typedropdownclick();
				Thread.sleep(1000);
				ISS.Selecttypedropdown(type);
			}
			
			if(placement !=null && !placement.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("placement"+placement);
				ISS.placementdropdownclick();
				Thread.sleep(1000);
				ISS.Selectplacementdropdown(placement);
			}
			
			if(rootcause !=null && !rootcause.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("rootcause"+rootcause);
				ISS.rootcausedropdownclick();
				Thread.sleep(1000);
				ISS.Selectrootcausedropdown(rootcause);
			}
			
			if(wf!=null && !wf.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Workflow"+wf);
				ISS.workflowselection(wf);
			}
			
			if(loc!=null && !loc.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Location"+loc);
				ISS.ClearonLocation();
				ISS.EnterOnLocation(loc);
			}
			
			if(estimatecost!=null && !estimatecost.isEmpty()) {
				Thread.sleep(1000);
				ISS.ClickOnEstimateCost();
				ISS.ClearOnEstimateCost();
				Thread.sleep(1000);
				System.out.println("estimatecost"+estimatecost);
				ISS.EnterOnEstimateCost(estimatecost);			
			}
			
			if(actualcost!=null && !actualcost.isEmpty()) {
				Thread.sleep(1000);
				ISS.ClickOnActualCost();
				ISS.ClearOnActualCost();
				Thread.sleep(1000);
				System.out.println("actualcost"+actualcost);
				ISS.EnterOnActualCost(actualcost);
			}
			
			if(Uploadimg!=null && !Uploadimg.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Path"+Uploadimg);
				ISS.UploadingAnImage(Uploadimg);
			}
			
			if ((attachfile != null && !attachfile.isEmpty()) && (filename != null && !filename.isEmpty())) {
				Thread.sleep(1000);
				System.out.println("Atachfile" + attachfile);
				System.out.println("filename" + filename);
				ISS.ClickOnAttachFiles();
				Thread.sleep(1000);
				ISS.attachFile(attachfile, filename);
				Thread.sleep(1000);
				ISS.clickOnRequiredFile(filename);
				Thread.sleep(2000);
				ISS.ClickOnAttachButton();
			}
			Thread.sleep(4000);
			ISS.ClickOnUpdate();
		}catch(Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Issue");
			throw e;
		}
	   
	}
	
	
}