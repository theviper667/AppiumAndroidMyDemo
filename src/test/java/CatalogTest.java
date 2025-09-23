import data.TestDataProvider;
import jdk.jfr.Description;
import models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
