package com.intenthq.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.intenthq.domain.BallThrow;
import com.intenthq.domain.Horse;
import com.intenthq.exception.InsufficientBallThrowInputsException;
import com.intenthq.exception.InvalidNumberOfPlayersException;
import com.intenthq.exception.InvalidThrowYardsException;
import com.intenthq.util.HorsePositionComparator;

/**
 * Horse Racing Service class for handling the game play logic
 * 
 * @author MadhuriSowmya
 * 
 */
public class HorseRacingService {

	private static final int MAX_PLAYERS = 7;
	private static final int MAX_YARDS = 220; // Assuming 1 furlong equals 220
												// yards.
	private static final List<Integer> VALID_VALUES_FOR_YARDS = Arrays.asList(
			5, 5, 5, 5, 10, 10, 10, 20, 20, 40, 60);

	public static Set<Horse> playGame(String[] horses,
			List<BallThrow> ballThrowInputs) throws Exception {

		if (horses.length > MAX_PLAYERS || horses.length < 1) {
			throw new InvalidNumberOfPlayersException(
					"Invalid number of players.");
		}

		if (ballThrowInputs == null || ballThrowInputs.size() == 0) {
			throw new InsufficientBallThrowInputsException(
					"Please provide the ball throw inputs to continue the game.");
		}

		Map<Integer, Horse> laneNumToHorseMap = new HashMap<>();
		for (int laneNum = 1; laneNum <= horses.length; laneNum++) {
			Horse horse = new Horse(horses[laneNum - 1], laneNum);
			laneNumToHorseMap.put(laneNum, horse);
		}
		boolean gameFinished = false;
		for (BallThrow ballThrow : ballThrowInputs) {
			int laneNum = ballThrow.getLane();
			Horse horse = laneNumToHorseMap.get(laneNum);
			if (horse == null) {
				//We can use Log4j to log these messages.
				System.out.println("There is no player in lane numer "
						+ laneNum + ". So ignoring that input.");
				continue;
			}
			int yardsCovered = horse.getYards();
			int currentThrowYards = ballThrow.getYards();
			if (!VALID_VALUES_FOR_YARDS.contains(currentThrowYards)) {
				throw new InvalidThrowYardsException("Invalid throw yards "
						+ currentThrowYards + ".");
			}
			horse.setYards(yardsCovered + currentThrowYards);
			if (horse.getYards() >= MAX_YARDS) {
				gameFinished = true;
				break;
			}
		}
		if (!gameFinished) {
			throw new InsufficientBallThrowInputsException(
					"Game is not yet finished. Need some more inputs to continue the game.");
		}
		Set<Horse> horseSet = new TreeSet<>(new HorsePositionComparator());
		horseSet.addAll(laneNumToHorseMap.values());
		return horseSet;
	}
}
