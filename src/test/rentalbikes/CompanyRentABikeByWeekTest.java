package test.rentalbikes;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rentalbikes.Bike;
import com.rentalbikes.Company;

class CompanyRentABikeByWeekTest {

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

	

	@Test
	void testRentByWeek() {
		company.rentByWeek(1);
		assertTrue(company.getTotalRentals() == 60);		
	}


	@Test
	void testRentByTwoWeeks() {
		company.rentByWeek(2);
		assertTrue(company.getTotalRentals() == 120);		
	}


	@Test
	void testRentByFiveWeeks() {
		company.rentByWeek(5);
		assertTrue(company.getTotalRentals() == 300);		
	}

}
