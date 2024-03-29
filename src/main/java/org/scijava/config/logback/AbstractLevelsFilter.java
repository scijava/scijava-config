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

import java.util.ArrayList;
import java.util.Arrays;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Filters log messages, keeping only certain levels. This is useful so that
 * they can be directed to a particular log appender (e.g., {@code stdout} or
 * {@code stderr}).
 * <p>
 * This implementation is distinct from logback-classic's built-in
 * {@link ch.qos.logback.classic.filter.LevelFilter}, because that filter only
 * accepts one level at a time, whereas this implementation accepts a list of
 * levels.
 * </p>
 * <p>
 * Thanks to Uriah Carpenter for <a
 * href="http://stackoverflow.com/a/5653532">his answer on StackOverflow</a>.
 * </p>
 *
 * @author Curtis Rueden
 */
public class AbstractLevelsFilter extends AbstractMatcherFilter<LoggingEvent> {

	private final ArrayList<Level> levels;

	public AbstractLevelsFilter(final Level... levels) {
		this.levels = new ArrayList<Level>(Arrays.asList(levels));
	}

	@Override
	public FilterReply decide(final LoggingEvent event) {
		if (!isStarted()) return FilterReply.NEUTRAL;

		return levels.contains(event.getLevel()) ?
			FilterReply.NEUTRAL : FilterReply.DENY;
	}

}
