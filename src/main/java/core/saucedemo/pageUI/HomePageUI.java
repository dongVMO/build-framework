package core.saucedemo.pageUI;

import org.openqa.selenium.By;

public class HomePageUI {
    public static final By TITLE_HOME_PAGE = By.xpath("//div[@class='app_logo']");
    public static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    public static final By LIST_PRODUCT = By.xpath("//div[@class=\"inventory_item_label\"]/following-sibling::div/button[text()='Add to cart']");
    public static final By ITEM_CARD = By.className("shopping_cart_badge");
    public static final By LIST_NAME_PRODUCT = By.xpath("//button[text()='Remove']/../../div[@class='inventory_item_label']//div[@class='inventory_item_name']");
}
