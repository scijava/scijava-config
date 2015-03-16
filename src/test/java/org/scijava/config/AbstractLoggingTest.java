
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
