package Mock;

import utils.Account;

import java.util.List;

public class MockTestLogin {
    public static Account login(String username, String password) {
        Mock mock = new Mock();
        List<Account> accounts = mock.getAccounts();
        for (Account account: accounts) {
            if (username.equals(account.getAddress()) && password.equals(account.getPassword())) {
                return account;
            }
        }
        return null;
    }
}
