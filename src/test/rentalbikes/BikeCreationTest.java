package test.rentalbikes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rentalbikes.Bike;

class BikeCreationTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void CreateTest() {
			Bike aBike = new Bike("UTF-865");
			assertEquals("UTF-865", aBike.getPlate());
	}

}
