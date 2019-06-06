package Mock;

import utils.Account;

import java.util.ArrayList;
import java.util.List;

public class Mock {
    private List<Account> accounts;

    public Mock() {
        createAccount();
    }

    public void createAccount() {
        accounts = new ArrayList<>();
        accounts.add(new Account("0x8fa7173202d86C746bd884C9f116E356600c6b0E", "123456",true , false));
        accounts.add(new Account("0xE80778D90E2407Fd88F6cbdD5540364A18183Cc6", "123456",false , true));
        accounts.add(new Account("0x5bbC9F0b57acF06ED60758b09Eb372204dCe8fBd", "123456",true , true));
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
