package com.intenthq.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.intenthq.domain.BallThrow;
import com.intenthq.domain.Horse;
import com.intenthq.exception.InsufficientBallThrowInputsException;
import com.intenthq.exception.InvalidNumberOfPlayersException;
import com.intenthq.exception.InvalidThrowYardsException;

/**
 * Unit tests for HorseRacingService
 * 
 * @author MadhuriSowmya
 * 
 */
public class HorseRacingServiceTest {

	private List<BallThrow> ballThrows;

	@Before
	public void setUp() {
		ballThrows = new ArrayList<>();
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
	}

	@Test(expected = InvalidNumberOfPlayersException.class)
	public void testMaximumNumberOfPlayers() throws Exception {
		String[] horses = { "Star", "Dakota", "Cheyenne", "Misty", "Spirit",
				"horse6", "horse7", "horse8" };
		HorseRacingService.playGame(horses, ballThrows);
	}

	@Test
	public void testTheYardsAreNotCounterAfterAnotherPlayerWins()
			throws Exception {
		String[] horses = { "Star", "Dakota", "Cheyenne", "Misty", "Spirit" };
		Set<Horse> horseSet = HorseRacingService.playGame(horses, ballThrows);
		for (Horse horse : horseSet) {
			if (horse.getName().equals("Dakota")) {
				assertEquals(
						"The Yards after the other player wins can not be counted.",
						5, horse.getYards());
			}
		}
	}

	@Test(expected = InvalidNumberOfPlayersException.class)
	public void testAtleastOnePlayerIsRequiredToPlayTheGame() throws Exception {
		String[] horses = {};
		HorseRacingService.playGame(horses, ballThrows);
	}

	@Test(expected = InsufficientBallThrowInputsException.class)
	public void testThatTheBallThrowInputsMustBeProvided() throws Exception {
		String[] horses = { "Star", "Dakota", "Cheyenne", "Misty", "Spirit" };
		HorseRacingService.playGame(horses, null);
	}

	@Test(expected = InsufficientBallThrowInputsException.class)
	public void testThatTheBallThrowInputsMustBeProvided2() throws Exception {
		String[] horses = { "Star", "Dakota", "Cheyenne", "Misty", "Spirit" };
		HorseRacingService.playGame(horses, new ArrayList());
	}

	@Test(expected = InvalidThrowYardsException.class)
	public void testInvalidThrowYardsAreNotAllowed() throws Exception {
		String[] horses = { "Star", "Dakota", "Cheyenne", "Misty", "Spirit" };
		ballThrows = new ArrayList<>();
		ballThrows.add(new BallThrow(1, 60));
		ballThrows.add(new BallThrow(3, 5));
		ballThrows.add(new BallThrow(2, 80));
		HorseRacingService.playGame(horses, ballThrows);
	}

	@Test(expected = InsufficientBallThrowInputsException.class)
	public void testIfGameIsFinished() throws Exception {
		String[] horses = { "Star", "Dakota", "Cheyenne", "Misty", "Spirit" };
		ballThrows = new ArrayList<>();
		ballThrows.add(new BallThrow(1, 60));
		ballThrows.add(new BallThrow(3, 5));
		ballThrows.add(new BallThrow(2, 40));
		HorseRacingService.playGame(horses, ballThrows);
	}

}
