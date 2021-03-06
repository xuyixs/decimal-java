/*
 * Copyright (c) 2017 Firebird development team and individual contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.firebirdsql.decimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Test to check if the decimal constants match the specification.
 *
 * @author <a href="mailto:mark@lawinegevaar.nl">Mark Rotteveel</a>
 */
public class DecimalFormatTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void decimal32() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal32;
        assertEquals("formatBitLength", 32, decimalFormat.formatBitLength);
        assertEquals("formatByteLength", 4, decimalFormat.formatByteLength);
        assertEquals("coefficientDigits", 7, decimalFormat.coefficientDigits);
        assertEquals("exponentContinuationBits", 6, decimalFormat.exponentContinuationBits);
        assertEquals("coefficientContinuationBits", 20, decimalFormat.coefficientContinuationBits);
        assertEquals("eLimit", 191, decimalFormat.eLimit);
        assertEquals("exponentBias", 101, decimalFormat.biasedExponent(0));
    }

    @Test
    public void decimal32_validateCoefficient_min() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal32;
        final BigInteger value = new BigInteger("-9999999");

        assertSame(value, decimalFormat.validateCoefficient(value));
    }

    @Test
    public void decimal32_validateCoefficient_min_minusOne() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal32;
        final BigInteger value = new BigInteger("-9999999").subtract(BigInteger.ONE);
        expectedException.expect(DecimalOverflowException.class);

        decimalFormat.validateCoefficient(value);
    }

    @Test
    public void decimal32_validateCoefficient_max() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal32;
        final BigInteger value = new BigInteger("9999999");

        assertSame(value, decimalFormat.validateCoefficient(value));
    }

    @Test
    public void decimal32_validateCoefficient_max_plusOne() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal32;
        final BigInteger value = new BigInteger("9999999").add(BigInteger.ONE);
        expectedException.expect(DecimalOverflowException.class);

        decimalFormat.validateCoefficient(value);
    }

    @Test
    public void decimal64() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal64;
        assertEquals("formatBitLength", 64, decimalFormat.formatBitLength);
        assertEquals("formatByteLength", 8, decimalFormat.formatByteLength);
        assertEquals("coefficientDigits", 16, decimalFormat.coefficientDigits);
        assertEquals("exponentContinuationBits", 8, decimalFormat.exponentContinuationBits);
        assertEquals("coefficientContinuationBits", 50, decimalFormat.coefficientContinuationBits);
        assertEquals("eLimit", 767, decimalFormat.eLimit);
        assertEquals("exponentBias", 398, decimalFormat.biasedExponent(0));
    }

    @Test
    public void decimal64_validateCoefficient_min() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal64;
        final BigInteger value = new BigInteger("-9999999999999999");

        assertSame(value, decimalFormat.validateCoefficient(value));
    }

    @Test
    public void decimal64_validateCoefficient_min_minusOne() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal64;
        final BigInteger value = new BigInteger("-9999999999999999").subtract(BigInteger.ONE);
        expectedException.expect(DecimalOverflowException.class);

        decimalFormat.validateCoefficient(value);
    }

    @Test
    public void decimal64_validateCoefficient_max() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal64;
        final BigInteger value = new BigInteger("9999999999999999");

        assertSame(value, decimalFormat.validateCoefficient(value));
    }

    @Test
    public void decimal64_validateCoefficient_max_plusOne() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal64;
        final BigInteger value = new BigInteger("9999999999999999").add(BigInteger.ONE);
        expectedException.expect(DecimalOverflowException.class);

        decimalFormat.validateCoefficient(value);
    }

    @Test
    public void decimal128() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal128;
        assertEquals("formatBitLength", 128, decimalFormat.formatBitLength);
        assertEquals("formatByteLength", 16, decimalFormat.formatByteLength);
        assertEquals("coefficientDigits", 34, decimalFormat.coefficientDigits);
        assertEquals("exponentContinuationBits", 12, decimalFormat.exponentContinuationBits);
        assertEquals("coefficientContinuationBits", 110, decimalFormat.coefficientContinuationBits);
        assertEquals("eLimit", 12287, decimalFormat.eLimit);
        assertEquals("exponentBias", 6176, decimalFormat.biasedExponent(0));
    }

    @Test
    public void decimal128_validateCoefficient_min() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal128;
        final BigInteger value = new BigInteger("-9999999999999999999999999999999999");

        assertSame(value, decimalFormat.validateCoefficient(value));
    }

    @Test
    public void decimal128_validateCoefficient_min_minusOne() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal128;
        final BigInteger value = new BigInteger("-9999999999999999999999999999999999").subtract(BigInteger.ONE);
        expectedException.expect(DecimalOverflowException.class);

        decimalFormat.validateCoefficient(value);
    }

    @Test
    public void decimal128_validateCoefficient_max() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal128;
        final BigInteger value = new BigInteger("9999999999999999999999999999999999");

        assertSame(value, decimalFormat.validateCoefficient(value));
    }

    @Test
    public void decimal128_validateCoefficient_max_plusOne() {
        final DecimalFormat decimalFormat = DecimalFormat.Decimal128;
        final BigInteger value = new BigInteger("9999999999999999999999999999999999").add(BigInteger.ONE);
        expectedException.expect(DecimalOverflowException.class);

        decimalFormat.validateCoefficient(value);
    }

}