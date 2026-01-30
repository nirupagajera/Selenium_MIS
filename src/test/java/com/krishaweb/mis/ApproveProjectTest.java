package com.krishaweb.mis;

import org.testng.annotations.Test;

import com.krishaweb.mis.base.BaseTest;
import com.krishaweb.mis.pages.AdminApproveProjectPage;
import com.krishaweb.mis.pages.LoginPage;

public class ApproveProjectTest extends BaseTest {

    @Test
    public void approveProjectRequest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsMitesh(); // from your second file

        AdminApproveProjectPage approvalPage = new AdminApproveProjectPage(driver);
        approvalPage.approveProjectRequest(); // your approve_project_request() body
    }
}
 