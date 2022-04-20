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

import hh.harjoitus.domain.Character;
import hh.harjoitus.domain.Region;
import hh.harjoitus.domain.RegionRepository;

@CrossOrigin
@Controller
public class RegionController {

	@Autowired
	private RegionRepository rrepository;
	
	@RequestMapping(value = "/regionlist", method = RequestMethod.GET)
	public String getRegions(Model model) {
		model.addAttribute("regions", rrepository.findAll());
		return "regions";
	}
	
	//Regionlist REST
			@RequestMapping(value="/regions", method = RequestMethod.GET)
		    public @ResponseBody List<Region> regionListRest() {	
		        return (List<Region>) rrepository.findAll();
		    }
			
			// REST find region by id
			@RequestMapping(value="/regions/{id}", method = RequestMethod.GET)
		    public @ResponseBody Optional<Region> findRegionRest(@PathVariable("regionid") Long regionId) {	
		    	return rrepository.findById(regionId);
		    }     
			
			// REST save region
			@RequestMapping(value="/regions", method = RequestMethod.POST)
		    public @ResponseBody Region saveRegionRest(@RequestBody Region region) {	
		    	return rrepository.save(region);
		    }
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/addregion")
	public String addRegion(Model model) {
		model.addAttribute("region", new Region());
		return "addregion";
	}
	
	@RequestMapping(value = "/saveregion", method = RequestMethod.POST)
	public String save(@Valid Region region, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addregion";
			} else {
		rrepository.save(region);
		return "redirect:regionlist";
			}
	}
	
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/deleteregion/{id}", method = RequestMethod.GET)
	public String deleteRegion(@PathVariable("id") Long regionId, Model model) {
		rrepository.deleteById(regionId);
		return "redirect:../regionlist";
	}
	
}
