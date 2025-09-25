import data.TestDataProvider;
import io.qameta.allure.Description;
import models.CheckoutFlowData;
import models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CatalogTest extends BaseTest{

    @Test (dataProvider = "productData", dataProviderClass = TestDataProvider.class)
    @Description("Verify the details of products on the catalog page and product page")
    public void verifyProductDetails(Product product) {
        Assert.assertTrue(inventoryPage.isProductNameVisible(product.getName()), "Product title "
                +product.getName()+" not visible");
        Assert.assertEquals(inventoryPage.getProductPriceText(product.getName()), product.getPrice());
        inventoryPage.clickProductName(product.getName());
        Assert.assertEquals(productPage.getProductTitleText(), product.getName());
        Assert.assertEquals(productPage.getProductPriceText(), product.getPrice());
        Assert.assertEquals(productPage.getProductDescriptionText(), product.getDescription());
        productPage.pressBackButton();
    }

    @Test (dataProvider = "checkoutData", dataProviderClass = TestDataProvider.class)
    @Description("Verify the checkout flow for each product")
    public void verifyCheckoutFlow(CheckoutFlowData checkout) {
        BigDecimal expectedTotal, actualProductPrice;
        testUserAutoFillLogin();
        navigationMenu.resetAppState().clickProductName(checkout.getProduct().getName())
                .clickAddToCartButton();
        Assert.assertEquals(productPage.getCartItemsCount(), "1");
        productPage.clickCartBadge();
        Assert.assertEquals(cartPage.getProductNameText(), checkout.getProduct().getName());
        Assert.assertEquals(cartPage.getProductPriceText(checkout.getProduct().getName()), checkout.getProduct().getPrice());
        actualProductPrice = reviewOrderPage.getProductPriceValue(checkout.getProduct().getName());
        Assert.assertEquals(cartPage.getProductCounterText(checkout.getProduct().getName()), "1");
        cartPage.clickCheckoutButton()
                .fillShippingAddress(checkout.getShippingAddress())
                .fillPaymentMethod(checkout.getPaymentMethod());
        Assert.assertEquals(reviewOrderPage.getProductNameText(), checkout.getProduct().getName());
        Assert.assertEquals(reviewOrderPage.getProductPriceText(checkout.getProduct().getName()), checkout.getProduct().getPrice());
        reviewOrderPage.verifyReviewDeliveryAddress(checkout.getShippingAddress());
        reviewOrderPage.verifyReviewPaymentMethod(checkout.getPaymentMethod());
        expectedTotal = reviewOrderPage.getCheckoutValues().get("actualDeliveryFee")
                .add(actualProductPrice);
        Assert.assertEquals(reviewOrderPage.getCheckoutValues().get("actualTotal"), expectedTotal);
        reviewOrderPage.clickPlaceOrderButton();
        Assert.assertTrue(checkoutCompletePage.getCheckoutCompleteHeaderVisibility(), "Cannot find Checkout Complete page elements");
        navigationMenu.returnToCatalog();
    }
}
