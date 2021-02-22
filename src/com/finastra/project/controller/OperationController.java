package com.finastra.project.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.BankUser;
import com.finastra.project.entity.Transaction;
import com.finastra.project.service.AccountService;
import com.finastra.project.service.CustomerService;
import com.finastra.project.service.TransactionService;

@Controller
@RequestMapping("/bank")
@SessionAttributes({"errorMessage"})
public class OperationController {
	
	//private final CustomerService customerService;
	private final AccountService accountService;
	private final TransactionService transactionService;
	private final CustomerService customerService;
	
	
	@Autowired
	public OperationController(AccountService accountService, TransactionService transactionService,
			CustomerService customerService) {
		this.accountService = accountService;
		this.transactionService = transactionService;
		this.customerService = customerService;
	}
	


	
	
	// 1. Loading Deposit Page
	@GetMapping("/deposit")
	public String depositPage(Model model)
	{	
		//BankUser theCustomer = new BankUser();
		//model.addAttribute("customer",theCustomer); 
		return "FormDeposit"; 
	}
	

	//2. Deposit Amount 
	@PostMapping("/depositAmount")
	public String depositFund(@RequestParam("accountNumber") long accountNumber,
			@RequestParam("amount") double sum, HttpSession session){
		
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		//System.out.println(theCustomer);
		Account a = accountService.getAccount(accountNumber); 
		//System.out.println(a);
		//System.out.println("Outside if");
		if(theCustomer.getUserName().equals(a.getUserName())) //Getting stuck here, not equal hence showing failure
		{
			double currentBalance = a.getBalance();
			System.out.println(currentBalance);
			double newBalance = currentBalance + sum;
			System.out.println(newBalance);
			a.setBalance(newBalance);
			accountService.saveAccount(a);
			System.out.println(a);
			
			//Create a new transaction, because every time it is a new transaction
			Transaction t = new Transaction();
			t.setOperation("Deposit");
			t.setNewBalance(newBalance);
			t.setBalance(currentBalance);
			t.setAccountNumber(accountNumber);	 
			t.setTimeDetails(new Timestamp(new Date().getTime()));
			t.setUserName(theCustomer.getUserName());
			transactionService.saveTransaction(t);
			System.out.println(t);
			return "SuccessDeposit";
		}
		
		return "FailedDeposit";
		
	}
	
	// 3. Loading Withdraw Page
			@GetMapping("/withdraw")
			public String withdrawPage(Model model)
			{	
				return "FormWithdraw"; 
			}
			
	//4. Withdraw Amount 
	@PostMapping("/withdrawAmount")
	public String withdrawFund(@RequestParam("accountNumber") long accountNumber,
			@RequestParam("amount") double sum, HttpSession session) {
	
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		//System.out.println(theCustomer);
		Account a = accountService.getAccount(accountNumber); 
		//System.out.println(a);
		//System.out.println("Outside if");
		if(theCustomer.getUserName().equals(a.getUserName())) //Getting stuck here, not equal hence showing failure
		{
			if(sum<= a.getBalance())
			{
				double currentBalance = a.getBalance();
				System.out.println(currentBalance);
				double newBalance = currentBalance - sum;
				System.out.println(newBalance);
				a.setBalance(newBalance);
				accountService.saveAccount(a);
				System.out.println(a);
				
				//Create a new transaction, because every time it is a new transaction
				Transaction t = new Transaction();
				t.setOperation("Withdraw");
				t.setNewBalance(newBalance);
				t.setBalance(currentBalance);
				t.setAccountNumber(accountNumber);	 
				t.setTimeDetails(new Timestamp(new Date().getTime()));
				t.setUserName(theCustomer.getUserName());
				transactionService.saveTransaction(t);
				System.out.println(t);
				return "SuccessWithdraw";
			}
			
		}
		
		return "FailedWithdraw";
		
	}
	

	// 5. Loading Transfer Page
	@GetMapping("/transfer")
	public String transferPage(Model model)
	{	
		return "FormTransfer"; 
	}
	
	//6. Transfer Amount 
	@PostMapping("/transferAmount")
	public String transferFund(@RequestParam("accountNumber") long accountNumber,
			@RequestParam("accountNumberReciever") long accountNumberReciever,
			@RequestParam("amount") double sum, HttpSession session) {
		
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		//System.out.println(theCustomer);
		Account a = accountService.getAccount(accountNumber); 
		Account b = accountService.getAccount(accountNumberReciever);
		//System.out.println(a);
		//System.out.println("Outside if");
		if(theCustomer.getUserName().equals(a.getUserName())) //Getting stuck here, not equal hence showing failure
		{
			if(sum<= a.getBalance())
			{
				double currentBalanceOfSender = a.getBalance();
				double currentBalanceOfReciever = b.getBalance();
			
				double newBalanceOfSender = currentBalanceOfSender - sum;
				double newBalanceOfReciever = currentBalanceOfReciever + sum;
				
				a.setBalance(newBalanceOfSender);
				b.setBalance(newBalanceOfReciever);
				
				accountService.saveAccount(a);
				accountService.saveAccount(b);
				
				//Create a new transaction, because every time it is a new transaction
				
				Transaction t = new Transaction();
				t.setOperation("Transfer to Account: " + accountNumberReciever);
				t.setNewBalance(newBalanceOfSender);
				t.setBalance(currentBalanceOfSender);
				t.setAccountNumber(accountNumber);	 
				t.setTimeDetails(new Timestamp(new Date().getTime()));
				t.setUserName(theCustomer.getUserName());
				transactionService.saveTransaction(t);
				System.out.println(t);
				
				Transaction t2 = new Transaction();
				t2.setOperation("Transfer Recieved from Account: " + accountNumber);
				t2.setNewBalance(newBalanceOfReciever);
				t2.setBalance(currentBalanceOfReciever);
				t2.setAccountNumber(accountNumberReciever);	 
				t2.setTimeDetails(new Timestamp(new Date().getTime()));
				t2.setUserName(b.getUserName());
				transactionService.saveTransaction(t2);
				System.out.println(t2);
				return "SuccessTransfer";
			}
			
		}
		
		return "FailedTransfer";

		
		
	}
	
	
	// 7. Loading Close Account Page
	@GetMapping("/close")
	public String closeAccountPage(Model model)
	{	
		return "FormClose"; 
	}
	
	//8. Close Account
	@PostMapping("/closeAccount")
	public String closeCurrentAccount(@RequestParam("accountNumber") long accountNumber,
			HttpSession session) {
	
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		//System.out.println(theCustomer);
		//System.out.println(theCustomer);
		Account a = accountService.getAccount(accountNumber); 
		//System.out.println(a);
		//System.out.println("Outside if");
		if(theCustomer.getUserName().equals(a.getUserName())) //Getting stuck here, not equal hence showing failure
		{
			System.out.println("Checking if account entered exists");
			if(accountService.deleteAccount(accountNumber))
			{
				return "redirect:/bank/operations";
			}

		}
		
		return "FailedClose";
		
	}
	
	
	// 9. Loading Transaction History
	@GetMapping("/transaction")
	public String transactionPage(Model model)
	{	
		return "FormTransaction"; 
	}
	
	//10. Transaction Account
	@PostMapping("/transactionHistory")
	public String transactionHistoryList(@RequestParam("accountNumber") long accountNumber,
			HttpSession session) {
	
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		//System.out.println(theCustomer);
		Account a = accountService.getAccount(accountNumber); 
		//Transaction t = transactionService.getAccount(accountNumber);
		
		
		
		if(theCustomer.getUserName().equals(a.getUserName())) 
		{
			session.setAttribute("account", a);
			//session.setAttribute("transaction", t);
			return "redirect:/bank/transactionViewHistory";
		}
		
		return "FailedTransactionHistory";
		
	}
	
	// 11. View Transaction History
	
	@GetMapping("/transactionViewHistory")
	public String transactionViewPage(Model model, HttpSession session)
	{	
		Account theAccount = (Account) session.getAttribute("account");
		//Transaction theTrans = (Transaction) session.getAttribute("transaction");
		List<Transaction> theTransactions = transactionService.getTransactionsByAccountNumber(theAccount.getAccountNumber());
		model.addAttribute("transactionsList",theTransactions);
		return "FormTransactionHistory"; 
	}
	
	// 12. Loading Create Account Page
		@GetMapping("/create")
		public String createPage(Model model)
		{	
			//BankUser theCustomer = new BankUser();
			//model.addAttribute("customer",theCustomer); 
			return "FormCreate"; 
		}
		
	//13. Creating Account
	@PostMapping("/createAccount")
	public String createNewAccount(@RequestParam("accountType") String accountType,
			HttpSession session) {
	
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		//Account a = accountService.getAccount(accountNumber); 
		String username = theCustomer.getUserName();
		System.out.println(username);
		if(customerService.checkUser(username)) 
		{
			System.out.println("inside if");
			
			Account a = new Account();
			long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			a.setBalance(0);
			a.setAccountNumber(number);
			a.setUserName(theCustomer.getUserName());
			a.setAccountType(accountType);
			a.setUserId(1);
			System.out.println("object is" + a);
			accountService.saveAccount(a);
			System.out.println(a);
			
			session.setAttribute("account", a);
			//session.setAttribute("transaction", t);
			return "redirect:/bank/operations";
		}
			
			return "FailedCreateAccount";
			
		}
	
	// 14. Loading View All Accounts Page
	@GetMapping("/viewAllAccounts")
	public String viewAccounts(Model model, HttpSession session)
	{	
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		String username = theCustomer.getUserName();
		//Transaction theTrans = (Transaction) session.getAttribute("transaction");
		List<Account> theAccounts = accountService.getAccountsByUserName(username);
		model.addAttribute("accountsList",theAccounts);
		return "FormViewAllAccounts"; 

	}
	
	// 14. Loading Current Balance Page
	@GetMapping("/current")
	public String current(Model model, HttpSession session)
	{	
		BankUser theCustomer = (BankUser) session.getAttribute("userName");
		String username = theCustomer.getUserName();
		List<Account> theAccounts = accountService.getCurrentBalanceOfAllAccounts(username);
		model.addAttribute("balanceList",theAccounts);
		return "FormCurrent"; 

	}
}
	
	/*
	
	// 9. Loading Current Balance Page
	@GetMapping("/current")
	public String current(Model model)
	{	
		BankUser theCustomer = new BankUser();
		model.addAttribute("customer",theCustomer); 
		return "FormCurrent"; 
	}
	
	// 10. Checking Current Balance Page
	@PostMapping("/currentBalance")
	public String currentAmount(@ModelAttribute("customer") BankUser theCustomer,
			@ModelAttribute("account") Account theAccount,
			@RequestParam("accountNumber") long accountNumber)
	{	
		if(customerService.checkBalance(theCustomer,theAccount,accountNumber))
		{
			return "redirect:/customer/showBalance";
		}
		return "FailedCheckBalance";
		
	}
	
	// 11. Loading Current Balance Page
	@GetMapping("/showBalance")
	public String currentBal(Model model)
	{	
		return "FormShowBalance";
	}
	
	*/
	

