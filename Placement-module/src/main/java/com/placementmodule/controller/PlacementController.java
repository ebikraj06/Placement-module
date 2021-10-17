package com.placementmodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placementmodule.entities.Placement;
import com.placementmodule.exception.InvalidInputException;
import com.placementmodule.service.PlacementService;

@RestController
public class PlacementController {

	@Autowired
	PlacementService placementService;
	
	//add new Placement
	@PostMapping("/placement/add")
	public Placement savePlacement(@RequestBody Placement placement) {
		return placementService.savePlacement(placement);
	}
	
	//get the list of Placement
	@GetMapping("/placement/lists")
	public List<Placement> getAllPlacements(){
		return placementService.getAllPlacement();
	}
	
	//get the Placement detail using id,if id value <= 0 exception will be thrown
	@GetMapping("/placement/{id}")
	public ResponseEntity<Placement> getPlacementById(@PathVariable int placementId){
		if(placementId <= 0) {
			throw new InvalidInputException(placementId+" is not a valid Placement ID");
		}
		Placement Placement = placementService.getPlacementByid(placementId);
		return new ResponseEntity<Placement>(Placement,HttpStatus.OK);

	}
	
	//Using Delete method deleting Placement using id, and if id not is <= 0 exception will be thrown
	@DeleteMapping("/placement/{id}")
	public String deletePlacement(@PathVariable int id) {
		if(id <= 0) {
			throw new InvalidInputException(id+" is not a valid Placement ID");
		}
		placementService.deletePlacement(id);
		return "Deleted Successfully";
	}
	
	//Using Put method updating Placement detail using id
	@PutMapping("/placement/{id}")
	public ResponseEntity<Placement> updatePlacement(@PathVariable(value = "id") int id,
			@RequestBody Placement placement){
		if(id <= 0) {
			throw new InvalidInputException(id+" is not a valid Placement ID");
		}
		Placement updatedplacement =placementService.upadatePlacement(id, placement);
		return ResponseEntity.ok(updatedplacement);
	}
	
}
