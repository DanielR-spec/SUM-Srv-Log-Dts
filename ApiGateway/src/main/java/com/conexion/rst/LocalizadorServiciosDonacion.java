package com.conexion.rst;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.data.services.ServiciosUsuarioRemote;
import com.logic.services.ServiciosLogicaDonacionRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;

public class LocalizadorServiciosDonacion {

	public LocalizadorServiciosDonacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public ServiciosLogicaDonacionRemote getRemoteFachadaLogica() throws NamingException {
		return this.lookupFachadaLogicaBean("ejb:");
	}

	/**
	 * @param args
	 */
	private ServiciosLogicaDonacionRemote lookupFachadaLogicaBean(String namespace) throws NamingException {
		Context ctx = createInitialContextlog();
		String appName = "TierLogica";
		String moduleName = "ServiciosLogica";
		String distinctName = "";
		String beanName = "ServiciosLogicaDonacion";
		String viewClassName = "com.logic.services.ServiciosLogicaDonacionRemote";
		return (ServiciosLogicaDonacionRemote) ctx.lookup(namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	}

	/**
	 * @param args
	 */
	private static Context createInitialContextlog() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:9085");
		//jndiProperties.put(Context.SECURITY_PRINCIPAL, "root");
		//jndiProperties.put(Context.SECURITY_CREDENTIALS, "root");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new InitialContext(jndiProperties);
	}
}
