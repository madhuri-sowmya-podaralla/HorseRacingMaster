package com.intenthq.util;

import java.util.Comparator;

import com.intenthq.domain.Horse;

/**
 * Comparator class to compare Horses based on the yards they covered in
 * descending order.
 * 
 * @author MadhuriSowmya
 * 
 */
public class HorsePositionComparator implements Comparator<Horse> {

	@Override
	public int compare(Horse horse1, Horse horse2) {
		return horse2.getYards() - horse1.getYards();
	}

}
