package Testcases;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;


public class Edit_DesignProject_Testcases {

	 private WebDriver driver;
	 private Locators.LoginLocators L;
	 private Locators.Edit_Design_Projects_Locators D;
	 private Locators.Edit_Review_Locators R;
	 private Locators.Edit_RFA_Locators RFA;
	 private Locators.Edit_Meeting_Locators MET;
	 private Locators.Edit_BOM_BOQ_Locators BOM;
	 private Locators.Edit_Checklist_Locators Chk;
	 private ExtentTest test;
	 private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
	 
	 
	 
	 @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
     }
	 
	 
	 public Edit_DesignProject_Testcases() throws InterruptedException {
         System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
         System.setProperty("webdriver.chrome.verboseLogging", "true");
         this.driver = CustomWebDriverManager.getDriver();
         this.D = new Locators.Edit_Design_Projects_Locators(driver);
         this.R = new Locators.Edit_Review_Locators(driver);
         this.RFA = new Locators.Edit_RFA_Locators(driver);
         this.MET = new Locators.Edit_Meeting_Locators(driver);
         this.BOM = new Locators.Edit_BOM_BOQ_Locators(driver);
         this.Chk = new Locators.Edit_Checklist_Locators(driver);
     }
     
	 
	   @Given("I visit the User Login for Design Projects using sheetname {string} and rownumber {int}")
	     public void i_visit_the_user_login_for_Design_projects_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	     	try {
	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
	           
	           String email = testdata.get(rownumber).get("Login Email");
	           String password = testdata.get(rownumber).get("Login Password");

	           if (password.matches("\\d+(\\.\\d+)?")) { // Check if password is numeric
	               password = password.replaceAll("\\.0$", ""); // Remove the decimal if it's a whole number
	           }
	           
	           L = new Locators.LoginLocators(driver);
	           L.EnterEmail(email);
	           L.EnterPassword(password);
	           
	           LoginInputDatas("Email", email);
	           LoginInputDatas("Password", password);
	     	} catch (Exception e) {
	 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	 		   exceptionHandler.handleException(e, "Login Page");
	 		    throw e; 
	 		}
	     }
	     
	     @Given("I enter the credentials in login and click a login button")
	     public void i_enter_the_credentials_in_login_and_click_a_login_button() {
	 		try {
	 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 			L.ClickOnLogin();
	 			
	 		} catch (Exception e) {
	 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	 		   exceptionHandler.handleException(e, "Login Page");
	 		    throw e; 
	 		}
	     }
	 
	     
	     
	     
	     //Filtering the Required Project to Edit
	 
	 
	     @Then("Changing the required fields in Project using sheetname {string} and rownumber {int}")
	     public void chaning_the_required_fields_in_project(String sheetname, int rownumber) throws Exception {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	   	     List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
	   	  Thread.sleep(3000);
			D.ClickOnDesignProject();
	   	  String OldProjectCode = testdata.get(rownumber).get("Old Project code");
	         Thread.sleep(4000);
	         D.clickOnActionButtonForProject(OldProjectCode);
	   	     
	   	     
	   	   String WithOrWithoutISOProject = testdata.get(rownumber).get("With or Without ISO Project");
	   	   String ProjectCode = testdata.get(rownumber).get("Project code");  
	       String ProjectName = testdata.get(rownumber).get("Project name");  
	       String ProjectDescrpt = testdata.get(rownumber).get("Project Description");   
	       String ProjectStartDate = testdata.get(rownumber).get("start date");
	       String ProjectStartMonth = testdata.get(rownumber).get("start month");
	       String ProjectStartYear = testdata.get(rownumber).get("start year");  
	       String ProjectDesigntype = testdata.get(rownumber).get("Design type");
	       String Projectcategory = testdata.get(rownumber).get("category");
	       String ProjectOwner = testdata.get(rownumber).get("Owner");
	       String Projectstatus = testdata.get(rownumber).get("status");
	       String AddressLine1 = testdata.get(rownumber).get("Address Line1");
	       String AddressLine2 = testdata.get(rownumber).get("Address Line2");
	       String City = testdata.get(rownumber).get("city");
	       String State = testdata.get(rownumber).get("state");
	       String Pincode = testdata.get(rownumber).get("postal code");
	       String Country = testdata.get(rownumber).get("country");
	       
	       
	   	  if (WithOrWithoutISOProject != null && !WithOrWithoutISOProject.isEmpty()) {
	            int WithOrWithoutISOProjectStatus = Integer.parseInt(WithOrWithoutISOProject.split("\\.")[0]);
	            System.out.println(WithOrWithoutISOProjectStatus + "--->WithOrWithoutISOProjectStatus");
	            if (WithOrWithoutISOProjectStatus == 1) {
	            	Thread.sleep(1000);
	                D.ClickOnProjectWithoutISO();
	            }
	   	  }
	   	    
	   	  
	   	 if(ProjectCode != null && !ProjectCode.isEmpty()) {
	   		Thread.sleep(1000);
   			D.ClearOnProjectCode();
   			Thread.sleep(2000);
   			D.EnterOnProjectCode(ProjectCode);
	   	  }
	   	  
	   	 
	   	 if(ProjectName != null && !ProjectName.isEmpty()) {
	   		Thread.sleep(1000);
			D.ClearOnProjectName();
			Thread.sleep(2000);
			D.EnterOnProjectName(ProjectName);
	   	  }
	   	  
	   	  
		 if(ProjectDescrpt != null && !ProjectDescrpt.isEmpty()) {
		   		Thread.sleep(1000);
		   		D.ClearOnProjectDescrpt();
				Thread.sleep(2000);
				D.EnterOnProjectDescrpt(ProjectDescrpt);
		   	  }
	   	  
	   	  
		 if ((ProjectStartDate != null && !ProjectStartDate.isEmpty()) &&
				    (ProjectStartMonth != null && !ProjectStartMonth.isEmpty()) &&
				    (ProjectStartYear != null && !ProjectStartYear.isEmpty())) {
				
				  if (ProjectStartYear != null && ProjectStartYear.matches("\\d+\\.0")) {
					  ProjectStartYear = ProjectStartYear.substring(0, ProjectStartYear.indexOf(".0"));
		        	
					  Thread.sleep(1000);
			  			D.ClickOnStartDate();
			  			D.ClearOnStartDate();
			  			D.EnterOnStartDate(ProjectStartDate);
			  			D.EnterOnStartDate(ProjectStartMonth);
			  			D.EnterOnStartDate(ProjectStartYear);
			    }
			}
	   	  
		 if(ProjectDesigntype != null && !ProjectDesigntype.isEmpty()) {
			 Thread.sleep(1000);
		        D.ClickOnProjectDesignType();
		        Thread.sleep(2000);
		        D.EnterOnProjectDesignType(ProjectDesigntype);
		        performTabKeyPress();
		   	  }
	   	  
		 if(Projectcategory != null && !Projectcategory.isEmpty()) {
			 Thread.sleep(1000);
		     D.EnterOnProjectCategory(Projectcategory);
		     Thread.sleep(1000);
		     performTabKeyPress();
		   	  }
	   	  
	   	  
		 if(ProjectOwner != null && !ProjectOwner.isEmpty()) {
			 Thread.sleep(1000);
				D.ClickOnProjectOwnerSelection();
				Thread.sleep(1000);
				D.EnterOnProjectOwnerSelection(ProjectOwner);
				Thread.sleep(1000);
				performTabKeyPress();
		   	  }
	   	  
		 if(ProjectOwner != null && !ProjectOwner.isEmpty()) {
			 Thread.sleep(1000);
				D.ClickOnProjectStatus();
				Thread.sleep(1000);
				D.EnterOnProjectStatus(Projectstatus);
				Thread.sleep(1000);
				performTabKeyPress();
		   	  }
	   	  
		 if(AddressLine1 != null && !AddressLine1.isEmpty()) {
			 Thread.sleep(1000);
			 D.ClearOnAddressLine1();
			 Thread.sleep(2000);
			 D.EnterOnAddressLine1(AddressLine1);
		   	  }
	   	  
		 if(AddressLine2 != null && !AddressLine2.isEmpty()) {
			 Thread.sleep(1000);
			 D.ClearOnAddressLine2();
			 Thread.sleep(2000);
			 D.EnterOnAddressLine2(AddressLine2);
		   	  }
	   	  
	   	  
		 if(City != null && !City.isEmpty()) {
			 Thread.sleep(1000);
			 D.ClearOnCity();
			 Thread.sleep(2000);
			 D.EnterOnCity(City);
		 }
		 
		 if(State != null && !State.isEmpty()) {
			 Thread.sleep(1000);
			 D.ClearOnState();
			 Thread.sleep(2000);
			 D.EnterOnState(State);
		 }
		 
		 if(Pincode != null && !Pincode.isEmpty()) {
			 if (Pincode != null && Pincode.matches("\\d+\\.0")) {
					Pincode = Pincode.substring(0, Pincode.indexOf(".0"));
					
			 Thread.sleep(1000);
			 	D.ClearOnPincode();
				Thread.sleep(1000);
				D.EnterOnPincode(Pincode);
			 }
		 }
		 
		 if(Country != null && !Country.isEmpty()) {
			 Thread.sleep(1000);
			 D.ClearOnCountry();
			 Thread.sleep(2000);
			 D.EnterOnCountry(Country);
		 }
		 
		 D.ClickOnUpdateButton();
		 Thread.sleep(4000);
	   	  
	     }
	 
	     
	     
	     
	 //Edit Review under Action
	     
	     @Then("Changing the required field in Review module under Action using sheetname {string} and rownumber {int}")
	     public void Changing_the_required_field_in_Review_module_under_Action(String sheetname, int rownumber) throws Exception {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	   	     List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
	   	   String ProjectCode = testdata.get(rownumber).get("Project code");
	   	   	Thread.sleep(2000);
			D.ClickOnDesignProject();
	         Thread.sleep(4000);
	         D.EnterOnSearchBox(ProjectCode);
	         Thread.sleep(2000);
	         D.clickOnProject(ProjectCode);
	         Thread.sleep(3000);
	   	     
	   	     
	   	     driver.navigate().refresh();
	   		Thread.sleep(4000);
			R.ClickOnActions();
			Thread.sleep(3000);
			R.ClickOnReview();
	        Thread.sleep(4000);
	        R.SelectStatusclick();
	        Thread.sleep(4000);
			String type = testdata.get(rownumber).get("Status");
			R.SelectStatusType(type);
			Thread.sleep(4000);
			String OldReviewCode = testdata.get(rownumber).get("Old Review Code");
		    Thread.sleep(4000);
		    D.clickOnActionButtonForProject(OldReviewCode);
	   	     
		    String ParentReview = testdata.get(rownumber).get("Parent Review"); 
			String ReviewCode = testdata.get(rownumber).get("Review Code");
            String ReviewName = testdata.get(rownumber).get("Review Name");
       	    String Description = testdata.get(rownumber).get("Description");
       	    String ReviewStartDate = testdata.get(rownumber).get("Start Date");
         	String ReviewStartMonth = testdata.get(rownumber).get("Start Month");
        	String ReviewStartYear = testdata.get(rownumber).get("Start Year");
        	String ReviewEndDate = testdata.get(rownumber).get("End Date");
        	String ReviewEndMonth = testdata.get(rownumber).get("End Month");
        	String ReviewEndYear = testdata.get(rownumber).get("End Year");
        	String Workflow = testdata.get(rownumber).get("Workflow");
        	String Priority = testdata.get(rownumber).get("Priority");
        	String EstimateCost = testdata.get(rownumber).get("Estimate Cost");
        	String ActualCost = testdata.get(rownumber).get("Actual Cost");
        	String Attachfile = testdata.get(rownumber).get("Attachfile");
			String FileName = testdata.get(rownumber).get("File Name");
		    
			
			 if(ParentReview != null && !ParentReview.isEmpty()) {
				 Thread.sleep(1000);
		         R.ClickOnParentReview();
		         Thread.sleep(1000);
		         R.selectDropdownOption(ParentReview);
		         performTabKeyPress();
			   	  }
			
			 if(ReviewCode != null && !ReviewCode.isEmpty()) {
				 Thread.sleep(1000);
				 R.ClearOnReviewCode();
				 Thread.sleep(1000);
				 R.EnterOnReviewCode(ReviewCode);
			   	  }
			
			 if(ReviewName != null && !ReviewName.isEmpty()) {
				 Thread.sleep(1000);
				 R.ClearOnReviewName();
				 Thread.sleep(1000);
				 R.EnterOnReviewName(ReviewName);
			   	  }
			
			 if(Description != null && !Description.isEmpty()) {
				 Thread.sleep(1000);
				 R.ClearOnDescription();
				 Thread.sleep(1000);
				 R.EnterOnDescription(Description);
			   	  }
			
			  
			 if ((ReviewStartDate != null && !ReviewStartDate.isEmpty()) &&
					    (ReviewStartMonth != null && !ReviewStartMonth.isEmpty()) &&
					    (ReviewStartYear != null && !ReviewStartYear.isEmpty())) {
					
					  if (ReviewStartYear != null && ReviewStartYear.matches("\\d+\\.0")) {
						  ReviewStartYear = ReviewStartYear.substring(0, ReviewStartYear.indexOf(".0"));
			        	
						  Thread.sleep(1000);
							R.ClickOnStartDate();
							R.ClearOnStartDate();
							R.EnterOnStartDate(ReviewStartDate);
							R.EnterOnStartDate(ReviewStartMonth);
							R.EnterOnStartDate(ReviewStartYear);
				    }
				}
			
			
			 if ((ReviewEndDate != null && !ReviewEndDate.isEmpty()) &&
					    (ReviewEndMonth != null && !ReviewEndMonth.isEmpty()) &&
					    (ReviewEndYear != null && !ReviewEndYear.isEmpty())) {
					
					  if (ReviewEndYear != null && ReviewEndYear.matches("\\d+\\.0")) {
						  ReviewEndYear = ReviewEndYear.substring(0, ReviewEndYear.indexOf(".0"));
			        	
						  Thread.sleep(1000);
							R.ClickOnEndDate();
							R.ClearOnEndDate();
							R.EnterOnEndDate(ReviewEndDate);
							R.EnterOnEndDate(ReviewEndMonth);
							R.EnterOnEndDate(ReviewEndYear);
				    }
				}
			
			 
			 if(Workflow != null && !Workflow.isEmpty()) {
				    Thread.sleep(1000);
				    R.workflowselection(Workflow);
				    Thread.sleep(1000);
			   	  }
			 
			 
			 if(Priority != null && !Priority.isEmpty()) {
				 Thread.sleep(1000);
					R.prioritydropdownclick();
					Thread.sleep(1000);
					R.SelectPrioritydropdown(Priority);
			   	  }
		 	
			
			 if(EstimateCost != null && !EstimateCost.isEmpty()) {
			    	 Thread.sleep(1000);
				     R.ClearOnEstimateCost();
					 Thread.sleep(1000);
					 R.EnterOnEstimateCost(EstimateCost);
			   	  }
			
			 if(ActualCost != null && !ActualCost.isEmpty()) {
		    	 Thread.sleep(1000);
		    	 R.ClearOnActualCost();
				 Thread.sleep(1000);
				 R.EnterOnActualCost(ActualCost);
		   	  }
		    
			 if (Attachfile != null && !Attachfile.isEmpty()) {
				 Thread.sleep(1000);
					R.ClickOnAttachFiles();
					Thread.sleep(1000);
					R.attachFile(Attachfile,FileName);
					Thread.sleep(1000);													
					R.clickOnRequiredFile(FileName);
					Thread.sleep(2000);
					R.ClickOnAttachButton();
			    }
			 
			 
			 
			 Thread.sleep(4000);
				R.ClickOnUpdate();
			 
				 Thread.sleep(4000);
	     }
	 
	 
	 //Edit RFA under Action
	     
	     @Then("Changing the required field in RFA module under Action using sheetname {string} and rownumber {int}")
	 	public void changing_the_required_fied_in_RFA_module(String sheetname, int rownumber) throws Exception {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	   	     List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
	   	   String ProjectCode = testdata.get(rownumber).get("Project code");
	   	   Thread.sleep(2000);
			D.ClickOnDesignProject();
			Thread.sleep(4000);
			D.EnterOnSearchBox(ProjectCode);
			Thread.sleep(2000);
			D.clickOnProject(ProjectCode);
			Thread.sleep(3000);
	   	   
	   	   driver.navigate().refresh();
		   		Thread.sleep(4000);
				R.ClickOnActions();
				Thread.sleep(3000);
				RFA.ClickOnRFA();
		        Thread.sleep(4000);
		        R.SelectStatusclick();
		        Thread.sleep(4000);
				String type = testdata.get(rownumber).get("Status");
				R.SelectStatusType(type);
				Thread.sleep(4000);
				String OldRFACode = testdata.get(rownumber).get("Old RFA Code");
			    Thread.sleep(4000);
			    D.clickOnActionButtonForProject(OldRFACode);
	         
	         
	         String RFACode = testdata.get(rownumber).get("RFA Code");
	         String RFAName = testdata.get(rownumber).get("RFA Name");
	         String Description = testdata.get(rownumber).get("Description");
	         String RFAStartDate = testdata.get(rownumber).get("Start Date");
	         String RFAStartMonth = testdata.get(rownumber).get("Start Date");
	         String RFAStartYear = testdata.get(rownumber).get("Start Year");
	         String RFAEndDate = testdata.get(rownumber).get("End Date");
	         String RFAEndMonth = testdata.get(rownumber).get("End Date");
	         String RFAEndYear = testdata.get(rownumber).get("End Year");
	         String Workflow = testdata.get(rownumber).get("Workflow");  	  
	         String Priority = testdata.get(rownumber).get("Priority");
	         String Attachfile = testdata.get(rownumber).get("Attachfile");
	 		String FileName = testdata.get(rownumber).get("File Name");
	 		
	 		if (RFACode != null && !RFACode.isEmpty()) {
	 			Thread.sleep(1000);
	 			 RFA.ClearOnRFACode();
	 			 Thread.sleep(1000);
	 			 RFA.EnterOnRFACode(RFACode);
	 	    }
	 		
	 		if (RFAName != null && !RFAName.isEmpty()) {
	 			Thread.sleep(1000);
	 	      	 RFA.ClearOnRFAName();
	 	      	 Thread.sleep(1000);
	 			 RFA.EnterOnRFAName(RFAName);
	 		}
	 		
	 		if (Description != null && !Description.isEmpty()) {
	 			RFA.ClearOnDescription();
	 			RFA.EnterOnDescription(Description);
	 	    }
	 		
	 		if ((RFAStartDate != null && !RFAStartDate.isEmpty()) &&
	 			    (RFAStartMonth != null && !RFAStartMonth.isEmpty()) &&
	 			    (RFAStartYear != null && !RFAStartYear.isEmpty())) {
	 			
	 			  if (RFAStartYear != null && RFAStartYear.matches("\\d+\\.0")) {
	 	        		RFAStartYear = RFAStartYear.substring(0, RFAStartYear.indexOf(".0"));
	 	        	
	 	        	  Thread.sleep(1000);
	 			RFA.ClickOnStartDate();
	 			RFA.ClearOnStartDate();
	 			RFA.EnterOnStartDate(RFAStartDate);
	 			RFA.EnterOnStartDate(RFAStartMonth);
	 			RFA.EnterOnStartDate(RFAStartYear);
	 		    }
	 		}
	 		
	 		
	 		if ((RFAEndDate != null && !RFAEndDate.isEmpty()) &&
	 			    (RFAEndMonth != null && !RFAEndMonth.isEmpty()) &&
	 			    (RFAEndYear != null && !RFAEndYear.isEmpty())) {
	 			
	 			  if (RFAEndYear != null && RFAEndYear.matches("\\d+\\.0")) {
	 				  RFAEndYear = RFAEndYear.substring(0, RFAEndYear.indexOf(".0"));
	 	        	
	 				  Thread.sleep(1000);
	 					RFA.ClickOnEndDate();
	 					RFA.ClearOnEndDate();
	 					RFA.EnterOnEndDate(RFAEndDate);
	 					RFA.EnterOnEndDate(RFAEndMonth);
	 					RFA.EnterOnEndDate(RFAEndYear);
	 		    }
	 		}
	 		
	 		
	 		 if (Workflow != null && !Workflow.isEmpty()) {
	 			 Thread.sleep(1000);
	 				RFA.workflowselection(Workflow);
	 				Thread.sleep(1000);
	 				performTabKeyPress();
	 				performTabKeyPress();
	 		    }
	 		
	 		
	 		 if (Priority != null && !Priority.isEmpty()) {
	 				Thread.sleep(1000);
	 				RFA.prioritydropdownclick();
	 				Thread.sleep(1000);
	 				RFA.SelectPrioritydropdown(Priority);
	 		    }
	 		
	 		
	 		 if (Attachfile != null && !Attachfile.isEmpty()) {
	 			 Thread.sleep(1000);
	 			 	R.ClickOnAttachFiles();
	 				Thread.sleep(1000);
	 				RFA.attachFile(Attachfile,FileName);
	 				Thread.sleep(1000);													
	 				R.clickOnRequiredFile(FileName);
	 				Thread.sleep(2000);
	 				R.ClickOnAttachButton();
	 		    }
	 		
	 		 Thread.sleep(3000);
	 		 RFA.ClickOnUpdate();
	 		 Thread.sleep(4000);
	 		 
	     }
	     
	 
	 // Share ->  Edit Meeting Module
	     
	     
	     @Then("Changing the required field in Meeting module under Share using sheetname {string} and rownumber {int}")
		 	public void changing_the_required_fied_in_meeting_module(String sheetname, int rownumber) throws Exception {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	   	     List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
	   	   String ProjectCode = testdata.get(rownumber).get("Project code");
	   	   Thread.sleep(2000);
			D.ClickOnDesignProject();
			Thread.sleep(4000);
			D.EnterOnSearchBox(ProjectCode);
			Thread.sleep(2000);
			D.clickOnProject(ProjectCode);
			Thread.sleep(3000);
	     
	     
			  driver.navigate().refresh();
		   		Thread.sleep(4000);
		   		MET.ClickOnShare();
				Thread.sleep(3000);
				MET.ClickOnMeeting();
		        Thread.sleep(4000);
				String OldMeetingName = testdata.get(rownumber).get("Old Meeting Name");
			    Thread.sleep(4000);
			    D.clickOnActionButtonForProject(OldMeetingName);
	     
	     
			    String MeetingName = testdata.get(rownumber).get("Name"); 
		      	String MeetingStartDate = testdata.get(rownumber).get("Meeting Start Date");
  	        	String MeetingStartMonth = testdata.get(rownumber).get("Meeting Start Month");
  	        	String MeetingStartYear = testdata.get(rownumber).get("Meeting Start Year");
  	    	    String Hour = testdata.get(rownumber).get("Hour");
  	    	    String Minute = testdata.get(rownumber).get("Minute");
  	    	    String AM_PM = testdata.get(rownumber).get("AM/PM");
  	    	    String DurationHours = testdata.get(rownumber).get("Duration Hours");
  	         	String DurationMinutes = testdata.get(rownumber).get("Duration Minutes");
  	            String Description = testdata.get(rownumber).get("Description");
  	            String imageFilePath = testdata.get(rownumber).get("Upload Images");
  	            String Attachfile = testdata.get(rownumber).get("Attachfile");
  	            String FileName = testdata.get(rownumber).get("File Name");
	     
	     
	     
  	          if (MeetingName != null && !MeetingName.isEmpty()) {
 	 			 Thread.sleep(1000);
 	 			 MET.ClearOnName();
 	 			Thread.sleep(1000);
 	 			MET.EnterOnName(MeetingName);
 	 		    }
	     
	     
  	        if ((MeetingStartDate != null && !MeetingStartDate.isEmpty()) &&
	 			    (MeetingStartMonth != null && !MeetingStartMonth.isEmpty()) &&
	 			    (MeetingStartYear != null && !MeetingStartYear.isEmpty())) {
	 			
	 			  if (MeetingStartYear != null && MeetingStartYear.matches("\\d+\\.0")) {
	 				 MeetingStartYear = MeetingStartYear.substring(0, MeetingStartYear.indexOf(".0"));
	 	        	
	 				 Thread.sleep(1000);
	     			MET.ClickOnDate();
	     			MET.ClearOnDate();
	     			MET.EnterOnDate(MeetingStartDate);
	     			MET.EnterOnDate(MeetingStartMonth);
	     			performTabKeyPress();
	     			MET.EnterOnDate(MeetingStartYear);
	 		    }
	 		}
	     
  	      if ((Hour != null && !Hour.isEmpty()) &&
	 			    (Minute != null && !Minute.isEmpty()) &&
	 			    (AM_PM != null && !AM_PM.isEmpty())) {
	 	        	
	 				Thread.sleep(1000);
	 				MET.ClickOnTime();
	 				MET.ClearOnTime();
	 				MET.EnterOnTime(Hour);
	 				MET.EnterOnTime(Minute);
	 				MET.EnterOnTime(AM_PM);
	 		    }

  	      
  	    if ((DurationHours != null && !DurationHours.isEmpty()) &&
 			    (DurationMinutes != null && !DurationMinutes.isEmpty())) {
 	        	
  	    	Thread.sleep(1000);
  			MET.ClearOnDurationHours();
  			MET.EnterOnDurationHours(DurationHours);
  			Thread.sleep(1000);
  			MET.ClearOnDurationMinutes();
  			MET.EnterOnDurationMinutes(DurationMinutes);
 		    }
  	      
  	      
  	  if (Description != null && !Description.isEmpty()) {
  		 MET.ClearOnDescription();
		 Thread.sleep(1000);
		 MET.EnterOnDescription(Description);
		    }
  	    

  	  
  	  for (Map<String, String> row : testdata) {
	        String userName = row.get("Select users"); // Adjust based on your Excel column header
	        if (userName != null && !userName.isEmpty()) {
	        	 Thread.sleep(1000);
	        	 MET.ClickOnSelectUsersTab();
	        	 Thread.sleep(1000);
	        	 MET.ClickOnSelectUserField();
	        	 Thread.sleep(1000);
	        	 MET.Selectusers(userName);
	        	 Thread.sleep(2000);
	        } else {
	            System.out.println("No more users to select, stopping the selection process.");
	            break;
	        }
	    }
      
      
      for (Map<String, String> row : testdata) {
	        String userName = row.get("Select user groups"); // Adjust based on your Excel column header
	        if (userName != null && !userName.isEmpty()) {
	        	 Thread.sleep(1000);
	        	 MET.ClickOnSelectGroupUsersTab();
	        	 Thread.sleep(1000);
	        	 MET.ClickOnSelectUserGroupField();
	        	Thread.sleep(1000);
	            MET.Selectusersgroup(userName);
	            Thread.sleep(2000);
	        } else {
	            System.out.println("No more users to select, stopping the selection process.");
	            break;
	        }
	    }
        
  	     
      
  	      
      if (imageFilePath != null && !imageFilePath.isEmpty()) {
    	  Thread.sleep(1000);
    	  MET.UploadingAnImage(imageFilePath);
      }
      
      
      if (Attachfile != null && !Attachfile.isEmpty()) {
			 Thread.sleep(1000);
				R.ClickOnAttachFiles();
				Thread.sleep(1000);
				R.attachFile(Attachfile,FileName);
				Thread.sleep(1000);													
				R.clickOnRequiredFile(FileName);
				Thread.sleep(2000);
				R.ClickOnAttachButton();
		    }
      
      				Thread.sleep(4000);
      				RFA.ClickOnUpdate();
      				Thread.sleep(4000);
      				
}	        
  	        
  	        
  	    //Attachments -> Edit BOM/BOQ
	     
	     
	     @Then("Changing the required field in BOM_BOQ module under Attachments using sheetname {string} and rownumber {int}")
	     public void changing_the_required_field_in_bom_boq_module_under_attachments_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	   	     List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
	   	   String ProjectCode = testdata.get(rownumber).get("Project code");
	   	   Thread.sleep(2000);
			D.ClickOnDesignProject();
			Thread.sleep(4000);
			D.EnterOnSearchBox(ProjectCode);
			Thread.sleep(2000);
			D.clickOnProject(ProjectCode);
			Thread.sleep(3000);
			
			 driver.navigate().refresh();
		   		Thread.sleep(4000);
		   		BOM.ClickOnAttachments();
				Thread.sleep(3000);
				BOM.ClickOnBOM_BOQ();
		        Thread.sleep(4000);
		        R.SelectStatusclick();
		        Thread.sleep(4000);
				String type = testdata.get(rownumber).get("Status");
				R.SelectStatusType(type);
				Thread.sleep(4000);
				String OldBOMCode = testdata.get(rownumber).get("Old BOM Code");
			    Thread.sleep(4000);
			    D.clickOnActionButtonForProject(OldBOMCode);
	    	 
	    	 
			    String ParentBOM = testdata.get(rownumber).get("Parent BOM");
				String Code = testdata.get(rownumber).get("Code");
				String Name = testdata.get(rownumber).get("Name");
				String Workflow = testdata.get(rownumber).get("Workflow");
				String Priority = testdata.get(rownumber).get("Priority");
				String Unit = testdata.get(rownumber).get("Unit");
				String EstimatedQuantity = testdata.get(rownumber).get("Estimated Quantity");
				String EstimatedPricePerUnit = testdata.get(rownumber).get("Estimated Price Per Unit");
	 			String EstimatedTotal = testdata.get(rownumber).get("Estimated Total");
	 			String OrderedQuantity = testdata.get(rownumber).get("Ordered Quantity");
	 			String QuotedPricePerUnit = testdata.get(rownumber).get("Quoted Price Per Unit");
	 			String QuotedTotal = testdata.get(rownumber).get("Quoted Total");
	 			String ActualQuantity = testdata.get(rownumber).get("Actual Quantity");
	 			String ActualPricePerUnit = testdata.get(rownumber).get("Actual Price Per Unit");
	 			String ActualTotal = testdata.get(rownumber).get("Actual Total");
	 			String Remarks = testdata.get(rownumber).get("Remarks");
	 			String GUID = testdata.get(rownumber).get("GUID");
	 			String QRCode = testdata.get(rownumber).get("QR Code");
	    	 
	    	 
	    	 
	 		      if (ParentBOM != null && !ParentBOM.isEmpty()) {
	 		    	 Thread.sleep(1000);
	 		         BOM.ClickOnParentBOM();
	 		         Thread.sleep(1000);
	 		         BOM.selectDropdownOption(ParentBOM);
	 		         performTabKeyPress();
	 				    }
	    	 
	    	 
	 		     if (Code != null && !Code.isEmpty()) {
	 		    	 Thread.sleep(1000);
	 		    	BOM.ClickOnCode();
	 	 			BOM.ClearOnCode();
	 	 			Thread.sleep(1000);
	 	 			BOM.EnterOnCode(Code);
	 				    }
	    	 
	    	 
	 		    if (Name != null && !Name.isEmpty()) {
	 		    	 Thread.sleep(1000);
	 		    	BOM.ClearOnName();
	 		    	 Thread.sleep(1000);
	 	 			BOM.EnterOnName(Name);
	 				    }
	    	 
	 		    if (Workflow != null && !Workflow.isEmpty()) {
	 		    	  Thread.sleep(1000);
	 		         RFA.workflowselection(Workflow);
	 				    }
	 		    
	 		   if (Priority != null && !Priority.isEmpty()) {
	 		    	  Thread.sleep(1000);
	 		    	  RFA.prioritydropdownclick();
	 		    	  Thread.sleep(1000);
	 		    	  RFA.SelectPrioritydropdown(Priority);
	 				    }
	    	 
	 		   if (Unit != null && !Unit.isEmpty()) {
	 		    	  Thread.sleep(1000);
	 		    		BOM.unitdropdownclick();
	 		    	  Thread.sleep(1000);
	 		    	 BOM.SelectUnitdropdown(Unit);
	 				    }
	 		   
	 		   if (EstimatedQuantity != null && !EstimatedQuantity.isEmpty()) {
	 		    	  Thread.sleep(1000);
	 		    	  BOM.ClearOnEstimatedQuantity();
	 		    	 Thread.sleep(1000);
	 	 			BOM.EnterOnEstimatedQuantity(EstimatedQuantity);
	 				    }
	 		   else {
	 			   System.out.println("Estimated Quantity Value remains the same");
	 		   }
	 		   
	 		   
	 		   if (EstimatedPricePerUnit != null && !EstimatedPricePerUnit.isEmpty()) {
	 		    	  Thread.sleep(1000);
	 		    	  BOM.ClearOnEstimatedPricePerUnit();
	 		    	 Thread.sleep(1000);
	 	 			BOM.EnterOnEstimatedPricePerUnit(EstimatedPricePerUnit);
	 				    }
	 		  else {
	 			   System.out.println("Estimated Price Per Unit remains the same");
	 		   }
	 		   
	 		   
	 		 
	 		   
	 		  if (EstimatedQuantity != null && EstimatedQuantity.matches("\\d+\\.0")) {
	 				EstimatedQuantity = EstimatedQuantity.substring(0, EstimatedQuantity.indexOf(".0"));
	 			}
	 			
	 			if (EstimatedPricePerUnit != null && EstimatedPricePerUnit.matches("\\d+\\.0")) {
	 				EstimatedPricePerUnit = EstimatedPricePerUnit.substring(0, EstimatedPricePerUnit.indexOf(".0"));
	 			}
	 			
	 			Thread.sleep(1000);
	 			String calculatedEstimatedTotal = BOM.getEstimatedTotal(); 			
	 			int estimatedquantity = Integer.parseInt(EstimatedQuantity);
	 			int estimatedpricePerUnit = Integer.parseInt(EstimatedPricePerUnit);
	 	        
	 	        int estimatedTotalCalculated = estimatedquantity * estimatedpricePerUnit;
	 	        
	 	        
	 	        String estimatedTotalCalculatedStr = String.valueOf(estimatedTotalCalculated);
	 	        String estimatedTotalFieldValue = BOM.getEstimatedTotal();
	 	        
	 	       	Assert.assertEquals("Estimated Total value does not match!", estimatedTotalCalculatedStr, estimatedTotalFieldValue);
	 		   
	 		   
	 		   
	 	       if (OrderedQuantity != null && !OrderedQuantity.isEmpty()) {
	 		    	  Thread.sleep(1000);
	 		    	 BOM.ClearOnOrderedQuantity();		
	 				Thread.sleep(1000);
	 				BOM.EnterOnOrderedQuantity(OrderedQuantity);
	 				    }
	 	       else {
	 			   System.out.println("Ordered Quantity remains the same");
	 		   }
	 	       	
	 	       	
	 	      if (QuotedPricePerUnit != null && !QuotedPricePerUnit.isEmpty()) {
 		    	  Thread.sleep(1000);
 		    	 BOM.ClearOnQuotedPricePerUnit();
 	 			Thread.sleep(1000);
 	 			BOM.EnterOnQuotedPricePerUnit(QuotedPricePerUnit);	
 				    }
	 	      else {
	 			   System.out.println("Ordered Price Per Unit remains the same");
	 		   }
	 	       	
	 	      
	 	      


	 			if (OrderedQuantity != null && OrderedQuantity.matches("\\d+\\.0")) {
	 				OrderedQuantity = OrderedQuantity.substring(0, OrderedQuantity.indexOf(".0"));
	 			}
	 			
	 			if (QuotedPricePerUnit != null && QuotedPricePerUnit.matches("\\d+\\.0")) {
	 				QuotedPricePerUnit = QuotedPricePerUnit.substring(0, QuotedPricePerUnit.indexOf(".0"));
	 			}
	 			
	 			
	 			
	 			Thread.sleep(1000);
	 			int orderedquantity = Integer.parseInt(OrderedQuantity);
	 			int quotedpricePerUnit = Integer.parseInt(QuotedPricePerUnit);
	 	        
	 			int quotedTotalCalculated = orderedquantity * quotedpricePerUnit;
	 	        
	 	        
	 	        String quotedTotalCalculatedStr = String.valueOf(quotedTotalCalculated);
	 	        String quotedTotalFieldValue = BOM.getQuotedTotal();
	 	        
	 	       	Assert.assertEquals("Quoted Total value does not match!", quotedTotalCalculatedStr, quotedTotalFieldValue);
	 	       
	 	     
	 	     
	 	     
	 	     
	 	       	
	 	       if (ActualQuantity != null && !ActualQuantity.isEmpty()) {
	 		    	  Thread.sleep(1000);
	 		    	 BOM.ClearOnActualQuantity();		
	 				Thread.sleep(1000);
	 				BOM.EnterOnActualQuantity(ActualQuantity);
	 				    }
	 	      else {
	 			   System.out.println("Actual Quantity remains the same");
	 		   }
	 	       
	 	       
	 		   
	 	      if (ActualPricePerUnit != null && !ActualPricePerUnit.isEmpty()) {
 		    	  Thread.sleep(1000);
 		    	 BOM.ClearOnActualPricePerUnit();
 	 			Thread.sleep(1000);
 	 			BOM.EnterOnActualPricePerUnit(ActualPricePerUnit);
 				    }
	 	     else {
	 			   System.out.println("Actual Price Per Unit remains the same");
	 		   }
	 	      
	 	      
	 	      
	 
	 	    	 
	 	       	
	 	 	if (ActualQuantity != null && ActualQuantity.matches("\\d+\\.0")) {
 				ActualQuantity = ActualQuantity.substring(0, ActualQuantity.indexOf(".0"));
 			}
 			
 			if (ActualPricePerUnit != null && ActualPricePerUnit.matches("\\d+\\.0")) {
 				ActualPricePerUnit = ActualPricePerUnit.substring(0, ActualPricePerUnit.indexOf(".0"));
 			}
 			
 			
 			Thread.sleep(1000);
 			int actualquantity = Integer.parseInt(ActualQuantity);
 			int actualpricePerUnit = Integer.parseInt(ActualPricePerUnit);
 	        
 			int actualotalCalculated = actualquantity * actualpricePerUnit;
 	        
 	        
 	        String actualTotalCalculatedStr = String.valueOf(actualotalCalculated);
 	        String actualTotalFieldValue = BOM.getActualTotal();
 	        
 	       	Assert.assertEquals("Actual Total value does not match!", actualTotalCalculatedStr, actualTotalFieldValue);
	 	     
	 	      
	 	      
 	       if (Remarks != null && !Remarks.isEmpty()) {
		    	  Thread.sleep(1000);
		    	 BOM.ClearOnRemarks();
	 			Thread.sleep(1000);
	 			BOM.EnterOnRemarks(Remarks);	
				    }
	 	      
 	      if (GUID != null && !GUID.isEmpty()) {
	    	  Thread.sleep(2000);
	    	  BOM.ClearOnGUID();
	    	  Thread.sleep(1000);
	    	  BOM.EnterOnGUID(GUID);	
			    }  
	 	      
	 	      
 	     if (QRCode != null && !QRCode.isEmpty()) {
	    	  Thread.sleep(2000);
	    	    BOM.UploadingQRCode(QRCode);	
			    }   
	 	      
	 	      
 	    for (int rownumber1 = 0; rownumber1 < testdata.size(); rownumber1++) {
            String propertyNameValue = testdata.get(rownumber1).get("Property Name");
            String propertyValueValue = testdata.get(rownumber1).get("Property Value");
            if (propertyNameValue == null || propertyNameValue.isEmpty() || propertyValueValue == null || propertyValueValue.isEmpty()) {
                System.out.println("No data found for Property Name or Property Value at row " + (rownumber1 + 1) + ". Skipping this row.");
                continue;  // Skip this row if missing data
            }
            System.out.println("Adding Property: " + propertyNameValue + " with Value: " + propertyValueValue);
            Thread.sleep(1000); 
            BOM.ClickOnAddPropertiesButton(); 
            Thread.sleep(1000); 
            BOM.EnterOnPropertyName(propertyNameValue);  
            BOM.EnterOnPropertyValue(propertyValueValue); 
            Thread.sleep(2000);
            BOM.ClickOnSubmitButton(); 
            System.out.println("Property Submitted for row " + (rownumber1 + 1));
            Thread.sleep(2000); 
        }
	 	      
 	    	Thread.sleep(4000);
			RFA.ClickOnUpdate();
			Thread.sleep(4000);

}
	     
	     
	    //Attachments -> Edit Checklist
	     
	     @Then("Entering values in checklist fields and items using sheetnames {string} and {string} with rownumber {int}")
	     public void enteringValuesInChecklistFieldsAndItems(String checklistSheet, String checklistItemsSheet, int rownumber) throws Exception {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	   	     List<Map<String, String>> testdata = excelDataManager.getCachedData(checklistSheet);
	   	   String ProjectCode = testdata.get(rownumber).get("Project code");
	   	   Thread.sleep(2000);
			D.ClickOnDesignProject();
			Thread.sleep(4000);
			D.EnterOnSearchBox(ProjectCode);
			Thread.sleep(2000);
			D.clickOnProject(ProjectCode);
			Thread.sleep(3000);
			
			 driver.navigate().refresh();
		   		Thread.sleep(4000);
		   		BOM.ClickOnAttachments();
				Thread.sleep(3000);
				Chk.ClickOnCheckList();
		        Thread.sleep(4000);
				String OldChecklistCode = testdata.get(rownumber).get("Old Checklist Code");
			    Thread.sleep(4000);
			    D.clickOnActionButtonForProject(OldChecklistCode);
	    	  
	    	 
			    String Code = testdata.get(rownumber).get("Checklist Code");
			    String Name = testdata.get(rownumber).get("Checklist Name");
			    
			    if (Code != null && !Code.isEmpty()) {
		            Thread.sleep(1000);
		            Chk.ClearOnCheckListCode();
		            Thread.sleep(1000);
		            Chk.EnterOnCheckListCode(Code);
		        }
			    
			    if (Name != null && !Name.isEmpty()) {
		            Thread.sleep(1000);
		            Chk.ClearOnCheckListTitle();
		            Thread.sleep(1000);
		            Chk.EnterOnCheckListTitle(Name);
		        }
			    
			    
			    
			    List<Map<String, String>> checklistItemsData = excelDataManager.getCachedData(checklistItemsSheet);
		        int totalRows = checklistItemsData.size();

		        for (int i = rownumber; i < totalRows; i++) {
		            String itemName = checklistItemsData.get(i).get("Checklist item Name");
		            String category = checklistItemsData.get(i).get("Category");
		            String priority = checklistItemsData.get(i).get("Priority");
		            String description = checklistItemsData.get(i).get("Description");

		            // Stop processing if the key column (Checklist item Name) is empty
		            if (itemName == null || itemName.trim().isEmpty()) {
		                System.out.println("Empty data encountered at row: " + i + ". Stopping further processing.");
		                break;
		            }

		            // Fill in Checklist Item fields
		            Thread.sleep(1000);
		            Chk.ClearOnName();
		            Chk.EnterOnName(itemName);
		            LoginInputDatas("ChecklistitemName", itemName);

		            // Enter Category
		            Thread.sleep(1000);
		            Chk.prioritydropdownclick();
		            Thread.sleep(1000);
		            Chk.SelectPrioritydropdown(category);
		            LoginInputDatas("Category", category);

		            // Enter Priority
		            Thread.sleep(1000);
		            RFA.prioritydropdownclick();
		            Thread.sleep(1000);
		            RFA.SelectPrioritydropdown(priority);
		            LoginInputDatas("Priority", priority);

		            // Enter Description
		            Thread.sleep(1000);
		            Chk.ClearOnDescription();
		            Chk.EnterOnDescription(description);
		            LoginInputDatas("Description", description);

		            // Click "Add Row" for next entry
		            Thread.sleep(1000);
		            Chk.ClickOnAddRow();
		            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		        }

		        Thread.sleep(4000);
				RFA.ClickOnUpdate();
				Thread.sleep(4000);
	    	 
	     }
	     
	     
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	     private void takeScreenshot(int rowNumber) {
	  		try {
	  			// Take a screenshot
	  			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  			String screenshotPath = "C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\screenshot\\" + rowNumber
	  					+ ".png";

	  			// Save the screenshot to the specified path
	  			FileUtils.copyFile(screenshot, new File(screenshotPath));

	  			// Attach the screenshot to the Allure report
	  			Allure.addAttachment("Screenshot for Row " + rowNumber,
	  					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

	  			// Attach the screenshot to the Extent report
	  			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

	  		} catch (IOException e) {
	  			e.printStackTrace();

	  		}
	  	}

	  	private void takeScreenshotStr(String rowNumber) {
	  		try {
	  			// Take a screenshot
	  			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  			String screenshotPath = "C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\screenshot\\" + rowNumber
	  					+ ".png";

	  			// Save the screenshot to the specified path
	  			FileUtils.copyFile(screenshot, new File(screenshotPath));

	  			// Attach the screenshot to the Allure report
	  			Allure.addAttachment("Screenshot for Row " + rowNumber,
	  					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

	  			// Attach the screenshot to the Extent report
	  			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

	  		} catch (IOException e) {
	  			e.printStackTrace();

	  		}
	  	}

	  	private void performTabKeyPress() throws AWTException {
	  		Robot robot = new Robot();
	  		robot.keyPress(KeyEvent.VK_TAB);
	  		robot.keyRelease(KeyEvent.VK_TAB);
	  	}

	  	private void LoginInputDatas(String fieldName, String fieldValue) {

	  		test = ExtentCucumberAdapter.getCurrentStep();

	  		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
	  				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldName + "</td></tr>"
	  				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldValue + "</td></tr>" + "</table>";

	  		Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

	  		String[][] data = { { fieldName }, { fieldValue }, };
	  		Markup m = MarkupHelper.createTable(data);

	  		// Log the table in Extent Report
	  		test.log(Status.PASS, m);
	  	}

	      
	      
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
