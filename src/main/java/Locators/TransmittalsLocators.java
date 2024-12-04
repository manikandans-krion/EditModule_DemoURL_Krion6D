package Locators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransmittalsLocators {

	private WebDriver driver;
	private WebDriverWait wait;

	public TransmittalsLocators(WebDriver driver) {
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

	@FindBy(xpath = "//*[@id='Share-nav']/li[3]/a")
	private WebElement Transmittalclick;

	@FindBy(xpath = "//button[@rolepermissionbutton='Transmittal.Modify']")
	private WebElement addbtn;

	@FindBy(xpath = "//input[@id='createTask']")
	private WebElement togglebtn;

	@FindBy(xpath = "//input[@id='code']")
	private WebElement code;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;

	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement description;

	@FindBy(xpath = "//select[@id='workflowStatusId']")
	private WebElement workflow;

	@FindBy(xpath = "//div[@class='btn-group']/button")
	private WebElement attachfilebtn;

	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[1]")
	private WebElement drivebtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']/li")
	private List<WebElement> filetypes;

	@FindBy(xpath = "//input[@id='_gridcontrol_searchbar']")
	private WebElement searchfield;

	@FindBy(id = "_gridcontrol_searchbutton")
	private WebElement searchiconbtn;

	@FindBy(xpath = "//*[@id='_gridcontrol_content_table']/tbody/tr[2]/td[1]")
	private WebElement checkboxclick;

	@FindBy(xpath = "//button[@class='btn btn-outline-info']")
	private WebElement attachbtn;

	@FindBy(xpath = "//button[@class='w-100 btn btn-info']")
	private WebElement createclick;
	
	@FindBy(xpath="//div[@id='filterStatusDiv']/descendant::div/ejs-dropdownlist")
	private WebElement statusclick;
	
	@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> statuslist;
	
	@FindBy(xpath="//input[@name='input']")
	private WebElement Transmittalsearchbar;
	
	@FindBy(xpath="//tr[@aria-rowindex='1']/td[9]")
	private WebElement ActionButton;
	 
	@FindBy(id="edit")
	private WebElement Edit;

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

	public void Transmittalclick() {
		waits.until(ExpectedConditions.visibilityOf(Transmittalclick));
		Transmittalclick.click();
	}

	public void addbtnclick() {
		waits.until(ExpectedConditions.visibilityOf(addbtn));
		addbtn.click();
	}

	public void togglebtnclick(String val) {
		if(val.equalsIgnoreCase("0")) {
		waits.until(ExpectedConditions.visibilityOf(togglebtn));
		togglebtn.click();
		System.out.println("Creating Transmittals Not as Review");
		}
		else if (val.equalsIgnoreCase("1")) {
			System.out.println("Creating Transmittals as Review");
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

	public void entertransmtlCode(String codevalue) throws AWTException {

		waits.until(ExpectedConditions.elementToBeClickable(code));
		code.sendKeys(codevalue);
		wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CLEAR);
	}

	public void entertransmtlname(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(name));
		name.sendKeys(val);
	}

	public void enterdescription(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(description));
		description.sendKeys(val);
	}

	public void selectworkflow(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(workflow));
		Select ss = new Select(workflow);
		ss.selectByVisibleText(val);
	}
	
	public void clickattachbtn() {
		waits.until(ExpectedConditions.elementToBeClickable(attachfilebtn));
		attachfilebtn.click();
	}

	public void driverbtnclick() {
		waits.until(ExpectedConditions.elementToBeClickable(drivebtn));
		drivebtn.click();
	}

	public void searchfile(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(searchfield));
		searchfield.click();
		searchfield.sendKeys(val);
		waits.until(ExpectedConditions.elementToBeClickable(searchiconbtn));
		searchiconbtn.click();
	}

	public void checkboxclick() {
		try {
			waits.until(ExpectedConditions.elementToBeClickable(checkboxclick));
			checkboxclick.click();
			} catch (Exception e) {
			//checkboxclick.click();
			System.out.println("File not displayed :" + e.getMessage());
			}
	}
	
	public void clickattachedbtn() {
		waits.until(ExpectedConditions.elementToBeClickable(attachbtn));
		attachbtn.click();
	}

	public void createclick() {
		waits.until(ExpectedConditions.elementToBeClickable(createclick));
		createclick.click();
	}
	
	public void EnterOnSearchBox(String values) throws AWTException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchbar);
		wait.until(ExpectedConditions.elementToBeClickable(searchbar));
		searchbar.sendKeys(values);
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
	
	public void EnterOnSearchsubmittals(String values) throws AWTException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Transmittalsearchbar);
		wait.until(ExpectedConditions.elementToBeClickable(Transmittalsearchbar));
		Transmittalsearchbar.sendKeys(values);
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
	
	public void clearname() {
		wait.until(ExpectedConditions.elementToBeClickable(name));
		name.clear();
	}
	
	public void cleardesc() {
		wait.until(ExpectedConditions.elementToBeClickable(description));
		description.clear();
	}
	
	public void selectfiletype(String file) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", attachfilebtn);
		wait.until(ExpectedConditions.elementToBeClickable(attachfilebtn));
		attachfilebtn.click();
		selectDropdown(filetypes, file);
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