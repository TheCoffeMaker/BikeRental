package test.rentalbikes;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rentalbikes.RentByHour;
import com.rentalbikes.RentByWeek;

class RentByHourTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRentByHour() {
		RentByHour rental = new RentByHour(1);
		assertTrue(rental.getTotalCost().longValueExact() == 5);		
	}

	@Test
	void testGetTotalCost() {
		RentByHour rental = new RentByHour(2);
		assertTrue(rental.getTotalCost().longValueExact() == 10);
	}

	@Test
	void testGetCost() {
		RentByHour rental = new RentByHour(1);
		assertTrue(rental.getCost().longValueExact() == 5);
	}

	@Test
	void testSetCost() {
		RentByHour rental = new RentByHour(1);
		rental.setCost(new BigDecimal(100));
		assertTrue(rental.getCost().longValueExact() == 100);
	}

	@Test
	void testGetQuantity() {
		RentByHour rental = new RentByHour(1);
		rental.setQuantity(5);
		assertTrue(rental.getQuantity() == 5 );
	}

	@Test
	void testSetQuantity() {
		RentByHour rental = new RentByHour(1);
		rental.setQuantity(5);
		assertTrue(rental.getTotalCost().longValueExact() == 25 );
	}
}
