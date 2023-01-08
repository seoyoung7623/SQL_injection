package edu.catholic.controller;



import edu.catholic.Service.AccountService;


import edu.catholic.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Pattern;


@Controller
public class HomeController {
    private final AccountService accountService;
    private String regExp;

    @Autowired
    public HomeController(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("text", "SQL Injection");
        return "index";
    }

    @RequestMapping(value = "/registration")
    public String loadRegistrationForm() {
        return "registration";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(Model model, HttpServletResponse res, HttpServletRequest req) throws Exception{
        Account account = new Account();
        account.setId(req.getParameter("id"));
        account.setPassword(req.getParameter("password"));
        Pattern pattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]");
        if (pattern.matcher(account.getId()).find()){
            ScriptUtils.alert(res,"특수문자가 포함되어있습니다.");
            return "index";
        }
        else {
            accountService.insertAccount(account);
            model.addAttribute("text", "SQL Injection");
        }
        return "index";
    }

    @RequestMapping(value = "/findUser")
    public String loadFindForm(Model model, HttpServletRequest req) {
        return "findUser";
    }

    @RequestMapping(value = "/showUser")
    public String showUser(Model model, HttpServletRequest req) {
        List<Account> accountList = accountService.sqlInjection(req.getParameter("id"), req.getParameter("password"));
        model.addAttribute("accountList", accountList);
        return "showUser";
    }

    @RequestMapping(value = "/userList")
    public String userList(Model model, HttpServletRequest req) {
        List<Account> accountList = accountService.getAccountList();
        model.addAttribute("accountList", accountList);
        return "userList";
    }
}
