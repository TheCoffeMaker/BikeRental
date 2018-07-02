package com.rentalbikes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompositeFamilyPromotion implements iRentable {

	private static int minPromos = 3;
	private static int maxPromos = 5;

	private static int discount = 30;
	
	private List<iRentable> promoRentals = new ArrayList<iRentable>();

	
	/**
	 * 
	 */
	@Override
	public BigDecimal getTotalCost() {
		if (this.promoRentals.size() < this.minPromos) {
			return new BigDecimal(0);
		}
		
		long promoSums = 0;
		
		for (iRentable rental : this.promoRentals) {
			promoSums = promoSums + rental.getTotalCost().longValueExact();
		} 		
		return new BigDecimal(promoSums * discount / 100);
	}
	
	/**
	 * 
	 * @param aRental
	 * @throws Exception
	 */
	public void addRental(iRentable aRental) throws Exception {
		if (this.promoRentals.size() < this.maxPromos) {
			this.promoRentals.add(aRental);
		}else {
			throw new Exception("Maximum rental items reached");
		}
	}
}
