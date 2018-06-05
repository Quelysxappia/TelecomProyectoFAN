package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OM {

	static WebDriver driver;

	// *********************************CONSTRUCTOR******************************************************//

	public OM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *********************************ELEMENTOS******************************************************//

	@FindBy(id = "tabBar")
	private WebElement TabBar;

	@FindBy(css = ".dataCol.orderBlock")
	private List<WebElement> listTabs;

	@FindBy(name = "btnAgregar")
	private WebElement agregar;

	@FindBy(id = "fileinput")
	private WebElement adjuntar;

	// ********************************METODOS*******************************************************//
	public void sleep(long s) {
		try {
			Thread.sleep(s);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Hace click en los tabs principal segun el "Id" recibido.
	 * 
	 * @param id
	 */
	public void clickTab(String id) {
		TabBar.findElement(By.id(id)).click();
	}

	/**
	 * Click en "+".
	 */
	public void clickMore() {
		TabBar.findElement(By.id("AllTab_Tab")).click();
	}

	/**
	 * Hace click al tab del listado que aparece despues de Hacerle click en "+".
	 * 
	 * @param tab
	 */
	public void clickOnListTabs(String tab) {
		boolean flag = true;
		for (WebElement option : listTabs) {
			System.out.println(option.getText());
			if (option.getText().toLowerCase().equals(tab.toLowerCase())) {
				WebElement BenBoton = option.findElement(By.tagName("a"));
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + BenBoton.getLocation().y + ")");
				sleep(1000);
				BenBoton.click();
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("No hizo Click en: " + tab);
		sleep(5000);
	}

	/**
	 * Cambia de Pestana en el Navegador.
	 * 
	 * @param Ventana
	 */
	public void cambiarVentanaNavegador(int Ventana) {
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(Ventana));
	}

	public void primeraOrden() {
		WebElement fila = driver.findElement(By.cssSelector(".dataRow.even.first"));
		WebElement nro = fila.findElement(By.tagName("th")).findElement(By.tagName("a"));
		nro.click();
		sleep(5000);
	}

	public boolean scrollDown(WebElement Elemento) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + Elemento.getLocation().y + ")");
			return true;
		} catch (NullPointerException e) {
			System.out.println("Error: No se puede hacer Scroll");
			return false;
		}
	}

	public boolean scrollDownInAView(WebElement Elemento) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Elemento);
			return true;
		} catch (NullPointerException e) {
			System.out.println("Error: No se puede hacer Scroll");
			return false;
		}
	}

	public void goToMenuOM() {
		sleep(5000);
		String actual = driver.findElement(By.id("tsidLabel")).getText();

		if (actual.toLowerCase().contains("sales") || actual.toLowerCase().contains("ventas"))
			return;
		else {
			driver.findElement(By.id("tsid")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u41000000QWha\"]")).click();
		}
	}

	/**
	 * Crea una orden desde la vista de todas las ordenes.
	 */
	public void crearOrden(String Cuenta) {

		driver.findElement(By.name("new")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		// crearCuentaOM(Cuenta);
		driver.findElement(By.id("accid")).sendKeys(Cuenta);
		driver.findElement(By.className("dateFormat")).click();
		Select Estado = new Select(driver.findElement(By.id("Status")));
		Estado.selectByVisibleText("Draft");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		driver.findElement(By.name("save")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Pasa todas las cajas rojas del flujo de orquestacion a verdes.
	 */
	public void completarFlujoOrquestacion() {
		boolean chiqui = false;
		while (chiqui == false) {

			try {
				driver.findElement(By.id("zoomOut")).click();
			} catch (Exception ex1) {
				chiqui = true;
				break;
			}

		}

		List<WebElement> cajas = driver.findElements(By.cssSelector(".item-label-container.item-header.item-failed"));
		int i = 1;
		while (cajas.size() > 0) {
			for (WebElement UnaC : cajas) {
				UnaC.click();
				sleep(5000);
				cambiarVentanaNavegador(i);
				i++;
				sleep(5000);
				List<WebElement> botones = driver
						.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
				for (WebElement UnB : botones) {
					if (UnB.getText().equals("Complete")) {
						UnB.click();
						break;
					}
				}
				sleep(5000);
				cambiarVentanaNavegador(0);
				sleep(5000);
				break;
			}
			cajas = driver.findElements(By.cssSelector(".item-label-container.item-header.item-failed"));

		}
		closeAllOtherTabs();
	}

	/**
	 * Crea una orden desde la vista de todas las ordenes.
	 */
	public void crearCuentaOM(String Cuenta) {
		sleep(1000);
		List<WebElement> buscarCuenta = driver.findElements(By.className("lookupIcon"));
		for (WebElement op : buscarCuenta) {
			if (op.getAttribute("alt").equalsIgnoreCase("Account Name Lookup (New Window)")) {
				op.click();
			}
		}
		sleep(3000);
		cambiarVentanaNavegador(1);
		sleep(1000);

		driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
		driver.findElement(By.name("new")).click();
		sleep(2000);
		driver.switchTo().defaultContent();
		sleep(200);
		driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));

		WebElement inputNombreCuenta = driver
				.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/input"));
		inputNombreCuenta.click();
		inputNombreCuenta.clear();
		inputNombreCuenta.sendKeys(Cuenta);
		driver.findElements(By.name("save")).get(1).click();
		cambiarVentanaNavegador(0);
		driver.switchTo().defaultContent();

	}

	/**
	 * Crea una vista desde la ventana "Ordenes"
	 * 
	 * @param
	 * @return
	 */
	public boolean crearVistaOM(String nombreVista, String nombreCuenta) {
		clickTab("Order_Tab");
		sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")).click();
			sleep(3000);
			driver.findElement(By.id("fname")).sendKeys(nombreVista);

			// Filtros de Busqueda
			Select campo = new Select(driver.findElement(By.id("fcol1")));
			campo.selectByValue("SALES.ACCOUNT.NAME");
			Select operador = new Select(driver.findElement(By.id("fop1")));
			operador.selectByValue("e");
			driver.findElement(By.id("fval1")).sendKeys(nombreCuenta);
			;
			sleep(1000);
			// click guardar
			driver.findElement(By.cssSelector(".btn.primary")).click();
			sleep(2000);
			if (driver.findElement(By.name("fcf")).getText().contains(nombreVista))
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("Vista '" + nombreVista + "' no creada.");
			e.printStackTrace();
			return false;
		}
	}

	/* Obtiene un elemento aleatorio de una lista de WebElements */
	public WebElement getRandomElementFromList(List<WebElement> lista) {

		int listaSize = lista.size();
		Random rand = new Random();
		WebElement randomWebElement = lista.get(rand.nextInt(listaSize));
		return randomWebElement;

	}

	/* Genera un String de numeros al azar de n digitos */
	public String getRandomNumber(int digitos) {
		Random rand = new Random();
		StringBuilder number = new StringBuilder(digitos);
		// Asegura que el primer digito no sea 0
		number.append((char) ('1' + rand.nextInt(9)));
		// Genera el resto de los digitos
		for (int i = 0; i < (digitos - 1); i++) {
			number.append((char) ('0' + rand.nextInt(10)));
		}
		return number.toString();
	}

	/* Cierra todas las ventanas que no sean la principal */
	public void closeAllOtherTabs() {
		String mainWindowHandle = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String t : tabs) {
			if (!t.equals(mainWindowHandle)) {
				driver.switchTo().window(t);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle);
	}

	/* Cambia a la nueva ventana/tab/popup -- Recibe la ventana actual */
	public void switchToPopup(String currentWindowHandle) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String t : tabs) {
			if (!t.equals(currentWindowHandle)) {
				driver.switchTo().window(t);
				break;
			}
		}
	}

	/* Selecciona una Vista por Texto Visible */
	public void selectVistaByVisibleText(String vista) {
		Select vistaSelect = new Select(driver.findElement(By.name("fcf")));
		vistaSelect.selectByVisibleText(vista);
		try {
			driver.findElement(By.name("go")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Go Button not found exception");
		}
	}

	/* Elimina la Vista Seleccionada */
	public void eliminarVista() {
		try {
			driver.findElement(By.name("delID")).click();
			Alert confirmDelete = driver.switchTo().alert();
			confirmDelete.accept();
			// sleep(5000);
		} catch (UnhandledAlertException f) {
			try {
				// Aceptar Alerta para Borrar Lista
				Alert confirmDelete = driver.switchTo().alert();
				confirmDelete.accept();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> traerColumna(WebElement wBody, int iColumn) {
		List<WebElement> wRows = wBody.findElements(By.tagName("tr"));
		List<String> sColumn = new ArrayList<String>();
		for(WebElement wAux : wRows) {
			List<WebElement> wTd = wAux.findElements(By.tagName("td"));
			sColumn.add(wTd.get(iColumn).getText());
		}

		return sColumn;
	}

}