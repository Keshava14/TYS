package com.com.autodesk.Elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rule 1: create a separate class for evry webpage

public class LoginPage {  	
	
	// rule 4: create constructor and use PageFactory class to intialize
	public LoginPage(WebDriver driver){
				
			PageFactory.initElements(driver, this);
	}
	
	// rule 2: identify all the WebElements using @FindBy,@FindBys and @Find All annotation
	
	//@FindBy(css = "[name='user_name']")
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	// Hidden WebElement message
	@FindBy(xpath="//div[contains(text(),'You must specify a valid']")
	private WebElement errMsg;

	// rule 3: Declare all the WebElements as private and provide the getters
	public WebElement getUsernameTb() {
		return usernameEdt;
	}

	public WebElement getPasswordTb() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getErrMsg() {
		return errMsg;
	}
				
	// rule 5: access the WebElements using getters() / business methods
	public void loginToApp(String username, String password) {
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
