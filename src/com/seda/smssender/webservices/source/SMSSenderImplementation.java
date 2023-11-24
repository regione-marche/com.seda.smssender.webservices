package com.seda.smssender.webservices.source;

import it.vola.sms.GatewayResponse;
import it.vola.sms.GatewayResponse.GatewayStatus;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.seda.commons.logger.CustomLoggerManager;
import com.seda.commons.logger.LoggerWrapper;
import com.seda.j2ee5.webservice.spi.JaxRpc10WebServiceHandler;
import com.seda.smssender.webservices.dati.SMSSenderRequestType;
import com.seda.smssender.webservices.dati.SMSSenderResponse;
import com.seda.smssender.webservices.shared.PrintStrings;
import com.seda.smssender.webservices.shared.PropertiesPath;
import com.seda.smssender.webservices.srv.SMSSenderFaultType;

public class SMSSenderImplementation extends JaxRpc10WebServiceHandler implements SMSSenderInterface
{
	protected LoggerWrapper logger = CustomLoggerManager.get(SMSSenderImplementation.class);
	private String treeContextName = PrintStrings.TREE_CONTEXT_NAME.format();

	public SMSSenderResponse getSMSSender(SMSSenderRequestType in)
			throws RemoteException, SMSSenderFaultType
	{
		//logger(loggerContextName);
		SMSSenderResponse smsResponse = SMSSenderResponse.fromValue(SMSSenderResponse._KO);
		
		
		if (!SettingsFactory.isAvailable)
		{
			error(Messages.SERVICE_UNAVAILABLE.format());
			return smsResponse;
		}
		
		try
		{
			
			
			/* Initializing properties tree */
			propertiesTree(treeContextName);
			
			SettingsFactory.on=propertiesTree().getProperty(PropertiesPath.smssenderON.format());
				

			SettingsFactory.volaSMSEngine.setUsername(propertiesTree().getProperty(PropertiesPath.smssenderUSERNAME.format()));
	    	SettingsFactory.volaSMSEngine.setPassword(propertiesTree().getProperty(PropertiesPath.smssenderPASSWORD.format()));
	    	SettingsFactory.volaSMSEngine.setTestMode(Boolean.parseBoolean(propertiesTree().getProperty(PropertiesPath.smssenderTESTMODE.format())));
	    	SettingsFactory.volaSMSEngine.setSslConnection(Boolean.parseBoolean(propertiesTree().getProperty(PropertiesPath.smssenderUSESSL.format())));
	    	
	    	SettingsFactory.volaSMSEngine.setLongMessage(true);
	    	
	    	SettingsFactory.senderphone = propertiesTree().getProperty(PropertiesPath.smssenderSENDERPHONE.format());
	    	
	    	SettingsFactory.useProxy = propertiesTree().getProperty(PropertiesPath.smssenderUSEPROXY.format());
	    	SettingsFactory.proxyHost = propertiesTree().getProperty(PropertiesPath.smssenderPROXYHOST.format());
	    	SettingsFactory.proxyPort = propertiesTree().getProperty(PropertiesPath.smssenderPROXYPORT.format());
	    	SettingsFactory.proxyUser = propertiesTree().getProperty(PropertiesPath.smssenderPROXYUSER.format());
	    	SettingsFactory.proxyPassword = propertiesTree().getProperty(PropertiesPath.smssenderPROXYPASSWORD.format());
	    	
	    	
	    	
	    	
	    	if (SettingsFactory.on.equalsIgnoreCase("Y"))
	    	{
	    		if(SettingsFactory.useProxy.equalsIgnoreCase("Y")) {
	    			System.getProperties().put("http.proxyHost", SettingsFactory.proxyHost);
	    			System.getProperties().put("http.nonProxyHosts", "localhost");
	    			System.getProperties().put("http.proxyPort", SettingsFactory.proxyPort);
	    			System.getProperties().put("http.proxyUser", SettingsFactory.proxyUser);
	    			System.getProperties().put("http.proxyPassword", SettingsFactory.proxyPassword);

	    		}
	    		
		    	info(Messages.START_SENDING.format());
				String smsReceiverPhone = in.getSMSEDataTOList();
				String smsMessage = in.getSMSDataText();
				DateFormat sdfData = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat sdfTime = new SimpleDateFormat("HH:mm");
				String dateStr = sdfData.format(new Date());
				String timeStr = sdfTime.format(new Date());
				
				info("Sender: " + SettingsFactory.senderphone);
				info("Destinatario: " + smsReceiverPhone);
				info("Testo: " + smsMessage);
				info("Data: " + dateStr);
				info("Ora: " + timeStr);
				
				GatewayResponse send_res =  SettingsFactory.volaSMSEngine.sendSms(SettingsFactory.senderphone, smsReceiverPhone, smsMessage, dateStr, timeStr);
				
				if (send_res.getStatus() == GatewayStatus.GW_CMD_OK) {
					smsResponse = SMSSenderResponse.fromValue(SMSSenderResponse._OK);

					info("INVIO AVVENUTO CON SUCCESSO - ORDERID: " + send_res.getOrderId());
					info(send_res.toString());
		        } else {
		        	error("INVIO SMS NON RIUSCITO: " + send_res.toString());
		        }			
				
				info(Messages.END_SENDING.format());
	    	}
		}
		catch (Exception e)
		{
			error(Messages.ERROR.format(Messages.ERROR_MSG.format()));
			smsResponse = SMSSenderResponse.fromValue(SMSSenderResponse._KO);
		}
		
		return smsResponse;
	}

}
