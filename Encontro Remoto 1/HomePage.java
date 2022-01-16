package br.senai.sp.homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	private WebDriver driver;
	
	@Before
	public void TesteHomePageSenai() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void TesteNavegabilidadeSenai() {
		driver.get("https://online.sp.senai.br/");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement inputBuscar = driver.findElement(By.id("Busca1_txtFiltro")); 
		WebElement btnSubmit = driver.findElement(By.id("Busca1_btnBusca"));
		
		//Procurando por gestão
		inputBuscar.sendKeys("gestão");
		btnSubmit.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.get("https://online.sp.senai.br/");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		driver.findElement(By.id("Busca1_txtFiltro")).clear();
		driver.findElement(By.id("Busca1_txtFiltro")).sendKeys("tecnologia");
		driver.findElement(By.id("Busca1_RadioButtonList1_1")).click();
		driver.findElement(By.id("Busca1_btnBusca")).click();
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void Fechar() {
		driver.close();
	}

}
