package edu.catholic.mapper;

import edu.catholic.model.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    void insertAccount(Account account);

    Account getAccount(String id);
    List<Account> getAccountList();
    List<Account> sqlInjection(@Param("id") String id, @Param("password") String password);

    List<Account> sqlInjectionSol(String id, String password);
}
