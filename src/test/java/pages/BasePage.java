package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    final static String PATH_DRIVER = "D:\\IdeaProjects\\";

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    static {
        System.setProperty("webdriver.chrome.driver", PATH_DRIVER + "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser(){

        driver.quit();
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }


    public void clickElement(String locator) {

        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator) {

        actions.moveToElement(find(locator));
    }

    public void doubleClick(String locator) {

        actions.doubleClick(find(locator));
    }

    public void rightClick(String locator) {

        actions.contextClick(find(locator));
    }

    public String getValueFromTable(String locator, int row, int column) {
        String cellIneed = locator + "/table/tbody/tr{" + row + "}/td{" + column + "}";
        return find(cellIneed).getText();
    }

    public void switchToiFrame(String iFrameIndex) {

        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame() {

        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {

        driver.switchTo().alert().dismiss();
    }

    public String textFromElement(String locator) {

        return find(locator).getText();
    }

    public boolean isEnable(String locator) {

        return find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator) {

        return find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){

        return find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public void goToLinkText(String linkText){

        driver.findElement(By.id(linkText)).click();
    }
}