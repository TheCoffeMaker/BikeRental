package test.rentalbikes;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rentalbikes.Bike;
import com.rentalbikes.Company;

class CompanyRentABikeByDayTest{

	Company company = new Company();
	
	@BeforeEach
	void setUp() throws Exception {
		company.addNewBike(new Bike("RFJ-123"));
		company.addNewBike(new Bike("RFJ-133"));
		company.addNewBike(new Bike("RFJ-143"));
		company.addNewBike(new Bike("RFJ-153"));
		company.addNewBike(new Bike("RFJ-163"));
		company.addNewBike(new Bike("RFJ-173"));
	}

	/**
	 * Test method for {@link com.rentalbikes.Company#rentByDay(com.rentalbikes.Bike, java.lang.Integer)}.
	 * Test rental for one hour
	 */
	@Test
	void testRentByDay() {
		company.rentByDay(1);
		assertTrue(company.getTotalRentals() == 20);		
	}

	/**
	 * Test method for {@link com.rentalbikes.Company#rentByDay(com.rentalbikes.Bike, java.lang.Integer)}.
	 * Test rental for one hour
	 */
	@Test
	void testRentByTwoDays() {
		company.rentByDay(2);
		assertTrue(company.getTotalRentals() == 40);		
	}

	/**
	 * Test method for {@link com.rentalbikes.Company#rentByDay(com.rentalbikes.Bike, java.lang.Integer)}.
	 * Test rental for one hour
	 */
	@Test
	void testRentByFiveDays() {
		company.rentByDay(5);
		assertTrue(company.getTotalRentals() == 100);		
	}
	
}
