package org.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

public class DictionaryPage {

    @FindBy(name = "search")
    private SelenideElement searchTerms;

    @FindBy(name = "go")
    private SelenideElement lookupButton;

    public List<String> getDefinitions() {
        return $$("ol li").texts();
    }

    public void searchFor(String query) {
        searchTerms.val(query);
        lookupButton.click();
    }

    public void shouldSeeDefinition(String definition) {
        assertTrue("Should see definition '"+definition+"', but sees only these definitions: " + getDefinitions(),
                getDefinitions().contains(definition));
    }
}
