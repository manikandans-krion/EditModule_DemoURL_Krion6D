package Locators;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edit_RFA_Locators {

	WebDriver driver;
	WebDriverWait wait;
	
	 @FindBy(xpath = "//span[.='RFA']")
	 private WebElement RFA;
	
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-rfa/section/div/div[1]/div/div[2]/div/div[2]/button")
	 private WebElement AddButton;


	 @FindBy(xpath = "//input[@placeholder='Enter rfa code']")
	 private WebElement RFACode;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter RFA name']")
	 private WebElement RFAName;
	 
	 @FindBy(xpath = "//textarea[@placeholder='Enter description']")
	 private WebElement Description;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter Start Date']")
	 private WebElement StartDate; 
	 
	 @FindBy(xpath = "//input[@placeholder='Enter Due Date']")
	 private WebElement EndDate;
	 
	 @FindBy(xpath = "//input[@placeholder='Select the workflow']")
	 private WebElement WorkFlow;
	 
	 @FindBy(xpath="//app-multiselect[@name='Workflow']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
		private WebElement workflow;
		
		@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
		private List<WebElement> workflowlist;
			
		@FindBy(xpath="//app-multiselect[@name='Priority']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
		private WebElement priorityclick;
		
		@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
		private List<WebElement> Priorityselect;
	 
	 
	 
	 @FindBy(xpath = "//input[@placeholder='Select the priority']")
	 private WebElement Priority;
	 
	 
	 
	 @FindBy(xpath = "//app-multiselect[@formcontrolname='status']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	 private WebElement SelectStatus;
	 
	 @FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
	 private List<WebElement> selectstatustype;
	 
	 
	 @FindBy(xpath = "//*[@id='_gridcontrol_searchbar']")
	 private WebElement SearchBoxinRFA;
	 
	 @FindBy(xpath = "//*[@title='Actions']")
	 private WebElement ActionButton;
	 
	 @FindBy(xpath = "//*[@id='edit']")
	 private WebElement Edit;
	 
	 @FindBy(xpath="//button[.=' Update ']")
	 private WebElement UpdateButton;

	 
	 
	 FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2));
	 
	 
		public Edit_RFA_Locators(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
			PageFactory.initElements(driver, this);
		}
	
		
		
		
		public void ClickOnUpdate() {
			try {
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.visibilityOf(UpdateButton)); 
	  			wait.until(ExpectedConditions.elementToBeClickable(UpdateButton));
	  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", UpdateButton);
	  		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", UpdateButton);
	  		} catch (ElementClickInterceptedException e) {
	  			System.err.println("Element click intercepted: " + e.getMessage());
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.visibilityOf(UpdateButton)); 
	  			wait.until(ExpectedConditions.elementToBeClickable(UpdateButton));
	  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", UpdateButton);
	  			((JavascriptExecutor) driver).executeScript("arguments[0].click();", UpdateButton);
	  		} catch (Exception e) {
	  			System.err.println("An unexpected error occurred: " + e.getMessage());
	  		}
		}
		
		
		
		
		
		public void SelectStatusclick() {
			waits.until(ExpectedConditions.elementToBeClickable(SelectStatus));
			SelectStatus.click();
		}
		
		public void SelectStatusType(String type) {
			try {
				selectDropdown(selectstatustype, type);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public void selectDropdown(List<WebElement>t,String comparetxt) throws Exception {
			List<WebElement> elements=t;
			Thread.sleep(2000);
			for(WebElement s:elements) {
				String txt=s.getText();
				if(txt.equalsIgnoreCase(comparetxt)) {
					s.click();
					break;	
				}
				else {
					System.out.println("Given Option is not found in the Dropdown List");
				}
			}
			System.out.println("Given Option is Found ");
		}
		
		
		  public WebElement findTheRequiredRFA(String projectName) {
		        String dynamicXpath = "//tbody//tr//td//a[contains(text(),'" + RFAName + "')]";
		        return driver.findElement(By.xpath(dynamicXpath));
		    }
		
		  public void clickOnEdit() throws InterruptedException {
		        Thread.sleep(2000);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionButton);
		    	wait.until(ExpectedConditions.elementToBeClickable(ActionButton));
		        ActionButton.click();
		        Thread.sleep(3000);
		        Edit.click();
		    } 
		
		 public void EnterOnSearchBox(String values) throws AWTException, InterruptedException {
		    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SearchBoxinRFA);
		    	wait.until(ExpectedConditions.elementToBeClickable(SearchBoxinRFA));
		    	SearchBoxinRFA.sendKeys(values);
		    	Thread.sleep(2000);
		    	Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
		    }
		    
		
		
		
		 public void attachFile(String DocumentName, String FileName) {
		        try {
		            String fileXPath = "//ul//li//a[contains(text(), '" + DocumentName + "')]";
		            System.out.println(fileXPath);
		            WebElement fileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fileXPath)));
		            fileElement.click();
		            Thread.sleep(2000);
		            String Searchfield = "(//input[@placeholder='Search'])[1]";
		            WebElement SearchfieldBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Searchfield)));
		            SearchfieldBox.click();
		            Thread.sleep(2000);
		            SearchfieldBox.sendKeys(FileName);
		            Thread.sleep(2000);
			    	Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
		            System.out.println("DocumentName '" + DocumentName + "' attached successfully.");
		        } catch (Exception e) {
		            System.out.println("Error attaching file: " + e.getMessage());
		        }
		    }	
		
	
	 public void EnterOnPriority(String values) {
		 Priority.sendKeys(values);
	 }
	 
	 
	public void ClickOnPriority() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Priority)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Priority));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Priority);
  		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Priority);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Priority)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Priority));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Priority);
  			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Priority);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	 public void selectDropdownOption(String optionText) {
		    String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
		                              + optionText.toLowerCase() + "')]";
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
		        optionElement.click();
		    } catch (TimeoutException e) {
		        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
		    } catch (ElementClickInterceptedException e) {
		        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
		        
		        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		    }
		}
	
	
	public void EnterOnWorkFlow(String values) {
		WorkFlow.sendKeys(values);
    }
	
	
	public void ClickonWorkFlow() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(WorkFlow)); 
  			wait.until(ExpectedConditions.elementToBeClickable(WorkFlow));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", WorkFlow);
  		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", WorkFlow);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(WorkFlow)); 
  			wait.until(ExpectedConditions.elementToBeClickable(WorkFlow));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", WorkFlow);
  			((JavascriptExecutor) driver).executeScript("arguments[0].click();", WorkFlow);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}

	
	
	 public void EnterOnEndDate(String values) {
		 EndDate.sendKeys(values);
	    }
	 
	  
	 public void ClearOnEndDate() {
		 EndDate.clear();
	 }
	
	public void ClickOnEndDate() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(EndDate)); 
  			wait.until(ExpectedConditions.elementToBeClickable(EndDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", EndDate);
  		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", EndDate);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(EndDate)); 
  			wait.until(ExpectedConditions.elementToBeClickable(EndDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", EndDate);
  			((JavascriptExecutor) driver).executeScript("arguments[0].click();", EndDate);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	 public void EnterOnStartDate(String values) {
	    	StartDate.sendKeys(values);
	    }
	 
	  
    public void ClearOnStartDate() {
    	StartDate.clear();
    }
    
    
    public void ClickOnStartDate() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(StartDate)); 
  			wait.until(ExpectedConditions.elementToBeClickable(EndDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", StartDate);
  		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", StartDate);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(StartDate)); 
  			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", StartDate);
  			((JavascriptExecutor) driver).executeScript("arguments[0].click();", StartDate);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	public void EnterOnDescription(String values) {
		Description.sendKeys(values);
	}
	
	public void ClearOnDescription() {
		Description.clear();
	}
	
	public void EnterOnRFAName(String values) {
		RFAName.sendKeys(values);
	}
	
	public void ClearOnRFAName() {
		RFAName.clear();
	}
	
	
	public void EnterOnRFACode(String values) {
		RFACode.sendKeys(values);
	}
	
	public void ClearOnRFACode() {
		RFACode.clear();
	}
	
	
	
	public void ClickOnRFA() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(RFA)); 
  			wait.until(ExpectedConditions.elementToBeClickable(RFA));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", RFA);
  		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", RFA);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(RFA)); 
  			wait.until(ExpectedConditions.elementToBeClickable(RFA));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", RFA);
  			((JavascriptExecutor) driver).executeScript("arguments[0].click();", RFA);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	public void workflowselection(String text) throws Exception {
			waits.until(ExpectedConditions.elementToBeClickable(workflow));
			workflow.click();
			selectDropdown(workflowlist, text);
		}
	
	
	
	public void prioritydropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(priorityclick));
		priorityclick.click();
	}
	
	public void SelectPrioritydropdown(String type) {
		try {
			selectDropdown(Priorityselect, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
