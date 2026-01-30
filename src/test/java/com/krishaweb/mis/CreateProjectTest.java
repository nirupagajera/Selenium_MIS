package com.krishaweb.mis;

import org.testng.annotations.Test;

import com.krishaweb.mis.base.BaseTest;
import com.krishaweb.mis.pages.LoginPage;
import com.krishaweb.mis.pages.ProjectRequestPage;

public class CreateProjectTest extends BaseTest {

    @Test
    public void createProjectRequest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsNisarg();  // from your first file

        ProjectRequestPage projectPage = new ProjectRequestPage(driver);
        projectPage.createProject(); // your create_project() body
    }
}
