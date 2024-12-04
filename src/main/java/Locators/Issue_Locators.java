package Locators;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Issue_Locators {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id='sidebar-nav']/li[4]/a")
	private WebElement DesignProject;

	@FindBy(xpath = "//span[.='Issue']")
	private WebElement Issues;

//    @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-issue-list/section/div/div[1]/div/div[2]/div/div[2]/button/text()")
//  private WebElement AddButton;

	@FindBy(xpath = "//*[@id='main']/app-project-management/app-project-issue-list/section/div/div[1]/div/div[2]/div/div[2]/button")
	private WebElement AddButton;

	@FindBy(xpath = "//input[@id='number']")
	private WebElement IssueCode;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement Name;

	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement Description;

	@FindBy(xpath = "//input[@id='startDate']")
	private WebElement StartDate;

	@FindBy(xpath = "//input[@id='targetDate']")
	private WebElement DueDate;

	@FindBy(xpath = "//input[@placeholder='Select the type']")
	private WebElement Type;

	//

	@FindBy(xpath = "//app-multiselect[@name='Type']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement type;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> typelist;

	//

	@FindBy(xpath = "//input[@placeholder='Select the placement']")
	private WebElement Placement;

	//
	@FindBy(xpath = "//app-multiselect[@name='Placement']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement placement;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> placementlist;

	//

	@FindBy(xpath = "//input[@placeholder='Select the root cause']")
	private WebElement RootCause;

	//

	@FindBy(xpath = "//app-multiselect[@name='Root cause']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement rootcause;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> rootcauselist;

	//

	// @FindBy(xpath = "//input[@placeholder='Select the workflow']")
	// private WebElement Workflow;

	@FindBy(xpath = "//app-multiselect[@name='Workflow']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement workflow;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> workflowlist;

	@FindBy(xpath = "//input[@id='location']")
	private WebElement Location;

	@FindBy(xpath = "//input[@id='estimatedCost']")
	private WebElement EstimateCost;

	@FindBy(xpath = "//input[@id='actualCost']")
	private WebElement ActualCost;

	@FindBy(xpath = "(//input[@type='file'])[2]")
	private WebElement UploadImages;

	@FindBy(xpath = "//button[.=' Attach files ']")
	private WebElement Attachfiles;

	@FindBy(xpath = "//button[.=' Attach ']")
	private WebElement AttachButton;

	@FindBy(xpath = "//div[@id='filterStatusDiv']/descendant::div/ejs-dropdownlist")
	private WebElement statusclick;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> statuslist;

	@FindBy(id = "grid_198727267_0_searchbar")
	private WebElement Searchbar;
	
	@FindBy(id = "grid_986202533_0_searchbar")
	private WebElement Searchissue;
	

	@FindBy(xpath = "//*[@id='grid_986202533_0_content_table']/tbody/tr/td[10]")
	private WebElement ActionButton;

	@FindBy(id = "edit")
	private WebElement Edit;

	@FindBy(xpath = "//button[@class='w-100 btn btn-info']")
	private WebElement updatebtn;

	@FindBy(xpath = "//*[@id=\"project-sidebar\"]/ul/ul/li[3]/a/i[2]")
	private WebElement Actiondownarrow;

	@FindBy(xpath = "//ul[@id='Actions-nav']/li[2]")
	private WebElement issubtn;

	public void viewMenu() {
		waits.until(ExpectedConditions.visibilityOf(Actiondownarrow));
		Actiondownarrow.click();
	}

	public void Issueclick() {
		waits.until(ExpectedConditions.elementToBeClickable(issubtn));
		issubtn.click();
	}

	public void SelectStatusclick() {
		wait.until(ExpectedConditions.elementToBeClickable(statusclick));
		statusclick.click();

	}

	public void SelectStatusType(String type) {
		// wait.until(ExpectedConditions.elementToBeClickable((By) statuslist));
		try {
			selectDropdown(statuslist, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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

	public void EnterOnSearchBox(String values) throws AWTException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Searchbar);
		wait.until(ExpectedConditions.elementToBeClickable(Searchbar));
		Searchbar.sendKeys(values);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void EnterOnSearchissue(String values) throws AWTException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Searchissue);
		wait.until(ExpectedConditions.elementToBeClickable(Searchissue));
		Searchissue.sendKeys(values);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	

	public void clickOnEdit() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionButton);
		wait.until(ExpectedConditions.elementToBeClickable(ActionButton));
		ActionButton.click();
		Thread.sleep(3000);
		Edit.click();
	}

	FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2));

	public Issue_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	//
	public void typedropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(type));
		type.click();
	}

	public void Selecttypedropdown(String type) {
		try {
			selectDropdown(typelist, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void workflowselection(String text) throws Exception {
		// Select ss= new Select(workflow);
		// ss.selectByVisibleText(text);

		waits.until(ExpectedConditions.elementToBeClickable(workflow));
		workflow.click();
		selectDropdown(workflowlist, text);
	}

	public void selectDropdown(List<WebElement> t, String comparetxt) throws Exception {
		List<WebElement> elements = t;
		Thread.sleep(2000);
		for (WebElement s : elements) {
			String txt = s.getText();
			if (txt.equalsIgnoreCase(comparetxt)) {
				s.click();
				break;
			} else {
				System.out.println("Given Option is not found in the Dropdown List");
			}
		}
		System.out.println("Given Option is Found ");
	}

	//

	//
	public void placementdropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(placement));
		placement.click();
	}

	public void Selectplacementdropdown(String type) {
		try {
			selectDropdown(placementlist, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//

	public void rootcausedropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(rootcause));
		rootcause.click();
	}

	public void Selectrootcausedropdown(String type) {
		try {
			selectDropdown(rootcauselist, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void UploadingAnImage(String imageFilePath) {
		if (imageFilePath != null && !imageFilePath.isEmpty()) {
			System.out.println("Image path from Excel: " + imageFilePath);
			UploadImages.sendKeys(imageFilePath);
			System.out.println("Image uploaded successfully: " + imageFilePath);
		} else {
			throw new RuntimeException("Image file path is not available in the Excel sheet or it's invalid.");
		}
	}

	public void ClickOnAttachFiles() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Attachfiles));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Attachfiles);
			Attachfiles.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Attachfiles));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Attachfiles);
			Attachfiles.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void attachFile(String DocumentName, String FileName) {
		try {
			// Wait for the list of file names to appear and click on the specific file
			String fileXPath = "//ul//li//a[contains(text(), '" + DocumentName + "')]";
			System.out.println(fileXPath);
			WebElement fileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fileXPath)));
			fileElement.click();

			Thread.sleep(2000);
			// After clicking the file, wait for the "Attach" button to appear and click it
			String Searchfield = "//input[@placeholder='Search']";
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

	public void EnterOnActualCost(String values) {
		ActualCost.sendKeys(values);
	}

	public void ClearOnActualCost() {
		ActualCost.clear();
	}

	public void ClickOnActualCost() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ActualCost));
			wait.until(ExpectedConditions.elementToBeClickable(ActualCost));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ActualCost);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActualCost);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ActualCost));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ActualCost);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActualCost);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnterOnEstimateCost(String values) {
		EstimateCost.sendKeys(values);
	}

	public void ClearOnEstimateCost() {
		EstimateCost.clear();
	}

	public void ClickOnEstimateCost() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(EstimateCost));
			wait.until(ExpectedConditions.elementToBeClickable(RootCause));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
					EstimateCost);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", EstimateCost);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(EstimateCost));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
					EstimateCost);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", EstimateCost);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonLocation() {
		Location.clear();
	}

	public void EnterOnLocation(String values) {
		Location.sendKeys(values);
	}

	/*
	 * public void EnterOnWorkflow(String values) { Workflow.sendKeys(values); }
	 * 
	 * 
	 * 
	 * public void ClickOnWorkflow() { try { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.visibilityOf(Workflow));
	 * wait.until(ExpectedConditions.elementToBeClickable(RootCause));
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
	 * Workflow); ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].click();", Workflow); } catch
	 * (ElementClickInterceptedException e) {
	 * System.err.println("Element click intercepted: " + e.getMessage());
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.elementToBeClickable(Workflow));
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
	 * Workflow); ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].click();", Workflow); } catch (Exception
	 * e) { System.err.println("An unexpected error occurred: " + e.getMessage()); }
	 * }
	 */

	public void EnterOnRootCause(String values) {
		RootCause.sendKeys(values);
	}

	public void ClickOnRootCause() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(RootCause));
			wait.until(ExpectedConditions.elementToBeClickable(RootCause));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", RootCause);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", RootCause);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(RootCause));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", RootCause);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", RootCause);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnterOnPlacement(String values) {
		Placement.sendKeys(values);
	}

	public void ClickOnPlacement() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(Placement));
			wait.until(ExpectedConditions.elementToBeClickable(Placement));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Placement);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Placement);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Placement));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Placement);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Placement);
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
			System.out.println(
					"The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");

			WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	public void EnterOnType(String values) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Types = wait.until(ExpectedConditions.elementToBeClickable(Type));
		Types.sendKeys(values);
	}

	public void ClickOnType() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(Type));
			wait.until(ExpectedConditions.elementToBeClickable(Type));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Type);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Type);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Type));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Type);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Type);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnterOnDueDate(String values) {
		DueDate.sendKeys(values);
	}

	public void ClearOnDueDate() {
		DueDate.clear();
	}

	public void ClickOnDueDate() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(DueDate));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", DueDate);
			DueDate.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(DueDate));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", DueDate);
			DueDate.click();
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

			StartDate.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
			StartDate.click();
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

	public void EnterOnName(String values) {
		Name.sendKeys(values);
	}

	public void ClearOnName() {
		Name.clear();
	}

	public void EnterOnIssueCode(String values) {
		IssueCode.sendKeys(values);
	}

	public void ClearOnIssueCode() {
		IssueCode.clear();
	}

	public void ClickOnIssueCode() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(IssueCode));
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", IssueCode);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", IssueCode);
			IssueCode.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", IssueCode);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", IssueCode);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnAddButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));

			AddButton.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));
			AddButton.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnIssues() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Issues));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Issues);
			Issues.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Issues);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public WebElement findTheRequiredFile(String FileName) {
		if (FileName == null || FileName.trim().isEmpty()) {
			System.err.println("File name is empty or null.");
			return null;
		}
		// Build dynamic XPath based on the provided file name
		String dynamicXpath = "//tbody//tr//td[contains(text(),'" + FileName + "')]";
		try {
			// Return the located WebElement using the dynamic XPath
			return driver.findElement(By.xpath(dynamicXpath));
		} catch (NoSuchElementException e) {
			System.err.println("File with name '" + FileName + "' not found: " + e.getMessage());
			return null;
		}
	}

	public void clickOnRequiredFile(String FileName) {
		try {
			WebElement FileElement = findTheRequiredFile(FileName);

			// Check if the file element was found before proceeding
			if (FileElement != null) {
				// Wait until the element is clickable
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(FileElement));
				// FileElement.click();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", FileElement);
				// Log success and perform the click
				System.out.println("Clicking on file: " + FileName);
			} else {
				System.err.println("Cannot click. The file '" + FileName + "' was not found.");
			}
		} catch (TimeoutException e) {
			System.err.println("Timed out waiting for file '" + FileName + "' to be clickable: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("An unexpected error occurred while clicking the file: " + e.getMessage());
		}
	}

	public void ClickOnAttachButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AttachButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
					AttachButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AttachButton);
			System.out.println("Attach button clicked successfully.");
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
						AttachButton);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", AttachButton);
				System.out.println("Attach button clicked using JavaScript.");
			} catch (Exception jsException) {
				System.err.println("JavaScript click failed: " + jsException.getMessage());
			}

		} catch (TimeoutException e) {
			System.err.println("Timed out waiting for Attach button to be clickable: " + e.getMessage());
		} catch (NoSuchElementException e) {
			System.err.println("Attach button not found: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnUpdate() {
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn));
		updatebtn.click();
	}
}