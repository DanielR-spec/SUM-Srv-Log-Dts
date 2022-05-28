/**
 * 
 */
package com.conexion.srv;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.data.services.ServiciosUsuarioRemote;

/**
 * @author danie
 *
 */
public class LocalizadorServicios {

	/**
	 * 
	 */
	public LocalizadorServicios() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 */
	public ServiciosUsuarioRemote getRemoteFachadaLogica() throws NamingException {
		return this.lookupFachadaLogicaBean("ejb:");
	}
	/**
	 * @param args
	 */
	private ServiciosUsuarioRemote lookupFachadaLogicaBean(String namespace) throws NamingException {
		Context ctx = createInitialContext();
		String appName = "TierDatos";
		String moduleName = "ServiciosDatos";
		String distinctName = "";
		String beanName = "ServiciosUsuario";
		String viewClassName = "com.data.services.ServiciosUsuarioRemote";
		return (ServiciosUsuarioRemote) ctx.lookup(namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	}
	/**
	 * @param args
	 */
	private static Context createInitialContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:9090");
		//jndiProperties.put(Context.SECURITY_PRINCIPAL, "root");
		//jndiProperties.put(Context.SECURITY_CREDENTIALS, "root");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new InitialContext(jndiProperties);
	}

}
