package edu.catholic.Service;

import edu.catholic.mapper.AccountMapper;
import edu.catholic.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public static void init(HttpServletResponse response){
        response.setContentType("text/html; charset=euc-kr");
        response.setCharacterEncoding("euc-kr");
    }

    @Transactional
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    @Transactional
    public Account getAccount(Account account, HttpServletResponse res) throws  Exception {
 /*       res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("<script> function characterCheck(obj){");
        out.println("var regExp = /[ \\{\\}\\[\\]\\/?.,;:|\\)*~`!^\\-_+┼<>@\\#$%&\\'\\\"\\\\\\(\\=]/gi; ");
        out.println("if(regExp.test(obj.value)){");
        out.println("alert(\"특수문자는 입력하실수 없습니다.\");</script>");
        out.close();*/
        return account;
    }
    @Transactional
    public List<Account> getAccountList() {
        List<Account> result = accountMapper.getAccountList();
        return result;
    }
    @Transactional
    public List<Account> sqlInjection(String id, String password) {
        System.out.println("id: " + id + " password: " + password);
        List<Account> result = accountMapper.sqlInjection(id, password);
        return result;
    }

    @Transactional
    public List<Account> sqlInjecttionSol(String id, String password){
        List<Account> result = accountMapper.sqlInjectionSol(id,password);
        return result;
    }
}
