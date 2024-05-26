package factory;

import io.cucumber.datatable.DataTable;
import pojoClasses.ResponseLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loader {

	private static final Map<String, Map<String, String>> loadInputValues = new HashMap<>();
	

	public static void loadInputValues(String apiName, DataTable table) {
		
		loadInputValues.put(apiName, updateTableWithGlobalValues(table));
		
	}
	
	public static String getInputValue(String keyValue, String apiName) {
		
		return loadInputValues.get(apiName).getOrDefault(keyValue, "");
	}
	
	public static Map<String, String> loadTableValues(List<Map<String, String>> map) {
		
		//List<Map<String, Object>> dataList = map.asMaps(String.class, Object.class);

        if (!map.isEmpty()) {
             return map.getFirst();
        }
        else 
        	//logger.error("Data table is empty");
        	System.out.println("Data is empty");
        
        return new HashMap<String, String>();
	}
	
	public static Map<String, String> loadTableValues(DataTable table) {
		
		List<Map<String, String>> dataList = table.asMaps(String.class, String.class);

        if (!dataList.isEmpty()) {
             return dataList.getFirst();
        }
        else 
        	//logger.error("Data table is empty");
        	System.out.println("Data is empty");
        
        return new HashMap<String, String>();
	}
	
	public static Map<String, String> updateTableWithGlobalValues(DataTable table) {
		
		Map<String, Object> globalMap = ResponseLoader.getGlobalValues();

		Map<String, String> updatedInputValues = new HashMap<>();
		
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> mainMap : data) {
            
        	for (Map.Entry<String, String> entry : mainMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                
                // Check if the value contains '$'
                if (value != null && value.contains("$")) {
                    
                	//String temp = String.valueOf(value);
                    Object updatedValue = globalMap.get(value.replace("$", ""));
                    
                    System.out.println(updatedValue);
                    // Update the value in the main map
                    if (updatedValue != null) {
                    	updatedInputValues.put(key, updatedValue.toString());
                    }
                    else
                    	//logger.error("Global value has null");
                    	System.out.println("Global value has null");
                }
                else
                	updatedInputValues.put(key, value);
                
            }
        }
        
        return updatedInputValues;
	}
}
