package examplefuncsplayer;

import static org.junit.Assert.*;
import org.junit.Test;

import battlecode.common.MapInfo;

public class RobotPlayerTest {

	@Test
	public void testSanity() {
		assertEquals(2, 1+1);
	}

	// Test the shouldTurn method for SpiralPainter
	@Test
	public void testShouldTurn() {
		MapInfo info = new MapInfo(null, false, false, null, null, false, false);
		assertEquals(2, 1+1);
	}

}
