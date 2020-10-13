package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject
{

    private static final String
    STEP_LEARN_MORE_LINK = "xpath://*[contains(@name, 'Learn more about Wikipedia')]",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LINK = "id:Search in nearly 300 languages",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Help make the app better",
    NEXT_LINK = "xpath://*[contains(@name, 'Next')]",
    GET_STARTED_BUTTON = "xpath://*[@name='Get started']",
    SKIP = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Learn more about Wikipedia' Link", 10);
    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore' Link", 10);
    }

    public void waitForAddOrPreferredLangText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LINK, "Cannot find 'Search in nearly 300 languages' Link", 10);
    }

    public void waitForLeanMoreAboutDataCollectedText()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Help make the app better' Link", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_LINK, "Cannot find and click 'Next' Link", 10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click 'Get started button' link", 10);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP, "Cannot find and click SKIP button", 5);
    }
}

