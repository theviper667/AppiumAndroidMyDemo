package data;

import org.testng.annotations.DataProvider;

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
}
