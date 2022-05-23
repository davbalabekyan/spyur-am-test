package core;

import org.openqa.selenium.WebElement;

public final class UiHelper {

    private UiHelper(){}

    public static void clickOnWebElement(final WebElement target){
        WaitHelper.waitElementToBeClickable(target);
        WaitHelper.waitElementToBeVisible(target);
        target.click();
    }
}
