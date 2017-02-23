package com.adv.api.domain;

public class Campaign {

	private String partnerId;

	private long duration;
	private String adContent;
	
	
	public Campaign() {
	
	}
	
	public Campaign(String partnerId, long duration, String adContent) {
		super();
		this.partnerId = partnerId;
		this.duration = duration;
		this.adContent = adContent;
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
	@Override
	public String toString() {
		return "Campaign [partnerId=" + partnerId + ", duration=" + duration + ", adContent=" + adContent + "]";
	}

	
}
