package Testcases;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
public class EditTransmittals {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public ExcelDataManager excelDataManager= ExcelDataManager.getInstance();
	public Locators.TransmittalsLocators T;
	public Locators.Issue_Locators ISS;
	
	@Before
	public void setup() throws InvalidFormatException, IOException {
		excelDataManager.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\EditModule\\Excel\\TigerKrionDataSheet.xlsx");
	}
	
	public EditTransmittals() {
		System.setProperty("webdriver.chrome.log", "chromedriver.logfile");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver=CustomWebDriverManager.getDriver();
		this.T=new Locators.TransmittalsLocators(driver);
		this.ISS= new Locators.Issue_Locators(driver);
	}
	@Then("filtering the required Transmittals and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_transmittals_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname,Integer rownumber) throws Exception {
		try {
			List<Map<String,String>>testdata=excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet Details :"+testdata);
			String projectcode=testdata.get(rownumber).get("Project Code");
			ISS.ClickOnDesignProject();
    Thread.sleep(2000);
    T.Navigateproject();
    Thread.sleep(4000);
    T.EnterOnSearchBox(projectcode);
    Thread.sleep(2000);
    T.clickOnProject(projectcode);
    Thread.sleep(3000);
    driver.navigate().refresh();
    Thread.sleep(3000);
    T.viewMenu();
    T.Transmittalclick();
			Thread.sleep(4000);
			T.SelectStatusclick();
			Thread.sleep(4000);
			String status=testdata.get(rownumber).get("Status");
			System.out.println("Status :"+status);
			T.SelectStatusType(status);
			Thread.sleep(4000);
			String transmitalcode=testdata.get(rownumber).get("OldTransmittal code");
			System.out.println("Transmittal code :"+transmitalcode);
			T.EnterOnSearchsubmittals(transmitalcode);
			Thread.sleep(4000);
			T.clickOnEdit();
			Thread.sleep(2000);
		}
		catch(Exception e) {
			ExceptionHandler exceptionHandler= new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}
	@Then("Changing the required field in Transmittals using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_transmittals_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
		try {
			List<Map<String,String>>testdata=excelDataManager.getCachedData(sheetname);
			String updatecode=testdata.get(rownumber).get("Updatetransmittal code");
			String updatename=testdata.get(rownumber).get("Updatetransmittal name");
			String desc=testdata.get(rownumber).get("Description");
			String Wf=testdata.get(rownumber).get("Workflow");
			String attachfile=testdata.get(rownumber).get("Attachfile");
			String filename=testdata.get(rownumber).get("File Name");
			
			if(updatecode!=null && !updatecode.isEmpty()) {
				Thread.sleep(1000);
				T.clearcode();
				T.entertransmtlCode(updatecode);
			}
			
			if(updatename!=null && !updatename.isEmpty()) {
				Thread.sleep(1000);
				T.clearname();
				T.entertransmtlname(updatename);
			}
			
			if(desc!=null && !desc.isEmpty()) {
				Thread.sleep(1000);
				T.cleardesc();
				T.enterdescription(desc);
			}
			
			if(Wf!=null && !Wf.isEmpty()) {
				Thread.sleep(1000);
				T.selectworkflow(Wf);
			}
			
			if(attachfile!=null && !attachfile.isEmpty() && filename !=null && !filename.isEmpty()) {
				Thread.sleep(1000);
				T.selectfiletype(attachfile);
				Thread.sleep(2000);
				T.searchfile(filename);
				Thread.sleep(2000);
				T.checkboxclick();
				T.clickattachedbtn();
				
			}
			
			T.createclick();
		}
		catch(Exception e) {
			ExceptionHandler exceptionHandler= new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}
}