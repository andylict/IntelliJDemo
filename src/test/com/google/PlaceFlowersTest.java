package test.com.google;

import static org.junit.Assert.*;

import org.junit.Test;

import main.com.google.PlaceFlowers;

public class PlaceFlowersTest {

	@Test
	public void test() {
		int[] flowerbed = {1, 0, 0, 0, 1};
		assertEquals(true, PlaceFlowers.canPlaceFlowers(flowerbed, 1));
		assertEquals(false, PlaceFlowers.canPlaceFlowers(flowerbed, 2));
	}

}
