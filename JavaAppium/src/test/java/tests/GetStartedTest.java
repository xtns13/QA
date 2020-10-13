package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPastThroughWelcome()
    {

        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW()))
        {
            return;
        }

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);

        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWayToExploreText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrPreferredLangText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForLeanMoreAboutDataCollectedText();
        welcomePageObject.clickGetStartedButton();
    }
}
