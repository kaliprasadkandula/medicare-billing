package medicare.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import medicare.services.PatientService;

@Controller
public class PatientController {
	
	@Autowired PatientService psrv;
	@Autowired HttpSession session;
}
