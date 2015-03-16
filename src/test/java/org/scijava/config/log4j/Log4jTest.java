package org.scijava.config.log4j;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.scijava.config.AbstractLoggingTest;

/**
 * Tests the SciJava-Config log4j configuration.
 * 
 * @author Curtis Rueden
 */
public class Log4jTest extends AbstractLoggingTest {

	private Logger log;

	@Before
	public void setUp() {
		log = Logger.getLogger(Log4jTest.class);
	}

	@Test
	public void testFatal() {
		final String fatal = "Kernel panic: Fatal exception";
		log.fatal(fatal);
		assertEquals("", stdout());
		assertEquals("[FATAL] " + fatal + "\n", stderr());
	}

	@Test
	public void testError() {
		final String error = "Guru Meditation";
		log.error(error);
		assertEquals("", stdout());
		assertEquals("[ERROR] " + error + "\n", stderr());
	}

	@Test
	public void testWarn() {
		final String warning = "Watch out for snakes!";
		log.warn(warning);
		assertEquals("", stdout());
		assertEquals("[WARN ] " + warning + "\n", stderr());
	}

	@Test
	public void testInfo() {
		final String info = "Dogs are bigger than cats. But not all the time.";
		log.info(info);
		assertEquals(info + "\n", stdout());
		assertEquals("", stderr());
	}

	@Test
	public void testDebug() {
		final String debug = "I like turtles.";
		log.debug(debug);
		assertEquals("", stdout());
		assertEquals("", stderr());
	}

	@Test
	public void testTrace() {
		final String trace = "https://youtu.be/Vxq9yj2pVWk";
		log.trace(trace);
		assertEquals("", stdout());
		assertEquals("", stderr());
	}

}
