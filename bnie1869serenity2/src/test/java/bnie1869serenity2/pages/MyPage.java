package bnie1869serenity2.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://localhost/vvss/index.php")
public class MyPage extends PageObject {

    @FindBy(name="regnumber")
    private WebElementFacade regNumber;

    @FindBy(name="name")
    private WebElementFacade name;

    @FindBy(name="group")
    private WebElementFacade group;

    @FindBy(name="add")
    private WebElementFacade addButton;

    public void enterRegNumber(String myRegNumber) {
        regNumber.type(myRegNumber);
    }

    public void enterName(
            String myName
    )
    {
        name.type(myName);
    }

    public void enterGroup(String myGroup)
    {
        group.type(myGroup);
    }

    public void addNew() throws InterruptedException {
        addButton.click();
        switchToPage(MyNextPage.class);
    }
}