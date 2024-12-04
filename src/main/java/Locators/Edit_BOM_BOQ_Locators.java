package Locators;

import java.awt.AWTException;
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

public class Edit_BOM_BOQ_Locators {

	WebDriver driver;
	WebDriverWait wait;
	
	
	 @FindBy(xpath = "//span[.='Attachments']")
	 private WebElement Attachments;
	
	 @FindBy(xpath = "//span[.='BOM/BOQ']")
	 private WebElement BOM_BOQ;
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-bom-list/section/div/div[1]/div/div[2]/div/div[2]/button")
	 private WebElement AddButton;


	 @FindBy(xpath = "//select[@formcontrolname='parentBomID']")
	 private WebElement ParentBOM;
	
	 @FindBy(xpath = "//input[@placeholder='Enter bom code']")
	 private WebElement EnterCode;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter bom name']")
	 private WebElement EnterName;
	 
	 @FindBy(xpath = "//input[@placeholder='Select the workflow']")
	 private WebElement Workflow;
	    
	 @FindBy(xpath = "//input[@placeholder='Select the priority']")
	 private WebElement Priority;
	
	 @FindBy(xpath = "//input[@placeholder='Select the unit']")
	 private WebElement Unit;
	 
	 //
	    @FindBy(xpath="//app-multiselect[@name='Unit']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
		private WebElement unit;
		
		@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
		private List<WebElement> unitlist;
	 
	 //
	 
	 @FindBy(xpath = "//input[@placeholder='Enter estimated quantity']")
	 private WebElement EstimatedQuantity;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter estimated price per unit']")
	 private WebElement EstimatedPricePerUnit;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter estimated total']")
	 private WebElement EstimatedTotal;
	 
	 @FindBy(xpath = "//input[@id='orderedQuantity']")
	 private WebElement OrderedQuantity;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter quoted price']")
	 private WebElement QuotedPricePerUnit;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter quoted total']")
	 private WebElement QuotedTotal;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter actual quantity']")
	 private WebElement ActualQuantity;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter actual price']")
	 private WebElement ActualPricePerUnit;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter actual total']")
	 private WebElement ActualTotal;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter remarks']")
	 private WebElement Remark;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter guid']")
	 private WebElement GUID;
	 
	 @FindBy(xpath = "//*[@id='file-upload']")
	 private WebElement AttachQRCode;
	 
	 @FindBy(xpath = "//button[.=' Add Properties ']")
	 private WebElement AddPropertiesButton;
	 
	 
	 
	 @FindBy(xpath = "//input[@id='propertyName']")
	 private WebElement PropertyName;
	 
	 @FindBy(xpath = "//input[@id='propertyValue']")
	 private WebElement PropertyValue; 
	 
	 @FindBy(xpath = "//button[.='Submit']")
	 private WebElement SubmitButton;
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-bom-add-edit/section/div/div[2]/div/div/form/div[2]/div/div/app-common-button/div/div[2]/button")
	 private WebElement CreateButton;

	 
	 
		FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2));
	 
		
		
	public Edit_BOM_BOQ_Locators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	//
	public void unitdropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(unit));
		unit.click();
	}
	
	public void SelectUnitdropdown(String type) {
		try {
			selectDropdown(unitlist, type);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ClickOnCreateButton() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(CreateButton)); 
  			wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", CreateButton);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CreateButton);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", CreateButton);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CreateButton);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}

	
	
	
	
	
	public void ClickOnSubmitButton() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SubmitButton);
  			SubmitButton.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SubmitButton);
  			SubmitButton.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	
	
	public void EnterOnPropertyValue(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement PropertyValues = wait.until(ExpectedConditions.elementToBeClickable(PropertyValue));
	    PropertyValues.sendKeys(value);
	}
	
	
	public void ClickOnPropertyValue() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(PropertyValue)); 
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyValue));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", PropertyValue);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", PropertyValue);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyValue));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", PropertyValue);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", PropertyValue);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	public void EnterOnPropertyName(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement PropertyNames = wait.until(ExpectedConditions.elementToBeClickable(PropertyName));
	    PropertyNames.sendKeys(value);
	}
	
	public void ClickOnPropertyName() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(AddPropertiesButton)); 
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyName));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", PropertyName);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", PropertyName);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyName));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", PropertyName);
 			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", PropertyName);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	
	
	
	
	
	public void ClickOnAddPropertiesButton() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(AddPropertiesButton)); 
  			wait.until(ExpectedConditions.elementToBeClickable(AddPropertiesButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddPropertiesButton);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddPropertiesButton);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AddPropertiesButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddPropertiesButton);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddPropertiesButton);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	

	
	
	public void UploadingQRCode(String imageFilePath ) {
    	if (imageFilePath != null && !imageFilePath.isEmpty()) {
        System.out.println("QR Code image path from Excel: " + imageFilePath);
        AttachQRCode.sendKeys(imageFilePath);
        System.out.println("QR Code image uploaded successfully: " + imageFilePath);
    	} else {
        throw new RuntimeException("QR Code file path is not available in the Excel sheet or it's invalid.");
    	}
    }
	
	
	public void ClearOnGUID() {
		GUID.clear();
	}
	
	
	public void EnterOnGUID(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement GUIDs = wait.until(ExpectedConditions.elementToBeClickable(GUID));
	    GUIDs.sendKeys(value);
	}
	
	
	public void EnterOnRemarks(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Remarks = wait.until(ExpectedConditions.elementToBeClickable(Remark));
	    Remarks.sendKeys(value);
	}
	
	
	public void ClearOnRemarks() {
		Remark.clear();
	}
	
	
	public String getActualTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ActualTotal));
        return ActualTotal.getAttribute("value"); 
	}
	
	
	
	public void EnterOnActualPricePerUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ActualPricePerUnits = wait.until(ExpectedConditions.elementToBeClickable(ActualPricePerUnit));
	    ActualPricePerUnits.sendKeys(value);
	}
	
	public void ClearOnActualPricePerUnit() {
		ActualPricePerUnit.clear();
	}
	
	
	
	
	
	public void EnterOnActualQuantity(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ActualQuantitys = wait.until(ExpectedConditions.elementToBeClickable(ActualQuantity));
	    ActualQuantitys.sendKeys(value);
	}
	
	public void ClearOnActualQuantity() {
		ActualQuantity.clear();
	}
	
	
	
	
	public String getQuotedTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(QuotedTotal));
        return QuotedTotal.getAttribute("value"); // or .getText() if applicable
    }
	
	
	
	
	public void EnterOnQuotedPricePerUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement QuotedPricePerUnits = wait.until(ExpectedConditions.elementToBeClickable(QuotedPricePerUnit));
	    QuotedPricePerUnits.sendKeys(value);
	}
	
	
	public void ClearOnQuotedPricePerUnit() {
		QuotedPricePerUnit.clear();
	}
	
	
	public void EnterOnOrderedQuantity(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement OrderedQuantitys = wait.until(ExpectedConditions.elementToBeClickable(OrderedQuantity));
	    OrderedQuantitys.sendKeys(value);
	}
	

	public void ClearOnOrderedQuantity() {
		OrderedQuantity.clear();
	}
	
	
	
	
	
	public String getEstimatedTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(EstimatedTotal));
        return EstimatedTotal.getAttribute("value"); // or .getText() if applicable
    }
	
	
	
	
	public void EnterOnEstimatedPricePerUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement EstimatedPricePerUnits = wait.until(ExpectedConditions.elementToBeClickable(EstimatedPricePerUnit));
	    EstimatedPricePerUnits.sendKeys(value);
	}
	
	
	public void ClearOnEstimatedPricePerUnit() {
		EstimatedPricePerUnit.clear();
	}
	
	
	
	public void EnterOnEstimatedQuantity(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement EstimatedQuantitys = wait.until(ExpectedConditions.elementToBeClickable(EstimatedQuantity));
	    EstimatedQuantitys.sendKeys(value);
	}
	
	public void ClearOnEstimatedQuantity() {
		EstimatedQuantity.clear();
	}
	
	
	public void EnterOnUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Units = wait.until(ExpectedConditions.elementToBeClickable(Unit));
	    Unit.sendKeys(value);
	}
	
	
	
	

public void selectDropdownOptionForUnit(String optionText) {
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
	
	
	 
	public void ClickOnUnit() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Unit));
  			wait.until(ExpectedConditions.elementToBeClickable(Unit));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Unit);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Unit);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Unit));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Unit);
 			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Unit);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	
public void selectDropdownOptionForPriority(String optionText) {
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
	
	public void EnterOnPriority(String value) {
		Priority.sendKeys(value);
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
  			wait.until(ExpectedConditions.elementToBeClickable(Priority));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Priority);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Priority);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	public void selectDropdownOptionForWorkFlow(String optionText) throws InterruptedException {
		 String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                 + optionText.toLowerCase() + "')]";
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        Thread.sleep(1000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	} 
	
	
	public void EnterOnWorkflow(String value) {
		Workflow.sendKeys(value);
	}
	
	
	public void ClickOnWorkflow() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Workflow));
  			wait.until(ExpectedConditions.visibilityOf(Workflow)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Workflow));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Workflow);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Workflow);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Workflow)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Workflow));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Workflow);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Workflow);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
	
	
	
	
	
	public void EnterOnName(String values) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(EnterName));
		    Name.sendKeys(values);
	}
	
	public void ClearOnName() {
		EnterName.clear();
	}
	
	
	
	public void EnterOnCode(String values) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement Code = wait.until(ExpectedConditions.elementToBeClickable(EnterCode));
		    Code.sendKeys(values);
	}
	
	public void ClearOnCode() {
		EnterCode.clear();
	}
	
	
	public void ClickOnCode() {
		 try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(EnterCode));
				wait.until(ExpectedConditions.elementToBeClickable(EnterCode));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", EnterCode);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", EnterCode);
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(EnterCode));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", EnterCode);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", EnterCode);
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
	 }
	
	
	
	
	public void ClickOnParentBOM() {
		 try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(ParentBOM));
				wait.until(ExpectedConditions.elementToBeClickable(ParentBOM));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ParentBOM);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ParentBOM);
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(ParentBOM));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ParentBOM);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ParentBOM);
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
	 }
	
	
	
	
	public void selectDropdownOption(String optionText) {
	    String xpathSelect = "//*[@id='task']"; // Replace with your actual select element XPath

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));

	        selectElement.click();

	        String xpathOption = "//select[@id='task']//option[normalize-space(.)='" + optionText.trim() + "']";

	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOption)));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("Timeout waiting for dropdown option '" + optionText + "' to be clickable.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for dropdown option '" + optionText + "'. Trying to click via JavaScript.");
	        String xpathOption = "//select[@id='task']//option[normalize-space(.)='" + optionText.trim() + "']";
	        WebElement optionElement = driver.findElement(By.xpath(xpathOption));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	}

	
	
	public void ClickOnAddButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddButton);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddButton);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void ClickOnBOM_BOQ() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(BOM_BOQ)); 
  			wait.until(ExpectedConditions.elementToBeClickable(BOM_BOQ));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", BOM_BOQ);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BOM_BOQ);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(BOM_BOQ)); 
  			wait.until(ExpectedConditions.elementToBeClickable(BOM_BOQ));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", BOM_BOQ);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", BOM_BOQ);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
	
	
	
	public void ClickOnAttachments() {
	  	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Attachments)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Attachments));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Attachments);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Attachments);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Attachments)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Attachments));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Attachments);
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Attachments);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
