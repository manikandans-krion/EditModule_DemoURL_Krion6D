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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmittalsLocators {

	private WebDriver driver;
	private WebDriverWait wait;

	public SubmittalsLocators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='sidebar-nav']/li[4]/a")
	private WebElement project;

	@FindBy(id = "grid_198727267_0_searchbar")
	private WebElement searchbar;

	@FindBy(id = "grid_198727267_0_searchbutton")
	private WebElement searchicon;

	@FindBy(xpath = "//*[@id='grid_198727267_0_content_table']/tbody/tr/td[4]")
	private WebElement projectclick;

	@FindBy(xpath = "//aside[@id='project-sidebar']/ul/child::ul/li[5]/descendant::i[2]")
	private WebElement arrowdownbtnforshare;

	@FindBy(xpath = "//*[@id='Share-nav']/li[2]/a")
	private WebElement Submittalclick;

	@FindBy(xpath = "//button[@rolepermissionbutton='Submittal.Modify']")
	private WebElement addbtn;

	@FindBy(xpath = "//input[@id='createTask']")
	private WebElement togglebtn;

	@FindBy(xpath = "//input[@id='code']")
	private WebElement code;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;

	@FindBy(xpath = "//ejs-dropdownlist[@id='specId']")
	private WebElement specsection;

	@FindBy(xpath = "//ul[@id='specId_options']/li")
	private List<WebElement> specsectionlist;

	@FindBy(xpath = "//input[@id='subSpec']")
	private WebElement subspec;

	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement description;

	@FindBy(xpath = "//ejs-dropdownlist[@id='typeId']")
	private WebElement type;

	@FindBy(xpath = "//ul[@id='typeId_options']/li")
	private List<WebElement> typelist;

	@FindBy(xpath = "//select[@formcontrolname='workflowStatusId']")
	private WebElement workflow;

	@FindBy(xpath = "//input[@id='targetDate']")
	private WebElement enddate;

	@FindBy(xpath = "//ejs-dropdownlist[@id='priorityId']")
	private WebElement priority;

	@FindBy(xpath = "//ul[@id='priorityId_options']/li")
	private List<WebElement> prioritylist;

	@FindBy(xpath = "//input[@id='requiredDate']")
	private WebElement reqdate;

	@FindBy(xpath = "//input[@id='approvedDate']")
	private WebElement reqappdate;

	@FindBy(xpath = "//input[@id='onSiteDate']")
	private WebElement jobsitedate;

	@FindBy(xpath = "//input[@id='leadTime']")
	private WebElement leadtime;

	@FindBy(xpath = "//div[@class='btn-group']/button")
	private WebElement attachbtn;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li")
	private List<WebElement> attachfileoptions;

	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[1]")
	private WebElement drivebtn;

	@FindBy(xpath = "//input[@id='_gridcontrol_searchbar']")
	private WebElement searchfield;

	@FindBy(id = "_gridcontrol_searchbutton")
	private WebElement searchiconbtn;

	@FindBy(xpath = "//*[@id='_gridcontrol_content_table']/tbody/tr[2]/td[1]")
	private WebElement checkboxclick;

	@FindBy(xpath = "//button[@class='btn btn-outline-info']")
	private WebElement fileattachbtn;

	@FindBy(xpath = "//div[@class='col-6 mt-3']/button")
	private WebElement createbtn;
	
	@FindBy(id="grid_198727267_0_searchbar")
	private WebElement searchbox;
	
	@FindBy(xpath="//div[@id='filterStatusDiv']/descendant::div/ejs-dropdownlist")
	private WebElement statusclick;
	
	@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> statuslist;
	
	@FindBy(xpath="//input[@name='input']")
	private WebElement submittalsearchbar;
	
	@FindBy(xpath="//tr[@aria-rowindex='1']/td[11]")
	private WebElement ActionButton;
	 
	@FindBy(id="edit")
	private WebElement Edit;
	 
	@FindBy(xpath = "//input[@id='_gridcontrol_searchbar']")
	private WebElement filesearchbtn;

	@FindBy(xpath = "//span[@id='_gridcontrol_searchbutton']")
	private WebElement filesearchicon;
	
	@FindBy(xpath = "//*[@id='_gridcontrol_content_table']/tbody/tr/td[1]")
	private WebElement filecheckbox;

	FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2));

	public void Navigateproject() {
		waits.until(ExpectedConditions.elementToBeClickable(project));
		project.click();
	}

	public void pname(String name) {
		Actions act = new Actions(driver);
		waits.until(ExpectedConditions.elementToBeClickable(searchbar));
		act.click(searchbar).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		searchbar.sendKeys(name);
		searchicon.click();
	}

	public void projectclik() {
		try {
			waits.until(ExpectedConditions.visibilityOf(projectclick));
			projectclick.click();
		} catch (Exception e) {
			projectclick.click();
		}
	}

	public void viewMenu() {
		waits.until(ExpectedConditions.visibilityOf(arrowdownbtnforshare));
		arrowdownbtnforshare.click();
	}

	public void submittalclick() {
		waits.until(ExpectedConditions.visibilityOf(Submittalclick));
		Submittalclick.click();
	}

	public void addbtnclick() {
		waits.until(ExpectedConditions.visibilityOf(addbtn));
		addbtn.click();
	}

	public void togglebtnclick(String val) {
		if(val.equalsIgnoreCase("0")) {
		waits.until(ExpectedConditions.visibilityOf(togglebtn));
		togglebtn.click();
		System.out.println("Creating Submittals Not as Review");
		}else if (val.equalsIgnoreCase("1")) {
			System.out.println("Creating Submittals as Review");
		} else {
			System.out.println("Given value is Invalid...");
		}
	}

	public void clearcode() throws AWTException {

		waits.until(ExpectedConditions.elementToBeClickable(code));
		code.click();
		Robot rb = new Robot();
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_CLEAR);
		rb.delay(2000);
	}

	public void entersubtmlCode(String codevalue) throws AWTException {
		
		waits.until(ExpectedConditions.elementToBeClickable(code));
		code.sendKeys(codevalue);
		wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CLEAR);
	}

	public void entersubtlname(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(name));
		name.sendKeys(val);
	}

	public void clickspecsection() {
		waits.until(ExpectedConditions.elementToBeClickable(specsection));
		specsection.click();
	}

	public void selectspecsection(String val) throws Exception {
		selectDropdown(specsectionlist, val);
	}

	public void entersubspec(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(subspec));
		subspec.sendKeys(val);
	}

	public void enterdescription(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(description));
		description.sendKeys(val);
	}
	
	public void typeclick(){
		
		waits.until(ExpectedConditions.elementToBeClickable(type));
		type.click();
	}
	public void selecttype(String val) throws Exception {
		selectDropdown(typelist, val);
	}

	public void selectworkflow(String val) throws InterruptedException {
		Thread.sleep(2000);
		Select ss = new Select(workflow);
		ss.selectByVisibleText(val);
	}

	public void ClickOnWorkflow() {
		waits.until(ExpectedConditions.elementToBeClickable(workflow));
		workflow.click();
	}
	public void selectDropdownOption(String optionText) {
	    // Construct the XPath for the option text in a case-insensitive manner
	    String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	                              + optionText.toLowerCase() + "')]";
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // Wait for the overlay to disappear (if it exists)
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	        // Wait for the dropdown option to be visible and clickable
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	        // Scroll the element into view (if needed) and click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
	        
	        // Try clicking via JavaScript as a fallback
	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	}
	
	
	
	public void selectduedate(String date) {
		waits.until(ExpectedConditions.elementToBeClickable(enddate));
		enddate.sendKeys(date);
	}
	
	public void priorityclick() {
		waits.until(ExpectedConditions.elementToBeClickable(priority));
		priority.click();
	}
	
	public void selectpriority(String val) throws Exception {
		selectDropdown(prioritylist, val);
	}

	public void selectreqdate(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(reqdate));
		reqdate.sendKeys(val);
	}

	public void ClickAndClearOnreqdate() throws InterruptedException {
		waits.until(ExpectedConditions.elementToBeClickable(reqdate));
		reqdate.click();
		Thread.sleep(1000);
		reqdate.clear();
	}
	
	
	public void selectreqappdate(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(reqappdate));
		reqappdate.sendKeys(val);
	}

	public void selectjobsitedate(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(jobsitedate));
		jobsitedate.sendKeys(val);
	}

	public void enterleadtime(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(leadtime));
		leadtime.sendKeys(val);
	}

	public void attachpackagebtn() {
		waits.until(ExpectedConditions.elementToBeClickable(attachbtn));
		attachbtn.click();
	}

	public void clickdrive() {
		waits.until(ExpectedConditions.elementToBeClickable(drivebtn));
		drivebtn.click();
	}

	public void searchfilename(String val) throws Exception {
		waits.until(ExpectedConditions.elementToBeClickable(searchfield));
		searchfield.click();
		searchfield.sendKeys(val);
		Thread.sleep(3000);
		waits.until(ExpectedConditions.elementToBeClickable(searchiconbtn));
		searchiconbtn.click();
	}

	public void checkboxclick() {
		waits.until(ExpectedConditions.elementToBeClickable(checkboxclick));
		checkboxclick.click();
	}

	public void clickattachfilebtn() {
		waits.until(ExpectedConditions.elementToBeClickable(fileattachbtn));
		fileattachbtn.click();
	}

	public void createclick() {
		waits.until(ExpectedConditions.elementToBeClickable(createbtn));
		createbtn.click();
	}
	
	public void EnterOnSearchBox(String values) throws AWTException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchbox);
		wait.until(ExpectedConditions.elementToBeClickable(searchbox));
		searchbox.sendKeys(values);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}
	
	public void EnterOnSearchsubmittals(String values) throws AWTException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submittalsearchbar);
		wait.until(ExpectedConditions.elementToBeClickable(submittalsearchbar));
		submittalsearchbar.sendKeys(values);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}

	public void clickOnProject(String projectName) throws InterruptedException {
        WebElement projectElement = driver.findElement(By.xpath("//tbody//tr//td//a[contains(text(),'" + projectName + "')]"));
     	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectElement);
        wait.until(ExpectedConditions.elementToBeClickable(projectElement));
        Thread.sleep(2000);
        System.out.print(projectName);
        projectElement.click();
    } 
	
	public void SelectStatusclick() {
		wait.until(ExpectedConditions.elementToBeClickable(statusclick));
		statusclick.click();
	}
	
	public void SelectStatusType(String type) {
		try {
			selectDropdown(statuslist, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void clickOnEdit() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionButton);
		wait.until(ExpectedConditions.elementToBeClickable(ActionButton));
		ActionButton.click();
		Thread.sleep(3000);
		Edit.click();
		}
	
	public void clearname(){
		wait.until(ExpectedConditions.elementToBeClickable(name));
		name.clear();
	}
	
	public void clearsubspec() {
		wait.until(ExpectedConditions.elementToBeClickable(subspec));
		subspec.clear();
	}
	
	public void cleardesc() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", type);
		wait.until(ExpectedConditions.elementToBeClickable(description));
		description.clear();
	}
	
	public void clearduedate() {
		wait.until(ExpectedConditions.elementToBeClickable(enddate));
		enddate.clear();
	}
	
	public void clearreqdate() {
		wait.until(ExpectedConditions.elementToBeClickable(reqdate));
		reqdate.clear();
	}
	public void clearreqappdate() {
		wait.until(ExpectedConditions.elementToBeClickable(reqappdate));
		reqappdate.clear();
	}
	public void clearjosbitedate() {
		wait.until(ExpectedConditions.elementToBeClickable(jobsitedate));
		jobsitedate.clear();
	}
	
	public void clearleadtime() {
		wait.until(ExpectedConditions.elementToBeClickable(leadtime));
		leadtime.clear();
	}
	
	public void selectfiletype(String name) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(attachbtn));
		attachbtn.click();
		selectDropdown(attachfileoptions, name);
	}
	
	public void searchfile(String filename) {
		String s = filename.trim();
		filesearchbtn.click();
		filesearchbtn.sendKeys(s);
		filesearchicon.click();
	}
	
	public void fileattach() throws Exception {
		try {
			Thread.sleep(3000);
			filecheckbox.click();
		}catch(Exception e) {
			System.out.println("File Not found");
		}
	}
	
	public void attachedbtnclick() {
		wait.until(ExpectedConditions.elementToBeClickable(fileattachbtn));
		fileattachbtn.click();
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

}