package com.evertvdbruel.helpers.test;

import org.junit.Test;

import com.evertvdbruel.helpers.StringHelper;

import junit.framework.TestCase;

public class StringHelperTest extends TestCase {

	@Test
	public void testIsEmpty() {
		assertEquals("null String must be true", Boolean.TRUE,
				StringHelper.isEmpty(null));
		assertEquals("test String must be false", Boolean.FALSE,
				StringHelper.isEmpty("test"));
	}

	@Test
	public void testFormatNumber() {
		String format = "0.00";
		String formattedDouble = StringHelper.formatNumber((double) 0, format);
		assertEquals("formatted double must equal 0.00", "0.00",
				formattedDouble);

	}
}
