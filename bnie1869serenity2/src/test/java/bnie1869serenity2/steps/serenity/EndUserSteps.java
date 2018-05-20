package bnie1869serenity2.steps.serenity;

import bnie1869serenity2.pages.DictionaryPage;
import bnie1869serenity2.pages.MyNextPage;
import bnie1869serenity2.pages.MyPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;
    MyPage myPage;
    MyNextPage myNextPage;


    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }


    @Step
    public void start_my_page() {
        myPage.open();
    }

    @Step
    public void insert_student(
            String regnumber,
            String name,
            String group
    )
    {
        myPage.enterGroup(group);
        myPage.enterName(name);
        myPage.enterRegNumber(regnumber);
        try {
            myPage.addNew();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step
    public boolean isStudentInserted(
            String regnumber,
            String name,
            String group
    )
    {
        String shouldSee = regnumber + "---" + name + "---" + group;
        return myNextPage.getStudents().contains(shouldSee);
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}