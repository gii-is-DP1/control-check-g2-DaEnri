package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/feeding")
public class FeedingController {
	
	private final FeedingService feedingService;
    
	@Autowired
	public FeedingController(FeedingService feedingService) {
		this.feedingService = feedingService;
	}
}
