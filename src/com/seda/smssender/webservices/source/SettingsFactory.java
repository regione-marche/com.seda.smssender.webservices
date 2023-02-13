package com.seda.smssender.webservices.source;

import it.vola.sms.GatewayConnector;

public class SettingsFactory
{
	public static boolean isAvailable = false; // if it is false, the WS cannot be used

	public static GatewayConnector volaSMSEngine = new GatewayConnector();
	
	public static String username = "";
	public static String password = "";
	public static String senderphone = "";
	public static boolean testmode = true;
	public static String on = "N";

	public static String useProxy = "N";
	public static String proxyHost = "";
	public static String proxyPort = "";
	public static String proxyUser = "";
	public static String proxyPassword = "";
	
}
