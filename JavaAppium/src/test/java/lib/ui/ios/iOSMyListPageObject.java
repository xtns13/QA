package lib.ui.ios;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        SWIPE_ACTION_DELETE = "id:swipe action delete";
    }

    public iOSMyListPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
