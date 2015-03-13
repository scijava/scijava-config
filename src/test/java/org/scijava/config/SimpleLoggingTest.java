package org.scijava.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.scijava.config.AbstractLoggingTest;

/**
 * Simple sanity tests for stdout and stderr log testing.
 * 
 * @author Curtis Rueden
 */
public class SimpleLoggingTest extends AbstractLoggingTest {

	@Test
	public void testStdOut() {
		final String greeting = "Hello, world!";
		System.out.print(greeting);
		assertEquals(greeting, stdout());
	}

	@Test
	public void testStdOut2() {
		final String farewell = "Goodbye, cruel world!";
		System.out.print(farewell);
		assertEquals(farewell, stdout());
	}

	@Test
	public void testStdErr() {
		final String sentence = "The quick brown fox jumps over the lazy dog.";
		System.err.print(sentence);
		assertEquals(sentence, stderr());
	}

	@Test
	public void testStdErr2() {
		final String phrase = "Higgledy\npiggledy.";
		System.err.print(phrase);
		assertEquals(phrase, stderr());
	}

}
