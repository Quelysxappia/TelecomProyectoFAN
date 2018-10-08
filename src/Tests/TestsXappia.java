package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.setConexion;

public class TestsXappia extends TestBase{

	private WebDriver driver;
		
	private void loginUAT() {
		driver = setConexion.setupEze();
		driver.get("https://telecomcrm--uat.cs53.my.salesforce.com");
		driver.findElement(By.id("idp_section_buttons")).click();
		driver.findElement(By.name("Ecom_User_ID")).sendKeys("uat579805");
 		driver.findElement(By.id("Ecom_Password")).sendKeys("Testa10k");
 		driver.findElement(By.id("loginButton2")).click();
 		sleep(5000);
	}
	
	private void loginSIT() {
		driver = setConexion.setupEze();
		driver.get("https://crm--sit.cs14.my.salesforce.com/");
		driver.findElement(By.id("idp_section_buttons")).click();
		driver.findElement(By.name("Ecom_User_ID")).sendKeys("UAT195528");
 		driver.findElement(By.id("Ecom_Password")).sendKeys("Testa10k");
 		driver.findElement(By.id("loginButton2")).click();
 		sleep(5000);
	}
	
	
	@Test
	public void Gestiones_Del_Panel_Izquierdo_En_UAT() {
		loginUAT();
 		
	}
	
	@Test
	public void SmokeTest_Tiempo_De_Carga_De_SIT() {
		loginSIT();
		
	}
}
