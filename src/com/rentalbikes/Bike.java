package com.rentalbikes;

public class Bike {

	public Bike(String plate) {
		super();
		this.plate = plate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bike [plate=" + this.plate + "]";
	}

	private String plate;
	
	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	

}
