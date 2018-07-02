package com.rentalbikes;

import java.math.BigDecimal;

public class RentByWeek extends AbstractRent {
	
	private static BigDecimal BASE_COST = new BigDecimal(60);
	
	public RentByWeek(int quantity) {
		super();
		this.setQuantity(quantity);
		this.setCost(BASE_COST);
	}

	@Override
	public BigDecimal getTotalCost() {
		return this.getCost().multiply(new BigDecimal(this.getQuantity()));
	}
}
