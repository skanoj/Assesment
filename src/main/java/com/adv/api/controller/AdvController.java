package com.adv.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.adv.api.domain.Campaign;

public interface AdvController {
	
	public void addAdv(Campaign campaign) throws Exception;
	
	public Campaign getActiveAdv(String pId) throws Exception;
	
	public List<Campaign> getPartnerAdvs(String pId) throws Exception;

	public List<Campaign> getAllAdvs() throws Exception;

}
