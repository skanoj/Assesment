package com.adv.api.service;

import java.util.List;

import com.adv.api.domain.Campaign;

public interface CampaignDetailsService {

	
	/**
	 * THis method signature is to accept the Campaign object and create a campaign and associate to the partner Id
	 * @param campaign
	 */
	void addCampaign(Campaign campaign) throws Exception;

	
	/**
	 * Get the Active Campaign details of a partner, based on the partner Id 
	 * @param pId
	 * @return Campaign object
	 */
	Campaign getCampaignById(String pId) throws Exception;
	
	
	/**
	 * This is additional method implemented to return all the campains available in the memory object/database/cache
	 * @return List of Campaign objects
	 */
	List<Campaign> getAllCampaigns() throws Exception;

	
	/**
	 * Get all the Campaigns related to a partner, based on the partner Id 
	 * @param pId
	 * @return List of Campaign objects
	 */
	
	List<Campaign> getPartnerCampaigns(String pId) throws Exception;

	
}
