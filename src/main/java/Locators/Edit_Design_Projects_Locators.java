package Locators;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edit_Design_Projects_Locators {

	
	WebDriver driver;
    WebDriverWait wait;
	
	
    @FindBy(xpath = "//*[@id='sidebar-nav']/li[4]/a")
    private WebElement DesignProject;


	 @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	 private WebElement SearchBoxinProject;
    
	 @FindBy(xpath = "//*[@title='Actions']")
	 private WebElement ActionButton;
	 
	 @FindBy(xpath = "//*[@id='edit']")
	 private WebElement Edit;
	 
    
    @FindBy(xpath = "//input[@formcontrolname='isIsoActive']")
    private WebElement ProjectWithoutISO;
    
    @FindBy(xpath = "//span[@formcontrolname='template']")
    private WebElement ProjectTemplate;
    
    @FindBy(xpath = "//input[@placeholder='Enter project code']")
    private WebElement ProjectCode;
    
    @FindBy(xpath = "//input[@placeholder='Enter project name']")
    private WebElement ProjectName;
    
    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    private WebElement ProjectDescription;
    
    @FindBy(xpath = "//input[@formcontrolname='start_date']")
    private WebElement StartDate; 
    
    @FindBy(xpath = "//span[@formcontrolname='design_type']")
    private WebElement ProjectDesignType; 
    
    @FindBy(xpath = "//span[@formcontrolname='category']")
    private WebElement ProjectCategory; 
    
    @FindBy(xpath = "//select[@formcontrolname='owner']")
    private WebElement ProjectOwnerSelection; 
    
    @FindBy(xpath = "//select[@formcontrolname='status']")
    private WebElement ProjectStatus; 
    
    @FindBy(xpath = "//input[@formcontrolname='addressLine_1']")
    private WebElement AddressLine1; 
  
    @FindBy(xpath = "//input[@formcontrolname='addressLine_2']")
    private WebElement AddressLine2; 
    
    @FindBy(xpath = "//input[@formcontrolname='city']")
    private WebElement City; 
  
    @FindBy(xpath = "//input[@formcontrolname='state']")
    private WebElement State; 
  
    @FindBy(xpath = "//input[@formcontrolname='postal_code']")
    private WebElement Pincode; 
 
    @FindBy(xpath = "//input[@formcontrolname='country']")
    private WebElement Country; 
    
    @FindBy(xpath = "//div[.='Error']")
	public WebElement Error;
    
    @FindBy(xpath = "//div[.='Success']")
    public WebElement Success; 
    
    
    @FindBy(xpath="//button[.=' Update ']")
	 private WebElement UpdateButton;
  
    
    public Edit_Design_Projects_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
    
    
    
    
    
    
    public void clickOnProject(String projectName) throws InterruptedException {
        WebElement projectElement = findTheRequiredProject(projectName);
     	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectElement);
        wait.until(ExpectedConditions.elementToBeClickable(projectElement));
        Thread.sleep(2000);
        System.out.print(projectName);
        projectElement.click();
    } 
    
    
    
    
    public void EnterOnSearchBox(String values) throws AWTException, InterruptedException {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SearchBoxinProject);
    	wait.until(ExpectedConditions.elementToBeClickable(SearchBoxinProject));
    	 SearchBoxinProject.clear();
         Thread.sleep(2000);
    	SearchBoxinProject.sendKeys(values);
    	Thread.sleep(2000);
    	Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void ClickOnUpdateButton() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(UpdateButton)); 
  			wait.until(ExpectedConditions.elementToBeClickable(UpdateButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", UpdateButton);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", UpdateButton);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(UpdateButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", UpdateButton);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", UpdateButton);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
    
    
    public WebElement findTheRequiredProject(String projectName) {
        String dynamicXpath = "//tbody//tr//td//a[contains(text(),'" + projectName + "')]";
        return driver.findElement(By.xpath(dynamicXpath)); // Find the project name link
    }

    public void clickOnActionButtonForProject(String projectcode) throws InterruptedException, AWTException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SearchBoxinProject);
        wait.until(ExpectedConditions.elementToBeClickable(SearchBoxinProject));
        
        SearchBoxinProject.clear();
        Thread.sleep(2000); // Wait for the search box to update
        SearchBoxinProject.sendKeys(projectcode);
        Thread.sleep(2000); // Wait for the search results to filter
        
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000); // Wait for the filtered results to appear
        
        WebElement projectElement = findTheRequiredProject(projectcode);
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectElement);
        
        WebElement projectRow = projectElement.findElement(By.xpath("./ancestor::tr"));

        WebElement actionButton = driver.findElement(By.xpath(
                "//tbody//tr[td//a[contains(text(),'" + projectcode + "')]]//button[@title='Actions']"
            ));  
        
        
        wait.until(ExpectedConditions.elementToBeClickable(actionButton));
        actionButton.click();
        Thread.sleep(3000); // Wait for the action to be performed
        
        wait.until(ExpectedConditions.elementToBeClickable(Edit));
        Edit.click();
        Thread.sleep(3000); // Wait for the Edit action
    }

    
    
    public boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public void ClearOnCountry() {
    	Country.clear();
    }
    
    
    
    public void EnterOnCountry(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Countrys = wait.until(ExpectedConditions.elementToBeClickable(Country));
	    Countrys.sendKeys(values);
    }
    
    
    public void ClearOnPincode() {
    	Pincode.clear();
    }
    
    
    
    public void EnterOnPincode(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Pincodes = wait.until(ExpectedConditions.elementToBeClickable(Pincode));
	    Pincodes.sendKeys(values);
    }
    
    
    
    public void ClearOnState() {
    	State.clear();
    }
    
    
    
    public void EnterOnState(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement States = wait.until(ExpectedConditions.elementToBeClickable(State));
	    States.sendKeys(values);
    }
    
    
    public void ClearOnCity() {
    	City.clear();
    }
    
    
    public void EnterOnCity(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Citys = wait.until(ExpectedConditions.elementToBeClickable(City));
	    Citys.sendKeys(values);
    }
    
    
    public void ClearOnAddressLine2() {
    	AddressLine2.clear();
    }
    
    
    public void EnterOnAddressLine2(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement AddressLine2s = wait.until(ExpectedConditions.elementToBeClickable(AddressLine2));
	    AddressLine2s.sendKeys(values);
    } 
    
    
    public void ClearOnAddressLine1() {
    	AddressLine1.clear();
    }
    
    public void EnterOnAddressLine1(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement AddressLine1s = wait.until(ExpectedConditions.elementToBeClickable(AddressLine1));
	    AddressLine1s.sendKeys(values);
    }  
    

    public void EnterOnProjectOwnerSelection(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectOwnerSelections = wait.until(ExpectedConditions.elementToBeClickable(ProjectOwnerSelection));
	    ProjectOwnerSelections.sendKeys(values);
    }
    
    
    public void ClickOnProjectOwnerSelection() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectOwnerSelection));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectOwnerSelection);
  			ProjectOwnerSelection.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());

  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectOwnerSelection));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectOwnerSelection);
  			ProjectOwnerSelection.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    
    
    
    public void EnterOnProjectCategory(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectCategorys = wait.until(ExpectedConditions.elementToBeClickable(ProjectCategory));
	    ProjectCategorys.sendKeys(values);
    }
    
    
    public void ClickOnProjectCategory() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCategory));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectCategory);
  			ProjectCategory.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCategory));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectCategory);
  			ProjectCategory.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    
    
    
    
    
    
    public void EnterOnProjectStatus(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectStatuss = wait.until(ExpectedConditions.elementToBeClickable(ProjectStatus));
	    ProjectStatuss.sendKeys(values);
    }
    
    
    public void ClickOnProjectStatus() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectStatus));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectStatus);
  			ProjectStatus.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectStatus));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectStatus);
  			ProjectStatus.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    
    
    
    
    public void EnterOnProjectDesignType(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectDesignTypes = wait.until(ExpectedConditions.elementToBeClickable(ProjectDesignType));
	    ProjectDesignTypes.sendKeys(values);
    }
    
    
    public void ClickOnProjectDesignType() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDesignType));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectDesignType);
  			ProjectDesignType.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());

  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDesignType));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectDesignType);
  			ProjectDesignType.click();
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
  			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", StartDate);
  			StartDate.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", StartDate);
  			StartDate.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    
    public void EnterOnProjectDescrpt(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectDescriptions = wait.until(ExpectedConditions.elementToBeClickable(ProjectDescription));
	    ProjectDescriptions.sendKeys(values);
    }
    
    
    public void ClearOnProjectDescrpt() {
    	ProjectDescription.clear();
    }
    
    
    public void ClickOnProjectDescrpt() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDescription));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectDescription);
  			ProjectDescription.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDescription));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectDescription);
  			ProjectDescription.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    public void EnterOnProjectName(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectNames = wait.until(ExpectedConditions.elementToBeClickable(ProjectName));
	    ProjectNames.sendKeys(values);
    }
    
    
    public void ClearOnProjectName() {
    	ProjectName.clear();
    }
    
    
    public void ClickOnProjectName() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectName));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectName);
  			// Perform the click action
  			ProjectName.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectName));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectName);
  			ProjectName.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    public void EnterOnProjectCode(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectCodes = wait.until(ExpectedConditions.elementToBeClickable(ProjectCode));
	    ProjectCodes.sendKeys(values);
    }
    
    
    public void ClearOnProjectCode() {
    	ProjectCode.clear();
    }
    
    
    public void ClickOnProjectCode() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCode));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectCode);
  			// Perform the click action
  			ProjectCode.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCode));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectCode);
  			ProjectCode.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    public void EnterOnProjectTemplate(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ProjectTemplates = wait.until(ExpectedConditions.elementToBeClickable(ProjectTemplate));
	    ProjectTemplates.sendKeys(values);
    }
    
    
    
    public void ClickOnProjectTemplate() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectTemplate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectTemplate);
  			// Perform the click action
  			ProjectTemplate.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectTemplate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectTemplate);
  			ProjectTemplate.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    public void selectDropdownOption(String optionText) {
	    // Construct the XPath for the option text in a case-insensitive manner
	    String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	                              + optionText.toLowerCase() + "')]";
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // Wait for the overlay to disappear (if it exists)
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	        // Scroll the element into view (if needed) and click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
	        
	        // Try clicking via JavaScript as a fallback
	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	}
	
    
    
  	public void ClickOnProjectWithoutISO() {
  		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectWithoutISO));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectWithoutISO);
  			ProjectWithoutISO.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectWithoutISO));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ProjectWithoutISO);
  			ProjectWithoutISO.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
  	}
    
    
    public void ClickOnDesignProject() {
		  try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		        wait.until(ExpectedConditions.elementToBeClickable(DesignProject));
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DesignProject);
		        jsExecutor.executeScript("arguments[0].click();", DesignProject);
		        
		    } catch (ElementClickInterceptedException e) {
		        System.err.println("Element click intercepted: " + e.getMessage());
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(DesignProject));
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DesignProject);
		        jsExecutor.executeScript("arguments[0].click();", DesignProject);
		    } catch (Exception e) {
		        System.err.println("An unexpected error occurred: " + e.getMessage());
		    }
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
