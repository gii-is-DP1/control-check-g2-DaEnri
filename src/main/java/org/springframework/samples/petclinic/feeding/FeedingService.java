package org.springframework.samples.petclinic.feeding;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {
	
	@Autowired
	private FeedingRepository feedingRepository;
	
	@Autowired
	public FeedingService(FeedingRepository feedingRepository) {
		this.feedingRepository = feedingRepository;
	}
	
    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return feedingRepository.findAllFeedingTypes();
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.findFeedingTypeByName(typeName);
    }
    
    @Transactional
    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
        
    	if (p.getFeedingType().getPetType().getId() != p.getPet().getId()) {
			throw new UnfeasibleFeedingException();
		}else {
			return feedingRepository.save(p);
		}
    }

    
}
