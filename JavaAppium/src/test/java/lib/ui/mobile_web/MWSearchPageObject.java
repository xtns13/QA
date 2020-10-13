package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:div>button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_BY_SUBSTRING_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[contains(@text, '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        ClOSE_HINT = "xpath://XCUIElementTypeButton[@name='Close']";
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}

