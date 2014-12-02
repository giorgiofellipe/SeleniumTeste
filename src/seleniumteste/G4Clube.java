package seleniumteste;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class G4Clube {
    
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get("http://www.g4clube.com/forum/member.php?action=login");

            WebElement usuario = driver.findElement(By.name("username"));
            usuario.sendKeys("Lucas Guilherme");
            
            WebElement senha = driver.findElement(By.name("password"));
            senha.sendKeys("qwe123");
            
            WebElement enviar = driver.findElement(By.name("submit"));
            enviar.click();            
            
            driver.get("http://www.g4clube.com/forum/private.php?action=send");            
            WebDriverWait wait2 = new WebDriverWait(driver, 30);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("to")));
            
            WebElement to = driver.findElement(By.id("to"));
            to.sendKeys("Lucas Guilherme");
            WebElement subject = driver.findElement(By.name("subject"));
            subject.sendKeys("Teste");
            WebElement message_new = driver.findElement(By.id("message_new"));
            message_new.sendKeys("Mensagem");
            WebElement submit = driver.findElement(By.name("submit"));
            submit.click();
                
//           

   


        
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
   }
    
}
