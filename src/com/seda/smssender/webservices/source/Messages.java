package com.seda.smssender.webservices.source;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public enum Messages {
	START_SENDING,
	TO,
	END_SENDING,
	SERVICE_TESTMODE,
	SERVICE_UNAVAILABLE,
	ERROR,
	ERROR_MSG,
	SMS_SUCCESS_CODE
	;
	private static ResourceBundle rb;

    public String format( Object... args ) {
        synchronized(Messages.class) {
            if(rb==null)
                rb = ResourceBundle.getBundle(Messages.class.getName());
            return MessageFormat.format(rb.getString(name()),args);
        }
    }
}
