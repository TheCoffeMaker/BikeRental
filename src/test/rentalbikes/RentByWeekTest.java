package test.rentalbikes;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rentalbikes.RentByWeek;

class RentByWeekTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRentByWeek() {
		RentByWeek rental = new RentByWeek(1);
		assertTrue(rental.getTotalCost().longValueExact() == 60);		
	}

	@Test
	void testGetTotalCost() {
		RentByWeek rental = new RentByWeek(2);
		assertTrue(rental.getTotalCost().longValueExact() == 120);
	}

	@Test
	void testGetCost() {
		RentByWeek rental = new RentByWeek(1);
		assertTrue(rental.getCost().longValueExact() == 60);
	}

	@Test
	void testSetCost() {
		RentByWeek rental = new RentByWeek(1);
		rental.setCost(new BigDecimal(100));
		assertTrue(rental.getCost().longValueExact() == 100);
	}

	@Test
	void testGetQuantity() {
		RentByWeek rental = new RentByWeek(1);
		rental.setQuantity(5);
		assertTrue(rental.getQuantity() == 5 );
	}

	@Test
	void testSetQuantity() {
		RentByWeek rental = new RentByWeek(1);
		rental.setQuantity(5);
		assertTrue(rental.getTotalCost().longValueExact() == 300 );
	}

}
