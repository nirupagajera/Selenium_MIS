package com.krishaweb.mis.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminApproveProjectPage {

    private WebDriver driver;

    public AdminApproveProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    // Directly using your approve_project_request() body
    public void approveProjectRequest() throws Exception {
        WebElement status, radio, google_drive_checkbox, email_input, email_next, password, password_next, submit_button,
                allow_button, basecamp_folder, email_username;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        status = driver.findElement(By.xpath("//div[@class = 'inline-radio']"));
        js.executeScript("arguments[0].scrollIntoView(true);", status);

        radio = driver.findElement(By.xpath("//div[@class = 'col-sm-6 status-detail']//div//div//div"));
        List<WebElement> status_radio = radio.findElements(By.tagName("label"));
        for (WebElement radio_status : status_radio) {
            String text = radio_status.getText().trim();
            System.out.println(text);

            if (text.equalsIgnoreCase("active")) {
                radio_status.click();
                break;
            }
        }

        // google drive checkbox
        google_drive_checkbox = driver.findElement(By.xpath("//*[@id=\"home\"]/div[12]/div[2]/div/div/label"));
        google_drive_checkbox.click();

        Set<String> id = driver.getWindowHandles();
        ArrayList<String> tab = new ArrayList<String>(id);

        driver.switchTo().window(tab.get(1));
        email_input = driver.findElement(By.xpath("//input[@type = 'email']"));
        email_input.sendKeys("nirupa@krishaweb.com");

        email_next = driver.findElement(By.xpath("//span[text() = 'Next']"));
        email_next.click();

        password = driver.findElement(By.xpath("//input[@name = 'Passwd']"));
        password.sendKeys("Nirupa@1234");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        password_next = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        wait.until(ExpectedConditions.elementToBeClickable(password_next));
        password_next.click();

        WebDriverWait confirm = new WebDriverWait(driver, Duration.ofSeconds(30));
        allow_button = driver.findElement(By.xpath("//*[@id='submit_approve_access']/div/button/span"));
        confirm.until(ExpectedConditions.elementToBeClickable(allow_button));
        allow_button.click();

        driver.switchTo().window(tab.get(0));

        Thread.sleep(5000);
        // basecamp folder

        basecamp_folder = driver.findElement(By.xpath("//*[@id=\"home\"]/div[12]/div[3]/div/div/label"));
        basecamp_folder.click();

        Set<String> basecamp = driver.getWindowHandles();
        ArrayList<String> tab_basecamp = new ArrayList<String>(basecamp);

        driver.switchTo().window(tab_basecamp.get(1));

        email_username = driver.findElement(By.xpath("//input[@name = 'username']"));
        email_username.sendKeys("nirupa@krishaweb.com");

        submit_button = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/form[2]/button"));
        submit_button.click();

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Nirupa@12345");

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/form[2]/input[3]")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[2]/div/form/button")).click();
        System.out.println("Allow button is submitted successfully..");
        Thread.sleep(2000);

        driver.switchTo().window(tab_basecamp.get(0));

        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[text() = 'Save']")).click();

        System.out.println("Project approved successfully..");
    }
}
