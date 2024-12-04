package Locators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.WebDriverWait;

public class RFILocators {

	public WebDriver driver;
	public WebDriverWait wait;

	public RFILocators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofMillis(20));
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

	@FindBy(xpath = "//*[@id=\"project-sidebar\"]/ul/ul/li[3]/a/i[2]")
	private WebElement Actiondownarrow;

	@FindBy(xpath = "//*[@id='Actions-nav']/li[3]/a")
	private WebElement RFImenuclick;

	@FindBy(xpath = "//button[@rolepermissionbutton='RFI.Modify']")
	private WebElement Addbtn;

	@FindBy(xpath = "//input[@id='createTask']")
	private WebElement Disablebtn;

	@FindBy(xpath = "//input[@id='code']")
	private WebElement code;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;

	@FindBy(xpath = "//input[@id='question']")
	private WebElement question;

	@FindBy(xpath = "//textarea[@id='suggestedAnswer']")
	private WebElement suggestedAnswer;

	@FindBy(xpath = "//input[@id='targetDate']") // input[@id='endDate']
	private WebElement duedate;

	@FindBy(xpath = "//input[@id='location']")
	private WebElement location;

	@FindBy(xpath = "//app-multiselect[@name='Type']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement Typeclick;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> Typeselect;

	@FindBy(xpath = "//app-multiselect[@formcontrolname='desciplineId']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement Disciplineclick;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> Disciplineselect;

	@FindBy(xpath = "//app-multiselect[@formcontrolname='categoryId']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement categoryclick;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> Categoryselect;

	@FindBy(xpath = "//app-multiselect[@name='Workflow']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement workflow;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> workflowlist;

	@FindBy(xpath = "//app-multiselect[@name='Priority']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement priorityclick;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> Priorityselect;

	@FindBy(xpath = "//label//input[@type='file']")
	private WebElement uploadimg;

	@FindBy(xpath = "//div[@class='btn-group']/button")
	private WebElement Attachfilebtn;

	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li")
	private List<WebElement> attachfileoptions;

	@FindBy(xpath = "//input[@id='_gridcontrol_searchbar']")
	private WebElement filesearchbtn;

	@FindBy(xpath = "//span[@id='_gridcontrol_searchbutton']")
	private WebElement filesearchicon;

	@FindBy(xpath = "//*[@id='_gridcontrol_content_table']/tbody/tr[2]/td[1]")
	private WebElement filecheckbox;

	@FindBy(xpath = "//div[@class='modal-footer']/button[2]")
	private WebElement fileattachbtn;

	@FindBy(xpath = "//div[@class='row justify-content-md-end']/descendant::div/child::div[2]")
	private WebElement Createbtn;

	@FindBy(xpath = "//div[@id='filterStatusDiv']/descendant::div/ejs-dropdownlist")
	private WebElement statusclick;

	@FindBy(xpath = "//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> statuslist;

	@FindBy(id = "grid_667557311_0_searchbar")
	private WebElement searchbox;

	@FindBy(xpath = "//*[@id='grid_667557311_0_content_table']/tbody/tr/td[10]")
	private WebElement ActionButton;

	@FindBy(id = "edit")
	private WebElement Edit;

	@FindBy(xpath = "//button[.=' Attach files ']")
	private WebElement Attachfiles;

	@FindBy(xpath = "//button[@class='w-100 btn btn-info']")
	private WebElement updatebtn;

	FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2));

	public void scrolling(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,+" + pixel + ")", "");
	}

	public void scrollingtoElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
	}

	public void scrolltoBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

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
		waits.until(ExpectedConditions.visibilityOf(Actiondownarrow));
		Actiondownarrow.click();
	}

	public void routingRFI() {
		waits.until(ExpectedConditions.visibilityOf(RFImenuclick));
		RFImenuclick.click();
	}

	public void Addbtn() {
		waits.until(ExpectedConditions.visibilityOf(Addbtn));
		Addbtn.click();
	}

	public void disable(String val) {
		if (val.equalsIgnoreCase("0")) {
			waits.until(ExpectedConditions.visibilityOf(Disablebtn));
			Disablebtn.click();
			System.out.println("Creating RFI Not as Review");
		} else if (val.equalsIgnoreCase("1")) {
			System.out.println("Creating RFI as Review");
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

	public void enterCode(String codevalue) throws AWTException {
		waits.until(ExpectedConditions.elementToBeClickable(code));
		code.sendKeys(codevalue);
		wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CLEAR);
	}

	public void entername(String namevalue) {
		waits.until(ExpectedConditions.elementToBeClickable(name));
		name.sendKeys(namevalue);
	}

	public void enterquestion(String questiontext) {
		waits.until(ExpectedConditions.elementToBeClickable(name));
		question.sendKeys(questiontext);
	}

	public void enteranswer(String answertext) {
		waits.until(ExpectedConditions.elementToBeClickable(name));
		suggestedAnswer.sendKeys(answertext);
	}

	public void datefieldclick() throws Exception {
		duedate.click();
		Thread.sleep(3000);
	}

	public void datefieldclear() throws Exception {
		duedate.clear();
	}

	public void enterduedate(String date) throws Exception {
		waits.until(ExpectedConditions.elementToBeClickable(duedate));
		duedate.sendKeys(date);
	}

	public void enterLocation(String loc) {
		waits.until(ExpectedConditions.elementToBeClickable(location));
		location.sendKeys(loc);
	}

	public void Typedropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(Typeclick));
		Typeclick.click();
	}

	public void SelectTypedropdown(String type) {
		try {
			selectDropdown(Typeselect, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Disciplinedropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(Disciplineclick));
		Disciplineclick.click();
	}

	public void SelectDisciplinedropdown(String type) {
		try {
			selectDropdown(Disciplineselect, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Categorydropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(categoryclick));
		categoryclick.click();
	}

	public void SelectCategorydropdown(String type) {
		try {
			selectDropdown(Categoryselect, type);
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

	public void Imageupload(String path) {
		try {
			Thread.sleep(3000);
			uploadimg.sendKeys(path);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectfiletype(String name) throws Exception {
		Attachfilebtn.click();
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
		} catch (Exception e) {
			System.out.println("File is not found");
		}
	}

	public void attachedbtnclick() {
		fileattachbtn.click();
	}

	public void createClick() {
		Createbtn.click();
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
	public void EnterOnSearchRFI(String values) throws AWTException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchbox);
		wait.until(ExpectedConditions.elementToBeClickable(searchbox));
		searchbox.sendKeys(values);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void clickOnProject(String projectName) throws InterruptedException {
		WebElement projectElement = driver
				.findElement(By.xpath("//tbody//tr//td//a[contains(text(),'" + projectName + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectElement);
		wait.until(ExpectedConditions.elementToBeClickable(projectElement));
		Thread.sleep(2000);
		System.out.print(projectName);
		projectElement.click();
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

	public void clearquestion() {
		wait.until(ExpectedConditions.elementToBeClickable(question));
		question.clear();
	}

	public void clearanswer() {
		wait.until(ExpectedConditions.elementToBeClickable(suggestedAnswer));
		suggestedAnswer.clear();

	}

	public void clearlocation() {
		wait.until(ExpectedConditions.elementToBeClickable(location));
		location.clear();
	}

	public void ClickOnUpdate() {
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn));
		updatebtn.click();
	}

	public void cleardate() {
		wait.until(ExpectedConditions.elementToBeClickable(duedate));
		duedate.clear();
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