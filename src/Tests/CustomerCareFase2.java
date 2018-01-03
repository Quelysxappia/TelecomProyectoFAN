package Tests;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Accounts;
import Pages.BasePage;
import Pages.CasePage;
import Pages.CustomerCare;
import Pages.setConexion;

public class CustomerCareFase2 extends TestBase {

	private WebDriver driver;

	
	//@AfterClass(groups = {"CustomerCare", "Vista360Layout", "CambiosDeCondiciónImpositiva", "Sugerencias", "DetalleDeConsumos", "CambioDeCiclo", "MovimientoDeCuentasDeFacturación", "AdministraciónDeCasos", "CostoDeCambios"})
	public void tearDown() {
		driver.quit();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	//@AfterMethod(groups = {"CustomerCare", "Vista360Layout", "CambiosDeCondiciónImpositiva", "Sugerencias", "DetalleDeConsumos", "CambioDeCiclo", "MovimientoDeCuentasDeFacturación", "AdministraciónDeCasos", "CostoDeCambios"})
	public void alert() {
		CustomerCare page = new CustomerCare(driver);
		page.cerrarultimapestaña();
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
		} catch (org.openqa.selenium.NoAlertPresentException e) {}
	}

	@BeforeClass(groups = {"CustomerCare", "Vista360Layout", "CambiosDeCondiciónImpositiva", "Sugerencias", "DetalleDeConsumos", "CambioDeCiclo", "MovimientoDeCuentasDeFacturación", "AdministraciónDeCasos", "CostoDeCambios"})
	public void init() throws Exception {
		this.driver = setConexion.setupEze();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String a = driver.findElement(By.id("tsidLabel")).getText();
		driver.findElement(By.id("tsidLabel")).click();
		if (a.equals("Ventas")) {
			driver.findElement(By.xpath("//a[@href=\'/console?tsid=02uc0000000D6Hd\']")).click();
		} else {
			driver.findElement(By.xpath("//a[@href=\'/home/home.jsp?tsid=02u41000000QWha\']")).click();
			try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("tsidLabel")).click();
			driver.findElement(By.xpath("//a[@href=\'/console?tsid=02uc0000000D6Hd\']")).click();
		}
	}

	@BeforeMethod(groups = {"CustomerCare", "Vista360Layout", "CambiosDeCondiciónImpositiva", "Sugerencias", "DetalleDeConsumos", "CambioDeCiclo", "MovimientoDeCuentasDeFacturación", "AdministraciónDeCasos", "CostoDeCambios"})
	public void setup() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		CustomerCare page = new CustomerCare(driver);
		page.cerrarultimapestaña();
	}

	@Test(groups = {"CustomerCare", "Vista360Layout"})
	public void TS7137_BusinessDataPanelQuickAccessButtonsAccount() {
		CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.elegircuenta("aaaaAndres Care");
		page.openleftpanel();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("profile-box-details")));
		driver.findElements(By.className("profile-box-details"));
		page.validarDatos();
	}

	
	@Test(groups = {"CustomerCare", "Vista360Layout"})
	public void TS7138_BusinessDataPanelPicklistCommercialDataAccount() {
		CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.elegircuenta("aaaaAndres Care");
		page.openleftpanel();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("profile-box-details")));
		driver.findElement(By.className("account-select"));
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15962_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Boton_de_sesion_guiada() {
		CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.elegircuenta("aaaaAndres Care");
		page.openrightpanel();
		page.ValidarBtnsGestion("Cambios de condición impositiva");
	}

	
	@Test(groups = {"CustomerCare", "Vista360Layout"})
	public void TS14567_Capacidades_de_Busqueda_Filtrar_Por_DNI() {
		CustomerCare page = new CustomerCare(driver);
		page.usarbuscadorsalesforce("30303030");
		page.validarlabusqueda("aaaaAndres Care");
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "Vista360Layout"})
	public void TS14565_View_Capacidades_de_Busqueda_Visualizar_Filtro_Salesforce() {
		CustomerCare page = new CustomerCare(driver);
		page.validarbuscadorsalesforce();
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "Vista360Layout"})
	public void TS14570_Busqueda_de_Transacciones_Filtrar_Por_Numero_de_Caso() {
		CustomerCare page = new CustomerCare(driver);
		driver.findElement(By.id("phSearchInput")).clear();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.usarbuscadorsalesforce("00003035");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".listRelatedObject.caseBlock")));
		WebElement element = driver.findElement(By.cssSelector(".listRelatedObject.caseBlock"));
		Assert.assertTrue(element.getText().contains("00003035"));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "Sugerencias"})
	public void TS12244_Positive_Feedback_Suggestions_Generic_Interaction_No_Follow_up_Required_Creacion_de_los_Casos_Crear_Caso() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("sugerencia");
		page.crearsugerencia("Sugerencias", "Publicidad", "crear");
		List<WebElement> element = driver.findElements(By.className("ta-care-omniscript-done"));
		for (WebElement x : element) {
			if (x.getText().toLowerCase().contains("su gestión se finalizo correctamente.")) {
				Assert.assertTrue(x.isDisplayed());
			}
		}
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "Sugerencias"})
	public void TS12245_Positive_Feedback_Suggestions_Generic_Interaction_No_Follow_up_Required_Creacion_de_los_Casos_Crear_y_Cancelar_Gestion() {
		CustomerCare page = new CustomerCare(driver);
		CasePage page1 = new CasePage(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("sugerencia");
		page.crearsugerencia("Sugerencias", "Productos/Servicios", "cancel");
		page.cerrarultimapestaña();
		page.elegircaso();
		page1.validarcasocerrado("", "", "Sugerencias", "nico");
	}

	
	@Test(groups = {"CustomerCare", "Sugerencias"})
	public void TS12302_Positive_Feedback_Suggestions_Generic_Interaction_No_Follow_up_Required_Detalle_de_Atributos_Feedback_Positivo_Generar_Gestion_Subcategoria_Atencion_Ejecutivos() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("sugerencia");
		page.crearsugerencia("Sugerencias", "Atención Ejecutivos", "crear");
		List<WebElement> element = driver.findElements(By.className("ta-care-omniscript-done"));
		for (WebElement x : element) {
			if (x.getText().toLowerCase().contains("su gestión se finalizo correctamente.")) {
				Assert.assertTrue(x.isDisplayed());
			}
		}
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15962_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Boton_de_sesion_guiada() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.ValidarBtnsGestion("Cambios de condi");
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15966_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_1_Escenario_1() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.validarCheckBox();
		List<WebElement> dni = driver.findElements(By.cssSelector(".slds-form-element__label.ng-binding.ng-scope"));
		for (WebElement x : dni) {
			if (x.getText().toLowerCase().contains("dni --> cuit")) {
				Assert.assertTrue(x.isDisplayed());
			}
		}
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15976_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_2_Seleccion_DNI_a_CUIT() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.billings(driver.findElements(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding")));
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15977_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_2_Sin_seleccion_DNI_a_CUIT() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		page.validarError();
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15974_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_2_Visualizar_DNI_a_CUIT() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement billings = driver.findElement(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding"));
		boolean a = false;
		if (billings.isDisplayed()) {
			a = true;
			assertTrue(a);
		}
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15993_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_4_Valores_IVA_No_ejecutivo() {
		BasePage pagina = new BasePage(driver);
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.billings(driver.findElements(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding")));
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown((driver.findElement(By.id("NewCUITType"))), "20");
		page.setSimpleDropdown((driver.findElement(By.id("NewCheckDigit"))), "1");
		page.clickSiguiente(driver.findElement(By.id("Step_5_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("IVACondition")).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Select ivaSelect = new Select(driver.findElement(By.id("IVACondition")));
		Assert.assertTrue(pagina.getSelectOptions(ivaSelect).contains("IVA Exento / No Alcanzado"));
		Assert.assertTrue(pagina.getSelectOptions(ivaSelect).contains("IVA Responsable Inscripto"));
		Assert.assertTrue(pagina.getSelectOptions(ivaSelect).contains("IVA Sujeto No Categorizado"));
		Assert.assertTrue(pagina.getSelectOptions(ivaSelect).contains("IVA Monotributista"));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15999_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_4_Visualizar_Exencion_IVA() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.billings(driver.findElements(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding")));
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown((driver.findElement(By.id("NewCUITType"))), "20");
		page.setSimpleDropdown((driver.findElement(By.id("NewCheckDigit"))), "1");
		page.clickSiguiente(driver.findElement(By.id("Step_5_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.ElementPresent(driver.findElement(By.cssSelector(".taxConditionChanges")));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS16015_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_4_Visualizar_Percepcion_IIBB() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.billings(driver.findElements(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding")));
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown((driver.findElement(By.id("NewCUITType"))), "20");
		page.setSimpleDropdown((driver.findElement(By.id("NewCheckDigit"))), "1");
		page.clickSiguiente(driver.findElement(By.id("Step_5_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.ElementPresent(driver.findElement(By.id("IIBBCondition")));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS16017_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_4_Visualizar_Picklist_Jurisdicciones_Percepcion_IIBB() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.billings(driver.findElements(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding")));
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown((driver.findElement(By.id("NewCUITType"))), "20");
		page.setSimpleDropdown((driver.findElement(By.id("NewCheckDigit"))), "1");
		page.clickSiguiente(driver.findElement(By.id("Step_5_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.ElementPresent(driver.findElement(By.id("IIBBExemptionJurisdiction")));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15965_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Validaciones_negativas() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.validarError();
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS16052_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_6_Confirmacion() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.billings(driver.findElements(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding")));
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown((driver.findElement(By.id("NewCUITType"))), "20");
		page.setSimpleDropdown((driver.findElement(By.id("NewCheckDigit"))), "1");
		page.clickSiguiente(driver.findElement(By.id("Step_5_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown(driver.findElement(By.id("IVACondition")), "IVA Monotributista");
		driver.findElement(By.id("IVAExemptionDateTo")).sendKeys("24/12/2017");
		driver.findElement(By.id("IVAExemptionPercentage")).sendKeys("10");
		page.setSimpleDropdown(driver.findElement(By.id("IIBBCondition")), "IIBB Inscripto Local");
		page.setSimpleDropdown(driver.findElement(By.id("IIBBExemptionJurisdiction")), "CABA");
		driver.findElement(By.id("IIBBExemptionDateTo")).sendKeys("25/12/2017");
		driver.findElement(By.id("IIBBExemptionPercentage")).sendKeys("10");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("RespaldatoryDocumentationFile")).sendKeys("C:\\descarga.jpg");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.clickSiguiente(driver.findElement(By.id("Step_6_Select_New_Tax_Condition_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.clickSiguiente(driver.findElement(By.id("Step_8_Summary_nextBtn")));
		try {Thread.sleep(15000);}catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("ng-binding")));
		List<WebElement> nombre = driver.findElements(By.className("ng-binding"));
		Assert.assertTrue(nombre.get(0).getText().contains("Los datos se actualizaron correctamente. Su número de gestión es:"));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS16054_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Paso_6_Caso_creado() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(25000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-radio--faux.ng-scope")));
		driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope")).click();
		page.clickSiguiente(driver.findElement(By.id("Step_2_Select_Tax_Condition_To_Modify_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.billings(driver.findElements(By.cssSelector(".slds-form-element__label.tax-condition-billing-accounts-name.ng-binding")));
		page.clickSiguiente(driver.findElement(By.id("Step_3_Select_Billing_Accounts_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown((driver.findElement(By.id("NewCUITType"))), "20");
		page.setSimpleDropdown((driver.findElement(By.id("NewCheckDigit"))), "1");
		page.clickSiguiente(driver.findElement(By.id("Step_5_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.setSimpleDropdown(driver.findElement(By.id("IVACondition")), "IVA Monotributista");
		driver.findElement(By.id("IVAExemptionDateTo")).sendKeys("24/12/2017");
		driver.findElement(By.id("IVAExemptionPercentage")).sendKeys("10");
		page.setSimpleDropdown(driver.findElement(By.id("IIBBCondition")), "IIBB Inscripto Local");
		page.setSimpleDropdown(driver.findElement(By.id("IIBBExemptionJurisdiction")), "CABA");
		driver.findElement(By.id("IIBBExemptionDateTo")).sendKeys("25/12/2017");
		driver.findElement(By.id("IIBBExemptionPercentage")).sendKeys("10");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("RespaldatoryDocumentationFile")).sendKeys("C:\\descarga.jpg");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.clickSiguiente(driver.findElement(By.id("Step_6_Select_New_Tax_Condition_DNI_To_CUIT_nextBtn")));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.clickSiguiente(driver.findElement(By.id("Step_8_Summary_nextBtn")));
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("ng-binding")));
		List<WebElement> nombre = driver.findElements(By.className("ng-binding"));
		Assert.assertTrue(nombre.get(0).getText().contains("Los datos se actualizaron correctamente."));
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-media.slds-media--timeline.slds-timeline__media--standard-case")));
		WebElement x = driver.findElement(By.cssSelector(".slds-media.slds-media--timeline.slds-timeline__media--standard-case"));
		Assert.assertTrue(x.getText().toLowerCase().contains("cambio de condición impositiva"));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "DetalleDeConsumos"})
	public void TS15905_Consumption_Details_Definicion_de_Filtros_Filtro_Lista_de_Servicios_Servicio_que_lo_tiene_el_cliente() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("detalle de consumo");
		BasePage cambioFrameByID = new BasePage();
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("text-input-01")));
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("text-input-01")).click();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> servicios = driver.findElements(By.cssSelector(".slds-dropdown.slds-dropdown--left")).get(0).findElements(By.cssSelector(".slds-lookup__item-action.slds-lookup__item-action--label"));
		Assert.assertTrue(servicios.size() > 0);
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "DetalleDeConsumos"})
	public void TS15906_Consumption_Details_Definicion_de_Filtros_Filtro_Lista_de_Servicios_Servicio_que_no_tiene_el_cliente() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("detalle de consumo");
		BasePage cambioFrameByID = new BasePage();
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("text-input-01")));
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("text-input-01")).click();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> servicios = driver.findElements(By.cssSelector(".slds-dropdown.slds-dropdown--left")).get(0).findElements(By.cssSelector(".slds-lookup__item-action.slds-lookup__item-action--label"));
		Assert.assertTrue(servicios.size() != 0);
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS15964_Tax_Condition_Changes_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Guardar_para_Despues_Sesion_Guiada() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambios de condi");
		try {Thread.sleep(25000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver,By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope")));
		List<WebElement> guardar = driver.findElements(By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope"));
		guardar.get(1).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("alert-ok-button")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver,By.cssSelector(".slds-grid.slds-box.vlc-slds-save_for_later")));
		page.ElementPresent(driver.findElement(By.cssSelector(".slds-grid.slds-box.vlc-slds-save_for_later")));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "Vista360Layout"})
	public void TS15954_360_View_Ver_Equipo_Creador_en_Case_Visualizar_campo_Equipo_del_Creador() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.elegircaso();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(driver.findElement(By.cssSelector(".x-grid3-hd-inner.x-grid3-hd-00Nc0000001iLah")).isDisplayed());
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16069_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_1_Seleccion_Billing_accounts() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambio de ciclo");
		try {Thread.sleep(25000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("BillingCycle_nextBtn")));
		List<WebElement> checkbox = driver.findElements(By.className("slds-checkbox--faux"));
		checkbox.get(0).click();
		checkbox.get(1).click();
		checkbox.get(2).click();
		Assert.assertTrue(page.ElementPresent(driver.findElement(By.id("BillingCycle_nextBtn"))));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16062_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_1_Visualizar_Billing_accounts() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambio de ciclo");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("slds-checkbox--faux")));
		List<WebElement> cuenta = driver.findElements(By.className("slds-checkbox--faux"));
		Assert.assertTrue(cuenta.size() > 0);
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16077_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_2_Valores_Picklist_Ciclo_de_facturacion() {
		CustomerCare page = new CustomerCare(driver);
		BasePage pagina = new BasePage(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("cambio de ciclo");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("BillingCycle_nextBtn")));
		List<WebElement> checkbox = driver.findElements(By.className("slds-checkbox--faux"));
		checkbox.get(0).click();
		checkbox.get(1).click();
		checkbox.get(2).click();
		driver.findElement(By.id("BillingCycle_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("BillingCycleSelect")).click();
		Select dias = new Select(driver.findElement(By.id("BillingCycleSelect")));
		Assert.assertTrue(pagina.getSelectOptions(dias).contains("1"));
		Assert.assertTrue(pagina.getSelectOptions(dias).contains("7"));
		Assert.assertTrue(pagina.getSelectOptions(dias).contains("14"));
		Assert.assertTrue(pagina.getSelectOptions(dias).contains("21"));
		driver.switchTo().defaultContent();
	}


	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS16056_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Funcionamiento_Boton_Sesion_Guiada() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaAndres Care");
		page.SelectGestion("Cambio de ciclo");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.ValidarCambioDeCiclo();
	}

	
	@Test(groups = {"CustomerCare", "CambiosDeCondiciónImpositiva"})
	public void TS16055_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion__Boton_Sesion_Guiada() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaAndres Care");
		page.ValidarBtnsGestion("Cambio de ciclo");
	}

	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12252_Billing_Group_User_Line_Movements_Paso_0_Error_por_cliente_inactivo() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		goToLeftPanel(driver, "Cuentas");
		page.elegircuenta("aaaaAndres Care");
		page.SelectGestion("Movimientos de cuenta de facturaci");
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-text-block.vlc-slds-rte.ng-pristine.ng-valid.ng-scope")));
		WebElement element = driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-text-block.vlc-slds-rte.ng-pristine.ng-valid.ng-scope"));
		Assert.assertTrue(element.getText().contains("El cliente no está activo"));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12251_Billing_Group_User_Line_Movements_Paso_0_Error_por_fraude_Cliente_inactivo() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaAndres Care");
		page.SelectGestion("Movimientos de cuenta de facturaci");
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-text-block.vlc-slds-rte.ng-pristine.ng-valid.ng-scope")));
		WebElement element = driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-text-block.vlc-slds-rte.ng-pristine.ng-valid.ng-scope"));
		Assert.assertTrue(element.getText().contains("El cliente no está activo"));
	}

	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12262_Billing_Group_User_Line_Movements_Paso_1_Billing_Account_suspendida_por_fraude_No_se_visualiza() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaAndres Care");
		page.SelectGestion("movimiento");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("Validaciones_nextBtn")));
		List <WebElement> element = driver.findElements(By.cssSelector(".slds-col--padded.slds-size--1-of-1.ng-scope"));
		for (WebElement x : element) {
			if (x.getText().toLowerCase().contains("el cliente tiene fraude") && x.getText().toLowerCase().contains("el cliente no está activo")) {
				Assert.assertTrue(x.isDisplayed());
			}
		}
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12261_Billing_Group_User_Line_Movements_Paso_1_Mover_Bundle_Se_mueven_todos_los_servicios() {
		Assert.assertTrue(false);
		/*CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.editarcuenta("aaaaFernando Care", "no", "active");
		page.editarcuenta("aaaaaaaaFernando Care Billing 1", "no", "active");
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("Movimientos de cuenta de facturaci");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("Validaciones_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> element = driver.findElements(By.className("slds-checkbox--faux"));
		element.get(0).click();
		driver.findElement(By.id("BillingAccountFrom_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> x = driver.findElements(By.className("slds-radio--faux"));
		x.get(1).click();
		driver.findElement(By.id("BillingAccountToStep_nextBtn")).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("Summary_nextBtn")).click();
		page.serviciocambiadecuenta("Arnet 10 MB (Prueba)", "aaaaaaaaFernando Care Billing 2");
		page.SelectGestion("Movimientos de cuenta de facturacion");
		page.validarerrorpaso1("servicio cambia de cuenta billing");*/
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS15953_Billing_Cycle_Changes_Rastreo_de_los_Cambios_del_Inicio_del_Ciclo_de_Facturacion_Visualizar_Datos_Anteriores_Ciclo_Facturacion() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.usarpanelcentral("Detalles");
		page.validarhistorialdecuentas();
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16061_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_0_Caso_Cliente_activo() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");		
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope")));	
		List <WebElement> error = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		error.get(1).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> error2 = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		int cant = 0;
		while (cant < 2) {
			try {
				error2.get(1).click();
			} catch(org.openqa.selenium.StaleElementReferenceException e) {
				cant++;
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(false);
		//Assert.assertTrue(driver.findElement(By.cssSelector(".message.description.ng-binding.ng-scope")).isDisplayed());
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS15959_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_0_Caso_fraude() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaRaul Care");
		page.SelectGestion("ciclo");
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".message.description.ng-binding.ng-scope")));
		WebElement element = driver.findElement(By.cssSelector(".message.description.ng-binding.ng-scope"));
		Assert.assertTrue(element.getText().contains("En este momento no se puede efectuar este tipo de gestión porque su cuenta está en un estado de fraude"));
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16060_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_0_Validaciones_Cliente_activo() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");		
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID=new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".message.description.ng-binding.ng-scope")));
		WebElement element = driver.findElement(By.cssSelector(".message.description.ng-binding.ng-scope"));
		Assert.assertTrue(element.getText().toLowerCase().contains("en este momento no se puede efectuar este tipo de gestión porque su cuenta está en estado inactiva."));
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16057_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_0_Validaciones_correctas() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");		
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope")));	
		List <WebElement> error = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		error.get(1).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> error2 = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		int cant = 0;
		while (cant < 2) {
			try {
				error2.get(1).click();
			} catch(org.openqa.selenium.StaleElementReferenceException e) {
				cant++;
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("CostReview_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-text-block.vlc-slds-rte.ng-pristine.ng-valid.ng-scope")));
		boolean a = false;
		List <WebElement> element = driver.findElements(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-text-block.vlc-slds-rte.ng-pristine.ng-valid.ng-scope"));
		for (WebElement x : element) {
			if (x.getText().toLowerCase().contains("en este formulario podrás cambiar la fecha en la cual se te empieza a facturar cada mes")) {
				a = true;
			}
		}
		Assert.assertTrue(false);
		//Assert.assertTrue(a);
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16065_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_1_Ciclo_Billing_accounts() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope")));	
		List <WebElement> error = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		error.get(1).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> error2 = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		int cant = 0;
		while (cant < 2) {
			try {
				error2.get(1).click();
			} catch(org.openqa.selenium.StaleElementReferenceException e) {
				cant++;
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("CostReview_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> accounts = driver.findElements(By.className("slds-checkbox__label"));
		boolean a = false;
		boolean b = false;
		for (WebElement x : accounts) {
			if (x.getText().contains("aaaaFernando Care")) {
				a = true;
			}
			if (x.getText().contains("aaaaFernando Care Billing 1")) {
				b = true;
			}
		}
		Assert.assertTrue(false);
		//Assert.assertTrue(a && b);
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16064_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_1_Funcionamiento_Boton_Servicios_Billing_accounts() {
		CustomerCare page = new CustomerCare(driver);
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope")));	
		List <WebElement> error = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		error.get(1).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> error2 = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		int cant = 0;
		while (cant < 2) {
			try {
				error2.get(1).click();
			} catch(org.openqa.selenium.StaleElementReferenceException e) {
				cant++;
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("CostReview_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> element = driver.findElements(By.id("tree0-node1__label"));
		boolean a = false;
		for (WebElement x : element) {
			if (x.getText().toLowerCase().contains("ver servicios contratados")) {
				a = true;
			}
		}
		Assert.assertTrue(false);
		//Assert.assertTrue(a);
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16078_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_2_Mandatorio_Picklist_Ciclo_de_facturacion() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope")));	
		List <WebElement> error = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		error.get(1).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> error2 = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		int cant = 0;
		while (cant < 2) {
			try {
				error2.get(1).click();
			} catch(org.openqa.selenium.StaleElementReferenceException e) {
				cant++;
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("CostReview_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("BillingCycle_nextBtn")));
		List<WebElement> checkbox = driver.findElements(By.className("slds-checkbox--faux"));
		checkbox.get(0).click();
		checkbox.get(1).click();
		driver.findElement(By.id("BillingCycle_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("NewBillingCycle_nextBtn")).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement x = driver.findElement(By.cssSelector(".slds-modal__content.slds-p-around--medium"));
		Assert.assertTrue(false);
		//Assert.assertTrue(x.getText().toLowerCase().contains("error: por favor complete todos los campos requeridos"));
		driver.findElement(By.id("alert-ok-button")).click();
		driver.switchTo().defaultContent();
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16080_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_Inicio_Ciclo_Facturacion_Paso3_Visualizar_Datos_Antiguos_Resumen() {
		CustomerCare page = new CustomerCare(driver);
		BasePage Bp = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");
		page.clickContinueError();
		page.clickContinueError();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(Bp.getFrameForElement(driver, By.id("BillingCycle_nextBtn")));
		String parcial = driver.findElement(By.id("tree0-node1")).findElements(By.cssSelector(".slds-form-element__label.slds-truncate.ng-binding")).get(1).getText();
		parcial = parcial.substring(parcial.length() - 2, parcial.length());
		if (parcial.contains(" ")) {
			parcial.substring(1);
		}
		System.out.println("parcial" + parcial);
		page.ciclodefacturacionpaso2();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (parcial.equals("1")) {
			Bp.setSimpleDropdown(driver.findElement(By.id("BillingCycleSelect")), "7");
		} else {
			Bp.setSimpleDropdown(driver.findElement(By.id("BillingCycleSelect")), "1");
		}
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		((JavascriptExecutor) driver).executeScript(
		"window.scrollTo(0," + driver.findElement(By.id("NewBillingCycle_nextBtn")).getLocation().y + ")");
		driver.findElement(By.id("NewBillingCycle_nextBtn")).click();
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String actual = driver.findElement(By.id("SelectableItems2")).findElements(By.cssSelector("slds-text-align--left.slds-m-around--x-small.ng-binding.ng-scope")).get(1).getText();
		actual = actual.substring(actual.length() - 2, actual.length());
		if (actual.contains(" ")) {
			actual.substring(1);
		}
		System.out.println("actual" + actual);
		assertTrue(actual.equals(parcial));
		// error, se deben esperar 2 dias para relaizar la prueba
	}

	
	@Test(groups = {"CustomerCare", "CambioDeCiclo"})
	public void TS16081_Billing_Cycle_Changes_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Paso_3_Visualizar_Datos_Nuevos_Resumen() {
		CustomerCare page = new CustomerCare(driver);
		BasePage Bp = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("ciclo");
		page.clickContinueError();
		page.clickContinueError();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(Bp.getFrameForElement(driver, By.id("BillingCycle_nextBtn")));
		page.billings(driver.findElements(By.className("slds-checkbox--faux")));
		;
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String parcial = driver.findElement(By.id("tree0-node1")).findElements(By.cssSelector(".slds-form-element__label.slds-truncate.ng-binding")).get(1).getText();
		parcial = parcial.substring(parcial.length() - 2, parcial.length());
		if (parcial.contains(" ")) {
			parcial.substring(1);
		}
		System.out.println("parcial" + parcial);
		page.ciclodefacturacionpaso2();
		if (parcial.equals("1")) {
			Bp.setSimpleDropdown(driver.findElement(By.id("BillingCycleSelect")), "7");
		} else {
			Bp.setSimpleDropdown(driver.findElement(By.id("BillingCycleSelect")), "1");
		}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		((JavascriptExecutor) driver).executeScript(
		"window.scrollTo(0," + driver.findElement(By.id("BillingCycle_nextBtn")).getLocation().y + ")");
		driver.findElement(By.id("BillingCycle_nextBtn")).click();
	}
	
	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12254_Billing_Group_User_Line_Movements_Paso_1_Seleccion_de_Billing_Account_sin_seleccionar_servicios() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("movimiento");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("Validaciones_nextBtn")));
		driver.findElement(By.id("Validaciones_nextBtn")).click();
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("BillingAccountFrom_nextBtn")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(driver.findElement(By.cssSelector(".slds-modal__header.slds-theme--info.slds-theme--alert-texture.slds-theme--error")).isDisplayed());
		driver.findElement(By.id("alert-ok-button")).click();
		driver.switchTo().defaultContent();
	}
	
	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12255_Billing_Group_User_Line_Movements_Paso_1_Seleccion_de_Billing_Account_y_un_servicio() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("movimiento");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("Validaciones_nextBtn")));
		driver.findElement(By.id("Validaciones_nextBtn")).click();
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> element = driver.findElements(By.className("slds-checkbox--faux"));
		element.get(1).click();
		driver.findElement(By.id("BillingAccountFrom_nextBtn")).click();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> x = driver.findElements(By.cssSelector(".slds-size--11-of-12.vlc-slds-flex-grow.vlc-slds-underline--gradient"));
		for (WebElement a : x) {
			if (a.getText().toLowerCase().contains("paso 2: seleccionar billing account de destino")) {
				Assert.assertTrue(a.isDisplayed());
			}
		}
		driver.switchTo().defaultContent();
	}
	
	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12260_Billing_Group_User_Line_Movements_Paso_1_Visualizacion_Bundle() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("movimiento");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("Validaciones_nextBtn")));
		driver.findElement(By.id("Validaciones_nextBtn")).click();
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(driver.findElement(By.cssSelector(".slds-tree__container.ng-scope")).isDisplayed());
		driver.switchTo().defaultContent();
	}
	
	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12268_Billing_Group_User_Line_Movements_Paso_2_Billing_Account_suspendida_por_fraude_No_se_visualiza() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaAndres Care");
		page.SelectGestion("movimiento");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("Validaciones_nextBtn")));
		List <WebElement> element = driver.findElements(By.cssSelector(".slds-col--padded.slds-size--1-of-1.ng-scope"));
		for (WebElement x : element) {
			if (x.getText().toLowerCase().contains("el cliente tiene fraude") && x.getText().toLowerCase().contains("el cliente no está activo")) {
				Assert.assertTrue(x.isDisplayed());
			}
		}
		driver.switchTo().defaultContent();
	}
	
	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12264_Billing_Group_User_Line_Movements_Paso_2_Expansion_de_servicios() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("movimiento");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("Validaciones_nextBtn")));
		driver.findElement(By.id("Validaciones_nextBtn")).click();
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> element = driver.findElements(By.className("slds-checkbox--faux"));
		element.get(1).click();
		driver.findElement(By.id("BillingAccountFrom_nextBtn")).click();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> x = driver.findElements(By.className("slds-radio__label"));
		for (WebElement a : x) {
			if (a.getText().toLowerCase().contains("aaaaaaaaFernando Care Billing 1")) {
				a.click();
			}
		}
		List <WebElement> a = driver.findElements(By.className("slds-form-element__control"));
		for (WebElement b : a) {
			if (b.getText().toLowerCase().contains("fernando baf care")) {
				Assert.assertTrue(b.isDisplayed());
			}
		}
		driver.switchTo().defaultContent();
	}
	
	
	@Test(groups = {"CustomerCare", "MovimientoDeCuentasDeFacturación"})
	public void TS12273_Billing_Group_User_Line_Movements_Cancelacion_de_omniscript_Caso_con_estado_cancelado() {
		CustomerCare page = new CustomerCare(driver);
		BasePage cambioFrameByID = new BasePage();
		page.elegircuenta("aaaaFernando Care");
		page.SelectGestion("movimiento");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("Validaciones_nextBtn")));
		driver.findElement(By.id("Validaciones_nextBtn")).click();
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> element = driver.findElements(By.className("slds-checkbox--faux"));
		element.get(1).click();
		driver.findElement(By.id("BillingAccountFrom_nextBtn")).click();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("alert-ok-button")));
		driver.findElement(By.id("alert-ok-button")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("slds-text-heading--large")));
		WebElement x = driver.findElement(By.className("slds-text-heading--large"));
		Assert.assertTrue(x.getText().toLowerCase().contains("el proceso se canceló"));
		driver.switchTo().defaultContent();
	}
	
	
	@Test(groups = {"CustomerCare", "AdministraciónDeCasos"})
	public void TS14601_Case_Management__Casos_Ordernados_Por_Tipos_Vista_Todos_Los_Casos_Abiertos(){
		 Accounts accountPage = new Accounts(driver);
		 CustomerCare page = new CustomerCare(driver);
		 page.cerrarultimapestaña();
	     driver.switchTo().defaultContent();
	     goToLeftPanel2(driver, "Casos");
	     accountPage.accountSelect("Todos Los Casos Abiertos");
	     try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	     assertTrue(driver.findElement(By.cssSelector(".x-panel.x-grid-panel")).isDisplayed());
	}
	
	
	@Test(groups = {"CustomerCare", "CostoDeCambios"})
	public void TS15850_Cost_For_Changes_Sesion_Guiada_Visualizar_Leyenda_Cargo_Gestion_Consumidor_Final_Costo_IVA(){
		 Accounts accountPage = new Accounts(driver);
		 goToLeftPanel2(driver, "Cuentas");
	     driver.switchTo().defaultContent();
	     driver.switchTo().frame(accountPage.getFrameForElement(driver, By.cssSelector(".topNav.primaryPalette")));
	     Select field = new Select(driver.findElement(By.name("fcf")));
	     try {field.selectByVisibleText("Todas Las cuentas");}
			catch (org.openqa.selenium.NoSuchElementException ExM) {field.selectByVisibleText("Todas las cuentas");}
	     try {Thread.sleep(9000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
	     CustomerCare page = new CustomerCare(driver);
			page.cerrarultimapestaña();
			 try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
			page.elegircuenta("aaaaFernando Care");
			 try {Thread.sleep(9000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}  
			 accountPage.findAndClickButton("Cambios de condición impositiva");
			 try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}  
			 assertTrue(false);
			 //bug reportado, arreglar cuando se pueda visualizar
	}
	
	
	@Test(groups = {"CustomerCare", "CostoDeCambios"})
	public void TS15851_Cost_For_Changes_Sesion_Guiada_Visualizar_Leyenda_Cargo_Gestion_Empresas_Costo_Impuestos(){
		 Accounts accountPage = new Accounts(driver);
		 goToLeftPanel2(driver, "Cuentas");
	     driver.switchTo().defaultContent();
	     driver.switchTo().frame(accountPage.getFrameForElement(driver, By.cssSelector(".topNav.primaryPalette")));
	     Select field = new Select(driver.findElement(By.name("fcf")));
	     try {field.selectByVisibleText("Todas Las cuentas");}
	     catch (org.openqa.selenium.NoSuchElementException ExM) {field.selectByVisibleText("Todas las cuentas");}
	     try {Thread.sleep(9000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
	     CustomerCare page = new CustomerCare(driver);
	     page.cerrarultimapestaña();
		 try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
		 page.elegircuenta("Empresa Care");
		 try {Thread.sleep(9000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}  
		 accountPage.findAndClickButton("Cambios de condición impositiva");
		 try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}  
		 assertTrue(false);
		 //bug reportado, arreglar cuando se pueda visualizar
	}
	
	
	@Test(groups = {"CustomerCare", "Vista360Layout"})
	public void TS14569_360_View_360_View_Capacidades_De_Busqueda_Filtrar_Por_Billing_Account(){
		Accounts accountPage = new Accounts(driver);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("phSearchInput")).clear();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("phSearchInput")).sendKeys("aaaaFernando Care Billin");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.findElement(By.id("phSearchInput:group0:option0")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {driver.switchTo().alert().accept();}catch(org.openqa.selenium.NoAlertPresentException e) {}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("topButtonRow")));
		assertTrue(driver.findElement(By.className("mainTitle")).getText().equals("Detalle de Cuenta"));
	}
	
	
	@Test(groups = {"CustomerCare", "DetalleDeConsumos"})
	public void TS15940_Consumption_Details_Mostrar_Informacion_Sobre_El_Tiempo_De_Actualizacion_Ultima_Actualizacion_Dentro_Del_Dia(){
		 Accounts accountPage = new Accounts(driver);
		 goToLeftPanel2(driver, "Cuentas");
	     driver.switchTo().defaultContent();
	     driver.switchTo().frame(accountPage.getFrameForElement(driver, By.cssSelector(".topNav.primaryPalette")));
	     Select field = new Select(driver.findElement(By.name("fcf")));
	     try {field.selectByVisibleText("Todas Las cuentas");}
	     catch (org.openqa.selenium.NoSuchElementException ExM) {field.selectByVisibleText("Todas las cuentas");}
	     try {Thread.sleep(9000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
	     CustomerCare page = new CustomerCare(driver);
	     page.cerrarultimapestaña();
		 try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
		 page.elegircuenta("aaaaFernando Care");
		 accountPage.findAndClickButton("Detalle de Consumos");
		 try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("text-input-01")));
		 driver.findElement(By.id("text-input-01")).click();
		 driver.findElement(By.cssSelector(".slds-dropdown.slds-dropdown--left")).findElement(By.tagName("span")).click();
		 driver.findElement(By.cssSelector(".slds-button.slds-button--brand")).click();
		 driver.findElement(By.cssSelector(".slds-button.slds-button--brand")).click();
		 try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} 
		 //driver.switchTo().defaultContent();
		 //driver.switchTo().frame(accountPage.getFrameForElement(driver, By.className(".slds-text-title")));
		 String fecha = driver.findElements(By.className("slds-text-title")).get(2).getText();
		 fecha = fecha.substring(25, fecha.length()-2);
		 System.out.println("fecha: "+fecha);
		 Calendar Factual = Calendar.getInstance();
		 System.out.println("fecha act: "+(Integer.toString(Factual.get(Calendar.DATE))+"/"+Integer.toString(Factual.get(Calendar.MONTH))+"/"+Integer.toString(Factual.get(Calendar.YEAR))));
		 assertTrue(fecha.split(" ")[0].equals(Integer.toString(Factual.get(Calendar.DATE))+"/"+Integer.toString(Factual.get(Calendar.MONTH))+"/"+Integer.toString(Factual.get(Calendar.YEAR)))); 
	}
	
	
	@Test(groups = {"CustomerCare", "AdministraciónDeCasos"})
	public void TS15960_360_View_Ver_Equipo_Creador_En_Case_Usuario_Cambia_De_Equipo_No_Se_Modifica_El_Campo_Equipo_Del_Creador() throws ParseException{
		 Accounts accountPage = new Accounts(driver);
		 Date date1 = new Date();
	     driver.switchTo().defaultContent();
	     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	     try {
			date1 = sdf.parse("24/11/2017");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     goToLeftPanel2(driver, "Casos");
	     accountPage.accountSelect("Mis Casos");
	     driver.switchTo().defaultContent();
	     driver.switchTo().frame(accountPage.getFrameForElement(driver, By.className("x-grid3-body")));
	     List<WebElement> TodosCasos = driver.findElement(By.className("x-grid3-body")).findElements(By.className("x-grid3-row"));
	     TodosCasos.remove(0);
	     for (WebElement UnC : TodosCasos) {
	    	 String fecha = UnC.findElements(By.tagName("td")).get(12).findElement(By.tagName("div")).getText();
	    	 fecha = fecha.split(" ")[0];
	    	 if (date1.compareTo(sdf.parse(fecha))>0) {
	    		 System.out.println("Equipo: "+UnC.findElements(By.tagName("td")).get(10).findElement(By.tagName("div")).getText());
	    		 assertTrue(!UnC.findElements(By.tagName("td")).get(10).findElement(By.tagName("div")).getText().equals("Cubo magico team"));
	    		 break;
	    	 }   	 
	     }	     
	}
	
	
	@Test(groups = {"CustomerCare", "AdministraciónDeCasos"})
	public void TS15961_360_View_Ver_Equipo_Creador_En_Case_Usuario_Cambia_De_Equipo_Nuevo_Caso_Se_Modifica_El_Campo_Equipo_Del_Creador() throws ParseException{
		CustomerCare page = new CustomerCare(driver);
		page.elegircaso();
		page.crearCaso("Fernandoasd Careeeeee");
		List <WebElement> ec = driver.findElements(By.cssSelector(".dataCol.col02.inlineEditWrite"));
		String equipoCreador = ec.get(11).getText();
		Actions action = new Actions(driver);
		action.moveToElement(ec.get(11)).doubleClick().build().perform();
		driver.findElement(By.xpath("//*[@id=\"00Nc0000001iLah\"]")).sendKeys("cambio de equipo");
		List <WebElement> save = driver.findElements(By.name("inlineEditSave"));
		for (WebElement x : save) {
			if (x.getAttribute("value").contains("Guardar")) {
				x.click();
				break;
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> nec = driver.findElements(By.cssSelector(".dataCol.col02.inlineEditWrite"));
		String NequipoCreador = nec.get(11).getText();
		Assert.assertTrue(equipoCreador != NequipoCreador);
	}
}
