package br.senai.sp.testegm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGm {
	private WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestarLogin() {
		
		
		// TESTES COM LOGIN
		
		driver.get("http://localhost:4200/");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// CLICAR NO ICONE PARA LOGIN / CADASTRO
		WebElement loginIcon = driver.findElement(By.id("iconUser"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(loginIcon).perform();
		
		loginIcon.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/div[1]/span[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement submit = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/form/div/button"));
		
		//DADOS PREENCHIDOS COM A SENHA ERRADA
		inputEmail.sendKeys("louis@email.com");
		inputSenha.sendKeys("nba2022");
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		submit.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement mensagemErro = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/p"));
		System.out.println(mensagemErro.getText());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TESTE COM EMAIL ERRADO
		inputEmail.clear();
		inputSenha.clear();
		inputEmail.sendKeys("naoexistente@email.com");
		inputSenha.sendKeys("senhaqualquer");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		submit.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement msgEmailErrado = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/p"));
		System.out.println(msgEmailErrado.getText());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//TESTE COM FORMATO DE EMAIL INVÁLIDO
				inputEmail.clear();
				inputSenha.clear();
				inputEmail.sendKeys("naoexistente");
				inputSenha.sendKeys("senhaqualquer");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				submit.click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				WebElement msgEmailInvalido = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/p"));
				System.out.println(msgEmailInvalido.getText());
				
				
				
				//TESTE COM SENHA MUITO CURTA
				inputEmail.clear();
				inputSenha.clear();
				inputEmail.sendKeys("naoexistente@email.com");
				inputSenha.sendKeys("s");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				submit.click();
				
				WebElement msgSenhaCurta = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/p"));
				System.out.println(msgSenhaCurta.getText());
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		//TESTE PARA LOGIN CORRETO
		
		inputEmail.clear();
		inputEmail.sendKeys("louis@email.com");
		inputSenha.clear();
		inputSenha.sendKeys("krad");
		submit.click();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement mensagemCerta = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/p"));
		System.out.println(mensagemCerta.getText());
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		// TESTE DE CADASTRO
		
		driver.get("http://localhost:4200/log");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement inputNome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
		WebElement inputCadEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"senha\"]"));
		WebElement inputConfSenha = driver.findElement(By.id("senhaC"));
		WebElement cadSubmit = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/form/div/button"));

		
		
		//INPUT EM BRANCO
		inputNome.clear();
		inputCadEmail.sendKeys("emaildeteste@email.com");
		inputPassword.sendKeys("123456789");
		inputConfSenha.sendKeys("123456789");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cadSubmit.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement spanCad = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/p"));

		
		System.out.println(spanCad.getText());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//SENHAS NÃO CONFEREM
		
		inputNome.clear();
		inputNome.sendKeys("Bugs");
		inputCadEmail.clear();
		inputCadEmail.sendKeys("bugs@email.com");
		inputPassword.clear();
		inputPassword.sendKeys("neotheone");
		inputConfSenha.clear();
		inputConfSenha.sendKeys("isneotheone");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cadSubmit.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(spanCad.getText());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//EMAIL JÁ CADASTRADO
		inputNome.clear();
		inputNome.sendKeys("Thomas Anderson");
		inputCadEmail.clear();
		inputCadEmail.sendKeys("neo@matrix.com");
		inputPassword.clear();
		inputPassword.sendKeys("neotheone");
		inputConfSenha.clear();
		inputConfSenha.sendKeys("isneotheone");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cadSubmit.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement spanEmailRepetido = driver.findElement(By.xpath("/html/body/app-root/app-log/div/div/form/div/p"));
		
		System.out.println(spanEmailRepetido.getText());
		
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




