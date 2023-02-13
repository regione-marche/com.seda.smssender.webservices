package com.seda.smssender.webservices.shared;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public enum PropertiesPath {
	// pPath to get the log4j properties
	baseLogger,
	smssenderUSERNAME,
	smssenderPASSWORD,
	smssenderSENDERPHONE,
	smssenderTESTMODE,
	smssenderUSESSL,
//	smssenderPROXYHOST,
//	smssenderPROXYPORT,
//	smssenderPROXYUSER,
//	smssenderPROXYPWD,
	smssenderON, smssenderUSEPROXY, smssenderPROXYHOST, smssenderPROXYPORT, smssenderPROXYUSER, smssenderPROXYPASSWORD
	;
	
    private static ResourceBundle rb;

    public String format( Object... args ) {
        synchronized(PropertiesPath.class) {
            if(rb==null)
                rb = ResourceBundle.getBundle(PropertiesPath.class.getName());
            return MessageFormat.format(rb.getString(name()),args);
        }
    }
}

