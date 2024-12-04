package Testcases;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
public class ExcelDataManager {
    private static ExcelDataManager instance;
    private Map<String, List<Map<String, String>>> cachedData; // Store data for multiple sheets

    // Private constructor to implement Singleton pattern
    private ExcelDataManager() {
        cachedData = new HashMap<>(); // Initialize the map
    }

    // Get the single instance of this class
    public static ExcelDataManager getInstance() {
        if (instance == null) {
            instance = new ExcelDataManager();
        }
        return instance;
    }

    // Load data from Excel into the cache (only once)
    public void loadData(String excelPath) throws InvalidFormatException, IOException {
        if (cachedData.isEmpty()) { // Check if cache is empty before loading data
            ExcelReader reader = new ExcelReader(); // Assuming ExcelReader is a utility class for reading Excel data
            cachedData = reader.getAllData(excelPath); // Load all sheets at once into the cache
        }
    }

    // Retrieve cached data for a specific sheet
    public List<Map<String, String>> getCachedData(String sheetName) {
        return cachedData.get(sheetName); // Return data for the requested sheet
    }
}
