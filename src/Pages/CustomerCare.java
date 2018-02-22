package Pages;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Tests.TestBase;

public class CustomerCare extends BasePage {
	
	public CustomerCare(WebDriver driver){
		setupNuevaPage(driver);
        PageFactory.initElements(driver, this);
	}
	
	
	//Case information

	@FindBy (how = How.CSS, using = ".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")
	private WebElement panelder;
	
	@FindBy (how = How.CSS, using = ".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")
	private WebElement panelizq;
	
	@FindBy (how = How.CSS, using = ".slds-text-body_regular.spacer.acct-spacer")
	private WebElement paneldatospersonaleson;
	
	@FindBy (how = How.CSS, using = ".acct-info.ng-hide")
	private WebElement paneldatospersonalesoff;
	
	@FindBy (how = How.CSS, using = ".slds-p-right--x-small.via-slds-story-cards--header-title")
	private WebElement ultimasgestioneson;
	
	@FindBy (how = How.CLASS_NAME, using = "ng-hide")
	private WebElement ultimasgestonesoff;
	
	@FindBy (how =How.CLASS_NAME, using = "sidebar-actions-header")
	private WebElement iniciargestionespanel;
	
	@FindBy(how = How.CLASS_NAME, using = "promotions-section-header")
	private WebElement promocionespanel;
	
	@FindBy (how = How.CLASS_NAME, using = "abandoned-section")
	private WebElement gestionesabandonadaspanel;
	
	@FindBy (how = How.CLASS_NAME, using = "profile-box")
	private WebElement datoscomerciales;
	
	@FindBy (how = How.ID, using = "text-input-01")
	private WebElement picklistperfil;
	
	@FindBy (how = How.CSS, using = ".slds-button.slds-button--neutral.profile-tags-btn")
	private WebElement btnsperfil;
	
	@FindBy(how = How.XPATH, using = "//input[@id='phSearchInput']")
	private WebElement buscador;
	
	@FindBy(how = How.ID, using = "00Nc0000001pSW6_ileinner")
	private WebElement editstatus;
	
	@FindBy(how = How.ID, using= "00Nc0000001pSW6")
	private WebElement listeditstatus;
	
	@FindBy(how = How.ID, using= "00Nc0000001pSVd_ileinner")
	private WebElement editstatus2;
	
	@FindBy(how = How.ID, using= "00Nc0000001pSVd")
	private WebElement listeditstatus2;
	
	@FindBy(how = How.ID, using= "00Nc0000001iLaY_ileinner")
	private WebElement editfraude;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\'00Nc0000001iLaY\']")
	private WebElement checkfraude;
	
	@FindBy(how= How.XPATH, using= "//*[@id=\'topButtonRow\']/input[1]")
	private WebElement editsave;
	
	@FindBy(how=How.CSS, using= ".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")
	private WebElement buscargestion;
	
	@FindBy(css = ".x-plain-header.sd_primary_tabstrip.x-unselectable .x-tab-strip-closable")
	private List<WebElement> pestañasPrimarias;
	
	@FindBy(css = ".x-grid3-cell-inner.x-grid3-col-ACCOUNT_NAME")
	private List<WebElement> cuentas;
	
	@FindBy(css = ".x-menu-item.standardObject.sd-nav-menu-item")
	private List<WebElement> desplegable;
	
	@FindBy(css = ".x-plain-body.sd_nav_tabpanel_body.x-tab-panel-body-top .x-tab-strip-closable")
	private List<WebElement> pestañasSecundarias;
	
	@FindBy(css = ".console-card.active")
	public List<WebElement> lineasPrepago;
	
	@FindBy(css = ".via-slds.slds-m-around--small.ng-scope")
	private List<WebElement> tarjetasHistorial;
	
	@FindBy(css = ".x-panel.view_context.x-border-panel")
	private List<WebElement> panelesLaterales;
	
	@FindBy(css = ".sd_secondary_container.x-border-layout-ct")
	protected List<WebElement> panelesCentrales;
	
	@FindBy(css = ".x-btn-small.x-btn-icon-small-left")
	private WebElement selector;
	
	@FindBy(css = ".x-plain-body.sd_nav_tabpanel_body.x-tab-panel-body-top iframe")
	private WebElement marcoCuentas;
	
	@FindBy(name = "fcf")
	private WebElement selectCuentas;
	
	@FindBy(xpath = "//input[@ng-model='searchTerm']")
	protected WebElement buscadorGestiones;
	
	@FindBy(css = ".console-flyout.active.flyout .icon.icon-v-troubleshoot-line")
	private WebElement btn_ProblemaConRecargas;
	
	@FindBy(css = ".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")
	private WebElement panelDerechoColapsado;
	
	@FindBy(css = "icon icon-v-close")
	private WebElement cerrarFlyout;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral slds-truncate']")
	public List<WebElement> gestionesEncontradas;


	public void elegirCuenta(String nombreCuenta) {		
		driver.switchTo().defaultContent();
		Boolean flag = false;
		if (pestañasPrimarias.size() > 0) {
			for (WebElement t : pestañasPrimarias) {
				if (t.getText().equals(nombreCuenta)) {
					flag = true;
					t.click();
					// Verificar que exista la pestaña Servicios almenos
				} else {
					WebElement btn_cerrar = t.findElement(By.className("x-tab-strip-close"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_cerrar);	
				}
			}
		}
	
		if (flag == false) {
			if  (!selector.getText().equalsIgnoreCase("Cuentas")) {
				WebElement btnSplit = selector.findElement(By.className("x-btn-split"));
				Actions builder = new Actions(driver);   
				builder.moveToElement(btnSplit, 245, 20).click().build().perform();
				for (WebElement op : desplegable) {
					if (op.getText().equalsIgnoreCase("Cuentas")) op.click();
				}
			}
					
			driver.switchTo().frame(marcoCuentas);
			Select field = new Select(selectCuentas);
			if (!field.getFirstSelectedOption().getText().equalsIgnoreCase("Todas las cuentas")) {
				field.selectByVisibleText("Todas las cuentas");
				TestBase.sleep(1500);
			}
			
			char char0 = nombreCuenta.toUpperCase().charAt(0);
			driver.findElement(By.xpath("//div[@class='rolodex']//span[contains(.,'" + char0 + "')]")).click();
			sleep(1800);
			
			//waitForVisibilityOfElementLocated(By.cssSelector(".x-grid3-cell-inner.x-grid3-col-ACCOUNT_NAME"));
			for (WebElement c : cuentas) {
				//MEJORAR
				if (c.getText().equalsIgnoreCase(nombreCuenta)) {
					(new Actions(driver)).click(c.findElement(By.tagName("a"))).build().perform();
					c.findElement(By.tagName("a")).click();
					TestBase.sleep(1000);
					esperarAQueCargueLaCuenta();
					return;
				}
			}
		}
	}
	
	public void irACasos() {
		driver.switchTo().defaultContent();
		if  (!selector.getText().equalsIgnoreCase("Casos")) {
			WebElement btnSplit = selector.findElement(By.className("x-btn-split"));
			Actions builder = new Actions(driver);   
			builder.moveToElement(btnSplit, 245, 20).click().build().perform();
			for (WebElement op : desplegable) {
				if (op.getText().equalsIgnoreCase("Casos")) {
					op.click();
					break;
				}
			}
		}

		driver.switchTo().frame(marcoCuentas);
	}
	
	public WebElement obtenerFechaHasta() {
		waitForVisibilityOfElementLocated(By.xpath("//input[@name='maxDate']"));
		return driver.findElement(By.xpath("//input[@name='maxDate']"));
	}
	
	public String obtenerEstadoDelCaso(String numCaso) {
		List<WebElement> registros = driver.findElements(By.cssSelector(".x-grid3-row-table tr"));
		for (WebElement reg : registros) {
			if (reg.findElement(By.cssSelector(".x-grid3-col-CASES_CASE_NUMBER")).getText().contains(numCaso)) {
				return reg.findElement(By.cssSelector(".x-grid3-td-CASES_STATUS")).getText();
			}
		}
		return null;
	}
	
	private void esperarAQueCargueLaCuenta() {
		driver.switchTo().defaultContent();
		TestBase.sleep(4000);
		TestBase.dynamicWait().until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sd_secondary_container.x-border-layout-ct"), 2));
		cambiarAFrameActivo();
		TestBase.sleep(1000);
		TestBase.dynamicWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary")));
	}
	
	public void cerrarTodasLasPestañas() {
		driver.switchTo().defaultContent();
		if (pestañasPrimarias.size() > 0) {
			for (WebElement t : pestañasPrimarias) {
					WebElement btn_cerrar = t.findElement(By.className("x-tab-strip-close"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_cerrar);	
			}
		}
	}
	
	public void limpiarTodo() {
		driver.switchTo().defaultContent();
		for (WebElement t : pestañasSecundarias) {
			if(t.getText().equals("Servicios")) t.click();
			else {
				WebElement btn_cerrar = t.findElement(By.className("x-tab-strip-close"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_cerrar);
			}
		}
	
		intentarAbrirPanelDerecho();
		cambiarAFrameActivo();
		cerrarFlyout();
	}
	
	public void panelDerecho() {
		driver.switchTo().defaultContent();
		WebElement panelDerecho = null;
		intentarAbrirPanelDerecho();
		panelDerecho = panelesLaterales.get(0);
		driver.switchTo().frame(panelDerecho.findElement(By.cssSelector("iframe")));
	}
	
	public void panelIzquierdo() {
		driver.switchTo().defaultContent();
		WebElement panelIzquierdo = null;
		panelIzquierdo = panelesLaterales.get(1);
		driver.switchTo().frame(panelIzquierdo.findElement(By.cssSelector("iframe")));
	}
	
	public void buscarGestion(String gest) {
		panelDerecho();
		buscadorGestiones.clear();
		buscadorGestiones.sendKeys(gest);
	}
	
	public WebElement obtenerTarjetaHistorial(String tituloTarjeta) {
		(new WebDriverWait(driver, 2)).until(ExpectedConditions.visibilityOfAllElements(tarjetasHistorial));
		for (WebElement t : tarjetasHistorial) {
			if (t.getText().toLowerCase().contains(tituloTarjeta.toLowerCase())) {
				return t;
			}
		}
		System.err.println("ERROR: No se encontró la tarjeta \'" + tituloTarjeta + "\'");
		return null;
	}
	
	public WebElement obtenerAccionLineaPrepago(String accion) {
		for (WebElement linea : lineasPrepago) {
			if (!linea.getAttribute("class").contains("expired")) {
				List<WebElement> elementos = linea.findElements(By.cssSelector(".slds-text-body_regular"));
				for (WebElement e : elementos) {
					if (e.getText().toLowerCase().contains(accion.toLowerCase())) {
							return e;
					}
				}
			}
		}
		System.err.println("ERROR: No se encontró una línea Prepago activa");
		return null;
	}
	
	public void irAGestion(String gest) {
		buscarGestion(gest);
		if (gestionesEncontradas.isEmpty()) {
			System.err.println("ERROR: No existe la gestión \'" + gest + "\'");
			Assert.assertFalse(gestionesEncontradas.isEmpty());
		}
		gestionesEncontradas.get(0).click();
		if (gest.equals("Débito automático")) TestBase.sleep(6500);
		else TestBase.sleep(3000);
		if (gest.equals("Historial de Packs")) TestBase.sleep(1500);
		cambiarAFrameActivo();
	}
	
	public void irAGestiones() {
		driver.findElement(By.cssSelector(".console-card.active .card-top")).click();
		List<WebElement> accionesFlyout = driver.findElements(By.cssSelector(".community-flyout-actions-card li"));
		for (WebElement accion : accionesFlyout) {
			if (accion.getText().contains("Gestiones")) {
				accion.click();
				break;
			}
		}
		TestBase.sleep(4000);
		cambiarAFrameActivo();
	}
	
	public void irADetalleDeConsumos() {
		obtenerAccionLineaPrepago("Detalle de Consumos").click();
		TestBase.sleep(3000);
		cambiarAFrameActivo();
	}
	
	public void irAHistoriales() {
		obtenerAccionLineaPrepago("Historiales").click();
		TestBase.sleep(3000);
		cambiarAFrameActivo();
	}
	
	public void irAAhorrá() {
		obtenerAccionLineaPrepago("Ahorrá").click();
		TestBase.sleep(3000);
		cambiarAFrameActivo();
	}
	
	public void irAMisServicios() {
		obtenerAccionLineaPrepago("Mis Servicios").click();
		TestBase.sleep(3000);
		cambiarAFrameActivo();
	}
	
	public void irAProblemasConRecargas() {
		for (WebElement linea : lineasPrepago) {
			if (!linea.getAttribute("class").contains("expired")) {
					linea.findElement(By.cssSelector(".card-top")).click();
					//linea.click();
					TestBase.dynamicWait().until(ExpectedConditions.visibilityOf(btn_ProblemaConRecargas));
					btn_ProblemaConRecargas.click();
					break;
			}
		}
		TestBase.sleep(4000);
		cambiarAFrameActivo();
	}
	
	public void irAHistorialDeRecargas() {
		verDetallesHistorial("Historial de Recargas");
		TestBase.sleep(3000);
		cambiarAFrameActivo();
	}
	
	public void irAHistorialDePacks() {
		verDetallesHistorial("Historial de Packs");
		TestBase.sleep(3000);
		cambiarAFrameActivo();		
	}
	
	public void irAHistorialDeRecargasSOS() {
		verDetallesHistorial("Historial de Recargas S.O.S");
		TestBase.sleep(3000);
		cambiarAFrameActivo();		
	}
	
	public void irAHistorialDeAjustes() {
		verDetallesHistorial("Historial de Ajustes");
		TestBase.sleep(3000);
		cambiarAFrameActivo();	
	}
	
	public void irAResumenDeCuenta() {
		driver.findElement(By.xpath("//ul[@class='actions']//a[contains(.,'Resumen de Cuenta')]")).click();
		TestBase.sleep(4000);
		cambiarAFrameActivo();
	}
	
	public WebElement obtenerPestañaActiva() {
		driver.switchTo().defaultContent();
		TestBase.sleep(3000);
		return driver.findElement(By.cssSelector(".sd_secondary_tabstrip .x-tab-strip-closable.x-tab-strip-active"));
	}
	
	// -----------------------------------------------------------------------------------------------------
	// 											METODOS PRIVADOS
	// -----------------------------------------------------------------------------------------------------

	private void cambiarAFrameActivo() {
		driver.switchTo().defaultContent();
		for (WebElement t : panelesCentrales) {
			if (!t.getAttribute("class").contains("x-hide-display")) {
				driver.switchTo().frame(t.findElement(By.cssSelector("div iframe")));
			}
		}
	}
	
	private void verDetallesHistorial(String nombreHistorial) {
		obtenerTarjetaHistorial(nombreHistorial).findElement(By.cssSelector(".slds-button.slds-button--brand")).click();
		cambiarAFrameActivo();
	}
	
	private void intentarAbrirPanelDerecho() {
		try { 
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			panelDerechoColapsado.click();
		} catch (NoSuchElementException|ElementNotVisibleException e) {	}
		finally {
			TestBase.sleep(2000);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
	}
	
	private void cerrarFlyout() {
		for (WebElement l : lineasPrepago) {
			if (l.getAttribute("class").contains("selected")) {
				l.click();
				TestBase.sleep(1000);
			}
		}
	}
	
	
	public void goToLeftPanel(WebDriver driver, String selection) {
		WebElement element = driver.findElement(By.className("x-btn-split"));	
		Actions builder = new Actions(driver);   
		builder.moveToElement(element, 245, 20).click().build().perform();
		List <WebElement> cuentas = driver.findElements(By.className("x-menu-item-text"));
		switch(selection) {
		case "Cuentas":
			for (WebElement x : cuentas) {
				if (x.getText().toLowerCase().contains("cuentas")) {
					x.click();
				}
			}
		case "Casos":
			for (WebElement x : cuentas) {
				if (x.getText().toLowerCase().contains("casos")) {
					x.click();
				}
			}	
		}
	}
	
	
	public void obligarclick(WebElement element) {	
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
	    element.click();
	}
		
	public void elegircaso() {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel(driver, "Casos");
		driver.switchTo().defaultContent();
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		Select field = new Select(driver.findElement(By.name("fcf")));
		BasePage cambioFrameByID=new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.name("fcf")));
		driver.findElement(By.id("00Bc0000001NxcT_listSelect")).click();
		field.selectByVisibleText("Todos los casos");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
	}
	
	public void elegircuenta(String cuenta) {
		goToLeftPanel(driver, "Cuentas");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Todas las cuentas");		
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accounts2 = driver.findElements(By.xpath("//*[text() ='"+cuenta+"']"));
		accounts2.get(0).click();
		accounts2.get(0).click();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {driver.switchTo().alert().accept();} catch (org.openqa.selenium.NoAlertPresentException e) {}
		driver.switchTo().defaultContent();
	}
		
	public void openrightpanel() {		
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")).size() != 0) {
			panelder.click();
		}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	public void openleftpanel() {	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).size() != 0) {
			panelizq.click();
		}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	public void closeleftpanel() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-mini.x-layout-mini-west.x-layout-mini-custom-logo")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-mini.x-layout-mini-west.x-layout-mini-custom-logo")).click();
			driver.findElement(By.cssSelector(".x-layout-mini.x-layout-mini-west.x-layout-mini-custom-logo")).click();
		}
	}
	
	public void closerightpanel() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-mini.x-layout-mini-east.x-layout-mini-custom-logo")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-mini.x-layout-mini-east.x-layout-mini-custom-logo")).click();
		}
	}
		
	public void leftpanel() {
		List <WebElement> btns = driver.findElements(By.className("ext-webkit ext-chrome"));
		System.out.println(btns.size());
	}
		
	public void GestionAbandonadapanel() {
		driver.findElement(By.className("abandoned-section")).click();
	}
		
	public void panelizq(String panel) {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> asd = driver.findElements(By.cssSelector(".slds-p-right--x-small.via-slds-story-cards--header-title"));	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		switch(panel) {
		case "todosOFF":
			paneldatospersonaleson.click();
			asd.get(1).click();
			break;
		case "todosON":
			paneldatospersonaleson.click();
			asd.get(0).click();
			asd.get(1).click();
			break;
		case "perfil":
			asd.get(0).click();
			break;
		}		
	}
	
	public void verificacrhideleft(String panel) {
		List <WebElement> hides = driver.findElements(By.className("ng-hide"));
		switch(panel) {
		//validacionesindividuales
		case "datospersonales":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
		case "perfil":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
		case "ultimasgestiones":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
			////
		case "todosOFF":
			Assert.assertTrue(hides.get(0).isEnabled());
			Assert.assertTrue(hides.get(1).isEnabled());
			Assert.assertTrue(hides.get(2).isEnabled());
			break;
		case "todosON":
			List <WebElement> hides2 = driver.findElements(By.className("ng-hide"));
			if (hides2.size()!=0)
				Assert.assertTrue(true);
			break;
		}
	}
		
	public void panelder(String panel) {	
		switch(panel) {		
		case "iniciargestiones":
			iniciargestionespanel.click();
			break;
		case "promociones":
			promocionespanel.click();
			break;
		case "gestionesabandonadas":
			gestionesabandonadaspanel.click();
			break;
		case "todos":
			iniciargestionespanel.click();
			promocionespanel.click();
			gestionesabandonadaspanel.click();
			break;
		}
	}
	
	public void verificarhideright(String panel) {
		List <WebElement> hides = driver.findElements(By.className("ng-hide"));
		switch(panel) {
		case "iniciargestiones":
			Assert.assertTrue(driver.findElement(By.cssSelector(".actions-content.ng-hide")).isEnabled());
			break;
		case "promociones":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
		case "gestionesabandonadas":
			Assert.assertTrue(driver.findElement(By.cssSelector(".abandoned-content.ng-hide")).isEnabled());
			break;
		case "todosOFF":
			Assert.assertTrue(driver.findElement(By.cssSelector(".actions-content.ng-hide")).isEnabled());
			Assert.assertTrue(hides.get(0).isEnabled());
			Assert.assertTrue(driver.findElement(By.cssSelector(".abandoned-content.ng-hide")).isEnabled());
			break;
		case "todosON":
			List <WebElement> hides2 = driver.findElements(By.className("ng-hide"));
			if (hides2.size()!=0)
				Assert.assertTrue(true);
			if (driver.findElements(By.cssSelector(".actions-content.ng-hide")).size()!=0)
				Assert.assertTrue(true);
			if (driver.findElements(By.cssSelector(".abandoned-content.ng-hide")).size()!=0)
				Assert.assertTrue(true);
		}
	}
		
	public void verificarnohidedatoscomerciales() {
		Assert.assertTrue(datoscomerciales.isEnabled());
	}
	
	public void verificaciondebotonesdegestion() {
		List <WebElement> btns = driver.findElements(By.cssSelector(".slds-text-body_regular.ta-button-font"));
		for(int i=0; i < 22; i++){
			btns.get(i).isEnabled();
		}
		Assert.assertEquals(btns.size(),22);	
	}
		
	public void verificarpicklist() {
		picklistperfil.isEnabled();
	}
		
	public void funcionamientopicklist() {
		List <WebElement> asl = driver.findElements(By.cssSelector(".slds-lookup__item-action.slds-lookup__item-action--label.customer-story-label"));
		for(int i=0; i<6; i++){
			picklistperfil.click();
			asl.get(i).click();			
		}
	}
		
	public void validarbtnsperfil(String btn) {	
		List <WebElement> asl = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.profile-tags-btn"));
		System.out.println(asl.size());
		switch (btn) {
		case "Preocupaciones":
			asl.get(0).isEnabled();
			break;
		case "Productos de interes":
			asl.get(1).isEnabled();
			break;
		case "Criterios de compra":
			asl.get(2).isEnabled();
			break;
		case "Familia":
			asl.get(3).isEnabled();
			break;
		case "Intereses Personales":
			asl.get(4).isEnabled();
			break;
		}
	}
	
	public void comparaciondefechas() throws ParseException {
		List<String> expected = new ArrayList<String>();
		List<WebElement> profileinfo = driver.findElements(By.className("story-field"));	
		for(int i=1; i<profileinfo.size(); i+=2){
			String b = (profileinfo.get(i).getText());	
			expected.add(b);
		}
		String d1 = expected.get(0);
		String d2 = expected.get(1);
		System.out.println(d1);
		System.out.println(d2);
		d1.compareTo(d2);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse(d1);
        Date date2 = sdf.parse(d2);
        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));
        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 despues Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 antes Date2");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 igual Date2");
        } else {
            System.out.println("How to get here?");
        }

    }
	
	public void usarpanelcentral(String pestaña) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		switch(pestaña){
		case "Detalles":
			driver.findElement(By.xpath("//*[text() ='Detalles']")).click();
			driver.findElement(By.cssSelector(".x-tab-right.primaryPalette")).click();
			break;
		case "Servicios":
			driver.findElement(By.xpath("//*[text() ='Servicios']")).click();
			driver.findElement(By.xpath("//*[text() ='Servicios']")).click();
			break;
		case "Facturacion":
			driver.findElement(By.xpath("//*[text() ='Facturacion']")).click();
			driver.findElement(By.xpath("//*[text() ='Facturacion']")).click();
			break;
		case "Cambio de ciclo":
			driver.findElement(By.xpath("//*[text() ='Cambio de ciclo']")).click();
			driver.findElement(By.xpath("//*[text() ='Cambio de ciclo']")).click();
			break;
		case "aaaaFernando Care":
			driver.findElements(By.xpath("//*[text() ='aaaaFernando Care']")).get(1).click();
			//driver.findElement(By.cssSelector(".x-tab-right.primaryPalette")).click();
			break;
		}	
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(1));
	}
		
	public void validarStatus(String status) {
		driver.findElement(By.xpath("//*[@id=\'00Nc0000001pSW6_ileinner\']"));	
		WebElement asl = driver.findElement(By.xpath("//*[@id=\"ep_Account_View_j_id4\"]/div[2]/div[2]/table/tbody/tr[2]/td[4]"));
		switch(status) {
		case "Active":
			Assert.assertEquals(asl.getText(), status);	
			break;
		case "Inactive":
			Assert.assertEquals(asl.getText(), status);	
			break;	
		case "Expired":
			Assert.assertEquals(asl.getText(), status);	
			break;
		case "Pending":
			Assert.assertEquals(asl.getText(), status);	
			break;
		case "Suspended":
			Assert.assertEquals(asl.getText(), status);	
			break;
		}
	}
		
	public void SelectGestion(String gestion) {
		openrightpanel();
		driver.switchTo().defaultContent();
		BasePage cambioFrameByID = new BasePage(driver);
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")));
		driver.findElement(By.cssSelector(".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")).sendKeys(gestion);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> btns = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.slds-truncate"));
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+btns.get(0).getLocation().y+")");
		btns.get(0).click();
		driver.switchTo().defaultContent();
	}
		
	public void detectarframe() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		// System.out.println(asl.get(0).getText());
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		int i = 0;
		String b;
		for (WebElement frame2: frame1){
			try {
				driver.switchTo().frame(frame2);
				driver.findElement(By.cssSelector(".x-grid3-cell-inner.x-grid3-col-CASES_CASE_NUMBER"));
				b =	Integer.toString(i);
				System.out.println("frame1 : "+ b);
				break;
			} catch (NoSuchElementException noSuchElementExcept) { b =Integer.toString(i);System.out.println(b+ " no"); driver.switchTo().defaultContent();i++;}
		}
	}
		
	public void ValidarCambioDeCiclo() {
		driver.switchTo().defaultContent();
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(4));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//driver.findElement(By.cssSelector("slds-form-element__control"));
		List <WebElement> asl = driver.findElements(By.className("slds-form-element__control"));
		for (WebElement x : asl) {
			Assert.assertTrue(x.getText().toLowerCase().contains("En este formulario podrás cambiar la fecha en la cual se te empieza a facturar cada mes"));
		}
	}
		
	public void ValidarBtnsGestion(String gestion) {
		openrightpanel();	
		driver.findElement(By.cssSelector(".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")).sendKeys(gestion);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> btns = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.slds-truncate"));
		Assert.assertTrue(btns.get(0).getText().contains(gestion));
	}
		
	public void usarbuscadorsalesforce(String busqueda) {
		buscador.sendKeys(busqueda);
		buscador.submit();
	}	
	
	public void validarbuscadorsalesforce() {
		Assert.assertTrue(buscador.isEnabled());
	}
	
	public void btnsdetallesedit(String btn) {
		switch(btn) {
		case "Guardar":
			driver.findElement(By.xpath("//*[@id=\'topButtonRow\']/input[1]")).click();
			break;
		case "Cancelar":
			driver.findElement(By.xpath("//*[@id=\'topButtonRow\']/input[2]")).click();
			break;
		}
			//driver.findElement(By.xpath("//*[@id=\'topButtonRow\']/input[1]"))
	}
		
	public void validarlabusqueda(String busqueda) {
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(1));
		List<WebElement>asl = driver.findElements(By.cssSelector(".list0"));
		//System.out.println(asl.size());
		//System.out.println(asl.get(0).getText());
		Assert.assertTrue(asl.get(0).getText().contains(busqueda));
	}
		
	public void validarvistaconsumidor() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".ng-not-empty.ng-valid")).isEnabled());
	}
	
	public void clienteinactivo() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Actions action = new Actions(driver);   
		try {action.moveToElement(editstatus).doubleClick().perform();
		try {
			Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			setSimpleDropdown(listeditstatus, "Inactive");
		} catch (NoSuchElementException e) {}
		try {
			action.moveToElement(editstatus2).doubleClick().perform();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			setSimpleDropdown(listeditstatus2, "No");
		} catch (NoSuchElementException e) {}
	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	public void clienteactivo() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Actions action = new Actions(driver);  
		try {
			action.moveToElement(editstatus).doubleClick().perform();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		setSimpleDropdown(listeditstatus, "Active");
		} catch (NoSuchElementException e) {}
		try {
			action.moveToElement(editstatus2).doubleClick().perform();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			setSimpleDropdown(listeditstatus2, "Yes");
		} catch (NoSuchElementException e) {}
	}
		
	public void seleccionarfraude(String check) {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Actions action = new Actions(driver);   
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+editfraude.getLocation().y+")");
	    editfraude.click();
		action.moveToElement(editfraude).doubleClick().perform();
		switch(check) {
		case "si":
			if ( !driver.findElement(By.id("00Nc0000001iLaY")).isSelected() ){
				driver.findElement(By.id("00Nc0000001iLaY")).click();}
				break;
		case "no":
			if ( driver.findElement(By.id("00Nc0000001iLaY")).isSelected() ){
				driver.findElement(By.id("00Nc0000001iLaY")).click();}
				break;
		}
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
		
	public void cerrarultimapestaña() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {driver.switchTo().alert().accept();} catch (org.openqa.selenium.NoAlertPresentException e) {}
		driver.switchTo().defaultContent();
		try {driver.findElement(By.name("cancel")).click();;} catch (NoSuchElementException e) {}
		List<WebElement> asl = driver.findElements(By.className("x-tab-strip-close"));
		for (WebElement e : asl) {			
			try {((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);} catch (org.openqa.selenium.StaleElementReferenceException b) {}
		}
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
		
	public void validarerrorpaso0() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID=new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".message.description.ng-binding.ng-scope")));
		WebElement element = driver.findElement(By.cssSelector(".message.description.ng-binding.ng-scope"));
		Assert.assertTrue(element.getText().toLowerCase().contains("en este momento no se puede efectuar este tipo de gestión porque su cuenta está en estado inactiva."));
		driver.switchTo().defaultContent();
	}
		
	public void validarerrorpaso1(String valid) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("Validaciones_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("OrderReview_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		switch (valid) {
		case "cuenta billing fraude no aparece":
			List<WebElement> asl = driver.findElements(By.id("tree0-node1__label"));
			Assert.assertEquals(asl.size(),3);	
			break;
		case "servicio cambia de cuenta billing":			
			break;
		}
	}
			
	public void serviciocambiadecuenta(String servicio, String cuenta) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("Validaciones_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("OrderReview_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> service = driver.findElements(By.cssSelector(".slds-checkbox__label"));
		//System.out.println("Tamaño: "+service.size());
		for(int i=0; i<service.size() ; i++){
			if(service.get(i).getText().equals(servicio)) {
				service.get(i).click();
			}
		}
		obligarclick(driver.findElement(By.id("BillingAccountFrom_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> cuentas = driver.findElements(By.cssSelector(".slds-radio"));
		List<WebElement> radiobtn = driver.findElements(By.xpath("//input[@name='options' and @type='radio']"));
		int a;
		for(int i=0; i<cuentas.size() ; i++){
			if(cuentas.get(i).getText().equals(cuenta)) {
				WebElement local_radio= radiobtn.get(i);
				String value=local_radio.getAttribute("value");
				System.out.println(value);
				a= i - 2;
				System.out.println(a);
			}
		}
	}
		
	public void crearsugerencia(String categoria, String subcategoria, String gestion) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		setSimpleDropdown(driver.findElement(By.id("Category")), categoria);
		setSimpleDropdown(driver.findElement(By.id("Subcategory")), subcategoria);
		driver.findElement(By.id("Comment")).sendKeys("Esto es un comentario");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}		
		switch(gestion) {
		case "crear":
			obligarclick(driver.findElement(By.id("ManagementType_nextBtn")));
			break;
		case "cancel":			
			driver.findElement(By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope")).click();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("alert-ok-button")).click();
			break;
		}				
	}
		
	public void clickContinueError() {
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID=new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope")));
	    try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    List <WebElement> emergente= driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
	    emergente.get(1).click();
	    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	 }
		
	public void validarCheckBox() {
		WebElement opb= driver.findElement(By.id("TaxConditionDNIOnly"));
		boolean a=false;
		if(opb.isDisplayed())
			a=true;
		assertTrue(a);
	}
	
	public void validarDniACuit() {
		WebElement dni= driver.findElement(By.cssSelector(".slds-form-element__label.ng-binding.ng-scope"));
		boolean a=false;
		if(dni.isDisplayed())
			a=true;
		assertTrue(a);
	}
		
	public void validarError() {
		WebElement error = driver.findElement(By.id("prompt-heading-id"));
		boolean a = false;
		if (error.isDisplayed()) {
			a = true;
			assertTrue(a);
		}	
	}
		
	public boolean validarDatos() {
		boolean a = false;
		if (driver.findElement(By.className("icon-v-chat2-line")).isEnabled() && driver.findElement(By.className("icon-v-phone-line")).isEnabled() 
			&& driver.findElement(By.className("icon-v-email-line")).isEnabled() && driver.findElement(By.className("icon-v-payment-line")).isEnabled()) {
			a = true;
		}
		return a;
	}
		
	public void goToLeftPanel2(WebDriver driver, String selection) {
		try {
			driver.findElement(By.className("x-btn-split"));
		}catch(NoSuchElementException noSuchElemExcept) {
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			for (WebElement frame : frames) {
				try {
					driver.findElement(By.className("x-btn-split"));
					break;
				}catch(NoSuchElementException noSuchElemExceptInside) {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(frame);
				}
			}
		}
		WebElement dropDown = driver.findElement(By.className("x-btn-split"));
		Actions builder = new Actions(driver);   
		builder.moveToElement(dropDown, 245, 20).click().build().perform();
		List<WebElement> options = driver.findElements(By.tagName("li"));
		for(WebElement option : options) {
			if(option.findElement(By.tagName("span")).getText().toLowerCase().equals(selection.toLowerCase())) {
				option.findElement(By.tagName("a")).click();
				//System.out.println("Seleccionado"); //13/09/2017 working.
				break;
			}
		}		
	}
	
	public boolean ElementPresent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickSiguiente(WebElement element) {
		if (element.isEnabled()){
			element.click();
		}
	}
	
	public void calendario (WebElement element, String fecha) {
		driver.switchTo().defaultContent();
		element.sendKeys(fecha);		
	}
	
	public void ciclodefacturacionpaso2() {
		 try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		 driver.findElement(By.className("slds-checkbox--faux")).click();
		 //Assert.assertTrue(driver.findElement(By.className("slds-checkbox--faux")).isSelected());
		 obligarclick(driver.findElement(By.id("BillingCycle_nextBtn")));
	}
	
	public void billings(List <WebElement> element) {
		for (int i = 0; i < element.size(); i++) {
			element.get(i).click();
		}
	}
		
	public boolean validarFecha(String fecha, String formato) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);
			formatoFecha.setLenient(false);
			formatoFecha.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
		
	public void editarcuenta(String cuenta, String fraude,String Status) {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {} catch (org.openqa.selenium.UnhandledAlertException e){driver.switchTo().alert().accept();}
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		goToLeftPanel(driver, "Cuentas");
		driver.switchTo().frame(frame0);

		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Todas las cuentas");		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accounts2 = driver.findElements(By.xpath("//*[text() ='"+cuenta+"']"));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		accounts2.get(0).click();
		accounts2.get(0).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		usarpanelcentral("Detalles");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		switch(Status) {
		case "active":
			clienteactivo();
			if(!cuenta.contains("Billing")){
				clienteactivo2();
			}			
			break;
		case "inactive":
			clienteinactivo();
			if(!cuenta.contains("Billing")){
				clienteinactivo2();
			}	
			break;
		}
		seleccionarfraude(fraude);
		obligarclick(editsave);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cerrarultimapestaña();
	}

	public void clienteactivo2() {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.xpath("//*[@id='lookup003c000000owQym00Nc0000001pSW3']")));	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		BasePage cambioFrameByID=new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("00Nc0000001pSdD_ileinner")));
		Actions action = new Actions(driver);   
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+driver.findElement(By.id("00Nc0000001pSdD_ileinner")).getLocation().y+")");
		driver.findElement(By.id("00Nc0000001pSdD_ileinner")).click();
		action.moveToElement(driver.findElement(By.id("00Nc0000001pSdD_ileinner"))).doubleClick().perform();
		if (!driver.findElement(By.id("00Nc0000001pSdD")).isSelected()) {
			driver.findElement(By.id("00Nc0000001pSdD")).click();
		}
		action.moveToElement(driver.findElement(By.id("00Nc0000001pSdR_ileinner"))).doubleClick().perform();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		setSimpleDropdown(driver.findElement(By.id("00Nc0000001pSdR")), "Activo");
		obligarclick(editsave);
		usarpanelcentral("Detalles");			
	}
		
	public void clienteinactivo2() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.xpath("//*[@id='lookup003c000000owQym00Nc0000001pSW3']")));	
		try {Thread.sleep(20000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID=new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("00Nc0000001pSdD_ileinner")));
		obligarclick(driver.findElement(By.id("00Nc0000001pSdD_ileinner")));
		Actions action = new Actions(driver);   
		action.moveToElement(driver.findElement(By.id("00Nc0000001pSdR_ileinner"))).doubleClick().perform();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		setSimpleDropdown(driver.findElement(By.id("00Nc0000001pSdR")), "Inactivo");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		action.moveToElement(driver.findElement(By.id("00Nc0000001pSdD_ileinner"))).doubleClick().perform();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (driver.findElement(By.id("00Nc0000001pSdD")).isSelected()){
			driver.findElement(By.id("00Nc0000001pSdD")).click();
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(editsave);
		usarpanelcentral("Detalles");
	}
	
	public boolean validarpaso0clienteinactivo(){
		boolean a = false;
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".message.description.ng-binding.ng-scope")));
		WebElement msg = driver.findElement(By.cssSelector(".message.description.ng-binding.ng-scope"));
		if (msg.getText().contains("su cuenta está en estado inactiva")) {
			a = true;
		}
		return a;
	}
	
	public void validarhistorialdecuentas() {
		driver.switchTo().defaultContent();
		Accounts accpage = new Accounts(driver);
		driver.switchTo().frame(accpage.getFrameForElement(driver, By.id("001c000001BMqtL_RelatedEntityHistoryList_title")));
		Assert.assertTrue(driver.findElement(By.id("001c000001BMqtL_RelatedEntityHistoryList_title")).isEnabled());
		Assert.assertTrue(driver.findElement(By.className("pbBody")).isEnabled());
	}
		
	public void validarcorrectopaso0() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("slds-form-element__control")));
		List<WebElement> asl = driver.findElements(By.className("slds-form-element__control"));
		Assert.assertEquals(asl.get(0).getText(),"En este formulario podrás cambiar la fecha en la cual se te empieza a facturar cada mes.");
		driver.switchTo().defaultContent();
	}
		
	public void validarpaso1cambiodeciclo() {
		usarpanelcentral("Detalles");
		String direccion = driver.findElement(By.xpath("//*[@id=\'acc17_ileinner\']/table/tbody/tr[1]/td")).getText();
		String b = direccion;
		driver.switchTo().defaultContent();
		usarpanelcentral("Cambio de ciclo");
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver,By.cssSelector(".slds-form-element__label.slds-truncate.ng-binding")));
		List<WebElement> asl = driver.findElements(By.cssSelector(".slds-form-element__label.slds-truncate.ng-binding"));
		String c = asl.get(0).getText().replaceAll("[(,)]", "");
		c = c.replaceAll(" ", "");
		c = c.substring(0, c.length() - 4);
		b = b.replaceAll(" ", "");
		b = b.substring(0, c.length());
		Assert.assertTrue(b.equals(c));
		Assert.assertTrue(asl.get(1).getText().contains("Ciclo Actual"));
	}
		
	public void validarcambiodecicloservicios() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		List<WebElement> asd = driver.findElements(By.xpath("//*[text() ='Ver servicios contratados']"));
		asd.get(0).click();
		driver.findElement(By.className("slds-tree__item")).click();
		Assert.assertTrue(driver.findElement(By.className("slds-form-element__control")).isDisplayed());
	}

	public void validarpicklistmandatorio() {
		BasePage cambioFrameByID = new BasePage();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("BillingCycleSelect")));
		obligarclick(driver.findElement(By.id("NewBillingCycle_nextBtn")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\'alert-container\']/div[2]/p")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\'alert-container\']/div[2]/p")).getText().equals("Error: Por favor complete todos los campos requeridos"));
	}
		 
	
	public void paso0CC() {
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("vlc-control-wrapper")));
		List<WebElement> element = driver.findElements(By.cssSelector(".slds-form-element__label.ng-binding.ng-scope"));
		for (WebElement x : element) {
			if (x.getText().toLowerCase().contains("si")) {
				x.click();
				break;
			}
		}
		driver.findElement(By.id("OrderReview_nextBtn")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	public void irAFacturacion() {
		BasePage cambioFrameByID = new BasePage(driver);
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.cssSelector(".slds-grid.slds-p-around--small.slds-wrap.via-slds-story-cards--header.slds-theme--shade.profile-tags-header")));
		List <WebElement> fact = driver.findElements(By.cssSelector(".slds-grid.slds-p-around--small.slds-wrap.via-slds-story-cards--header.slds-theme--shade.profile-tags-header"));
		fact.get(0).click();
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cambiarAFrameActivo();
	}
	
	public void crearCaso(String contacto) {
		BasePage cambioFrameByID = new BasePage();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.className("piped")));
		driver.findElement(By.name("newCase")).click();
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("bottomButtonRow")));
		List <WebElement> dc = driver.findElements(By.name("save"));
		for (WebElement x : dc) {
			if (x.getAttribute("value").contains("¿Desea continuar?")) {
				x.click();
				break;
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.xpath("//*[@id=\"cas3\"]")));
		driver.findElement(By.xpath("//*[@id=\"cas3\"]")).sendKeys(contacto);
		driver.findElement(By.xpath("//*[@id=\"cas7\"]")).click();
		driver.findElement(By.xpath("//*[text() = 'Nuevo']")).click();
		driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("topButtonRow")));
		List <WebElement> save = driver.findElements(By.name("save"));
		for (WebElement x : save) {
			if (x.getAttribute("value").contains("Guardar")) {
				x.click();
				break;
			}
		}
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	public WebElement botonSiguiente() {
		List<WebElement> botones = driver.findElements(By.xpath("//div[contains(@id,'nextBtn')]/p"));
		for (WebElement boton : botones) {
			if (boton.isDisplayed()) return boton;
		}		
		System.out.println("ERROR: No se encontró botón siguiente");
		return null;
	}
	
	public void avanzarAConfigurarAjuste() {
		driver.findElement(By.xpath("//label//span[contains(.,'Un servicio')]")).click();
		botonSiguiente().click();
		waitForVisibilityOfElementLocated(By.xpath("//section[@id='Step-AssetSelection']/section"));
		botonSiguiente().click();
		waitForVisibilityOfElementLocated(By.xpath("//section[@id='Step-TipodeAjuste']/section"));		
		WebElement concepto = driver.findElement(By.xpath("//select[@id='CboConcepto']"));
		WebElement tipoDeCargo = driver.findElement(By.xpath("//select[@id='CboTipo']"));
		WebElement item = driver.findElement(By.xpath("//select[@id='CboItem']"));
		WebElement motivo = driver.findElement(By.xpath("//select[@id='CboMotivo']"));
		(new Select(concepto)).selectByIndex(1);
		(new Select(tipoDeCargo)).selectByIndex(1);
		(new Select(item)).selectByIndex(1);
		(new Select(motivo)).selectByIndex(1);
		botonSiguiente().click();		
		try {
			driver.findElement(By.xpath("//div[@id='RAGetAdjustmentHistory']")).isDisplayed();
			Assert.assertTrue(false); // SE DEBE CORREGIR EL MENSAJE DE ERROR QUE APARECE ACA
			driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
		}
		catch (NoSuchElementException e) {}		
		waitForVisibilityOfElementLocated(By.xpath("//section[@id='Step-HistoricalAdjustments']/section"));
		driver.findElement(By.xpath("//label//span[contains(.,'Si, ajustar')]")).click();
		botonSiguiente().click();
		waitForVisibilityOfElementLocated(By.xpath("//section[@id='Step-adjustmentConfiguration']/section"));
	}
	
	public void unidad(String texto) {
		WebElement unidad = driver.findElement(By.xpath("//select[@id='Unidad']"));
		(new Select(unidad)).selectByVisibleText(texto);
	}
	
	public void buscarCaso(String nCaso) {
		driver.switchTo().defaultContent();
		sleep(1000);
		WebElement Buscador = driver.findElement(By.xpath("//input[@id='phSearchInput']"));
		Buscador.sendKeys(nCaso);
		sleep(2000);
		try {
			driver.findElement(By.className("autoCompleteRowLink")).click();
			sleep(2000);
			Buscador.clear();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			sleep(7000);
			Buscador.submit();
			sleep(1000);
			Buscador.clear();
			sleep(2000);
			BasePage cambioFrameByID = new BasePage();
			int i = 0;
			while (i < 3) {
				try {
					driver.switchTo()
							.frame(cambioFrameByID.getFrameForElement(driver, By.id("searchResultsWarningMessageBox")));
					if (driver.findElement(By.id("searchResultsWarningMessageBox")).isDisplayed()) {
						driver.navigate().refresh();
						sleep(2000);
						i++;
						// System.out.println(i);
					}
				} catch (java.lang.NullPointerException a) {
					sleep(3000);
					driver.switchTo().frame(cambioFrameByID.getFrameForElement(driver, By.id("searchPageHolderDiv")));
					i = 4;
					System.out.println("Segundo Catch");
				}
			}
			sleep(2000);
			WebElement Caso = driver.findElement(By.cssSelector(".listRelatedObject.caseBlock"))
					.findElement(By.cssSelector(".bPageBlock.brandSecondaryBrd.secondaryPalette"))
					.findElement(By.className("pbBody")).findElement(By.className("list"))
					.findElements(By.tagName("tr")).get(1).findElement(By.tagName("th")).findElement(By.tagName("a"));
			Caso.click();
		}
		sleep(5000);
	}
}
