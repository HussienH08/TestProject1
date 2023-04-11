package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;


public class PrimeTechPage {

	
 public PrimeTechPage () {
		 
		 PageFactory.initElements(Driver.getDriver(), this);
	 }
	
	 @FindBy (id = "newTab")
	 public WebElement newTabBtn; 
	 
	 @FindBy (xpath = "//h3[contains(text(), 'Browser')]")
	 public WebElement browserText; 
}

