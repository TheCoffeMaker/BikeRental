package com.rentalbikes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {

	private List<Bike> bikes = new ArrayList<Bike>();
	private List<iRentable> rents = new ArrayList<iRentable>();
	private Map<iRentable,Bike> rentedBikes = new HashMap<iRentable,Bike>(); 
	
	public void addNewBike(Bike aBike){
		this.bikes.add(aBike);
	}
	
	public void removeBike(Bike aBike){
		this.bikes.remove(aBike);
	}
	
	public void assignFreeBikeToRental(iRentable rental) {
		Bike aBike = this.bikes.get(0);		
		this.rentedBikes.put(rental, aBike);
		this.removeBike(aBike);		 
	}
	
	public void rentByHour(Integer hours) {
		iRentable rentable = new RentByHour(hours);
		this.rents.add(rentable);
		this.assignFreeBikeToRental(rentable);
		System.out.println("Rent by Hour: " +
		                    this.rentedBikes.get(rentable).toString() +
		                    " - Cost:" +
		                    rentable.getTotalCost());
	}
	
	public void rentByDay(Integer days) {
		iRentable rentable = new RentByDay(days);
		this.rents.add(rentable);
		this.assignFreeBikeToRental(rentable);
		System.out.println("Rent by Day: " +
					       this.rentedBikes.get(rentable).toString() +
					       " - Cost:" +
					       rentable.getTotalCost());
	}
	
	public void rentByWeek(Integer weeks) {
		iRentable rentable = new RentByWeek(weeks);
		this.rents.add(rentable);
		this.assignFreeBikeToRental(rentable);
		System.out.println("Rent by Week: " +
		                   this.rentedBikes.get(rentable).toString() +
		                   " - Cost:" +
		                   rentable.getTotalCost());
	}
	
	public void familyRental(List<iRentable> promoRentals){
		CompositeFamilyPromotion rentable = new CompositeFamilyPromotion();
		try {		
			for (iRentable selectedRentable : promoRentals){
	
						rentable.addRental(selectedRentable);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.rents.add(rentable);
		System.out.println("Familiy Promo Cost:" + rentable.getTotalCost());
	}

	public long getTotalRentals(){
		long total = 0;
		for (iRentable rent : this.rents) {
			total = total + rent.getTotalCost().longValueExact();
		}
		return total;
	}
	
}
