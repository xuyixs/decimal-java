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

/**
 * Signum constants used in decimal-java
 *
 * @author <a href="mailto:mark@lawinegevaar.nl">Mark Rotteveel</a>
 */
public final class Signum {

    public static final int POSITIVE = 1;
    public static final int NEGATIVE = -1;

    private Signum() {
        // no instances
    }

    /**
     * Is {@code signumValue} positive.
     * <p>
     * This is not a direct inverse of {@link #isNegative(int)}.
     * </p>
     *
     * @param signumValue
     *         signum value
     * @return {@code true} if {@code signumValue} is {@link #POSITIVE}
     */
    public static boolean isPositive(int signumValue) {
        return signumValue == POSITIVE;
    }

    /**
     * Is {@code signumValue} negative.
     * <p>
     * This is not a direct inverse of {@link #isPositive(int)}.
     * </p>
     *
     * @param signumValue
     *         signum value
     * @return {@code true} if {@code signumValue} is {@link #NEGATIVE}
     */
    public static boolean isNegative(int signumValue) {
        return signumValue == NEGATIVE;
    }

}
