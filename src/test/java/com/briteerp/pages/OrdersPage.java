package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

/**
 * Created by macik on 1/29/2019.
 */
public class OrdersPage extends BasePage {


    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
    public List<WebElement> OrderlistsNames;

    @FindBy(xpath = "//span[@class='o_field_char o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement OrderlistNameHeader;

    public OrdersPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public WebElement selectOrderlistName() {
        int rnd = new Random().nextInt(OrderlistsNames.size());
        WebElement orderlistName = OrderlistsNames.get(rnd);
        return orderlistName;
    }
}


