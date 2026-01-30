package com.krishaweb.mis.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProjectRequestPage {

    private WebDriver driver;

    public ProjectRequestPage(WebDriver driver) {
        this.driver = driver;
    }

    // Directly using your create_project() body
    public void createProject() throws Exception {
        WebElement projectName, selectCompany, radio_button, project_budget, hour_rate, checkbox, description,
                basecamp_desc, notes_for_pm, commercial_proposal_location, github, plan_start_date, plan_end_date,
                save_button;

        projectName = driver.findElement(By.name("name"));
        projectName.sendKeys("Basecamp_MIS_drive");

        Select company = new Select(driver.findElement(By.name("company_id")));
        company.selectByVisibleText("KWT - (KrishaWeb)");

        Select category = new Select(driver.findElement(By.name("category_id")));
        category.selectByValue("6");

        Thread.sleep(5000);
        Select Sub_Category = new Select(driver.findElement(By.name("sub_category_id")));
        Sub_Category.selectByVisibleText("WordPress");

        Select client = new Select(driver.findElement(By.name("client_id")));
        client.selectByValue("476");

        radio_button = driver.findElement(By.xpath("//div[@class = 'inline-radio']"));
        List<WebElement> radio_option = radio_button.findElements(By.tagName("label"));
        for (WebElement radio : radio_option) {
            String text = radio.getText().trim();
            System.out.println(text);
            if (text.equalsIgnoreCase("Hiring")) {
                radio.click();
                break;
            }
        }

        project_budget = driver.findElement(By.name("project_budget"));
        project_budget.sendKeys("75000");

        hour_rate = driver.findElement(By.name("hourly_rate"));
        hour_rate.sendKeys("30");

        Select currency = new Select(driver.findElement(By.name("currency_id")));
        currency.selectByValue("7");

        checkbox = driver.findElement(By.xpath("//*[@id=\"home\"]/div[4]/div[4]/div/div/label"));
        checkbox.click();

        Select project_manager = new Select(driver.findElement(By.name("project_manager_id")));
        project_manager.selectByVisibleText("Nisarg Pandya");

        Select project_lead = new Select(driver.findElement(By.name("projectlead_id")));
        project_lead.selectByVisibleText("Nirav Panchal");

        description = driver.findElement(By.xpath("//textarea[@ng-model = 'project_array.description']"));
        description.sendKeys("New Project");

        basecamp_desc = driver.findElement(By.name("basecamp_description"));
        basecamp_desc.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        notes_for_pm = driver.findElement(By.xpath("//textarea[@ng-model = 'project_array.notes']"));
        notes_for_pm.sendKeys("Deliver this project successfully..");

        commercial_proposal_location = driver.findElement(By.xpath("//textarea[@ng-model = 'project_array.commercial_proposal_location']"));
        commercial_proposal_location.sendKeys("India");

        github = driver.findElement(By.xpath("//input[@ng-model = 'project_array.gitlab']"));
        github.sendKeys("https://github.com/nirupagajera/MIS_Leave_Module");

        Select support_days = new Select(driver.findElement(By.name("support_days")));
        support_days.selectByVisibleText("60 Days");

        //For - sales Select start date
        plan_start_date = driver.findElement(By.xpath("//input[@ng-model = 'project_array.plan_start_date']"));
        plan_start_date.sendKeys("08-Apr-2021");

        plan_end_date = driver.findElement(By.xpath("//input[@ng-model = 'project_array.plan_end_date']"));
        plan_end_date.sendKeys("30-Sep-2024");

        driver.findElement(By.xpath("//*[@id=\"project-form\"]/div[2]")).click();
        save_button = driver.findElement(By.xpath("//button[text() = 'Save']"));
        save_button.click();
    }
}
