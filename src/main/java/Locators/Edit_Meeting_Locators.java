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
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edit_Meeting_Locators {

	WebDriver driver;
	WebDriverWait wait;
	
	
	 @FindBy(xpath = "//span[.='Share']")
	 private WebElement Share;
	
	 @FindBy(xpath = "//span[.='Meeting']")
	 private WebElement Meeting;
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-meeting-list/section/div/div[1]/div/div[2]/button")
	 private WebElement AddButton;


	 @FindBy(xpath = "//input[@placeholder='Enter title']")
	 private WebElement Name;
	 
	 @FindBy(xpath = "//input[@id='date_input']")
	 private WebElement Date;
	
	 @FindBy(xpath = "//input[@id='time_input']")
	 private WebElement Time;
	
	 @FindBy(xpath = "//input[@placeholder='Hours']")
	 private WebElement DurationHours;
	 
	 @FindBy(xpath = "//input[@placeholder='Minutes']")
	 private WebElement DurationMinutes;
	 
	 @FindBy(xpath = "//textarea[@formcontrolname='description']")
	 private WebElement Description;
	 
	 @FindBy(xpath = "//button[.=' Add Notes ']")
	 private WebElement AddNotes;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter notes']")
	 private WebElement EnterNotes;
	 
	 @FindBy(xpath = "//button[.=' Select Users ']")
	 private WebElement SelectUsersTab;
	 
	 @FindBy(xpath = "//button[.=' Select User Groups ']")
	 private WebElement SelectedUserGroupsTab;
	 
	 @FindBy(xpath = "//*[@id='multiUser']/div/div/span[3]/input")
	 private WebElement SearchUser;
	 
	 @FindBy(xpath = "//*[@id='multiUserGroup']/div/div/span[3]/input")
	 private WebElement SearchUserGroup;
	 
	 @FindBy(xpath = "(//input[@type='file'])[2]")
	 private WebElement UploadImages;
    
	 
	 
	 
	    @FindBy(xpath="//ejs-multiselect[@id='multiUser']")
		private WebElement userclick;
		
		@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
		private List<WebElement> userslist;
	 
		@FindBy(xpath="//ejs-multiselect[@id='multiUserGroup']")
		private WebElement usergroupclick;
		
		@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
		private List<WebElement> usersgrouplist;
		
		
	 
	 
	public Edit_Meeting_Locators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	public void ClickOnSelectUserField() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(userclick));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", userclick);
	        userclick.click();
	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(userclick));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", userclick);
	        userclick.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking Select Users tab: " + e.getMessage());
	    }
	}

	public void ClickOnSelectUserGroupField() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(usergroupclick));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", usergroupclick);
	        usergroupclick.click();
	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(usergroupclick));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", usergroupclick);
	        usergroupclick.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking Select User Group tab: " + e.getMessage());
	    }
	}

	
	
	public void Selectusers(String value) {
		try {
			selectDropdown(userslist, value);
		} catch (Exception e) {
			System.out.println("User is not found :"+e.getMessage());
		}
	}
	
	public void Selectusersgroup(String value) {
		try {
			selectDropdown(userslist, value);
		} catch (Exception e) {
			System.out.println("User is not found :"+e.getMessage());
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
	
	
	
	
	
	 public void attachFile(String DocumentName, String FileName) {
	        try {
	            String fileXPath = "//ul//li//a[contains(text(), '" + DocumentName + "')]";
	            System.out.println(fileXPath);
	            WebElement fileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fileXPath)));
	            fileElement.click();
	            Thread.sleep(2000);
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
	
	
	
	
	
	 public void UploadingAnImage(String imageFilePath ) {
	    	if (imageFilePath != null && !imageFilePath.isEmpty()) {
	        System.out.println("Image path from Excel: " + imageFilePath);
	        UploadImages.sendKeys(imageFilePath);
	        System.out.println("Image uploaded successfully: " + imageFilePath);
	    	} else {
	        throw new RuntimeException("Image file path is not available in the Excel sheet or it's invalid.");
	    	}
	    }
	


	 
	 
	 
	public void ClickOnSelectUsersTab() {
	    try {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectUsersTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SelectUsersTab);
	        SelectUsersTab.click();
	    } catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectUsersTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SelectUsersTab);
			SelectUsersTab.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking Select Users tab: " + e.getMessage());
	    }
	}

	public void ClickOnSelectGroupUsersTab() {
	    try {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectedUserGroupsTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SelectedUserGroupsTab);
			SelectedUserGroupsTab.click();
	    	}catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectedUserGroupsTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SelectedUserGroupsTab);
			SelectedUserGroupsTab.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking Select Group Users tab: " + e.getMessage());
	    }
	}



	
	
	public void ClickOnSearchUserGroup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUserGroup));
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
			SearchUserGroup.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUserGroup));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SearchUser);
			SearchUserGroup.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void ClickOnSearchUser() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUser));
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
			SearchUser.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUser));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SearchUser);
			SearchUser.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	

	
	
	public void EnterOnNotes(String note, int index) {
	    try {
	        // Use the index to locate the specific input field for entering notes
	        WebElement noteField = driver.findElement(By.xpath("(//input[@placeholder='Enter notes'])[" + (index + 1) + "]"));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(noteField));
	        noteField.sendKeys(note);
	    } catch (Exception e) {
	        System.err.println("An error occurred while entering note: " + e.getMessage());
	    }
	}


	
	
	public void ClickOnEnterNotes() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(EnterNotes));
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
			EnterNotes.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(EnterNotes));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", EnterNotes);
			EnterNotes.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	public void ClickOnAddNotes() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddNotes));
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
			AddNotes.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddNotes));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddNotes);
			AddNotes.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	public void EnterOnDescription(String values) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement Descriptions = wait.until(ExpectedConditions.elementToBeClickable(Description));
		 Descriptions.sendKeys(values);
	}
	
	public void ClearOnDescription() {
		Description.clear();
	}
	
	public void EnterOnDurationMinutes(String value) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement DurationMinutess = wait.until(ExpectedConditions.elementToBeClickable(DurationMinutes));
		 DurationMinutess.sendKeys(value);
		
	}
	
	public void EnterOnDurationHours(String value) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement DurationHourss = wait.until(ExpectedConditions.elementToBeClickable(DurationHours));
		 DurationHourss.sendKeys(value);
	}
	
	public void ClearOnDurationHours() {
		DurationHours.clear();
	}
	
	public void ClearOnDurationMinutes() {
		DurationMinutes.clear();
	}
	
	
	public void EnterOnTime(String value) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement Times = wait.until(ExpectedConditions.elementToBeClickable(Time));
		 Times.sendKeys(value);
	}
	
	public void ClearOnTime() {
		Time.clear();
	}
	
	
	public void ClickOnTime() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Time));
			Time.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Time));
			Time.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void EnterOnDate(String value) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(Date));
	    dateElement.sendKeys(value);
	}
	
	public void ClearOnDate() {
		Date.clear();
	}
	
	
	public void ClickOnDate() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Date));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Date);
			Date.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Date));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Date);
			Date.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void ClearOnName() {
		Name.clear();
	}
	
	public void EnterOnName(String value) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement Names = wait.until(ExpectedConditions.elementToBeClickable(Name));
		    Names.sendKeys(value);
	}
	
	
	public void ClickOnAddButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
			AddButton.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
			AddButton.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnMeeting() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Meeting));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Meeting);
			Meeting.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Meeting));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Meeting);
			Meeting.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public void ClickOnShare() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Share));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Share);
			Share.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Share));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Share);
			Share.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
