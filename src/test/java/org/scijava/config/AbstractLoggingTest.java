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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Abstract base class for stdout- and stderr-based logging tests.
 *
 * @author Curtis Rueden
 */
public abstract class AbstractLoggingTest {

	private static ByteArrayOutputStream stdout, stderr;

	static {
		// NB: We pollute the global state, but what can you do?
		stdout = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stdout));
		stderr = new ByteArrayOutputStream();
		System.setErr(new PrintStream(stderr));
	}

	// -- AbstractLoggingTest methods --

	/** Gets the text written to stdout since last time this method was called. */
	public static String stdout() {
		return s(stdout);
	}

	/** Gets the text written to stderr since last time this method was called. */
	public static String stderr() {
		return s(stderr);
	}

	// -- Helper methods --

	private static String s(final ByteArrayOutputStream baos) {
		final String s = baos.toString();
		baos.reset();
		return s;
	}

}
