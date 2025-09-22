package data;

public class LoginData {
    private String username;
    private String password;
    private String errormessage;

    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getErrormessage() {return errormessage;}

    private LoginData(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.errormessage = builder.errormessage;
    }

    public static class Builder {
        private String username;
        private String password;
        private String errormessage;

        public Builder withUserName(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withErrorMessage(String errormessage) {
            this.errormessage = errormessage;
            return this;
        }

        public LoginData build () {
            return new LoginData(this);
        }
    }
}
