import Pages.MainPage;
import Pages.SearchResultPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBooking {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private WebDriverWait wait;


    public void setUpBrowser(String browserName, String deviceName,
                             Integer width, Integer height) {
        if (browserName == null || browserName.isEmpty()) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else {
            if (browserName.contentEquals("Chrome")) {
                if (deviceName != null && !(deviceName == "")) {
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    mobileEmulation.put("deviceName", deviceName);

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                    driver = new ChromeDriver(chromeOptions);

                } else {
                    driver = new ChromeDriver();
                }
            } else {
                driver = new ChromeDriver();
            }
        }

        if (deviceName != null && !(deviceName == "")) {
            if (width != null && width != 0 && height != null && height != 0) {
                Dimension dimension = new Dimension(width, height);
                driver.manage().window().setSize(dimension);
            }
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"Browser", "Device", "Width", "Height"})
    public void start(@Optional String browserName,
                      @Optional String deviceName,
                      @Optional Integer width,
                      @Optional Integer height) {

        setUpBrowser(browserName, deviceName, width, height);

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        driver.get("https://www.booking.com/");

        mainPage = PageFactory.initElements(driver, MainPage.class);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void finish() {
        driver.quit();
    }

    @Test(priority = 1, groups = {"canFind"})
    public void canFindHotelsRoomsNearestWeekend() {

        int availableResult = 3;

        mainPage.inputPlace("Минск");
        mainPage.placesNames();
        mainPage.setNearestSaturday();
        mainPage.setNextDay();
        mainPage.labelGuests();
        if (mainPage.isPresentNoRooms()) {
            mainPage.selectRooms();
            mainPage.roomsValue();
            mainPage.groupAdults();
            mainPage.groupAdultsValue2();
            mainPage.groupChildren();
            mainPage.groupChildren0();
        } else {
            int room = 1;
            int intRoomsValue = 0;
            do {
                String roomsValue = mainPage.displayRooms();
                intRoomsValue = Integer.parseInt(roomsValue);
                if (room > intRoomsValue) {
                    mainPage.roomsAddButton();
                }
                if (room < intRoomsValue) {
                    mainPage.roomsSubtractButton();
                }
            } while (room != intRoomsValue);

            int adult = 2;
            int thisAdult = 0;
            do {
                String adultValue = mainPage.displayAdults();
                thisAdult = Integer.parseInt(adultValue);
                if (adult > thisAdult) {
                    mainPage.adultsAddButton();
                }
                if (adult < thisAdult) {
                    mainPage.adultsSubtractButton();
                }
            } while (adult != thisAdult);

            int children = 0;
            int thisСhildren = 0;
            do {
                String childrenValue = mainPage.displayChildren();
                thisСhildren = Integer.parseInt(childrenValue);
                if (children > thisСhildren) {
                    mainPage.childrenAddButton();
                }
                if (children < thisСhildren) {
                    mainPage.childrenSubtractButton();
                }
            } while (children != thisСhildren);
        }
        mainPage.checkPriceButton();
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        if (searchResultPage.isFilterOnlyAvailableHotel()) {
            searchResultPage.setFilterOnlyAvailableHotel();
        }
        searchResultPage.setFilterHotel();
        if (searchResultPage.isAvailableLinkFilterOnlyHotels()) {
            searchResultPage.setFilterOnlyHotel();
        }
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        String results = searchResultPage.resultsText();
        int result = Integer.parseInt(results.replaceAll("\\D+", ""));

        Assert.assertTrue(result > availableResult, "PlacesName Минск, Search results Have found enough free Hotels room");
    }


    @Test(dataProvider = "getPlacesName", groups = {"canFind"})
    public void canFind_dataProvider(String getPlacesName) {
        int availableResult = 3;

        mainPage.inputPlace(getPlacesName);
        mainPage.placesNames();
        mainPage.setNearestSaturday();
        mainPage.setNextDay();
        mainPage.labelGuests();
        if (mainPage.isPresentNoRooms()) {
            mainPage.selectRooms();
            mainPage.roomsValue();
            mainPage.groupAdults();
            mainPage.groupAdultsValue2();
            mainPage.groupChildren();
            mainPage.groupChildren0();
        } else {
            int room = 1;
            int thisRoomsValue = 0;
            do {
                String roomsValue = mainPage.displayRooms();
                thisRoomsValue = Integer.parseInt(roomsValue);
                if (room > thisRoomsValue) {
                    mainPage.roomsAddButton();
                }
                if (room < thisRoomsValue) {
                    mainPage.roomsSubtractButton();
                }
            } while (room != thisRoomsValue);

            int adult = 2;
            int intAdult = 0;
            do {
                String adultValue = mainPage.displayAdults();
                intAdult = Integer.parseInt(adultValue);
                if (adult > intAdult) {
                    mainPage.adultsAddButton();
                }
                if (adult < intAdult) {
                    mainPage.adultsSubtractButton();
                }
            } while (adult != intAdult);

            int children = 0;
            int thisСhildren = 0;
            do {
                String childrenValue = mainPage.displayChildren();
                thisСhildren = Integer.parseInt(childrenValue);
                if (children > thisСhildren) {
                    mainPage.childrenAddButton();
                }
                if (children < thisСhildren) {
                    mainPage.childrenSubtractButton();
                }
            } while (children != thisСhildren);
        }
        mainPage.checkPriceButton();
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        if (searchResultPage.isFilterOnlyAvailableHotel()) {
            searchResultPage.setFilterOnlyAvailableHotel();
        }
        searchResultPage.setFilterHotel();
        if (searchResultPage.isAvailableLinkFilterOnlyHotels()) {
            searchResultPage.setFilterOnlyHotel();
        }
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        String results = searchResultPage.resultsText();
        int result = Integer.parseInt(results.replaceAll("\\D+", ""));

        Assert.assertTrue(result > availableResult, " " + results + "; Search results Have found enough free Hotels room");
    }

    @Test(priority = 2, groups = {"canFind"})
    public void canFindHotelsRoomsNearestWeekendTwoChildren() {

        int availableResult = 3;
        int[] childrenAge = {5, 15};

        mainPage.inputPlace("Минск");
        mainPage.placesNames();
        mainPage.setNearestSaturday();
        mainPage.setNextDay();
        mainPage.labelGuests();
        if (mainPage.isPresentNoRooms()) {
            mainPage.selectRooms();
            mainPage.roomsValue();
            mainPage.groupAdults();
            mainPage.groupAdultsValue2();
            mainPage.groupChildren02();
        } else {
            int room = 1;
            int thisRoomsValue = 0;
            do {
                String roomsValue = mainPage.displayRooms();
                thisRoomsValue = Integer.parseInt(roomsValue);
                if (room > thisRoomsValue) {
                    mainPage.roomsAddButton();
                }
                if (room < thisRoomsValue) {
                    mainPage.roomsSubtractButton();
                }
            } while (room != thisRoomsValue);

            int adult = 2;
            int thisAdult = 0;
            do {
                String adultValue = mainPage.displayAdults();
                thisAdult = Integer.parseInt(adultValue);
                if (adult > thisAdult) {
                    mainPage.adultsAddButton();
                }
                if (adult < thisAdult) {
                    mainPage.adultsSubtractButton();
                }
            } while (adult != thisAdult);

            int children = 2;
            int thisСhildren = 0;
            do {
                String childrenValue = mainPage.displayChildren();
                thisСhildren = Integer.parseInt(childrenValue);
                if (children > thisСhildren) {
                    mainPage.childrenAddButton();
                }
                if (children < thisСhildren) {
                    mainPage.childrenSubtractButton();
                }
            } while (children != thisСhildren);
        }
        mainPage.groupChildren1();
        mainPage.setGroupChildrenAge5();
        mainPage.groupChildren2();
        mainPage.setGroupChildrenAge15();
        mainPage.checkPriceButton();
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        if (searchResultPage.isAvailableLinkFilterOnlyHotels()) {
            searchResultPage.setFilterOnlyHotel();
        }
        searchResultPage.setFilterHotel();
        if (searchResultPage.isFilterOnlyAvailableHotel()) {
            searchResultPage.setFilterOnlyAvailableHotel();
        }
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        String results = searchResultPage.resultsText();
        int result = Integer.parseInt(results.replaceAll("\\D+", ""));

        Assert.assertTrue(result > availableResult, "PlacesName Минск, Search results Have found enough free Hotels room");
    }

    @Test(priority = 2, groups = {"canReach"})
    public void canFindRoomsNearestMondayMaxQuality() {
        mainPage.inputPlace("Минск");
        mainPage.placesNames();
        mainPage.setNearestMonday();
        mainPage.setNextDay();
        mainPage.labelGuests();
        if (mainPage.isPresentNoRooms()) {
            mainPage.selectRooms();
            mainPage.roomsValue();
            mainPage.groupAdults();
            mainPage.groupAdultsValue2();
            mainPage.groupChildren();
            mainPage.groupChildren0();
        } else {
            int room = 1;
            int thisRoomsValue = 0;
            do {
                String roomsValue = mainPage.displayRooms();
                thisRoomsValue = Integer.parseInt(roomsValue);
                if (room > thisRoomsValue) {
                    mainPage.roomsAddButton();
                }
                if (room < thisRoomsValue) {
                    mainPage.roomsSubtractButton();
                }
            } while (room != thisRoomsValue);

            int adult = 2;
            int thisAdult = 0;
            do {
                String adultValue = mainPage.displayAdults();
                thisAdult = Integer.parseInt(adultValue);
                if (adult > thisAdult) {
                    mainPage.adultsAddButton();
                }
                if (adult < thisAdult) {
                    mainPage.adultsSubtractButton();
                }
            } while (adult != thisAdult);

            int children = 0;
            int thisСhildren = 0;
            do {
                String childrenValue = mainPage.displayChildren();
                thisСhildren = Integer.parseInt(childrenValue);
                if (children > thisСhildren) {
                    mainPage.childrenAddButton();
                }
                if (children < thisСhildren) {
                    mainPage.childrenSubtractButton();
                }
            } while (children != thisСhildren);
        }
        mainPage.checkPriceButton();
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        if (searchResultPage.isOnlyAvailableOptions()) {
            searchResultPage.setFilterOnlyAvailableOptions();
        }
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        Boolean resultFoundExpectationText = searchResultPage.isPresentSatisfiedAll();

        Assert.assertTrue(resultFoundExpectationText, "Search results Have found room Max Quality with 100% satisfactions");
    }

    @Test(priority = 2, groups = {"canReach"})
    public void canFindRoomsNearestMondayMaxQualityIsApartments() {
        mainPage.inputPlace("Минск");
        mainPage.placesNames();
        mainPage.setNearestMonday();
        mainPage.setNextDay();
        mainPage.labelGuests();
        if (mainPage.isPresentNoRooms()) {
            mainPage.selectRooms();
            mainPage.roomsValue();
            mainPage.groupAdults();
            mainPage.groupAdultsValue2();
            mainPage.groupChildren();
            mainPage.groupChildren0();
        } else {
            int room = 1;
            int intRoomsValue = 0;
            do {
                String roomsValue = mainPage.displayRooms();
                intRoomsValue = Integer.parseInt(roomsValue);
                if (room > intRoomsValue) {
                    mainPage.roomsAddButton();
                }
                if (room < intRoomsValue) {
                    mainPage.roomsSubtractButton();
                }
            } while (room != intRoomsValue);

            int adult = 2;
            int thisAdult = 0;
            do {
                String adultValue = mainPage.displayAdults();
                thisAdult = Integer.parseInt(adultValue);
                if (adult > thisAdult) {
                    mainPage.adultsAddButton();
                }
                if (adult < thisAdult) {
                    mainPage.adultsSubtractButton();
                }
            } while (adult != thisAdult);

            int children = 0;
            int thisСhildren = 0;
            do {
                String childrenValue = mainPage.displayChildren();
                thisСhildren = Integer.parseInt(childrenValue);
                if (children > thisСhildren) {
                    mainPage.childrenAddButton();
                }
                if (children < thisСhildren) {
                    mainPage.childrenSubtractButton();
                }
            } while (children != thisСhildren);
        }
        mainPage.checkPriceButton();
        searchResultPage.setFilterRankScoreAndPrice();

        if (searchResultPage.isOnlyAvailableOptions()) {
            searchResultPage.setFilterOnlyAvailableOptions();
        }
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        Boolean resultFoundExpectationText = searchResultPage.isPresentSatisfiedAll();
        String roomsValue = searchResultPage.textRoomsName();
        Boolean isApartments = roomsValue.contains("Апартаменты");

        Assert.assertTrue(resultFoundExpectationText, "Have found room with label: This option met or exceed the expectations of 100% of guests who left a review.");

        Assert.assertTrue(isApartments,"Rooms class is Apartments");

        Assert.assertEquals(resultFoundExpectationText, isApartments, "Have found room with label: This option met or exceed the expectations of 100% of guests who left a review, name is Apartments");
    }

    @Test(priority = 1, groups = {"canFind"})
    public void canFindHotelsCheapestRoomToday() {
        int maxSetPrice = 40;
        mainPage.inputPlace("Минск");
        mainPage.placesNames();
        mainPage.setToday();
        mainPage.setNextDay();
        mainPage.labelGuests();
        if (mainPage.isPresentNoRooms()) {
            mainPage.selectRooms();
            mainPage.roomsValue();
            mainPage.groupAdults();
            mainPage.groupAdultsValue2();
            mainPage.groupChildren();
            mainPage.groupChildren0();
        } else {
            int room = 1;
            int intRoomsValue = 0;
            do {
                String roomsValue = mainPage.displayRooms();
                intRoomsValue = Integer.parseInt(roomsValue);
                if (room > intRoomsValue) {
                    mainPage.roomsAddButton();
                }
                if (room < intRoomsValue) {
                    mainPage.roomsSubtractButton();
                }
            } while (room != intRoomsValue);

            int adult = 2;
            int thisAdult = 0;
            do {
                String adultValue = mainPage.displayAdults();
                thisAdult = Integer.parseInt(adultValue);
                if (adult > thisAdult) {
                    mainPage.adultsAddButton();
                }
                if (adult < thisAdult) {
                    mainPage.adultsSubtractButton();
                }
            } while (adult != thisAdult);

            int children = 0;
            int thisСhildren = 0;
            do {
                String childrenValue = mainPage.displayChildren();
                thisСhildren = Integer.parseInt(childrenValue);
                if (children > thisСhildren) {
                    mainPage.childrenAddButton();
                }
                if (children < thisСhildren) {
                    mainPage.childrenSubtractButton();
                }
            } while (children != thisСhildren);
        }
        mainPage.checkPriceButton();
        searchResultPage.setFilterRankPrice();
        searchResultPage.setFilterHotel();
        if (searchResultPage.isFilterOnlyAvailableHotel()) {
            searchResultPage.setFilterOnlyAvailableHotel();
        }
        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        if (searchResultPage.isAvailableLinkFilterOnlyHotels()) {
            searchResultPage.setFilterOnlyHotel();
        }
        String resultPriceText = searchResultPage.resultsPriceText();
        int resultPrice = Integer.parseInt(resultPriceText.replaceAll("\\D+", ""));

        Assert.assertTrue(resultPrice < maxSetPrice, "PlacesName Минск, Search results less maxSetPrice");

    }

    @Test(priority = 1, groups = {"canFind"})
    public void canFindRoomBestQualityLowPriceToday() {

        mainPage.inputPlace("Минск");
        mainPage.placesNames();
        mainPage.setToday();
        mainPage.setNextDay();
        mainPage.labelGuests();
        if (mainPage.isPresentNoRooms()) {
            mainPage.selectRooms();
            mainPage.roomsValue();
            mainPage.groupAdults();
            mainPage.groupAdultsValue2();
            mainPage.groupChildren();
            mainPage.groupChildren0();
        } else {
            int room = 1;
            int thisRoomsValue = 0;
            do {
                String roomsValue = mainPage.displayRooms();
                thisRoomsValue = Integer.parseInt(roomsValue);
                if (room > thisRoomsValue) {
                    mainPage.roomsAddButton();
                }
                if (room < thisRoomsValue) {
                    mainPage.roomsSubtractButton();
                }
            } while (room != thisRoomsValue);

            int adult = 2;
            int intAdult = 0;
            do {
                String adultValue = mainPage.displayAdults();
                intAdult = Integer.parseInt(adultValue);
                if (adult > intAdult) {
                    mainPage.adultsAddButton();
                }
                if (adult < intAdult) {
                    mainPage.adultsSubtractButton();
                }
            } while (adult != intAdult);

            int children = 0;
            int thisСhildren = 0;
            do {
                String childrenValue = mainPage.displayChildren();
                thisСhildren = Integer.parseInt(childrenValue);
                if (children > thisСhildren) {
                    mainPage.childrenAddButton();
                }
                if (children < thisСhildren) {
                    mainPage.childrenSubtractButton();
                }
            } while (children != thisСhildren);
        }
        mainPage.checkPriceButton();
        searchResultPage.setFilterRankScoreAndPrice();

        if (searchResultPage.isAvailableLinkFilterNoticeNoDorms()) {
            searchResultPage.clickLinkFilterNoticeNoDorms();
        }
        if (searchResultPage.isFilterOnlyAvailableHotel()) {
            searchResultPage.setFilterOnlyAvailableHotel();
        }
        searchResultPage.setFilterTodayAnyDeal1();
        searchResultPage.setFilterFacilityOrderWithoutPrepaiment();
        searchResultPage.clickFilterFacilityCollapsed();
        searchResultPage.setFilterFacilityParking();
        searchResultPage.setFilterFacilityFood();
        searchResultPage.setFilterExcellent();

        String resultsBuiReviewScoreTitleText = searchResultPage.resultsBuiReviewScoreTitleText();

        Assert.assertEquals("Великолепно", resultsBuiReviewScoreTitleText, "Search result should contain 'Великолепно'");
    }

    @DataProvider
    public Object[][] getPlacesName() {
        return new Object[][]{{"Минск"}, {"Витебск"}, {"Брест"}, {"Гродно"}, {"Гомель"}, {"Могилев"}};
    }
}
