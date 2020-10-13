import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyHomeWorkTest extends CoreTestCase {//Comment for commit

    private MainPageObject mainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        mainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearchTextOfElement()
    {

        mainPageObject.assertElementHasText(
                "//*[contains(@text, 'Search Wikipedia')]",
                "Search Wikipedia",
                "Doesn't contain expected text"
        );
    }

    @Test
    public void testCancelSomeArticle()
    {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Android");
        searchPageObject.waitForSearchResult("Android");
        searchPageObject.waitForCancelButtonToAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelButtonToDisappear();

    }
    @Test
    public void testWaitForElementByTitleAndDescription() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Android");

        searchPageObject.waitForElementByTitleAndDescription("Android","Java");

    }

    @Test
    public void testCountXpath() {
        mainPageObject.waitForElementAndClick(
                "org.wikipedia:id/search_container",
                "Cannot find 'Search Wikipedia input'",
                5
        );

        mainPageObject.waitForElementAndSendKeys(
                "//*[contains(@text, 'Search…')]",
                "Android",
                "Cannot find search input",
                5
        );

        WebElement item =  mainPageObject.waitForElementPresent(
                "//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[contains(@text, 'Android')]",
                "Cannot find 'Android'",
                30
        );
        List<WebElement> elements = driver.findElements(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[contains(@text, 'Android')]"));
        for (WebElement element: elements) {
            if (element.getAttribute("text").contains("Android"))  {
                System.out.println("Результат поиска №" + " " + (elements.indexOf(element)+1) + " " + element.getAttribute("text") + " - " + "Содержит поисковый запрос 'Android'");
            }

        }
        WebElement title_element = mainPageObject.waitForElementPresent(
                "//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[contains(@text, 'Android')]",
                "Cannot find article title",
                15
        );
        String article_title = title_element.getAttribute("text");

        assertEquals(
                "We see unexpected title",
                "Android",
                article_title
        );
    }

    @Test
    public void testSearchTitleArticle()
    {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Appium");
        searchPageObject.clickByArticleWithSubstring("Appium");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.assertElementPresent();

    }

    @Test
    public void testSaveTwoArticleToMyList() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String name_of_folder = "Learning programming";

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("java");

        articlePageObject.addArticleToMyListFromContextMenu(name_of_folder, "Object-oriented programming language");

        searchPageObject.clickByArticleWithSubstring("Programming language");
        articlePageObject.waitForTitleElement();
        articlePageObject.addArticleToExistingList(name_of_folder);
        articlePageObject.closeArticle();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyList();

        MyListsPageObject myListsPageObject = MyListPageObjectFactory.get(driver);
        myListsPageObject.openFolderByName(name_of_folder);

        myListsPageObject.swipeByArticleToDelete("object-oriented programming language");
        searchPageObject.clickByArticleWithSubstring("JavaScript");

        String article_title = articlePageObject.getArticleTitle();
        assertEquals(
                "We see unexpected title",
                "JavaScript",
                article_title
        );
    }
    @Test
    public void testSaveTwoArticleToMyList2()
    {
        final String name_of_folder = "Learning programming";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String article_title = articlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToMyList(name_of_folder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }

        articlePageObject.closeArticle();

        searchPageObject.clickByArticleWithSubstring("Java (software platform)");
        articlePageObject.addArticlesToMySaved();
        articlePageObject.closeArticle();
        searchPageObject.clickCancelSearch();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyList();
        searchPageObject.clickCloseHint();

        MyListsPageObject myListsPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()){
            myListsPageObject.openFolderByName(name_of_folder);
        }

        myListsPageObject.swipeByArticleToDelete("Object-oriented programming language");
        searchPageObject.waitForElementByArticleName("Test Article For Error");


    }

    @Test
    public void testSaveTwoArticleToMyListWebMobile() {

        final String
                name_of_folder = "Learning programming",
                login = "LearnQA13",
                password = "1q_2w3e4r";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String article_title = articlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToMyList(name_of_folder);
        } else {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        articlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitButton();

            articlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login.",
                    article_title,
                    articlePageObject.getArticleTitle());

            articlePageObject.addArticlesToMySaved();
        }

        articlePageObject.closeArticle();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("java");
        searchPageObject.clickByArticleWithSubstring("Java (software platform)");
        articlePageObject.waitForTitleElement();
        articlePageObject.addArticlesToMySaved();


        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.openNavigation();
        navigationUI.clickMyList();

        MyListsPageObject myListsPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openFolderByName(name_of_folder);
        }

        myListsPageObject.swipeByArticleToDelete("Object-oriented programming language");
        myListsPageObject.waitForArticleToAppearByTitle("Test Article For Error");

    }

    @Test
    public void testCountOfSearchResultMobileWeb() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Jdsasfh");
        int amount_of_search_results = searchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found less then 3 results! actual amounts of search is " + amount_of_search_results,
                amount_of_search_results > 2
        );
    }

}
