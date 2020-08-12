/*
 * Copyright 2020, birdeye-java-sdk Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.broadlume.birdeye.v1.exception;

import com.broadlume.birdeye.v1.model.ErrorResponse;

/**
 * Base class for all exceptions from BirdEye
 */
public class BirdEyeException extends RuntimeException {

    private final int statusCode;
    private final ErrorResponse errorResponse;

    public BirdEyeException(int statusCode, ErrorResponse errorResponse) {
        this(null, null, statusCode, errorResponse);
    }

    public BirdEyeException(String message, int statusCode, ErrorResponse errorResponse) {
        this(message, null, statusCode, errorResponse);
    }

    public BirdEyeException(Throwable cause, int statusCode, ErrorResponse errorResponse) {
        this(null, cause, statusCode, errorResponse);
    }

    public BirdEyeException(String message, Throwable cause, int statusCode, ErrorResponse errorResponse) {
        super(buildMessage(message, errorResponse), cause);
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    private static String buildMessage(String message, ErrorResponse errorResponse) {
        String result;
        if (message != null)
            result = message;
        else if (errorResponse != null)
            result = errorResponse.getErrorMessage();
        else
            result = null;
        return result;
    }
}
