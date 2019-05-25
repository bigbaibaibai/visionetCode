package com.ssm.entites;

import java.util.Date;
import java.util.List;

public class Trade {
	private Integer id;

	private Integer userId;

	private Date tradeTime;

	private List<TradeItem> tradeItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public List<TradeItem> getTradeItems() {
		return tradeItems;
	}

	public void setTradeItems(List<TradeItem> tradeItems) {
		this.tradeItems = tradeItems;
	}

	public Trade(Integer id, Integer userId, Date tradeTime, List<TradeItem> tradeItems) {
		super();
		this.id = id;
		this.userId = userId;
		this.tradeTime = tradeTime;
		this.tradeItems = tradeItems;
	}

	public Trade(Integer userId, Date tradeTime, List<TradeItem> tradeItems) {
		super();
		this.userId = userId;
		this.tradeTime = tradeTime;
		this.tradeItems = tradeItems;
	}

	public Trade() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tradeItems == null) ? 0 : tradeItems.hashCode());
		result = prime * result + ((tradeTime == null) ? 0 : tradeTime.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tradeItems == null) {
			if (other.tradeItems != null)
				return false;
		} else if (!tradeItems.equals(other.tradeItems))
			return false;
		if (tradeTime == null) {
			if (other.tradeTime != null)
				return false;
		} else if (!tradeTime.equals(other.tradeTime))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}