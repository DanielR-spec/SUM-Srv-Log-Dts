/**
 * 
 */
package com.conexion.srv;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.data.services.ServiciosUsuarioRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;

/**
 * @author danie
 *
 */
public class LocalizadorServiciosNg {

	/**
	 * 
	 */
	public LocalizadorServiciosNg() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 */
	public ServiciosLogicaUsuarioRemote getRemoteFachadaLogica() throws NamingException {
		return this.lookupFachadaLogicaBean("ejb:");
	}
	/**
	 * @param args
	 */
	private ServiciosLogicaUsuarioRemote lookupFachadaLogicaBean(String namespace) throws NamingException {
		Context ctx = createInitialContext();
		String appName = "TierLogica";
		String moduleName = "ServiciosLogica";
		String distinctName = "";
		String beanName = "ServiciosLogicaUsuario";
		String viewClassName = "com.logic.services.ServiciosLogicaUsuarioRemote";
		return (ServiciosLogicaUsuarioRemote) ctx.lookup(namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	}
	/**
	 * @param args
	 */
	private static Context createInitialContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:9085");
		//jndiProperties.put(Context.SECURITY_PRINCIPAL, "root");
		//jndiProperties.put(Context.SECURITY_CREDENTIALS, "root");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new InitialContext(jndiProperties);
	}

}
