package com.adv.api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adv.api.domain.Campaign;
import com.adv.api.domain.CampaignDaoUtility;
import com.adv.api.domain.CampaignRepository;

@Service
public class CampaignDetailsServiceImpl implements CampaignDetailsService {

	/**
	 * In-memory storage of the campaign data
	 * for the project.
	 * The Campaigns added by the users is bring stored in List, to process, return and save.
	 */
	List<CampaignRepository> campaignRepositoryPool = new ArrayList<>(Arrays.asList());
	
	CampaignDaoUtility daoUtility = new CampaignDaoUtility();

	
	/**
	 * Service implementation to get active campaign object
	 * for the given partnerId.
	 * 
	 */
	@Override
	public Campaign getCampaignById(String pId) {

		return daoUtility.getActiveCampaignById(campaignRepositoryPool, pId);
	}

	/**
	 * Service implementation to get all campaigns 
	 * irrespective of partnerId from the system.
	 * 
	 */
	@Override
	public List<Campaign> getAllCampaigns() {
		
		return daoUtility.getAllCampaigns(campaignRepositoryPool);

	}

	
	/**
	 * Service implementation to add a campaign object
	 * for the given partnerId.
	 * 
	 */
	@Override
	public void addCampaign(Campaign campaign) {
	
	  campaignRepositoryPool.add(new CampaignRepository(campaign.getPartnerId(), campaign.getDuration(), campaign.getAdContent(), LocalDateTime.now()));
		
	}

	/**
	 * Service implementation to get all campaign objects
	 * for the given partnerId.
	 * 
	 */
	@Override
	public List<Campaign> getPartnerCampaigns(String pId) {
		
		return daoUtility.getAllCampaignById(campaignRepositoryPool, pId);
	}

}
