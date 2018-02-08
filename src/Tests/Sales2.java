package Tests;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.CustomerCare;
import Pages.SalesBase;
import Tests.TestBase.IrA;

public class Sales2 extends TestBase{

	SalesBase sb;
	String DNI = "DNI";

	//@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//@AfterMethod
	public void deslogin() {
		sleep(3000);
		driver.get("https://crm--sit.cs14.my.salesforce.com/home/home.jsp?tsid=02u41000000QWha/");
		sleep(10000);
	}
		
	@BeforeClass
	public void init() {
		inicializarDriver();
		sb = new SalesBase(driver);
		loginAndres(driver);
		IrA.CajonDeAplicaciones.Ventas();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		sleep(5000);
		driver.findElement(By.xpath("//a[@href=\'https://crm--sit--c.cs14.visual.force.com/apex/taClientSearch']")).click();
		sleep(7000);
	}
	
	@Test(groups={"Sales", "Nueva Venta", "Ola1"})
	public void TS94698_Nueva_Venta_Modo_de_Entrega_Verificar_Solicitud_de_Domicilio_de_envio_Envio_Estandar(){
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		boolean x = false;
		sleep(15000);
		List<WebElement> cam = driver.findElements(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand"));
		for(WebElement c : cam ){	
			if(c.getText().toLowerCase().equals("cambiar")){
				c.click();
			}
		sleep(7000);	
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(0));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Delivery");
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		}
		sb.elegirplan("Plan con Tarjeta Repro");
		sb.continuar();
		sleep(10000);
		List<WebElement> cont = driver.findElements(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand"));
		for(WebElement c : cont){
			c.getText().equals("Continuar");
			c.click();
				
		}
		sleep(5000);
		CustomerCare page = new CustomerCare(driver);
		WebElement sig = driver.findElement(By.id("LineAssignment_nextBtn"));
		page.obligarclick(sig);
		Select delir= new Select (driver.findElement(By.id("DeliveryServiceType")));
		delir.selectByVisibleText("Env\u00edo Est\u00e1ndar");	
		Assert.assertEquals(delir.getFirstSelectedOption().getText(),"Env\u00edo Est\u00e1ndar");
	}
	
	@Test(groups = { "Sales", "Nueva Venta", "Ola1" })
	public void TS94699_Nueva_Venta_Modo_de_Entrega_Verificar_Solicitud_de_Domicilio_de_envio_Envio_Express() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		boolean x = false;
		sleep(15000);
		List<WebElement> cam = driver.findElements(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand"));
		for (WebElement c : cam) {
			if (c.getText().toLowerCase().equals("cambiar")) {
				c.click();
			}
			sleep(7000);
			List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(frame2.get(0));
			Select env = new Select(driver.findElement(By.id("DeliveryMethodSelection")));
			env.selectByVisibleText("Delivery");
			driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
			sleep(10000);
			driver.switchTo().defaultContent();
		}
		sb.elegirplan("Plan con Tarjeta Repro");
		sb.continuar();
		sleep(10000);
		List<WebElement> cont = driver.findElements(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand"));
		for (WebElement c : cont) {
			c.getText().equals("Continuar");
			c.click();

		}
		sleep(5000);
		CustomerCare page = new CustomerCare(driver);
		WebElement sig = driver.findElement(By.id("LineAssignment_nextBtn"));
		page.obligarclick(sig);
		Select delir = new Select(driver.findElement(By.id("DeliveryServiceType")));
		delir.selectByVisibleText("Env\u00edo Express");
		Assert.assertEquals(delir.getFirstSelectedOption().getText(), "Env\u00edo Express");
	}
	
	@Test(groups={"Sales", "AltaDeContacto", "Ola1"})
	public void TS94880_Alta_De_Contacto_Busqueda_Verificar_Accion_De_Ver_Detalle_De_Contacto(){//dentro del ver detalles no se muestran las opciones de actualizar ni lanzar carrito
		SalesBase SB = new SalesBase(driver);
		SB.BuscarCuenta(DNI, "34073329");
		driver.findElement(By.id("tab-scoped-3__item")).click();
		SB.acciondecontacto("ver contacto");
		Assert.assertTrue(false);
	}
	
	@Test(groups={"Sales", "AltaDeContacto", "Ola1"})
	public void TS94590_Alta_De_Contacto_Persona_Fisica_Verificar_Categoria_Impositiva_Por_Default(){
		sb.BuscarCuenta(DNI, "");
		driver.findElement(By.id("tab-scoped-3__item")).click();
		sb.acciondecontacto("catalogo");
		boolean x = false;
		sleep(15000);
		List<WebElement> cam = driver.findElements(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand"));
		for(WebElement c : cam ){	
			if(c.getText().toLowerCase().equals("cambiar")){
				c.click();
			}
		sleep(7000);	
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(0));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Delivery");
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		}
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		sb.continuar();
		sleep(5000);
		Select condI = new Select(driver.findElement(By.id("ImpositiveCondition")));
		Assert.assertTrue(condI.getFirstSelectedOption().getText().equalsIgnoreCase("iva consumidor final"));
	}
	
	@Test(groups={"Sales", "AltaDeCuenta", "Ola1"})
	public void TS95515_Alta_de_Cuenta_Business_Visualizar_los_campos_de_documentacion_impositiva_abajo() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("nueva cuenta");
		sleep(7000);
		BasePage imp = new BasePage(driver);
		imp.setSimpleDropdown(driver.findElement(By.id("ImpositiveCondition")), "IVA Responsable Inscripto");
		sleep(2000);
		WebElement dom = driver.findElement(By.id("State"));
		WebElement doc = driver.findElement(By.id("ImageDNI"));
		Assert.assertTrue(doc.getLocation().y > dom.getLocation().y);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})  //Falta terminar los pasos despues del carrito
	public void TS94637_Ventas_Nueva_Venta_Verificar_creacion_orden_de_venta_Usuario() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("catalogo");
		sb.agregarplan("plan con tarjeta");
		Assert.assertTrue(false);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94652_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Modo_de_Entrega() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Delivery");
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(15000);
		driver.findElement(By.id("LineAssignment_nextBtn")).click();
		sleep(10000);
		List <WebElement> num = driver.findElements(By.className("slds-form-element__control"));
		boolean a = false;
		for (WebElement x : num) {
			if (x.getText().contains("Nro. orden:")) {
				a = true;
			}
		}
		Assert.assertTrue(a);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94651_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Seleccion_de_Linea() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(15000);
		List <WebElement> num = driver.findElements(By.className("slds-form-element__control"));
		boolean a = false;
		for (WebElement x : num) {
			if (x.getText().contains("Nro. orden:")) {
				a = true;
			}
		}
		Assert.assertTrue(a);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})  
	public void TS94650_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Seleccionar_un_producto() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		List<WebElement> cam = driver.findElements(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand"));
			for(WebElement c : cam ){	
				if(c.getText().toLowerCase().equals("cambiar")){
				c.click();
			}
		sleep(7000);	
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(0));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Store Pick Up");
		sleep(2000);
		Select sta = new Select (driver.findElement(By.id("State")));
		sta.selectByVisibleText("Ciudad Aut\u00f3noma de Buenos Aires");
		sleep(2000);
		Select cit = new Select(driver.findElement(By.id("City")));
		cit.selectByVisibleText("CIUD AUTON D BUENOS AIRES");
		sleep(3000);
		driver.findElement(By.id("Store")).click();
		driver.findElements(By.cssSelector(".slds-list__item.ng-binding.ng-scope")).get(1).click();
		sleep(2000);
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		}
		sb.elegirplan("Plan con Tarjeta Repro");
		sb.continuar();
		sleep(10000);
		List<WebElement> cont = driver.findElements(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand"));
			for(WebElement c : cont){
				c.getText().equals("Continuar");
					c.click();
			}
		sleep(5000);
		CustomerCare page = new CustomerCare(driver);
		WebElement sig = driver.findElement(By.id("LineAssignment_nextBtn"));
		page.obligarclick(sig);
		sleep(7000);
		Assert.assertFalse(driver.findElement(By.id("DeliveryMethod")).isEnabled());
		
	
		
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})  //Falta terminar los pasos despues del carrito
	public void TS94646_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Medio_de_Pago() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("catalogo");
		sb.agregarplan("plan con tarjeta");
		Assert.assertTrue(false);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94641_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Nueva_Venta() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		WebElement num = driver.findElement(By.cssSelector(".slds-text-body--small.slds-page-header__info.taDevider"));
		Assert.assertTrue(num.getText().contains("Nro. de Orden:"));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94643_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Seleccion_de_Linea() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(10000);
		List <WebElement> num = driver.findElements(By.className("slds-form-element__control"));
		boolean a = false;
		for (WebElement x : num) {
			if (x.getText().contains("Nro. orden:")) {
				a = true;
			}
		}
		Assert.assertTrue(a);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})  //Falta terminar, no se puede crear venta desde la V360
	public void TS94639_Ventas_Nueva_Venta_Verificar_creacion_orden_de_venta_desde_un_Asset_Usuario() {
		driver.findElement(By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope")).click();
		sleep(2000);
		driver.findElement(By.id("alert-ok-button")).click();
		sleep(5000);
		IrA.CajonDeAplicaciones.ConsolaFAN();
		CustomerCare cc = new CustomerCare(driver);
		sb.cerrarTodasLasPestanias();
		cc.elegirCuenta("aaaaRaul Care");
		Assert.assertTrue(false);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94716_Ventas_VentasGestiones_Visualizar_un_historico_de_gestiones_realizadas() {
		driver.findElement(By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope")).click();
		sleep(2000);
		driver.findElement(By.id("alert-ok-button")).click();
		sleep(5000);
		IrA.CajonDeAplicaciones.ConsolaFAN();
		CustomerCare cc = new CustomerCare(driver);
		sb.cerrarTodasLasPestanias();
		cc.elegirCuenta("aaaaRaul Care");
		driver.switchTo().frame(cambioFrame(driver, By.cssSelector(".slds-media.slds-media--timeline.slds-timeline__media--custom-custom91")));
		List <WebElement> gest = driver.findElements(By.cssSelector(".slds-media.slds-media--timeline.slds-timeline__media--custom-custom91"));
		boolean a = false;
		boolean b = false;
		for (WebElement x : gest) {
			if (x.getText().toLowerCase().contains("t\u00edtulo")) {
				a = true;
			}
			if (x.getText().toLowerCase().contains("status")) {
				b = true;
			}
		}
		Assert.assertTrue(a && b);
	}
	
	@Test(groups={"Sales", "AltaDeLinea", "Ola1"})
	public void TS94611_Alta_Linea_Nueva_Venta_Verificar_acceso_a_Nueva_Venta_desde_vista_360() {
		driver.findElement(By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope")).click();
		sleep(2000);
		driver.findElement(By.id("alert-ok-button")).click();
		sleep(5000);
		IrA.CajonDeAplicaciones.ConsolaFAN();
		CustomerCare cc = new CustomerCare(driver);
		sb.cerrarTodasLasPestanias();
		cc.elegirCuenta("aaaaRaul Care");
		WebElement nv = driver.findElement(By.cssSelector(".console-card.open"));
		Assert.assertTrue(nv.getText().toLowerCase().contains("nueva venta"));
	}
	
	@Test(groups={"Sales", "AltaDeCuenta", "Ola1"})
	public void TS94972_Alta_Cuenta_Busqueda_Verificar_flujo_de_cuenta_Clonada() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("catalogo");
		sb.agregarplan("plan con tarjeta");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(10000);
		Assert.assertTrue(driver.findElement(By.id("ContactName")).getAttribute("value").toLowerCase().contains("adela sales"));
		List <WebElement> prov = driver.findElements(By.cssSelector(".slds-form-element__label.ng-binding"));
		boolean a = false;
		for (WebElement x : prov) {
			if (x.getText().toLowerCase().contains("provincia")) {
				a = true;
			}
		}
		Assert.assertTrue(a);
	}
	
	@Test(groups={"Sales", "AltaDeContacto", "Ola1"})
	public void TS94582_Alta_de_Contacto_Persona_Fisica_Verificar_confirmacion_de_adjunto_exitoso_XX() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("nueva cuenta");
		sleep(7000);
		driver.findElement(By.id("ImageDNI")).sendKeys("C:\\Users\\Nicolas\\Desktop\\descarga.jpg");
		sleep(3000);
		WebElement up = driver.findElement(By.cssSelector(".vlc-slds-box__max-width-80.ng-binding"));
		Assert.assertTrue(up.getText().toLowerCase().contains("descarga.jpg"));
		Assert.assertTrue(up.getText().toLowerCase().contains("5.97 kb"));
	}
	
	@Test(groups={"Sales", "AltaDeContacto", "Ola1"})
	public void TS94529_Alta_de_Contacto_Persona_Fisica_Confirmar_direccion_de_email_existente_30() {
		sb.BuscarCuenta(DNI, "11111111");
		String a = driver.findElement(By.xpath("//*[@id=\"tab-scoped-3\"]/section/div/table/tbody/tr/td[4]")).getText();
		List <WebElement> cuenta = driver.findElements(By.cssSelector(".slds-truncate.ng-binding"));
		for (WebElement x : cuenta) {
			if (x.getText().toLowerCase().contains("adela sales")) {
				x.click();
				break;
			}
		}
		sleep(7000);
		String b = driver.findElement(By.cssSelector(".slds-input.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty.ng-dirty")).getAttribute("value");
		Assert.assertTrue(a.equals(b));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94913_Ventas_General_Verificar_Completitud_Pendiente_para_cada_estado() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("catalogo");
		sb.agregarplan("plan con tarjeta");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(7000);
		Assert.assertTrue(driver.findElement(By.cssSelector(".list-group.vertical-steps.ng-scope")).isDisplayed());
	}
	
	@Test(groups={"Sales", "AltaDeContacto", "Ola1"})
	public void TS94530_Alta_de_Contacto_Persona_Fisica_Dar_de_alta_un_contacto_nuevo_48() {
		BasePage dni = new BasePage(driver);
		Random aleatorio = new Random(System.currentTimeMillis());
		aleatorio.setSeed(System.currentTimeMillis());
		int intAleatorio = aleatorio.nextInt(8999999)+1000000;
		dni.setSimpleDropdown(driver.findElement(By.id("SearchClientDocumentType")),"DNI");
		driver.findElement(By.id("SearchClientDocumentNumber")).click();
		driver.findElement(By.id("SearchClientDocumentNumber")).sendKeys(Integer.toString(intAleatorio));
		driver.findElement(By.id("SearchClientsDummy")).click();
		String a = driver.findElement(By.id("SearchClientDocumentNumber")).getAttribute("value");
		sleep(3000);
		List <WebElement> cc = driver.findElements(By.cssSelector(".slds-form-element__label.ng-binding"));
		for (WebElement x : cc) {
			if (x.getText().toLowerCase().contains("+ crear nuevo cliente")) {
				x.click();
				break;
			}
		}
		sleep(10000);
		List <WebElement> gen = driver.findElements(By.cssSelector(".slds-radio.ng-scope"));
		for (WebElement x : gen) {
			if (x.getText().toLowerCase().contains("masculino")) {
				x.click();
				break;
			}
		}
		driver.findElement(By.id("FirstName")).sendKeys("Cuenta");
		driver.findElement(By.id("LastName")).sendKeys("Generica");
		driver.findElement(By.id("Birthdate")).sendKeys("15/05/1980");
		driver.findElements(By.cssSelector(".slds-form-element__control.slds-input-has-icon.slds-input-has-icon--right")).get(2).findElement(By.tagName("input")).sendKeys("asdasd@gmail.com");
		driver.findElement(By.id("Contact_nextBtn")).click();
		sleep(10000);
		driver.get("https://crm--sit.cs14.my.salesforce.com/home/home.jsp?tsid=02u41000000QWha/");
		sleep(7000);
		driver.findElement(By.xpath("//a[@href=\'https://crm--sit--c.cs14.visual.force.com/apex/taClientSearch']")).click();
		sleep(7000);
		sb.BuscarCuenta(DNI, a);
		List <WebElement> cuenta = driver.findElements(By.cssSelector(".slds-truncate.ng-binding"));
		boolean b = false;
		for (WebElement x : cuenta) {
			if (x.getText().toLowerCase().contains("cuenta generica")) {
				b = true;
			}
		}
		WebElement verdni = driver.findElement(By.xpath("//*[@id=\"tab-scoped-3\"]/section/div/table/tbody/tr/td[3]"));
		Assert.assertTrue(b);
		Assert.assertTrue(verdni.getText().toLowerCase().contains(a));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94696_Nueva_Venta_Modo_de_Entrega_Verificar_LOV_Tipo_de_Delivery() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Delivery");
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(15000);
		driver.findElement(By.id("LineAssignment_nextBtn")).click();
		sleep(10000);
		driver.findElement(By.id("DeliveryServiceType")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'Env\u00edo Est\u00e1ndar']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'Env\u00edo Express']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'Retiro en Sucursal de Correo']")).isDisplayed());
		
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94690_Nueva_Venta_Modo_de_Entrega_Verificar_que_no_se_puede_cambiar_el_Modo_de_Entrega_Delivery() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Delivery");
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(15000);
		driver.findElement(By.id("LineAssignment_nextBtn")).click();
		sleep(10000);
		WebElement mde = driver.findElement(By.id("DeliveryMethod"));
		Assert.assertTrue(mde.getAttribute("disabled").equals("true"));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94691_Nueva_Venta_Modo_de_Entrega_Verificar_que_no_se_puede_cambiar_el_Modo_de_Entrega_Store_Pick_Up() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Store Pick Up");
		Select prov = new Select (driver.findElement(By.id("State")));
		prov.selectByVisibleText("Ciudad Aut\u00f3noma de Buenos Aires");
		Select loc = new Select (driver.findElement(By.id("City")));
		loc.selectByVisibleText("CIUD AUTON D BUENOS AIRES");
		driver.findElement(By.id("Store")).click();
		driver.findElements(By.cssSelector(".slds-list__item.ng-binding.ng-scope")).get(1).click();
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(15000);
		driver.findElement(By.id("LineAssignment_nextBtn")).click();
		sleep(10000);
		WebElement mde = driver.findElement(By.id("DeliveryMethod"));
		Assert.assertTrue(mde.getAttribute("disabled").equals("true"));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94694_Nueva_Venta_Modo_de_Entrega_Verificar_que_se_habilite_Tipo_de_Delivery() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Delivery");
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(10000);
		driver.switchTo().defaultContent();
		sb.elegirplan("Plan con Tarjeta Repro");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")).click();
		sleep(15000);
		driver.findElement(By.id("LineAssignment_nextBtn")).click();
		sleep(10000);
		Assert.assertTrue(driver.findElement(By.id("DeliveryServiceType")).isEnabled());
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94763_Ventas_Entregas_General_Modificar_el_lugar_de_entrega() {
		sb.BuscarCuenta(DNI, "11111111");
		sb.acciondecontacto("catalogo");
		sb.agregarplan("plan con tarjeta");
		sleep(15000);
		String a = driver.findElement(By.cssSelector(".slds-col.taChangeDeliveryMethod.slds-text-body--small.slds-m-left--large")).getText();
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Delivery");
		driver.findElement(By.id("SalesChannelConfiguration_nextBtn")).click();
		sleep(7000);
		String b = driver.findElement(By.cssSelector(".slds-col.taChangeDeliveryMethod.slds-text-body--small.slds-m-left--large")).getText();
		Assert.assertTrue(!a.equals(b));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})  
	public void TS94762_Ventas_Modo_De_Pago_General_Verificar_LOV_Modalidad_De_Pago() {
		sb.BuscarCuenta(DNI, "34073329");
		boolean DPF = false;
		boolean E = false;
		boolean TC = false;
		sb.acciondecontacto("catalogo");
		sleep(15000);
		sb.elegirplan("Plan con Tarjeta Repro");
		sb.continuar();
		sleep(10000);
		List<WebElement> cont = driver.findElements(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand"));
			for(WebElement c : cont){
				c.getText().equals("Continuar");
					c.click();
			}
		sleep(5000);
		CustomerCare page = new CustomerCare(driver);
		WebElement sig = driver.findElement(By.id("LineAssignment_nextBtn"));
		page.obligarclick(sig);
		sleep(10000);
		page.obligarclick(driver.findElement(By.id("ICCDAssignment_nextBtn")));
		sleep(10000);
		page.obligarclick(driver.findElement(By.id("InvoicePreview_nextBtn")));
		sleep(10000);
		driver.findElement(By.id("PaymentMethodRadio")).click();
		sleep(4000);
		List<WebElement> mediosP = driver.findElements(By.cssSelector(".slds-list__item.ng-binding.ng-scope"));
		for (WebElement UnMP : mediosP) {
			if(UnMP.getText().toLowerCase().contains("debito a proxima factura"))
				DPF = true;
			if (UnMP.getText().toLowerCase().contains("efectivo"))
				E = true;
			if (UnMP.getText().toLowerCase().contains("tarjeta de credito"))
				TC = true;
		}
		Assert.assertTrue(DPF&&E&&TC);
		
	}
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94777_Ventas_Entregas_General_Store_Pickup_Consulta_stock_por_PDV_Visualizar_campos_filtro_de_la_consulta() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Store Pick Up");
		sleep(2000);
		Select prov = new Select (driver.findElement(By.id("State")));
		prov.selectByVisibleText("Ciudad Aut\u00f3noma de Buenos Aires");
		sleep(2000);
		Select loc = new Select(driver.findElement(By.id("City")));
		loc.selectByVisibleText("CIUD AUTON D BUENOS AIRES");
		sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("State")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("City")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("Store")).isEnabled());
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})  //falta validar los campos porque los campos no son opcionales
	public void TS94935_Ventas_Modo_De_Pago_Tarjeta_Verificar_Campos_Opcionales_Medio_De_Pago_TC() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		sb.elegirplan("Plan con Tarjeta Repro");
		sb.continuar();
		sleep(10000);
		List<WebElement> cont = driver.findElements(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand"));
			for(WebElement c : cont){
				c.getText().equals("Continuar");
					c.click();
			}
		sleep(5000);
		CustomerCare page = new CustomerCare(driver);
		WebElement sig = driver.findElement(By.id("LineAssignment_nextBtn"));
		page.obligarclick(sig);
		sleep(10000);
		page.obligarclick(driver.findElement(By.id("ICCDAssignment_nextBtn")));
		sleep(10000);
		page.obligarclick(driver.findElement(By.id("InvoicePreview_nextBtn")));
		sleep(10000);
		driver.findElement(By.id("PaymentMethodRadio")).click();
		sleep(4000);
		List<WebElement> mediosP = driver.findElements(By.cssSelector(".slds-list__item.ng-binding.ng-scope"));
		for (WebElement UnMP : mediosP) {
			if (UnMP.getText().toLowerCase().contains("tarjeta de credito"))
				UnMP.click();
		}
		sleep(4000);
		System.out.println(driver.findElement(By.id("CardBankingEntity")).getAttribute("required"));
		Assert.assertTrue(false);
		//Assert.assertTrue(driver.findElement(By.id("CardBankingEntity")).getAttribute("required"));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})  //falta validar los campos porque el campo requerido no existe
	public void TS94936_Ventas_Modo_De_Pago_Tarjeta_Verificar_Campos_requeridos_Medio_De_Pago_TC() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		sb.elegirplan("Plan con Tarjeta Repro");
		sb.continuar();
		sleep(10000);
		List<WebElement> cont = driver.findElements(By.cssSelector(".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand"));
			for(WebElement c : cont){
				c.getText().equals("Continuar");
					c.click();
			}
		sleep(5000);
		CustomerCare page = new CustomerCare(driver);
		WebElement sig = driver.findElement(By.id("LineAssignment_nextBtn"));
		page.obligarclick(sig);
		sleep(10000);
		page.obligarclick(driver.findElement(By.id("ICCDAssignment_nextBtn")));
		sleep(10000);
		page.obligarclick(driver.findElement(By.id("InvoicePreview_nextBtn")));
		sleep(10000);
		driver.findElement(By.id("PaymentMethodRadio")).click();
		sleep(4000);
		List<WebElement> mediosP = driver.findElements(By.cssSelector(".slds-list__item.ng-binding.ng-scope"));
		for (WebElement UnMP : mediosP) {
			if (UnMP.getText().toLowerCase().contains("tarjeta de credito"))
				UnMP.click();
		}
		sleep(5000);
		driver.findElement(By.id("CreditCardData")).click();
		sleep(1000);
		Assert.assertTrue(false);
		Assert.assertTrue(driver.findElement(By.id("CardBankingEntity")).getAttribute("required").equals("true"));
		//Assert.assertTrue(driver.findElement(By.id("CardBankingEntity")).getAttribute("required"));
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94779_Ventas_Entregas_General_Store_Pickup_Consulta_stock_por_PDV_Visualizar_el_campo_LOCALIDAD_con_un_desplegable_que_permita_seleccionar_una() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Store Pick Up");
		sleep(2000);
		Select prov = new Select (driver.findElement(By.id("State")));
		prov.selectByVisibleText("Ciudad Aut\u00f3noma de Buenos Aires");
		sleep(2000);
		driver.findElement(By.id("City")).click();
		boolean a = false;
		List <WebElement> list = driver.findElement(By.id("City")).findElements(By.tagName("option"));
		if (list.size() >= 2) {
			a = true;
		}
		Assert.assertTrue(a);
	}
	
	@Test(groups={"Sales", "Ventas", "Ola1"})
	public void TS94778_Ventas_Entregas_General_Store_Pickup_Consulta_stock_por_PDV_Visualizar_el_campo_PROVINCIA_con_un_desplegable_que_permita_seleccionar_una() {
		sb.BuscarCuenta(DNI, "34073329");
		sb.acciondecontacto("catalogo");
		sleep(15000);
		driver.findElement(By.cssSelector(".slds-m-left--x-small.slds-button.slds-button--brand")).click();
		sleep(7000);
		driver.switchTo().frame(cambioFrame(driver, By.id("DeliveryMethodSelection")));
		Select env = new Select (driver.findElement(By.id("DeliveryMethodSelection")));
		env.selectByVisibleText("Store Pick Up");
		sleep(2000);
		driver.findElement(By.id("State")).click();
		boolean a = false;
		List <WebElement> list = driver.findElement(By.id("State")).findElements(By.tagName("option"));
		if (list.size() >= 2) {
			a = true;
		}
		Assert.assertTrue(a);
	}
	
	
}