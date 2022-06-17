package medicare.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import medicare.models.FrontDesk;
import medicare.models.Patient;
import medicare.models.Review;
import medicare.models.Ticket;
import medicare.services.PatientService;
import medicare.services.ReviewService;
import medicare.services.TicketService;
@Controller
public class UserController {
	
	@Autowired PatientService psrv;
	@Autowired TicketService tsrv;
	@Autowired ReviewService rsrv;
	@Autowired HttpSession session;
	
	@GetMapping("/patientregbyuser")
	public String regpatient(Model model)
	{
		String patientid="patient"+(psrv.countPatient()+1);
		model.addAttribute("patientid", patientid);
		System.out.println(model.getAttribute(patientid));
		
		return "addpatientbyuser";
	}
	@GetMapping("/addticket")
	public String raiseTicket(Model model)
	{
		String userid=(String)session.getAttribute("userid");
		model.addAttribute("userid", userid);
		System.out.println(model.getAttribute(userid));
		
		return "addticket";
	}
	@GetMapping("/addreview")
	public String createReview(Model model)
	{
		String userid=(String)session.getAttribute("userid");
		model.addAttribute("userid", userid);
		System.out.println(model.getAttribute(userid));
		
		return "addreview";
	}
	@PostMapping("/registerpatientbyuser")
	public String savePatient(Patient pat,String role,RedirectAttributes ra,Model model) {
		psrv.savePatient(pat);
		System.out.println(pat);
		model.addAttribute("users",psrv.allUserPatients((String)session.getAttribute("userid"))); //psrv.allUserPatients((String)model.getAttribute("userid")));
		return "udashboard";
	}
	@PostMapping("/raiseticket")
	public String saveTicket(Ticket t,RedirectAttributes ra,Model model) {
		t.setUserid((String)session.getAttribute("userid"));
		t.setResolution("not resolved");
		tsrv.saveTicket(t);
		System.out.println(t);
		model.addAttribute("tickets",tsrv.allTicketsforUser((String)session.getAttribute("userid"))); //psrv.allUserPatients((String)model.getAttribute("userid")));
		return "tickets";
	}
	
	@PostMapping("/createreview")
	public String saveReview(Review r,RedirectAttributes ra,Model model) {
		r.setUserid((String)session.getAttribute("userid"));
		rsrv.saveReview(r);
		System.out.println(r);
		model.addAttribute("reviews",rsrv.allReviewsforUser((String)session.getAttribute("userid"))); //psrv.allUserPatients((String)model.getAttribute("userid")));
		return "reviews";
	}
	@GetMapping("/viewuserdboard")
	public String udashboard(Model model,RedirectAttributes ra) {
		ra.addFlashAttribute("msg", "Patient registered succecssfully");
		return "udashboard";
	}
	@GetMapping("/viewpatientsbyuser")
	public String udashboardz(Model model,RedirectAttributes ra) {
		model.addAttribute("users",psrv.allUserPatients((String)session.getAttribute("userid"))); //psrv.allUserPatients((String)model.getAttribute("userid")));
		ra.addFlashAttribute("msg", "Patient registered succecssfully");
		return "udashboard";
	}
	

	@GetMapping("/patientbill")
	public String z(Model model,RedirectAttributes ra) {
		model.addAttribute("users",psrv.allUserPatients((String)session.getAttribute("userid"))); //psrv.allUserPatients((String)model.getAttribute("userid")));
		return "searchpatientbyuser";
	}
	
	@PostMapping("/kk")
	public String searchpatient(String patientid,RedirectAttributes ra,Model model) {
		Patient pat=(psrv.userfindByPatientId(patientid,(String)session.getAttribute("userid")));
		model.addAttribute("patient", pat);
		System.out.println(pat);
		return "patientbillbyidforuser";
	}
	@GetMapping("/detailpd")
	public String view(String patientid,RedirectAttributes ra,Model model) {
		Patient pat=(psrv.userfindByPatientId(patientid,(String)session.getAttribute("userid")));
		model.addAttribute("patient", pat);
		System.out.println(pat);
		
		return "detailpd";
	}
	@GetMapping("/viewticketsbyuser")
	public String tickets(Model model) {
		model.addAttribute("tickets", tsrv.allTicketsforUser((String)session.getAttribute("userid")));
		return "tickets";
	}
	@GetMapping("/viewreviewsbyuser")
	public String reviews(Model model) {
		model.addAttribute("reviews", rsrv.allReviewsforUser((String)session.getAttribute("userid")));
		return "reviews";
	}

}
