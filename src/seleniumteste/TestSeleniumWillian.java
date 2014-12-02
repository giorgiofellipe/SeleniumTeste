/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seleniumteste;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Willian
 */
public class TestSeleniumWillian {
    
 public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        try {
        driver.get("http://delsoftsistemas.com.br");
        
        WebDriverWait wait = new WebDriverWait(driver, 15);// 15 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-item-32")));
        
        WebElement aempresa = driver.findElement(By.id("menu-item-32"));
        aempresa.click();
        
        wait = new WebDriverWait(driver, 10);// 15 segundos
        
        WebElement imprensa = driver.findElement(By.id("menu-item-3691"));
        imprensa.click();
        
        wait = new WebDriverWait(driver, 10);// 15 segundos
        
        WebElement contato = driver.findElement(By.id("menu-item-27"));
        contato.click();
        
        wait = new WebDriverWait(driver, 15);// 15 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));       
        
        WebElement assunto = driver.findElement(By.name("assunto"));       
        assunto.click();
        assunto.sendKeys("testando");
        
        WebElement empresa = driver.findElement(By.name("empresa"));       
        empresa.click();
        empresa.sendKeys("selenium");
        
        WebElement nome = driver.findElement(By.name("nome"));       
        nome.click();
        nome.sendKeys("Willian/Teste trabalho Unidavi");
        
        WebElement email = driver.findElement(By.name("email"));       
        email.click();
        email.sendKeys("testselenium@hotmail.com");
        
        WebElement cidade = driver.findElement(By.name("cidade"));       
        cidade.click();
        cidade.sendKeys("Rio do Sul");
        
        WebElement UF = driver.findElement(By.name("uf"));       
        UF.click();
        UF.sendKeys("SC");
        
        WebElement msg = driver.findElement(By.name("mensagem"));       
        msg.click();
        msg.sendKeys("Teste realizado na materia de topicos avançados");
                
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
}
