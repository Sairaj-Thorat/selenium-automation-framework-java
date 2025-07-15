package com.tests;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.pages.OrangeHRMLoginPage;
import com.utils.DecodeUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest{

    private OrangeHRMTests(){}

    @FrameworkAnnotation(author={"tester_name_1", "tester_name_2"}, category = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void loginLogoutTest(Map<String, String> data) {
        String username = data.get("username");
        String password = DecodeUtils.getDecodedString(data.get("password"));

        String title = null;

        try {
            title = new OrangeHRMLoginPage()
                    .enterUsername(username).enterPassword(password).clickLogin()
                    .clickLogout().getTitle();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }


    @Test
    public void newTest(Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");

        String title = null;

        try {
            title = new OrangeHRMLoginPage()
                    .enterUsername(username).enterPassword(password).clickLogin()
                    .clickLogout().getTitle();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }


}
