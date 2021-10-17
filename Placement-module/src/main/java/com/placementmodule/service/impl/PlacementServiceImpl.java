package com.placementmodule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementmodule.entities.Placement;
import com.placementmodule.exception.RecordNotFoundException;
import com.placementmodule.repository.PlacementRepository;
import com.placementmodule.service.PlacementService;

@Service
public class PlacementServiceImpl implements PlacementService {

	@Autowired
	PlacementRepository placementRepo;

	@Override
	public Placement savePlacement(Placement placement) {
		return placementRepo.save(placement);
	}

	@Override
	public List<Placement> getAllPlacement() {
		return placementRepo.findAll();
	}
	
	@Override
	public Placement getPlacementByid(int id) {
		return placementRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("Placement Id not Found"));
	}

	@Override
	public Placement upadatePlacement(int id, Placement placement) {
		Placement p1 = getPlacementByid(id);
		p1.setDateAndVenue(placement.getDateAndVenue());
		return placementRepo.save(p1);
	}

	@Override
	public void deletePlacement(int id) {
		Placement placement = getPlacementByid(id);
		placementRepo.delete(placement);
	}
}
