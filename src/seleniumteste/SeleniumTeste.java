/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seleniumteste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 *
 * @author giorgiofellipe
 */
public class SeleniumTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        // Go to the Google Suggest home page
        driver.get("http://www.google.com/");

        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Giorgio");

//        driver.quit();
    }
    
}
