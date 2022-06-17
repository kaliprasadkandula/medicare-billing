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
import medicare.services.ConsultancyService;
import medicare.services.MedicineService;
import medicare.services.PatientService;
import medicare.services.RoomService;
import medicare.services.ServiceService;

@Controller
public class FrontDeskController {
	
	@Autowired PatientService psrv;
	@Autowired ServiceService ssrv;
	@Autowired MedicineService mdsrv;
	@Autowired RoomService rsrv;
	@Autowired ConsultancyService csrv;
	@Autowired HttpSession session;

	@GetMapping("/patientregbyfd")
	public String regpatient(Model model)
	{
		String patientid="patient"+(psrv.countPatient()+1);
		model.addAttribute("patientid", patientid);
		System.out.println(model.getAttribute(patientid));
		
		return "addpatient";
	}
	@GetMapping("/editpd")
	public String editfd(String patientid,Model model) {
		
		System.out.print(patientid+" "+"haii");
		Patient pd=psrv.findByPatientId(patientid);//.findbyid(patientid);
		model.addAttribute("patientid",pd.getPatientid());
		model.addAttribute("consultancy_bill",pd.getConsultancy_bill());
		model.addAttribute("room_bill",pd.getRoom_bill());
		model.addAttribute("service_bill",pd.getService_bill());
		model.addAttribute("medication_bill",pd.getMedication_bill());
		model.addAttribute("total_bill",pd.getTotal_bill());
		model.addAttribute("bill_status",pd.getBill_status());
		return "editpd"; //goes to editpd.jsp page
	}
	@PostMapping("/registerpatientbyfd")
	public String savePatient(Patient pat,String role,RedirectAttributes ra,Model model) {
		System.out.println(pat);
		psrv.savePatient(pat);
		
		return "redirect:/viewfronttdesk";
	}
	@PostMapping("/searchpatientbyid")
	public String searchpatient(String patientid,RedirectAttributes ra,Model model) {
		//model.addAttribute("patientid", patientid);
		Patient pat=(psrv.findByPatientId(patientid));
		model.addAttribute("patient", pat);
		System.out.println(pat);
		return "patientbillbyid";
	}
	@PostMapping("/editpdbyfd")
	public String editPatientbill(Patient pd,String role,Model model,RedirectAttributes ra) {
		
		System.out.println(pd);
		psrv.savePatient(pd);// (pd);
		ra.addFlashAttribute("msg", "Patient Bill edited succecssfully");
		return "patientbillbyid";
	}
	
	@GetMapping("/viewservices")
	public String services(Model model) {
		model.addAttribute("services",ssrv.allServices());
		return "services";
	}
	@GetMapping("/viewrooms")
	public String rooms(Model model) {
		model.addAttribute("rooms",rsrv.allRooms());
		return "rooms";
	}
	@GetMapping("/viewconsultancies")
	public String consultancies(Model model) {
		model.addAttribute("consultancies",csrv.allConsultancies());
		return "consultancies";
	}
	@GetMapping("/viewmedicines")
	public String medicines(Model model) {
		model.addAttribute("medicines",mdsrv.allMedications());
		return "medicines";
	}
	
	@GetMapping("/viewfronttdesk")
	public String fdashboard(Model model,RedirectAttributes ra) {
		model.addAttribute("users",psrv.allPatients()); //psrv.allUserPatients((String)model.getAttribute("userid")));
		ra.addFlashAttribute("msg", "Patient registered succecssfully");
		return "fdashboard";
	}
	

	@GetMapping("/patientbilling")
	public String z(Model model,RedirectAttributes ra) {
		model.addAttribute("users",psrv.allPatients()); //psrv.allUserPatients((String)model.getAttribute("userid")));
		return "searchpatient";
	}

}
