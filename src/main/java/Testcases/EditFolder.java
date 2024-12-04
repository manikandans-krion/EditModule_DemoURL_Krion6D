package Testcases;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class EditFolder {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.FolderLocators F;
	public Locators.Issue_Locators ISS;
	public ExcelDataManager excelDataManager= ExcelDataManager.getInstance();
	
	 @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
     }
	
	public EditFolder() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboselogging", "true");
		this.driver=CustomWebDriverManager.getDriver();
		this.F=new Locators.FolderLocators(driver);
		this.ISS= new Locators.Issue_Locators(driver);
	}
	
	@Given("filtering the required Folder and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_folder_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
		try {
		List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
		System.out.println("============================Testing====================");
		System.out.println("Sheet details :"+testdata);
		ISS.ClickOnDesignProject();
    String projectcode=testdata.get(rownumber).get("Projectcode");
    System.out.println(projectcode);
    Thread.sleep(2000);
    F.Navigateproject();
    Thread.sleep(4000);
    F.EnterOnSearchBox(projectcode);
    Thread.sleep(2000);
    F.clickOnProject(projectcode);
    Thread.sleep(3000);
    driver.navigate().refresh();
    Thread.sleep(3000);
    F.navigatetodoc();
    Thread.sleep(3000);
		}
		catch(Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Folder");
			throw e;
		}
	}
	
	@Given("Click the menu button on the folder using sheetname {string} and rownumber {int}")
	public void click_the_menu_button_on_the_folder_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println("=================Clicking menu button========");
			System.out.println("Sheet details :"+testdata);
			String foldername=testdata.get(rownumber).get("Foldername");
			System.out.println("foldername :"+foldername);
			if(foldername!=null && !foldername.isEmpty()) {
			F.folderlist(foldername);
			F.clickmenu();
			Thread.sleep(3000);
			};
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Folder");
			throw e;
		}
	}
	
	@Then("click the Rename button")
	public void click_the_rename_button() {
   F.clickrename();
	}
	
	@Then("Update the foldername using the sheetname {string} and rownumber {int}")
	public void update_the_foldername_using_the_sheetname_and_rowumber(String sheetname,Integer rownumber) throws Exception {
   try {
   List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
   System.out.println("Sheet details :"+testdata);   
   String updatefoldername=testdata.get(rownumber).get("Update Foldername");
   if(updatefoldername!=null && !updatefoldername.isEmpty()) {
   F.updatename(updatefoldername);
   F.clicksave();
   }
   
   }catch(Exception e) {
   ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
   }
	}
	
}