package bnie1869serenity2.features.search;

import bnie1869serenity2.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicu on 20-May-18.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/TestData.csv")
public class Lab5Serenity {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    public String regNumber;
    public String name;
    public String group;
    public String shouldFail;

    @Qualifier
    public String getQualifier()
    {
        return regNumber;
    }

    @Steps
    public EndUserSteps endUser;

    @Issue("MY-SITE")
    @Test
    public void addNewStudentValid() {
        endUser.start_my_page();
        endUser.insert_student(regNumber, name, group);
        if(Integer.parseInt(shouldFail) == 1) {
            assertFalse(endUser.isStudentInserted(regNumber, name, group));
        }
        else
        {
            assertTrue(endUser.isStudentInserted(regNumber, name, group));
        }
    }

}
