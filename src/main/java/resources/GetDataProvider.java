package resources;

import org.testng.annotations.DataProvider;

public class GetDataProvider {

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2]; // 2 rows and 2 cols
		// give the actual size while passing to array
		// counting starts from 0 -> [1]-row [1]-cols
		
		// first row
		data[0][0] = "firstuser@test.com"; // but index will be starts from 0
		data[0][1] = "PasswordUser1";
		
		//Second row
		data[1][0] = "seconduser@test.com";
		data[1][1] = "PasswordUser2";
		
		return data;

	}

}
