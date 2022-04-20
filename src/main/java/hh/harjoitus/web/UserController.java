package hh.harjoitus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import hh.harjoitus.domain.UserRepository;

@CrossOrigin
@Controller
public class UserController {

	@Autowired
	private UserRepository urepository;
	
	
	
}
