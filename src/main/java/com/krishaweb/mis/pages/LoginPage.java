package com.krishaweb.mis.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Uses code from Project_create_and_approve.login_mis()
    public void loginAsNisarg() throws Exception {
        WebElement Email, Password, Submit_Button, project, createProjectButton, requested_project;

        driver.get("https://teamwork.webdevtest1.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        Email.sendKeys("nisarg@krishaweb.com");

        Password = driver.findElement(By.name("password"));
        Password.sendKeys("Krisha2020");

        Submit_Button = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit_Button.click();

        project = driver.findElement(By.className("project"));
        project.click();

        requested_project = driver.findElement(By.xpath("//a[text() = 'Requested Projects']"));
        requested_project.click();

        createProjectButton = driver.findElement(By.xpath("//a[text() = ' Create Project Request']"));
        createProjectButton.click();
    }

    // Uses code from admin_approve_project_request.login_mis()
    public void loginAsMitesh() throws Exception {
        WebElement Email, Password, Submit_Button, project, requested_project, MIS_project;

        driver.get("https://teamwork.webdevtest1.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        Email.sendKeys("mitesh@krishaweb.com");

        Password = driver.findElement(By.name("password"));
        Password.sendKeys("Krisha2020");

        Submit_Button = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit_Button.click();

        project = driver.findElement(By.className("project"));
        project.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        requested_project = driver.findElement(By.xpath("//a[starts-with(text(),'Requested Projects')]"));
        js.executeScript("arguments[0].click();", requested_project);

        MIS_project = driver.findElement(By.xpath("//a[@class = 'btn btn-md btn_edit']"));
        MIS_project.click();
    }
}
