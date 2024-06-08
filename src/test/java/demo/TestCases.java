package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.wrappers.Wrappers;

import java.time.Duration;
import java.time.LocalTime;

// import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import demo.wrappers.Wrappers;




public class TestCases {
    static ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation.    
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @SuppressWarnings("deprecation")
    @Test(alwaysRun = true, enabled = true)
    public static void testCase01() throws InterruptedException{
        // Calendar calendar = Calendar.getInstance();
        // calendar.setTime(new Date());
        // long now = calendar.getTimeInMillis();
        // calendar.add(Calendar.DATE,1);
        // long then = calendar.getTimeInMillis();
        // long secondsFromEpoch = (then - now) / 1000;

        long epoch = System.currentTimeMillis()/1000;

        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebElement nameElement = driver.findElement(By.xpath("(//input[@type ='text'])[1]"));
        // nameElement.click();
        // nameElement.sendKeys("Crio Learner");

        Wrappers.wrapperClick(driver, nameElement);
        Wrappers.wrapperSendKeys(nameElement, "Crio Learner");

        

        WebElement reasonElement = driver.findElement(By.xpath("//textarea[@aria-label ='Your answer']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // reasonElement.click();
        // reasonElement.sendKeys("I want to be the best QA Engineer!" + epoch);

        String reasonText = "I want to be the best QA Engineer!" + epoch;
        Wrappers.wrapperClick(driver, reasonElement);
        Wrappers.wrapperSendKeys(reasonElement, reasonText);
        Thread.sleep(2000);

        WebElement experiencElement = driver.findElement(By.xpath("//span[text() = '0 - 2']"));
        // experiencElement.click();
        Wrappers.wrapperClick(driver, experiencElement);
        Thread.sleep(2000);

        WebElement learnedJavaElement = driver.findElement(By.xpath("//span[text() = 'Java']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // learnedJavaElement.click();
        Wrappers.wrapperClick(driver, learnedJavaElement);
        WebElement learnedSeleniumElement = driver.findElement(By.xpath("//span[text() = 'Selenium']"));
        // learnedSeleniumElement.click();
        Wrappers.wrapperClick(driver, learnedSeleniumElement);
        WebElement learnedTestNgElement = driver.findElement(By.xpath("//span[text() = 'TestNG']"));
        // learnedTestNgElement.click();
        Wrappers.wrapperClick(driver, learnedTestNgElement);

        Thread.sleep(2000);
        System.out.println("How should you be addressed?");
        WebElement chooseElement = driver.findElement(By.xpath("//span[text() = 'Choose']"));
        // chooseElement.click();
        Wrappers.wrapperClick(driver, chooseElement);
        Thread.sleep(3000);
        WebElement MrElement = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]"));
        // MrElement.click();
        Wrappers.wrapperClick(driver, MrElement);
 
        WebElement calendarIconElement=driver.findElement (By.xpath("//span[text() = 'What was the date 7 days ago?']"));
        Actions actions =new Actions(driver);
        actions.click(calendarIconElement).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("06").perform();
        
        actions.sendKeys("01").perform();
        actions.sendKeys("2024").perform();
        Thread.sleep(5000);

        WebElement currentTimeElement = driver.findElement(By.xpath("//span[text() = 'What is the time right now?']"));

        Actions actions2 = new Actions(driver);
        actions2.click(currentTimeElement).perform();
        actions2.sendKeys(Keys.TAB).perform();
        // Get the current system time
        // LocalTime currentTime = LocalTime.now();

         // Extract hours and minutes separately
        //  int hours = currentTime.getHour();
        //  int minutes = currentTime.getMinute();

        // Format the time as per your requirement, for example, HH:mm:ss
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        // String formattedTime = currentTime.format(formatter);

        // Input the current system time into the field
    
        // actions2.sendKeys(String.valueOf(hours)).perform();
        actions2.sendKeys("07").perform();
        actions2.sendKeys(Keys.TAB).perform();
        // actions2.sendKeys(String.valueOf(minutes)).perform();
        actions2.sendKeys("30").perform();
        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.xpath("//span[text() = 'Submit']"));

        // submitButton.click();
        Wrappers.wrapperClick(driver, submitButton);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement submitConfirmation = driver.findElement(By.xpath("//div[text() = 'Thanks for your response, Automation Wizard!']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Thanks for your response, Automation Wizard!']")));
        if(submitConfirmation.getText().contains("Thanks for your response, Automation Wizard!")){
            System.out.println("its submitted");
        }else{
            System.out.println("its not submitted");
        }


    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest(alwaysRun = true,enabled = true)
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true,enabled = true)
    public void endTest()
    {
        // driver.close();
        driver.quit();

    }
}