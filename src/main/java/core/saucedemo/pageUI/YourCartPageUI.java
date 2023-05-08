package core.saucedemo.pageUI;

import org.openqa.selenium.By;

public class YourCartPageUI {
    public static final By YOUR_CART_TITLE = By.xpath("//span[text()='Your Cart']");
    public static final By LIST_NAME_PRODUCT = By.xpath("//button[text()='Remove']/../../a/div[@class='inventory_item_name']");
}
