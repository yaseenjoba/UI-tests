import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class TestUI {
    WebDriver browser;
    @Before
    public void init(){
        System.setProperty("webdriver.gecko.driver","C:\\temp1\\geckodriver.exe");
        browser=new FirefoxDriver();
    }
    @Test
    public void firstTest() {
        browser.get("https://forms.office.com/Pages/ResponsePage.aspx?id=DQSIkWdsW0yxEjajBLZtrQAAAAAAAAAAAAN__tQlYTdURExDM0ZZQVBZQzIyRjQzMjNMTFk3RTYzMy4u");
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement sendBtn= browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div/div[2]/div[3]/div[1]/button/div"));
        sendBtn.click();
        WebElement reqField=browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]/span"));
        Assert.assertEquals(reqField.getText(),"This question is required.");
        browser.close();
    }
    @Test
    public void secondTest() {

        WebElement sendBtn= browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div/div[2]/div[3]/div[1]/button/div"));
        WebElement reqField2=browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div/div[2]/div[2]/div[3]/div/div[2]/div/div/input"));
        reqField2.sendKeys("anything");
        sendBtn.click();
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement ThanksSt=browser.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div[2]"));
        System.out.println(ThanksSt.getText());
        Assert.assertEquals("Your response was submitted.",ThanksSt.getText());
        browser.close();
    }
    @Test
    public void ThirdTest(){
        browser.get("https://forms.office.com/Pages/ResponsePage.aspx?id=DQSIkWdsW0yxEjajBLZtrQAAAAAAAAAAAAN__tQlYTdURExDM0ZZQVBZQzIyRjQzMjNMTFk3RTYzMy4u");
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement textBox=browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div/input"));
        textBox.sendKeys("100");
        WebElement message=browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/span"));
        Assert.assertTrue(message.isDisplayed());
        browser.close();
    }


}
