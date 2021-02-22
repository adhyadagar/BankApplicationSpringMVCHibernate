package com.finastra.project.controller;

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
import org.springframework.web.bind.support.SessionStatus;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.BankUser;
import com.finastra.project.entity.Transaction;
import com.finastra.project.service.AccountService;
import com.finastra.project.service.CustomerService;
import com.finastra.project.service.TransactionService;

//BASICALLY ANOTHER CUSTOMER CONTROLLER CLASS

@Controller
@RequestMapping("/bank")
@SessionAttributes({"errorMessage"})
public class BankLogController {
	
	private final CustomerService customerService;
	private final AccountService accountService;
	private final TransactionService transactionService;
	
	
	@Autowired
	public BankLogController(CustomerService customerService, AccountService accountService,
			TransactionService transactionService) {
		this.customerService = customerService;
		this.accountService = accountService;
		this.transactionService = transactionService;
	}

	// 1. Loading Home Page
	@RequestMapping({"","/"})
	public String homePage(Model model) //doubt - why do we have the MOdel model as a parameter
	{	
		return "HomePage";
	}
	
	// 1. Loading Home Page
	@RequestMapping("/home")
	public String homePageView(Model model) //doubt - why do we have the MOdel model as a parameter
	{	
		return "HomePage";
	}
	
	// 2. Loading About Us Page
	@GetMapping("/about")
	public String aboutPage(Model model)
	{	
		return "AboutUs";
	}
			
	// 3. Loading Contact Us Page
	@GetMapping("/contact")
	public String contactPage(Model model)
	{	
		return "ContactUs";
	}
	
	// 4. Loading Register User Page
	@GetMapping("/register")
	public String registrationPage(Model model, SessionStatus status)
	{	
		try
		{
			model.addAttribute("customer", new BankUser());
			status.setComplete();
			return "FormRegistration";
		}
		catch(Exception e)
		{
			return "HomePage";
		}
		
	}
	
	//5. Get and save Registration Details
	@PostMapping("/registerCustomer")
	public String registerUser(@ModelAttribute("customer") BankUser theCustomer, Model model) {
		
		try
		{
			
			System.out.println("outsideif");
			
			//If user does not exist, then create new user
			if(!customerService.checkUser(theCustomer.getUserName()))
				//System.out.println("check user");
			{
				
				System.out.println("Check User");
				customerService.saveUser(theCustomer);
				
				System.out.println(theCustomer);
				
			}
			else
			{
				model.addAttribute("errorMessage", "Username is already taken!");
				return "redirect:/bank/register";
			}
			
			return "redirect:/bank/login";
			
		}
		catch(Exception e)
		{
			model.addAttribute("errorMessage", "Something went wrong!");
			return "redirect:/bank/register";
		}
		
	}
	
	
	// 6. Loading Login Page
	@GetMapping("/login")
	public String loginPage(Model model, SessionStatus status)
	{	
		//BankUser theCustomer = new BankUser();
		//model.addAttribute("customer",theCustomer);
		try
		{
			model.addAttribute("customer", new BankUser()); //creating session
			status.setComplete();
			return "FormLogin";
		}
		catch(Exception e)
		{
			return "redirect:/bank/home";
		}
	}
	
	
	//7. Login Authorization 
	@PostMapping("/loginCustomer")
	public String loginUser(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "password") String password,
			Model model, HttpSession session) {
		try
		{
			BankUser theCustomer = customerService.authenticate(userName,password);
			if(theCustomer!= null)
			{
				session.setAttribute("userName", theCustomer);
				return "redirect:/bank/operations";
			}
			else
			{
				model.addAttribute("errorMessage", "Invalid Username or Password!");
				return "redirect:/bank/login";
			}
		}
		catch(Exception e)
		{
			return "redirect:/bank/login";
		}
	}
	
	// 8. Logging OUT
	@GetMapping("/logout")
	public String logoutPage(HttpSession session, SessionStatus status)
	{	
		//BankUser theCustomer = new BankUser();
		//model.addAttribute("customer",theCustomer);
		try
		{
			session.invalidate();
			status.setComplete();
			return "redirect:/bank/home";
		}
		catch(Exception e)
		{
			return "redirect:/bank/home";
		}
	}
	
	// 9. Loading Operations Menu Page
	@GetMapping("/operations")
	public String operationsPage(Model model)
	{	
		//BankUser theCustomer = new BankUser();
		//model.addAttribute("customer",theCustomer); 
		return "FormOperations"; 
	}
	
	
	
			
	

	
	
	
	
	
	

}
