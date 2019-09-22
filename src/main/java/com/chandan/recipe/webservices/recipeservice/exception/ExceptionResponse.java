/**
 * ---------------------------------------------------------------
 * The complete copyright of the code belongs to Chandan Kumar
 * ---------------------------------------------------------------
 */
package com.chandan.recipe.webservices.recipeservice.exception;

import java.util.Date;

/**
 * This class acts as general exception template to be used in our Recipe Service Application.
 * Same Exception template would be used across the application as have Common response for various Exceptions.
 *
 * @author Chandan Kumar
 * @since 0.0.1
 */
public class ExceptionResponse {

    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
