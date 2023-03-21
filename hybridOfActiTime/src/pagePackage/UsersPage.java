package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	
	//Declaration for all the webelements present on users page
	
	@FindBy(linkText = "Users") private WebElement UsersTab;
	@FindBy(xpath = "//input[@value='Create New User']") private WebElement createNewuserButton;
	
	//initialization
	
	public UsersPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//utilization
	
	public WebElement getUsersTab() 
	{
		return UsersTab;
	}
	
	public WebElement getCreateNewUsersButton()
	{
		return createNewuserButton;
	}

}
