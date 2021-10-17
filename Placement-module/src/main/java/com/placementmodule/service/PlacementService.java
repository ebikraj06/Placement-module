package com.placementmodule.service;

import java.util.List;

import com.placementmodule.entities.Placement;


public interface PlacementService {
	
	public Placement savePlacement(Placement placement);
	
	public List<Placement> getAllPlacement();
	
	public Placement getPlacementByid(int id);
	
	public Placement upadatePlacement(int id,Placement placement);
	
	public void deletePlacement(int id);
}
