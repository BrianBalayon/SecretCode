package test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.CharMatcher;

public class CharMatcherTest {
	
	private CharMatcher _match;

	public void matchTest (String s, ArrayList<Integer> answer) {
		ArrayList<Character> toMatch = new ArrayList<Character>();
		for (int i=0; toMatch.size() < s.length(); i+=1) {
			toMatch.add(s.charAt(i));
		}
		ArrayList<Integer> result = _match.match(toMatch);
		assertEquals("The ArrayLists and String should have the same length/size", s.length(), result.size());
		for (int i=0; i<s.length(); i+=1) {
			int currentAns = answer.get(i);
			int currentRes = result.get(i);
			assertEquals("The map at index " +i+ " is wrong", currentAns, currentRes);
		}
	}
	
	public void restringTest (String original, String expected, ArrayList<Integer> translated) {
		String result = _match.restring(translated, original);
		assertEquals(expected, result);
	}
	
	@Before
	public void setUp () {
		_match = new CharMatcher();
	}
	
	@Test 
	public void test00 () {
		String s = "a";
		Integer[] toAl = {0};
		ArrayList<Integer> ans = new ArrayList<Integer>(Arrays.asList(toAl));
		matchTest(s, ans);
		restringTest(s, s, ans);
	}
	
	@Test 
	public void test01 () {
		String s = "B 0";
		Integer[] toAl = {27, -1, 52};
		ArrayList<Integer> ans = new ArrayList<Integer>(Arrays.asList(toAl));
		matchTest(s, ans);
		restringTest(s, s, ans);
	}
	
	@Test 
	public void test02 () {
		String s = "B 0 :) yay";
		Integer[] toAl = {27, -1, 52, -1, -1, -1, -1, 24, 0, 24};
		ArrayList<Integer> ans = new ArrayList<Integer>(Arrays.asList(toAl));
		matchTest(s, ans);
		restringTest(s, s, ans);
	}
	
}
