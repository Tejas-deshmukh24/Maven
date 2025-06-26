package TestNG.Package_Sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDataProvider {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName , String lastName , long PhoneNumber) {
		
		System.out.println("FirstName:"+ firstName +", LastName:" + lastName +", PhoneNumber:"+PhoneNumber);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][3];
		objArr[0][0]="Tejas";
		objArr[0][1]="Deshmukh";
		objArr[0][2]=9856127453l;
		
		objArr[1][0]="Devesh";
		objArr[1][1]="Deshmukh";
		objArr[1][2]=76561274555l;
		
		objArr[2][0]="Ketan";
		objArr[2][1]="More";
		objArr[2][2]=89561274563l;
		
		return objArr;
	}

}
