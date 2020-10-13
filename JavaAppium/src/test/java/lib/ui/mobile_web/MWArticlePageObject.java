package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer.mw-footer";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#ca-watch[title='Remove this page from your watchlist']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions-watch a#ca-watch";
    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}

