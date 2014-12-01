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
 * @author giorgiofellipe
 */
public class MagamobiCurriculumSendTest {
    
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        try {
        driver.get("http://magamobi.com.br/");
        
        WebDriverWait wait = new WebDriverWait(driver, 15);// 15 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chama-tc")));
        
        WebElement trabalheConosco = driver.findElement(By.id("chama-tc"));
        trabalheConosco.click();
        
        wait = new WebDriverWait(driver, 5);// 5 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vaga-selecionada")));
        
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
        
        WebElement telefone = driver.findElement(By.id("form-telefone"));
        telefone.click();
        telefone.sendKeys("4735222608");
        
        WebElement data = driver.findElement(By.id("form-data"));
        data.click();
        data.sendKeys("08021993");
        
        WebElement mensagem = driver.findElement(By.name("mensagem"));
        mensagem.sendKeys("testando mensagem");
        
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
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
}
