package com.placementmodule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.placementmodule.entities.Placement;
import com.placementmodule.repository.PlacementRepository;

@SpringBootTest
class PlacementModuleApplicationTests {

	@Autowired
	PlacementRepository repo;
	
	@Test
	void contextLoads() {
	}
	
	@Test 
	public void testCreatePlacement() {
		Placement placement = new Placement();
	    placement.setCompanyEmail("wipro@gmail.com");
	    placement.setCompanyName("Wipro");
	    placement.setDateAndVenue("12-12-12 - KCT College");
	    placement.setPercentage("75");
	    placement.setPosition("BA");
	    Placement savedPlacement = repo.save(placement);    
	}
	

}
