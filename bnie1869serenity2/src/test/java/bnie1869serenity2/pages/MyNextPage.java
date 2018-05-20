package bnie1869serenity2.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class MyNextPage extends PageObject {
    public List<String> getStudents() {
        WebElementFacade definitionList = find(By.tagName("ul")).waitUntilPresent();
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}