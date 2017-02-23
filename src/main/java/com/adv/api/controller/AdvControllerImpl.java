package com.adv.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.adv.api.domain.Campaign;
import com.adv.api.service.CampaignDetailsService;


@RestController
public class AdvControllerImpl implements AdvController {

	@Autowired
	CampaignDetailsService campaignDetailsService;
	
	/**
	 * Service URI declaration for adding a new campaign
	 */
	@Override
	@PostMapping(path="/ad", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addAdv(@RequestBody Campaign campaign) throws Exception {

		campaignDetailsService.addCampaign(campaign);
	}

	/**
	 * Service URI declaration for retrieving an active campaign for a partner id
	 */
	@Override
	@GetMapping(path="/ad/{pId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Campaign getActiveAdv(@PathVariable String pId) throws Exception{ 

		return campaignDetailsService.getCampaignById(pId);
		
		
	}

	/**
	 * Service URI declaration for retrieving all campaigns for all the partners
	 */
	@Override
	@GetMapping(path="/ad/campaign/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Campaign> getAllAdvs() throws Exception{
		
		return campaignDetailsService.getAllCampaigns();
	}

	/**
	 * Service URI declaration for retrieving all campaigns for a partner id
	 */
	@Override
	@GetMapping(path="/ad/all/{pId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Campaign> getPartnerAdvs(@PathVariable String pId) throws Exception{
			
		return campaignDetailsService.getPartnerCampaigns(pId);
	}

}
