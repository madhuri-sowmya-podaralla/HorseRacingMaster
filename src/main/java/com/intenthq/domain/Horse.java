package com.intenthq.domain;

/**
 * Horse domain class
 * 
 * @author MadhuriSowmya
 * 
 */
public class Horse {

	private String name;
	private int lane;
	private int yards;

	public Horse(String name, int lane) {
		this.name = name;
		this.lane = lane;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
