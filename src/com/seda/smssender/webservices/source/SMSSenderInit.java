package com.seda.smssender.webservices.source;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.seda.compatibility.SystemVariable;
import com.seda.j2ee5.listener.spi.ApplicationListenerHandler;
import com.seda.smssender.webservices.shared.PrintStrings;
import com.seda.smssender.webservices.shared.PropertiesPath;

public class SMSSenderInit extends ApplicationListenerHandler
{
	public void contextDestroyed(ServletContextEvent event)
	{
	}

	//Strings to be changed once properties is up. Also watch out exceptions. printStackTrace is no good.
	public void contextInitialized(ServletContextEvent event) {
		
		super.contextInitialized(event);

		try
			{
				SystemVariable sv = new SystemVariable();
				// load the tree properties for this application 
				String propertiesRootPath = sv.getSystemVariableValue(PrintStrings.ROOT.format());
				configurePropertiesTree(PrintStrings.TREE_CONTEXT_NAME.format(), propertiesRootPath);
				// initialize log4j for this application context
//				configureLogger(PrintStrings.LOGGER_CONTEXT_NAME.format(), 
//					propertiesTree().getProperties(PropertiesPath.baseLogger.format()));
				// inserisci qui i messaggi di log utili per capire meglio l'esito dello start up
				
				// reset resource
				sv = null;
				SettingsFactory.isAvailable = true;
			}
			catch (Exception e)
			{
				SettingsFactory.isAvailable = false;
			}
			
		}	
	    
}
