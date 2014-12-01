/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seleniumteste;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Usuario
 */
public class LoginHotmailSeleniumTest {
    
 public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get("http://hotmail.com");

            WebElement login = driver.findElement(By.id("i0116"));
            login.click();
            login.sendKeys("testeselenium@hotmail.com");

            WebElement senha = driver.findElement(By.id("i0118"));
            senha.click();
            senha.sendKeys("SeleniuM123");

            WebElement botaosubmit = driver.findElement(By.id("idSIButton9"));       
            botaosubmit.click();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
}
