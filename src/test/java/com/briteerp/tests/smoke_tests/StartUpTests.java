package com.briteerp.tests.smoke_tests;

import com.briteerp.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by macik on 1/29/2019.
 */
public class StartUpTests extends TestBase {


//    Mehmet Acikgoz -BRIT 948
    @Test
    public void validProductPageHeader(){
        extentLogger = report.createTest("Product Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().tabTitle,
                                                       ApplicationConstants.PRODUCTS_PAGE_HEADER, timeOutInSec);

        extentLogger.info("Verify that product page has the header " + ApplicationConstants.PRODUCTS_PAGE_HEADER );

        assertEquals(pages.products().tabTitle.getText(), ApplicationConstants.PRODUCTS_PAGE_HEADER);

        extentLogger.pass("Completed: Product Page Header Test");
    }

//    Mehmet Acikgoz -BRIT-945
    @Test
    public void validProductNameWhenClicked(){
        extentLogger = report.createTest("Valid Product Name ");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);

        BrowserUtils.waitForClickablility(product, timeOutInSec);
        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product);
        BrowserUtils.waitForVisibility(pages.products().detailsProductNameLabel, timeOutInSec);

        extentLogger.info("Verify that product name is the same as previous page");
        assertEquals(pages.products().detailsProductNameLabel.getText(), productName);

        extentLogger.pass("Completed: Valid Product Name ");
    }

    //    Mehmet Keles
    @Test
    public void checkPricelistsPageHeader() {
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.PRICELISTS_PAGE_HEADER);
        assertEquals(pages.pricelist().tabTitle.getText(), ApplicationConstants.PRICELISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Pricelists Page Header Test");

    }


    //    Mehmet Keles
    @Test
    public void checkPricelistNameHeader() {
        extentLogger = report.createTest("Pricelists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Pricelists");
        pages.pointOfSale().priceListLink.click();

        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        extentLogger.info("Selecting the Pricelist name randomly  : " + pricelistName);

        BrowserUtils.waitForClickablility(pricelistNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + pricelistName);
        pricelistNameElement.click();

        String pricelistNameOnHeader = pages.pricelist().pricelistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(pricelistNameOnHeader, pricelistName);

    }

    //    Serkan Danisman
    @Test
    public void checkOrderlistsPageHeader() {
        extentLogger = report.createTest("Orderlists Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Orderlists");
        pages.pointOfSale().ordersLink.click();

        BrowserUtils.wait(10);
        extentLogger.info("Verify that Pricelists page has the header " + ApplicationConstants.ORDERLISTS_PAGE_HEADER);
        assertEquals(pages.orders().tabTitle.getText(), ApplicationConstants.ORDERLISTS_PAGE_HEADER);

        extentLogger.pass("Completed: Pricelists Page Header Test");

    }

    //    Serkan Danisman
    @Test
    public void checkOrdersNameHeader() {
        extentLogger = report.createTest("Order Page Header Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the OrdersLists");
        pages.pointOfSale().ordersLink.click();

        WebElement OrdersNameElement = pages.orders().selectOrderlistName();
        String OrderlistName = OrdersNameElement.getText();
        extentLogger.info("Selecting the Order randomly  : " + OrderlistName);

        BrowserUtils.waitForClickablility(OrdersNameElement, timeOutInSec);
        extentLogger.info("Clicking on the " + OrderlistName);
        OrdersNameElement.click();

        String OrderlistNameHeader = pages.orders().OrderlistNameHeader.getText();
        extentLogger.info("Verify that pricelist name is displayed on heading");
        assertEquals(OrderlistNameHeader, OrderlistName);
    }

    //    Yilmaz USTA
    @Test
    public void checkDescriptionForCustomersInNotes() {
        extentLogger = report.createTest("Description for Customers in Notes Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product);

        extentLogger.info("Clicking on the Notes Tab");
        BrowserUtils.waitForClickablility(pages.products().NotesTab, timeOutInSec);
        pages.products().NotesTab.click();

        extentLogger.info("Verify that user can see Description for Customer in Notes tab.");
        Assert.assertEquals(pages.products().descriptionForCustomer.getText(), "Description for Customers");
        extentLogger.pass("Completed: Description for Customers in Notes Test");

    }

    //    Yilmaz USTA
    @Test
    public void checkDescriptionForInternalInNotes() {
        extentLogger = report.createTest("Description for Internal in Notes Test");
        getMeToPointOfSalesAs("user");

        extentLogger.info("Click on the Products Link");
        pages.pointOfSale().productsLink.click();

        String productName = pages.products().selectAnyProduct();
        extentLogger.info("Selecting the Product randomly  : " + productName);
        WebElement product = pages.products().selectProduct(productName);

        extentLogger.info("Clicking on the " + productName);
        pages.products().clickOnProduct(product);

        extentLogger.info("Clicking on the Notes Tab");
        BrowserUtils.waitForClickablility(pages.products().NotesTab, timeOutInSec);
        pages.products().NotesTab.click();

        extentLogger.info("Verify that user can see Description for Internal in Notes tab.");
        WebElement element = pages.products().descriptionForInternal;
        BrowserUtils.waitForVisibility(element, timeOutInSec);
        Assert.assertEquals(element.getText(), "Description for Internal");
        extentLogger.pass("Completed: Description for Internal in Notes Test");
    }

    //    Eyup Savas
    @Test
    public void managerPointOfSaleUserName() {

        extentLogger = report.createTest("Manager PointOfSale UserName Test");
        getMeToPointOfSalesAs("manager");

        String actualUserName = pages.pointOfSale().topUsername.getText().trim();
        String expectedUserName = "POSManager9";

        extentLogger.info("Verify that userName is displayed on the top right");
        Assert.assertEquals(actualUserName, expectedUserName);
        extentLogger.pass("Completed: manager topUserName Test");


    }

    //    Eyup Savas
    @Test
    public void managerPointOfSaleHeader() {

        extentLogger = report.createTest("Manager PointOfSale Header Test");
        getMeToPointOfSalesAs("manager");

        BrowserUtils.wait(10);
        extentLogger.info("Verify that manager Point of Sale page has the header " + ApplicationConstants.POINTOFSALE_PAGE_HEADER);
        String header = pages.pointOfSale().tabTitle.getText().trim();


        Assert.assertEquals(header, ApplicationConstants.POINTOFSALE_PAGE_HEADER);
        extentLogger.pass("Completed: manager Point of Sale Page Header Test");

    }


}
