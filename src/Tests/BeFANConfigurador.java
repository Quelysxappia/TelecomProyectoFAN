package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Marketing;
import Pages.setConexion;

public class BeFANConfigurador extends TestBase {
	
	private WebDriver driver;
	private Pages.BeFan pbf;
	
	private void irA(String sMenu,String sOpcion) {
		sleep(3000);
		List<WebElement> wMenu = driver.findElement(By.className("tpt-nav")).findElements(By.className("dropdown"));
		for (WebElement wAux : wMenu) {
			if (wAux.findElement(By.className("dropdown-toggle")).getText().toLowerCase().contains(sMenu.toLowerCase())) {
				wAux.click();
			}
		}
		
		
		
		List<WebElement> wOptions = driver.findElement(By.cssSelector(".dropdown.open")).findElement(By.className("multi-column-dropdown")).findElements(By.tagName("li"));
		for (WebElement wAux2 : wOptions) {
			if (wAux2.findElement(By.tagName("a")).getText().toLowerCase().contains(sOpcion.toLowerCase())) {
				wAux2.click();
				sleep(3000);
				break;
			}
		}
	}
	

	@BeforeClass (alwaysRun = true)
	public void init() {
		driver = setConexion.setupEze();
		loginBeFANConfigurador(driver);
	}
	
	//@AfterMethod (alwaysRun = true)
	public void after() {
		driver.get(TestBase.urlBeFAN);
		sleep(3000);
	}
	
	//@AfterClass (alwaysRun = true)
	public void quit() {
		driver.quit();
	}
	
	@Test (groups = "BeFAN", dataProvider="GestionRegionesCreacion")
	public void TS126620_BeFan_Movil_REPRO_Preactivacion_repro_Gestion_de_agrupadores_Busqueda_Busqueda_especifica(String sRegion) {
		irA("Regiones", "Gesti\u00f3n");
		pbf = new Pages.BeFan(driver);
		
		Assert.assertTrue(pbf.buscarRegion(sRegion));
	}
	
	@Test (groups = "BeFAN")
	public void TS126621_BeFan_Movil_REPRO_Preactivacion_repro_Gestion_de_agrupadores_Busqueda_Busqueda_vacia() {
		irA("Regiones", "Gesti\u00f3n");
		sleep(3000);
		driver.findElement(By.xpath("//*[@type='search']")).sendKeys("asd");
		driver.findElement(By.xpath("//*[@type='search']")).clear();
		sleep(3000);
		WebElement wBody = driver.findElement(By.className("panel-data"));
		List<WebElement> wList = wBody.findElements(By.xpath("//*[@class='panel-group'] //*[@class='collapsed'] //*[@class='ng-binding']"));
		
		boolean bAssert = false;
		String sAgrupador = wList.get(0).getText().toLowerCase();
		for (WebElement wAux : wList) {
			if (!wAux.getText().toLowerCase().equalsIgnoreCase(sAgrupador)) {
				bAssert = true;
				break;
			}
		}
		
		Assert.assertTrue(bAssert && wList.size() > 1);
	}
	
	@Test (groups = "BeFAN", dataProvider="GestionRegionesCreacion")
	public void TS126619_BeFan_Movil_REPRO_Preactivacion_repro_Gestion_de_agrupadores_Creacion_de_agrupador_exitosa(String sRegion) {
		irA("Regiones", "Gesti\u00f3n");
		sleep(3000);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		sleep(3000);
		driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.ng-empty")).sendKeys(sRegion);
		driver.findElement(By.xpath("//*[@class='btn btn-primary' and contains(text(), 'Agregar')]")).click();
		sleep(5000);
		pbf = new Pages.BeFan(driver);
		Assert.assertTrue(pbf.verificarMensajeExitoso());
		//Ask about confirmation message
		driver.findElement(By.xpath("//*[@ng-show='mensajeAgregarRegionCtrl.container.showSuccess']//*[@class='btn btn-primary']")).click();
		TS126620_BeFan_Movil_REPRO_Preactivacion_repro_Gestion_de_agrupadores_Busqueda_Busqueda_especifica(sRegion);
	}
	
	@Test (groups = "BeFAN", dataProvider="GestionRegionesCreacion")
	public void TS126623_BeFan_Movil_REPRO_Preactivacion_repro_Gestion_de_agrupadores_Busqueda_Modificacion_de_agrupadores_Asignación_de_prefijos_a_agrupador_existente_Guardando(String sRegion) {
		irA("Regiones", "Gesti\u00f3n");
		pbf = new Pages.BeFan(driver);
		List<String> sPrefijos = pbf.agregarPrefijos(sRegion);
		
		WebElement wBody = driver.findElement(By.xpath("//*[@class='panel-collapse in collapse'] //table[@class='table table-top-fixed table-striped table-primary ng-scope']"));
		Marketing mM = new Marketing(driver);
		List<WebElement> wPrefijosWeb = mM.traerColumnaElement(wBody, 3, 2);
		boolean bAssert = false;
		for (String sAux3 : sPrefijos) {
			bAssert = false;
			for (WebElement wAux4 : wPrefijosWeb) {
				if (sAux3.equals(wAux4.getText())) {
					bAssert = true;
				}
			}
			if (!bAssert) {
				break;
			}
		}
		Assert.assertTrue(bAssert);
	}
	
	@Test (groups = "BeFAN", dataProvider="GestionRegionesCreacion")
	public void TS126623_BeFan_Movil_REPRO_Preactivacion_repro_Gestion_de_agrupadores_Busqueda_Modificacion_de_agrupadores_Eliminacion_de_prefijos_en_agrupador_existente_Guardando(String sRegion) {
		irA("Regiones", "Gesti\u00f3n");
		pbf = new Pages.BeFan(driver);
		pbf.buscarYAbrirRegion(sRegion);
		
		WebElement wBody = driver.findElement(By.xpath("//*[@class='panel-collapse in collapse'] //table[@class='table table-top-fixed table-striped table-primary ng-scope']"));
		Marketing mM = new Marketing(driver);
		List<WebElement> wRegiones = mM.traerColumnaElement(wBody, 3, 1);
		driver.findElement(By.xpath("//*[@ng-repeat='prefijo in displayedCollection'] [1] //button")).click();
		driver.findElement(By.xpath("//*[@ng-show='mensajeEliminarCtrl.container.showConfirmation'] //button[@class='btn btn-primary']")).click();
		sleep(3000);
		driver.findElement(By.xpath("//*[@ng-show='mensajeEliminarCtrl.container.showSuccess'] //button[@class='btn btn-primary']")).click();
		driver.navigate().refresh();
		
		pbf.buscarYAbrirRegion(sRegion);
		List<WebElement> wRegionesActualizadas = mM.traerColumnaElement(wBody, 3, 1);
		boolean bAssert= true;
		for (WebElement wAux : wRegionesActualizadas) {
			if (wAux.getText().equalsIgnoreCase(wRegiones.get(0).getText())) {
				bAssert = false;
				break;
			}
		}
		
		Assert.assertTrue(bAssert);
	}
	
}