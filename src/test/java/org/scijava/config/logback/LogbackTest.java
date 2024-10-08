/*
 * #%L
 * SciJava Configuration bundle for SciJava software.
 * %%
 * Copyright (C) 2014 - 2023 SciJava developers.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package org.scijava.config.logback;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.scijava.config.AbstractLoggingTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests the SciJava-Config logback configuration.
 * 
 * @author Curtis Rueden
 */
public class LogbackTest extends AbstractLoggingTest {

	private static final String NL = System.lineSeparator();

	private Logger log;

	@Before
	public void setUp() {
		log = LoggerFactory.getLogger(LogbackTest.class);
	}

	@Test
	public void testError() {
		final String error = "Guru Meditation";
		log.error(error);
		assertEquals("", stdout());
		assertEquals("[ERROR] " + error + NL, stderr());
	}

	@Test
	public void testWarn() {
		final String warning = "Watch out for snakes!";
		log.warn(warning);
		assertEquals("", stdout());
		assertEquals("[WARN] " + warning + NL, stderr());
	}

	@Test
	public void testInfo() {
		final String info = "Dogs are bigger than cats. But not all the time.";
		log.info(info);
		assertEquals(info + NL, stdout());
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
