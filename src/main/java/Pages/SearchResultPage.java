package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {
    private WebDriver driver;


    @FindBy(xpath = "//a[text()='Не показывать варианты проживания в одном номере с другими гостями']")
    private WebElement noticeNoDorms;
    @FindBy(xpath = "//a[@data-id='ht_id-204']")
    private WebElement filterHotel;
    @FindBy(xpath = "//a[text()='Показать только отели']")
    private WebElement filterOnlyHotel;
    @FindBy(xpath = "//a[@data-id='oos-1']")
    private WebElement filterOnlyAvailableHotel;
    @FindBy(xpath = "//a[@data-name='any_deal']")
    private WebElement filterAnyDeal1;
    @FindBy(xpath = "//a[@data-id='hotelfacility-2'and @data-name='hotelfacility']")
    private WebElement linkFilterFacilityCollapsed;
    @FindBy(xpath = "//*[@id='filter_facilities']//div[@class='collapsed_partly_link collapsed_partly_more']")
    private WebElement filterFacilityParking;
    @FindBy(xpath = "//a[@data-id='fc-5']")
    private WebElement filterFacilityOrderWithoutPrepaiment;
    @FindBy(xpath = "//a[text()='Показать только отели']")
    private WebElement linkFilterOnlyHotels;
    @FindBy(xpath = "//div[@class='sr_header--title']/div/*[1]")
    private WebElement resultsText;
    @FindBy(xpath = "//a[@data-name='oos']")
    private WebElement onlyAvailableOptions;
    @FindBy(xpath = "//div[@id='hotellist_inner']/div[1]//span[@class='sr_hotel_expectation__text']")
    private WebElement srHotelExpectationText;
    @FindBy(xpath = "//div[@id='hotellist_inner']/div//span[@class='sr_hotel_expectation__text']")
    private WebElement srHotelExpectationTextAll;
    @FindBy(xpath = "//div[@id='hotellist_inner']/div//span[@class='sr_hotel_expectation__text']/../../..//span[@class='room_link']")
    private WebElement srHotelExpectationTextRoom;
    @FindBy(xpath = "//*[@class='sort_option_list']//a[@data-category='price']")
    private WebElement filterPrice;
    @FindBy(xpath = "//*[@class='sort_option_list']//a[@data-category='review_score_and_price']")
    private WebElement filterScoreAndPrice;
    @FindBy(xpath = "//*[@id='filter_review']//span[contains(text(),'Превосходно')]")
    private WebElement filterExcellent;
    @FindBy(xpath = "//div[@id='hotellist_inner']/div[1]//strong/b")
    private WebElement bPrice;
    @FindBy(xpath = "//*[@id='hotellist_inner']/div[1]//div[@class='bui-review-score__title']")
    private WebElement buiReviewScoreTitle;


    public void clickFromNoticeNoDorms() {
        noticeNoDorms.click();
    }

    public void setFilterHotel() {
        filterHotel.click();
    }

    public void setFilterOnlyHotel() {
        filterOnlyHotel.click();
    }

    public void setFilterOnlyAvailableHotel() {
        filterOnlyAvailableHotel.click();
    }

    public void setFilterAnyDeal1() {
        filterAnyDeal1.click();
    }

    public void setFilterFacilityParking() {
        filterFacilityParking.click();
    }

    public void clickFilterFacilityCollapsed() {
        linkFilterFacilityCollapsed.click();
    }

    public void setFilterFacilityFood() {
        filterFacilityOrderWithoutPrepaiment.click();
    }

    public void setFilterFacilityOrderWithoutPrepaiment() {
        filterFacilityOrderWithoutPrepaiment.click();
    }


    public void setFilterOnlyAvailableOptions() {
        onlyAvailableOptions.click();
    }

    public void setFilterPrice() {
        filterPrice.click();
    }

    public void setFilterScoreAndPrice() {
        filterScoreAndPrice.click();
    }

    public void setFilterExcellent() {
        filterExcellent.click();
    }


    public String resultsText() {
        return resultsText.getText();
    }

    public String textSrHotelExpectationTextRoom() {
          return srHotelExpectationTextRoom.getText();
    }

    public String resultsPriceText() {
              return bPrice.getText();
    }

    public String resultsBuiReviewScoreTitleText() {
                    return buiReviewScoreTitle.getText();
    }

    public boolean isAvailableLinkFilterOnlyHotels(){
        return isPresent(linkFilterOnlyHotels);
    }

    public boolean isFilterOnlyAvailableHotel(){
        return isPresent(filterOnlyAvailableHotel);
    }

    public boolean isAvailableNoticeNoDorms(){
        return isPresent(noticeNoDorms);
    }

    public boolean isOnlyAvailableOptions(){
        return isPresent(onlyAvailableOptions);
    }

    public boolean isPresentSrHotelExpectationText(){
        return isPresent(srHotelExpectationText);
    }

    public boolean isPresentSrHotelExpectationTextAll() {
        return isPresent(srHotelExpectationTextAll);
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
