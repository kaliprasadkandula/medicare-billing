package medicare.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import medicare.models.Admin;
import medicare.models.FrontDesk;
import medicare.models.Patient;
import medicare.models.Ticket;
import medicare.models.User;
import medicare.services.AdminService;
import medicare.services.FrontDeskService;
import medicare.services.PatientService;
import medicare.services.ReviewService;
import medicare.services.TicketService;
import medicare.services.UserService;

@Controller
public class AdminController {
	@Autowired FrontDeskService fdsrv;
	@Autowired PatientService psrv;
	@Autowired AdminService asrv;
	@Autowired UserService usrv;
	@Autowired TicketService tsrv;
	@Autowired ReviewService rsrv;
	
	@Autowired HttpSession session;	

public String temp="";
	@GetMapping("/")
	public String home() {
		return  "index";
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/validate") //comes from index.jsp page
	public String validate(String userid,String pwd,Model model,RedirectAttributes ra) {
		
		if(userid.startsWith("user")) {
			
			User u=usrv.findById(userid);//no error 
			temp=userid;
			if(u.getPwd().equals(pwd)) {
			session.setAttribute("userid", userid);
			session.setAttribute("role", "User");
			session.setAttribute("uname", u.getFname()+" "+u.getLname());
			return "redirect:/Userdashboard";
			}else {
				System.out.println("user");
				if(u==null) ra.addFlashAttribute("msg", "Userid not present");
				else ra.addFlashAttribute("msg", "Password not matching");
				return "redirect:/";
			}
			
		}
		else if(userid.startsWith("frontdesk")) {
			
			FrontDesk fd=fdsrv.findById(userid);
			if(fd==null) {ra.addFlashAttribute("msg", "Userid not present");return "redirect:/";}
			
			System.out.println(fd.getFrontdeskid()+" "+fd.getPwd()+" "+fd.getStatus());
			System.out.println(userid+" "+pwd);
			
			
			if(fd.getPwd().equals(pwd) && fd.getStatus().equals("approved")) {
			session.setAttribute("userid", userid);
			session.setAttribute("role", "FrontDesk");
			session.setAttribute("uname", fd.getFname()+" "+fd.getLname());
			return "redirect:/viewfrontdesk";
			}
			else if(fd.getPwd().equals(pwd) && fd.getStatus().equals("rejected")) {
				ra.addFlashAttribute("msg", "Your registration is rejected");
				return "redirect:/";//this redirect goes to same page but with the redirect attributes
			}
			else if(fd.getPwd().equals(pwd) && fd.getStatus().equals("not approved")) {
				ra.addFlashAttribute("msg", "Registration pending for approval");
				return "redirect:/";//this redirect goes to same page but with the redirect attributes
			}
			else {
				
				return "redirect:/";
			}
		}
		else {
			Admin admin=asrv.validate(new Admin(userid, pwd));//creation of object no need of checking for admin as it is last option
			if(admin==null) {
				ra.addFlashAttribute("msg", "Userid not present");
				return "redirect:/";
			}
			else if(!pwd.equals("admin"))
			{
				ra.addFlashAttribute("msg", "Password not matching");
				return "redirect:/";
			}
			else {
				session.setAttribute("userid", userid);
				session.setAttribute("role", "Admin");
				session.setAttribute("uname", "Admin");
				return "redirect:/dashboard";
			}
		}
	}
	
	
	
	@PostMapping("/validatedetails") //comes from index.jsp page
	public String validatedetails(String userid,String favcolour,String favnumber,String favpet,Model model,RedirectAttributes ra) {
		
		if(userid.startsWith("user")) {
			temp=userid;
			
			User u=usrv.findById(userid);//no error 
			
			if(u.getFavcolour().equals(favcolour) &&  u.getFavnumber().equals(favnumber)&&u.getFavpet().equals(favpet)) {
				//System.out.println(u+"zuyyy");
			session.setAttribute("userid", userid);
			session.setAttribute("role", "User");
			session.setAttribute("user", u);
			return "redirect:/changepwd";
			}else {
				System.out.println("user");
				if(u==null) ra.addFlashAttribute("msg", "Userid not present");
				else ra.addFlashAttribute("msg", "Password not matching");
				return "redirect:/";
			}
			
		}
		/*else if(userid.startsWith("frontdesk")) {
			
			FrontDesk fd=fdsrv.findById(userid);
			if(fd==null) {ra.addFlashAttribute("msg", "Userid not present");return "redirect:/";}
			
			System.out.println(fd.getFrontdeskid()+" "+fd.getPwd()+" "+fd.getStatus());
			System.out.println(userid+" "+pwd);
			
			
			if(fd.getPwd().equals(pwd) && fd.getStatus().equals("approved")) {
			session.setAttribute("userid", userid);
			session.setAttribute("role", "FrontDesk");
			session.setAttribute("uname", fd.getFname()+" "+fd.getLname());
			return "redirect:/viewfrontdesk";
			}
			else if(fd.getPwd().equals(pwd) && fd.getStatus().equals("rejected")) {
				ra.addFlashAttribute("msg", "Your registration is rejected");
				return "redirect:/";//this redirect goes to same page but with the redirect attributes
			}
			else if(fd.getPwd().equals(pwd) && fd.getStatus().equals("not approved")) {
				ra.addFlashAttribute("msg", "Registration pending for approval");
				return "redirect:/";//this redirect goes to same page but with the redirect attributes
			}
			else {
				ra.addFlashAttribute("msg", "Incorrect details");
				
				return "redirect:/";
			}
		}*/
		else {
			ra.addFlashAttribute("msg", "Incorrect details");
				return "redirect:/";
			}
		
	}
	
	
	
	
	
	
	
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "adashboard";
	}
	
	@GetMapping("/Userdashboard")
	public String userdashboard(Model model) {
		model.addAttribute("users",psrv.allUserPatients(temp));
		
		return "udashboard";
	}
	@GetMapping("/viewfrontdesk")
	public String fdashboard(Model model) {
		model.addAttribute("users",psrv.allPatients()); //psrv.allUserPatients((String)model.getAttribute("userid")));
		
		return "fdashboard";
	}
	
	
	@GetMapping("/frontdesks")
	public String frontdesks(Model model) {
		model.addAttribute("users", fdsrv.allFDs());
		return "frontdesks";
	}
	
	@GetMapping("/viewtickets")
	public String tickets(Model model) {
		model.addAttribute("tickets", tsrv.allTickets());
		return "tickets";
	}
	@GetMapping("/viewreviews")
	public String reviews(Model model) {
		model.addAttribute("reviews", rsrv.allReviews());
		return "reviews";
	}
	
	
	@GetMapping("/addfrontdesk")
	public String addFrontDesk(Model model) {
		String frontdeskid="frontdesk"+(fdsrv.countFDs()+1);
		model.addAttribute("frontdeskid", frontdeskid);
		System.out.println(model.getAttribute(frontdeskid));
		return "addfrontdesk";
	}
	@GetMapping("/adduser")
	public String addUser(Model model) {
		String userid="user"+(usrv.countUsers()+1);
		model.addAttribute("frontdeskid", userid);
		System.out.println(model.getAttribute(userid));
		return "adduser";
	}
	
	
	
	
	
	@GetMapping("/register")
	public String register(Model model,String role) {
		
		String frontdeskid="frontdesk"+(fdsrv.countFDs()+1);
		String userid="user"+(usrv.countUsers()+1);
		
		model.addAttribute("frontdeskid", frontdeskid);
		model.addAttribute("userid", userid);
		
		model.addAttribute("frontdesk",new FrontDesk());
		model.addAttribute("user",new User());
		return "register";
	}
	@GetMapping("/fgpwd")
	public String fgpwd(Model model,String role) {
		
		
		
		return "fgpwd";
	}
	
	@GetMapping("/editfd")
	public String editfd(String frontdeskid,Model model) {
		
		System.out.print(frontdeskid+" "+"haii");
		FrontDesk fd=fdsrv.findById(frontdeskid);
		model.addAttribute("frontdeskid",fd.getFrontdeskid());
		model.addAttribute("fname",fd.getFname());
		model.addAttribute("lname",fd.getLname());
		model.addAttribute("status",fd.getStatus());
		model.addAttribute("frontdesk",new FrontDesk());
		return "editfd"; //goes to editfd.jsp page
	}
	
	@GetMapping("/changepwd")
	public String changepwd(String Userid,Model model) {
		
		return "changepwd"; //goes to editfd.jsp page
	}
	@GetMapping("/edittkt")
	public String edittkt(String userid,Model model) {
		
		System.out.print(userid+" "+"haii");
		Ticket t=tsrv.findById(userid);
		model.addAttribute("userid",t.getUserid());
		model.addAttribute("query",t.getQuery());
		model.addAttribute("resolution",t.getResolution());
		return "edittkt"; //goes to editfd.jsp page
	}
	
	
	
	
	@PostMapping("/registerpat")
	public String savePatient(Patient pat,String role,RedirectAttributes ra) {
		System.out.println(pat);
		psrv.savePatient(pat);
		ra.addFlashAttribute("msg", "Patient registered succecssfully");
		return "redirect:/";
	}
	@PostMapping("/savechanges")
	public String saveUserafterchanges(User u,String role,RedirectAttributes ra) {
		usrv.saveUserpwd(u);
		ra.addFlashAttribute("msg", "User changes done succecssfully");
		return "redirect:/";
	}
	
	@PostMapping("/registerfd")
	public String saveFrontDesk(FrontDesk fd,String role,Model model,RedirectAttributes ra) {
		fd.setStatus("not approved");
		System.out.println(fd);
		fdsrv.saveFrontDesk(fd);
		ra.addFlashAttribute("msg", "Your details are submitted succecssfully");
		return "redirect:/";
	}
	
	@PostMapping("/registeruser")
	public String saveUser(User u,String role,Model model,RedirectAttributes ra) {
		usrv.saveUser(u);
		ra.addFlashAttribute("msg", "Your details are submitted succecssfully");
		return "redirect:/";
	}
	
	@PostMapping("/registerfdbyadmin")
	public String saveFrontDeskbyAdmin(FrontDesk fd,String role,Model model,RedirectAttributes ra) {
		System.out.println(fd);
		fdsrv.saveFrontDesk(fd);
		ra.addFlashAttribute("msg", "FrontDesk registered succecssfully by admin");
		return "redirect:/frontdesks";
	}
	@PostMapping("/edittktbyadmin")
	public String saveTicketbyAdmin(Ticket t,Model model,RedirectAttributes ra) {
		System.out.println(t);
		tsrv.saveTicket(t);
		ra.addFlashAttribute("msg", "Ticket resolved succecssfully by admin");
		return "redirect:/viewtickets";
	}
	
	@PostMapping("/editfdbyadmin")
	public String editFrontDeskbyAdmin(FrontDesk fd,String role,Model model,RedirectAttributes ra) {
		
		System.out.println(fd);
		fdsrv.saveFrontDesk(fd);
		ra.addFlashAttribute("msg", "FrontDesk edited succecssfully");
		return "redirect:/frontdesks";
	}
	
	
	
	
	
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
}
