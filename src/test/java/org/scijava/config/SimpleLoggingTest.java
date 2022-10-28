/*-
 * #%L
 * SciJava Configuration bundle for SciJava software.
 * %%
 * Copyright (C) 2014 - 2022 SciJava developers.
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
