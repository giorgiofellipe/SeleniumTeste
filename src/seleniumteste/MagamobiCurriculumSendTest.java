package seleniumteste;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author giorgiofellipe
 */
public class MagamobiCurriculumSendTest {
    
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        
        driver.get("http://magamobi.com.br/");
        
        WebElement trabalheConosco = driver.findElement(By.id("chama-tc"));
        trabalheConosco.click();
        
        //Selecionado a vaga de Coordenador de TI
        WebElement vaga = driver.findElement(By.id("vaga-selecionada"));
        List<WebElement> options = vaga.findElements(By.tagName("option"));
        for(WebElement option : options){
            if(option.getText().equals("Coordenador de TI")) {
                option.click();
                break;
            }
        }
        WebElement nome = driver.findElement(By.id("form-nome"));
        nome.sendKeys("Testando Selenium");
        
        WebElement email = driver.findElement(By.id("form-email"));
        email.sendKeys("teste@selenium.com.br");
        
        
        //Resolvendo o "captcha"
        String captchaValue = "";
        WebElement secaoArquivo = driver.findElement(By.className("arquivo"));
        for(WebElement element : secaoArquivo.findElements(By.tagName("span"))){
            if (!element.getAttribute("class").equalsIgnoreCase("seuCurriculo")) {
                WebElement captcha = element.findElement(By.tagName("span"));
                captchaValue = captcha.getText();
                break;
            }
        }
        captchaValue = captchaValue.replace("=", "");
        captchaValue = captchaValue.replace(" ","");
        String[] aCaptchaValues = captchaValue.split("\\+");
        int captchaResult = Integer.parseInt(aCaptchaValues[0]) + Integer.parseInt(aCaptchaValues[1]); 
        System.out.println("Captcha: " + captchaResult);
        
        WebElement captchaResposta = driver.findElement(By.id("resposta"));
        captchaResposta.sendKeys(String.valueOf(captchaResult));
        
        vaga.submit();
    }
    
}
