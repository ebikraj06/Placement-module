package com.placementmodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.placementmodule.entities.Placement;
import com.placementmodule.service.PlacementService;


@Controller
public class PlacementViewController {

	@Autowired
	PlacementService placementService;
	
	//home page
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}
	
	//To display Placement list
	@RequestMapping("/placementlist")
	public String viewPlacementListPage(Model model) {
		List<Placement> placementList = placementService.getAllPlacement();
		model.addAttribute("placementList", placementList);
		return "placementlist";
	}
	
	//To add new Placement
	@RequestMapping("/placement/add")
	public String viewNewPlacementPage(Model model) {
		Placement placement = new Placement();
		model.addAttribute("placement", placement);
		return "new_placement";
	}
	
	//To save Placement details in database
	@RequestMapping(value = "/saveplacement", method = RequestMethod.POST)
	public String savePlacement(@ModelAttribute("placement") Placement placement) {
		placementService.savePlacement(placement);
		return "redirect:/";
	}
	
	//edit the Placement detail using placementId
	@RequestMapping("/edit/placement/{id}")
	public ModelAndView showEditPlacementPage(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_placement");
		Placement placement = placementService.getPlacementByid(id);
		mav.addObject("placement", placement);
		return mav;
	}
	
	//delete Placement details from Placement list
	@RequestMapping("/delete/placement/{id}")
	public String deletePlacement(@PathVariable(name="id") int id) {
		placementService.deletePlacement(id);
		return "redirect:/";
	}
	
}
