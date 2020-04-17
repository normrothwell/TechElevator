package com.techelevator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordCountTest {

	@Test
	public void getCount_returns_map_ba_2_black_1_sheep_1_given_ba_ba_black_sheep() {
		WordCount word = new WordCount();
		String[] test = new String[]{"ba","ba","black","sheep"};
		Map<String, Integer> expected = new HashMap<>();
		expected.put("ba", 2);
		expected.put("black", 1);
		expected.put("sheep", 1);
		assertTrue(expected.equals(word.getCount(test)));
	}
	
	@Test
	public void getCount_returns_map_b_2_c_1_a_2_given_a_b_a_c_b() {
		WordCount word = new WordCount();
		String[] test = new String[]{"a","b","a","c","b"};
		Map<String, Integer> expected = new HashMap<>();
		expected.put("b", 2);
		expected.put("c", 1);
		expected.put("a", 2);
		assertTrue(expected.equals(word.getCount(test)));
	}
	
	@Test
	public void getCount_returns_map_c_1_b_1_a_1_given_c_b_a() {
		WordCount word = new WordCount();
		String[] test = new String[]{"c","b","a"};
		Map<String, Integer> expected = new HashMap<>();
		expected.put("a", 1);
		expected.put("b", 1);
		expected.put("c", 1);
		assertTrue(expected.equals(word.getCount(test)));
	}

}
