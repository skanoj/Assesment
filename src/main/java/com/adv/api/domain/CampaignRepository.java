package com.adv.api.domain;

import java.time.LocalDateTime;

public class CampaignRepository {

	private String partnerId;
	private long duration;
	private String adContent;
	private LocalDateTime createdTime;
	
	public CampaignRepository() {
		
	}
	public CampaignRepository(String partnerId, long duration, String adContent, LocalDateTime createdTime) {
		super();
		this.partnerId = partnerId;
		this.duration = duration;
		this.adContent = adContent;
		this.createdTime = createdTime;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getAdContent() {
		return adContent;
	}
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "CampaignRepository [partnerId=" + partnerId + ", duration=" + duration + ", adContent=" + adContent
				+ ", createdTime=" + createdTime + "]";
	}
	
	
}
