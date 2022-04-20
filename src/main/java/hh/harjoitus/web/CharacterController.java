package hh.harjoitus.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.harjoitus.domain.CharacterRepository;
import hh.harjoitus.domain.Character;


@CrossOrigin
@Controller
public class CharacterController {
	
	@Autowired
	private CharacterRepository crepository;
	
	@RequestMapping(value = "/characterlist", method = RequestMethod.GET)
	public String getCharacters(Model model) {
		model.addAttribute("characters", crepository.findAll());
		return "characters";
	}
	
	//Characterlist REST
		@RequestMapping(value="/characters", method = RequestMethod.GET)
	    public @ResponseBody List<Character> characterListRest() {	
	        return (List<Character>) crepository.findAll();
	    }
		
		// REST id:n mukaan hahmon etsintä
		@RequestMapping(value="/characters/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Character> findCharacterRest(@PathVariable("characterid") Long characterId) {	
	    	return crepository.findById(characterId);
	    }     
		
		// REST hahmon tallennus
		@RequestMapping(value="/characters", method = RequestMethod.POST)
	    public @ResponseBody Character saveCharacterRest(@RequestBody Character character) {	
	    	return crepository.save(character);
	    }
		
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/addchar")
	public String addCharacter(Model model) {
		model.addAttribute("character", new Character());
		return "addchar";
	}
	
	@RequestMapping(value = "/savechar", method = RequestMethod.POST)
	public String save(@Valid Character character, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addchar";
			} else {
		crepository.save(character);
		return "redirect:characterlist";
			}
	}
	
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletechar/{id}", method = RequestMethod.GET)
	public String deleteCharacter(@PathVariable("id") Long characterId, Model model) {
		crepository.deleteById(characterId);
		return "redirect:../characterlist";
	}
	
}
