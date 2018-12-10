package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;


    @FindBy(id = "ss")
    private WebElement inputPlace;
    @FindBy(className = "search_hl_name")
    private WebElement placesNames;
    @FindBy(xpath = "//td[contains(@class,'today')]")
    private WebElement today;
    @FindBy(xpath = "//td[contains(@class,'selected')]/./following-sibling::td[@class='bui-calendar__date'][1]|//td[contains(@class,'selected')]/../following-sibling::*[1]/td[@class='bui-calendar__date'][1] |//div[@class='bui-calendar__wrapper'][2]//tr[2]/td[@data-bui-ref='calendar-date'][1]")
    private WebElement nextDay;
    @FindBy(xpath = "//td[contains(@class,'today')]/../td[@class='bui-calendar__date'][last()-1]|//td[contains(@class,'today')]/../following-sibling::*[1]/td[@class='bui-calendar__date'][6]|//div[@class='bui-calendar__wrapper'][2]//tr[2]/td[@data-bui-ref='calendar-date'][last()-1]|//div[@class='bui-calendar__wrapper'][2]//tr[2]/td[not(@class='bui-calendar__date')][6]/../following-sibling::tr[1]//td[@class='bui-calendar__date'][6]")
    private WebElement nearestSaturday;
    @FindBy(xpath = "//td[contains(@class,'today')]/../following-sibling::*[1]/td[@class='bui-calendar__date'][1]|//div[@class='bui-calendar__wrapper'][2]//tr[2]/td[@data-bui-ref='calendar-date'][last()-6]|//div[@class='bui-calendar__wrapper'][2]//tr[2]/td[not(@class='bui-calendar__date')][1]/../following-sibling::tr[1]//td[@class='bui-calendar__date'][1]")
    private WebElement nearestMonday;
    @FindBy(xpath = "//label[@class='xp__input ']")
    private WebElement labelGuests;
    @FindBy(xpath = "//select[@id='no_rooms']")
    private WebElement selectRooms;
    @FindBy(xpath = "//select[@id='no_rooms']//option[@value='1']")
    private WebElement roomsValue1;
    @FindBy(xpath = "//*[@id='group_adults']")
    private WebElement groupAdults;
    @FindBy(xpath = "//*[@id='group_adults']//option[@value='2']")
    private WebElement groupAdultsValue2;
    @FindBy(xpath = "//*[@name='group_children']")
    private WebElement groupChildren;
    @FindBy(xpath = "//*[@name='group_children']//option[@value='0']")
    private WebElement groupChildren0;
    @FindBy(xpath = "//*[@name='group_children']//option[@value='2']")
    private WebElement groupChildren02;
    @FindBy(xpath = "//div[@class='sb-group__children__field clearfix']/select[1]")
    private WebElement groupChildren1;
    @FindBy(xpath = "//div[@class='sb-group__children__field clearfix']/select[1]/option[@value='5']")
    private WebElement groupChildrenAge5;
    @FindBy(xpath = "//div[@class='sb-group__children__field clearfix']/select[2]")
    private WebElement groupChildren2;
    @FindBy(xpath = "//div[@class='sb-group__children__field clearfix']/select[2]/option[@value='15']")
    private WebElement groupChildrenAge15;
    @FindBy(xpath = "//div[contains(@class,'field-rooms')] //span[@class='bui-stepper__display']")
    private WebElement displayRooms;
    @FindBy(xpath = "//div[contains(@class,'field-rooms')] //button[contains(@class,'bui-stepper__add-button')]")
    private WebElement roomsAddButton;
    @FindBy(xpath = "//div[contains(@class,'field-rooms')] //button[contains(@class,'bui-stepper__subtract-button')]")
    private WebElement roomsSubtractButton;
    @FindBy(xpath = "//*[text()='Взрослых']/../..//span[@class='bui-stepper__display']")
    private WebElement displayAdults;
    @FindBy(xpath = "//*[text()='Взрослых']/../..//button[contains(@class,'bui-stepper__add-button')]")
    private WebElement adultsAddButton;
    @FindBy(xpath = "//*[text()='Взрослых']/../..//button[contains(@class,'bui-stepper__subtract-button')]")
    private WebElement adultsSubtractButton;
    @FindBy(xpath = "//*[text()='Детей']/../..//span[@class='bui-stepper__display']")
    private WebElement displayChildren;
    @FindBy(xpath = "//*[text()='Детей']/../..//button[contains(@class,'bui-stepper__add-button')]")
    private WebElement childrenAddButton;
    @FindBy(xpath = "//*[text()='Детей']/../..//button[contains(@class,'bui-stepper__subtract-button')]")
    private WebElement childrenSubtractButton;
    @FindBy(xpath = "//span[text()='Проверить цены']")
    private WebElement checkPriceButton;
    @FindBy(xpath = "//select[@id='no_rooms']")
    private WebElement noRooms;


    public void inputPlace(String getPlacesName) {
        inputPlace.sendKeys(getPlacesName);
    }

    public void placesNames() {
        placesNames.click();
    }

    public void setToday() {
        today.click();
    }

    public void setNextDay() {
        nextDay.click();
    }

    public void setNearestSaturday() {
        nearestSaturday.click();
    }

    public void setNearestMonday() {
        nearestMonday.click();
    }

    public void labelGuests() {
        labelGuests.click();
    }

    public void selectRooms() {
        selectRooms.click();
    }

    public void roomsValue() {
        roomsValue1.click();
    }

    public void groupAdults() {
        groupAdults.click();
    }

    public void groupAdultsValue2() {
        groupAdultsValue2.click();
    }

    public void groupChildren() {
        groupChildren.click();
    }

    public void groupChildren0() {
        groupChildren0.click();
    }

    public void groupChildren02() {
        groupChildren02.click();
    }

    public void groupChildren1() {
        groupChildren1.click();
    }

    public void groupChildren2() {
        groupChildren2.click();
    }

    public void setGroupChildrenAge5() {
        groupChildrenAge5.click();
    }

    public void setGroupChildrenAge15() {
        groupChildrenAge15.click();
    }

    public void roomsAddButton() {
        roomsAddButton.click();
    }

    public void roomsSubtractButton() {
        roomsSubtractButton.click();
    }

    public void adultsAddButton() {
        adultsAddButton.click();
    }

    public void adultsSubtractButton() {
        adultsSubtractButton.click();
    }

    public void childrenAddButton() {
        childrenAddButton.click();
    }

    public void childrenSubtractButton() {
        childrenSubtractButton.click();
    }

    public void checkPriceButton() {
        checkPriceButton.click();
    }

    public String displayRooms() {
        return displayRooms.getText();
    }

    public String displayAdults() {
        return displayAdults.getText();
    }

    public String displayChildren() {
        return displayChildren.getText();
    }

    public boolean isPresentNoRooms() {
        return isPresent(noRooms);
    }

    public boolean isPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (
                NoSuchElementException e) {
        }
        return false;
    }
}