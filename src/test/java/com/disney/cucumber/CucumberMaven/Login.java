package com.disney.cucumber.CucumberMaven;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	public WebDriver driver;
	
	@Given("^user launches the application$")
	public void user_launches_the_application() throws Throwable {
	    String baseUrl="HTTP://AUTOMATIONPRACTICE.COM/";
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get(baseUrl);
	   
	}

	@When("^user enters the credentials$")
	public void user_enters_the_credentials() throws Throwable {
	    driver.findElement(By.xpath("//a[@class='login']")).click();
	    Thread.sleep(2000);
	    Assert.assertTrue("Input field not present", driver.findElement(By.xpath("//div//label[text()='Email address']/following-sibling::input[@id='email']")).isDisplayed());
	    driver.findElement(By.xpath("//div//label[text()='Email address']/following-sibling::input[@id='email']")).sendKeys("sarthaksg@gmail.com");
	    driver.findElement(By.xpath("//div[@class='form-group']//input[@name='passwd']")).sendKeys("testing");
	    
	}

	@When("^Clicks on Sign-in button$")
	public void clicks_on_Sign_in_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//p[@class='submit']//button[@name='SubmitLogin']")).click();
	}   

	@Then("^user should be able to login$")
	public void user_should_be_able_to_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue("Login Not Successful", driver.findElement(By.xpath("//div//a//img[@class='logo img-responsive']")).isDisplayed());

	    
	}
	
	@Given("^user verifies \"([^\"]*)\"$")
	public void user_verifies(String arg1) throws Throwable {
	    String argValue=arg1;
	    if(argValue.equalsIgnoreCase("Women")){
	    	
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	WebElement womenBtn=driver.findElement(By.xpath("//li//a[@title='Women']"));
	    	Assert.assertTrue("",womenBtn.isDisplayed());
	    	womenBtn.click();
	    }
	      
	}
	@When("^user clicks Tops in Women$")
	public void user_clicks_Tops_in_Women() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		WebElement womenBtn=driver.findElement(By.xpath("//input[contains(@class,'search_query')]"));
//    	Assert.assertTrue("",womenBtn.isDisplayed());
//    	womenBtn.click();
//    	womenBtn.sendKeys("Women");
		 driver.findElement(By.xpath("Tops")).click();
	    
	}

	@Then("^user can view tops$")
	public void user_can_view_tops() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element1=driver.findElement(By.xpath("//span[contains(@class,'category')]"));
	   Assert.assertTrue("in tops page",element1.isDisplayed());
	}
}
