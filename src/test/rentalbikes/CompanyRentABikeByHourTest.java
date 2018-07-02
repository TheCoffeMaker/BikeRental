/**
 * 
 */
package test.rentalbikes;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rentalbikes.Bike;
import com.rentalbikes.Company;

/**
 * @author damian
 *
 */
class CompanyRentABikeByHourTest {

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
	 * Test method for {@link com.rentalbikes.Company#rentByHour(com.rentalbikes.Bike, java.lang.Integer)}.
	 * Test rental for one hour
	 */
	@Test
	void testRentByHour() {
		company.rentByHour(1);
		assertTrue(company.getTotalRentals() == 5);		
	}

	/**
	 * Test method for {@link com.rentalbikes.Company#rentByHour(com.rentalbikes.Bike, java.lang.Integer)}.
	 * Test rental for two hour
	 */
	@Test
	void testRentByTwoHour() {
		company.rentByHour(2);
		assertTrue(company.getTotalRentals() == 10);		
	}
	
	/**
	 * Test method for {@link com.rentalbikes.Company#rentByHour(com.rentalbikes.Bike, java.lang.Integer)}.
	 * Test rental for five hours
	 */
	@Test
	void testRentByFiveHours() {
		company.rentByHour(5);
		assertTrue(company.getTotalRentals() == 25);		
	}
	
}
