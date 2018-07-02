package test.rentalbikes;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.rentalbikes.Bike;
import com.rentalbikes.Company;
import com.rentalbikes.RentByDay;
import com.rentalbikes.RentByHour;
import com.rentalbikes.RentByWeek;
import com.rentalbikes.iRentable;

class CompanyRentAFamilyRentalTest {

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
	void testFamilyRental() {
		List<iRentable> rentals = new ArrayList<iRentable>();
		rentals.add(new RentByHour(10));
		rentals.add(new RentByDay(4));
		rentals.add(new RentByWeek(2));
		rentals.add(new RentByHour(8));
		rentals.add(new RentByDay(1));
		try {
			company.familyRental(rentals);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(company.getTotalRentals() == 93);
	}
	
	@Test
	void testInvalidFamilyRentalByLessThanMin() {
		List<iRentable> rentals = new ArrayList<iRentable>();
		rentals.add(new RentByHour(10));
		rentals.add(new RentByDay(4));
		try {
			company.familyRental(rentals);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(company.getTotalRentals() == 0);
	}
	
	@Test
	void testInvalidFamilyRentalByMoreThanMax() throws Exception{
		List<iRentable> rentals = new ArrayList<iRentable>();
		rentals.add(new RentByHour(10));
		rentals.add(new RentByDay(4));
		rentals.add(new RentByWeek(2));
		rentals.add(new RentByHour(8));
		rentals.add(new RentByDay(1));
		rentals.add(new RentByDay(4));
		company.familyRental(rentals);
	}

}
