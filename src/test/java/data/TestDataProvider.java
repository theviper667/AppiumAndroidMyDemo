package data;

import models.CheckoutFlowData;
import models.PaymentMethod;
import models.Product;
import models.ShippingAddress;
import utils.JSONDataUtil;
import org.testng.annotations.DataProvider;

import java.util.List;

public class TestDataProvider {
    @DataProvider(name = "validLoginData")
    public Object [][] validLoginData() {
        return new Object[][]{
                {new LoginData.Builder().withUserName("bob@example.com")
                        .withPassword("10203040")
                        .build()}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object [][] invalidLoginData() {
        return new Object[][]{
                {new LoginData.Builder().withUserName("bob")
                        .withPassword("thebuilder")
                        .withErrorMessage("Provided credentials do not match any user in this service.")
                        .build()},
                {new LoginData.Builder().withUserName("bob")
                        .withPassword("")
                        .withErrorMessage("Password is required")
                        .build()},
                {new LoginData.Builder().withUserName("")
                        .withPassword("thebuilder")
                        .withErrorMessage("Username is required")
                        .build()},
                {new LoginData.Builder().withUserName("alice@example.com")
                        .withPassword("10203040")
                        .withErrorMessage("Sorry, this user has been locked out.")
                        .build()}
        };
    }

    @DataProvider(name = "productData")
    public Object [][] productData() {
        List<Product> products = JSONDataUtil.getProductCatalog();

        if (products.isEmpty()) {
            return new Object[0][0];
        }
        Object[][] data = new Object[products.size()][1];
        for (int i = 0; i < products.size(); i++) {
            data[i][0] = products.get(i);
        }
        return data;
    }

    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutData() {
        List<Product> products = JSONDataUtil.getProductCatalog();
        ShippingAddress address = new ShippingAddress("The Arsenal", "1 Test Valley",
                "TesterVille", "442", "United Testerdom");
        PaymentMethod card = new PaymentMethod("T Arsenal", "1234", "09/26", "123");

        if (products.isEmpty()) {
            return new Object[0][0];
        }

        Object[][] data = new Object[products.size()][1];
        for (int i = 0; i < products.size(); i++) {
            data[i][0] = new CheckoutFlowData(products.get(i), address, card);
        }
        return data;
    }
}
