package com.adv.api.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CampaignDaoUtility {

	public CampaignDaoUtility() {
		
	}


	/**
	 * This method will return the Campaign object matching the 
	 * partnerId that was supplied to the API request.
	 * 
	 * @param fullLst
	 * @param partnerId
	 * @return
	 */
	public Campaign getActiveCampaignById(List<CampaignRepository> fullLst, String partnerId){
		
		 CampaignRepository campaignRepository =fullLst.stream().filter(t -> t.getPartnerId().equals(partnerId))
		.filter(t -> t.getCreatedTime().plusSeconds(t.getDuration()).isAfter(LocalDateTime.now()))
		.findFirst().get();
		 
		 return new Campaign(campaignRepository.getPartnerId(), campaignRepository.getDuration(), campaignRepository.getAdContent());

	}
	
	/**
	 * This method will return all the campaigns matching the 
	 * partnerId that was supplied to the API request.
	 * 
	 * @param fullLst
	 * @param partnerId
	 * @return
	 */
	public List<Campaign> getAllCampaignById(List<CampaignRepository> fullLst, String partnerId){

		List<Campaign> campaignList = new ArrayList<>();
		
		for(CampaignRepository c: fullLst)
		{
			if(c.getPartnerId().equals(partnerId))
				campaignList.add(new Campaign(c.getPartnerId(),c.getDuration(),c.getAdContent()));
		}
	
		return campaignList;	
		
	}
	
	
	/**
	 * This method will return all the campaigns  
	 * available in the data store/memory/cache
	 * @param fullLst
	 * @return
	 */
	public List<Campaign> getAllCampaigns(List<CampaignRepository> fullLst){
		
		List<Campaign> campaignList = new ArrayList<>();
				
			for(CampaignRepository c: fullLst)
			{
				campaignList.add(new Campaign(c.getPartnerId(),c.getDuration(),c.getAdContent()));
			}
		
			return campaignList;	

	}
	
	
}
