package hh.harjoitus.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.harjoitus.domain.CharacterRepository;
import hh.harjoitus.domain.Player;
import hh.harjoitus.domain.PlayerRepository;
import hh.harjoitus.domain.RegionRepository;

@CrossOrigin
@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository prepository;
	
	@Autowired
	private CharacterRepository crepository;
	
	@Autowired
	private RegionRepository rrepository;
	
	// Login
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}
	
	//Playerlist
	@RequestMapping(value = "/playerlist", method = RequestMethod.GET)
	public String getPlayers(Model model) {
		model.addAttribute("players", prepository.findAll());
		return "players";
	}
	
	//Playerlist REST
	@RequestMapping(value="/players", method = RequestMethod.GET)
    public @ResponseBody List<Player> playerListRest() {	
        return (List<Player>) prepository.findAll();
    }
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("characters", crepository.findAll());
		model.addAttribute("regions", rrepository.findAll());
		return "addplayer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Player player, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("characters", crepository.findAll());
			model.addAttribute("regions", rrepository.findAll());
			return "addplayer";
			}
		else {
		prepository.save(player);
		return "redirect:playerlist";
		}
	}
	
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
		prepository.deleteById(playerId);
		return "redirect:../playerlist";
	}
}
