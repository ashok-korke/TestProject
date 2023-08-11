package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

	@DataProvider(name = "Data")
	public Object[][] userData() throws IOException {
		

		String path = System.getProperty("user.dir") + "/testData/userData.xlsx";
		ExcelUtility excelUtility = new ExcelUtility(path);
		//DummyExcelUtility excelUtility= new DummyExcelUtility(path);

		int rowCount = excelUtility.getRowCount("sheet1");
		int celCount = excelUtility.getCellCount("sheet1", rowCount);
		
		String apiData[][] = new String[rowCount][celCount];
		
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j < celCount; j++) {

				apiData[i-1][j] = excelUtility.getCellData("sheet1", i, j);

			}
		}
System.out.println(apiData);
		return apiData;
		

	}

}
