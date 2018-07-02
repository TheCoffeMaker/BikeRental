package test.rentalbikes;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rentalbikes.RentByDay;

class RentByDayTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRentByDay() {
		RentByDay rental = new RentByDay(1);
		assertTrue(rental.getTotalCost().longValueExact() == 20);		
	}

	@Test
	void testGetTotalCost() {
		RentByDay rental = new RentByDay(2);
		assertTrue(rental.getTotalCost().longValueExact() == 40);
	}

	@Test
	void testGetCost() {
		RentByDay rental = new RentByDay(1);
		assertTrue(rental.getCost().longValueExact() == 20);
	}

	@Test
	void testSetCost() {
		RentByDay rental = new RentByDay(1);
		rental.setCost(new BigDecimal(100));
		assertTrue(rental.getCost().longValueExact() == 100);
	}

	@Test
	void testGetQuantity() {
		RentByDay rental = new RentByDay(1);
		rental.setQuantity(5);
		assertTrue(rental.getQuantity() == 5 );
	}

	@Test
	void testSetQuantity() {
		RentByDay rental = new RentByDay(1);
		rental.setQuantity(5);
		assertTrue(rental.getTotalCost().longValueExact() == 100 );
	}	
	
}
