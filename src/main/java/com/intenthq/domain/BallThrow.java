package com.intenthq.domain;

/**
 * Domain class representing the number of yards(points mentioned in hole) for each lane in a particular
 * throw
 * 
 * @author MadhuriSowmya
 * 
 */
public class BallThrow {

	private int lane;
	private int yards;

	public BallThrow(int lane, int yards) {
		this.lane = lane;
		this.yards = yards;
	}

	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	public int getYards() {
		return yards;
	}

	public void setYards(int yards) {
		this.yards = yards;
	}

}
