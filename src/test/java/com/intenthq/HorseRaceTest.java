package com.intenthq;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.intenthq.domain.BallThrow;
import com.intenthq.domain.Horse;
import com.intenthq.service.HorseRacingService;

/**
 * Test class to see the desired output
 * 
 * @author MadhuriSowmya
 * 
 */
public class HorseRaceTest {

	public static void main(String[] args) throws Exception {

		String[] horses = { "Star", "Dakota", "Cheyenne", "Misty", "Spirit" };
		List<BallThrow> ballThrows = new ArrayList<>();
		ballThrows.add(new BallThrow(1, 60));
		ballThrows.add(new BallThrow(3, 5));
		ballThrows.add(new BallThrow(1, 60));
		ballThrows.add(new BallThrow(4, 5));
		ballThrows.add(new BallThrow(4, 10));
		ballThrows.add(new BallThrow(2, 5));
		ballThrows.add(new BallThrow(5, 10));
		ballThrows.add(new BallThrow(1, 60));
		ballThrows.add(new BallThrow(3, 20));
		ballThrows.add(new BallThrow(7, 10));
		ballThrows.add(new BallThrow(1, 40));
		ballThrows.add(new BallThrow(2, 60));

		Set<Horse> horseSet = HorseRacingService.playGame(horses, ballThrows);
		int position = 1;
		for (Horse horse : horseSet) {
			System.out.println(position++ + ", " + horse.getLane() + ", "
					+ horse.getName());
		}
	}
}
