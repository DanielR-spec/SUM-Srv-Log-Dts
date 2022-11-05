package com.conexion;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.data.services.ServiciosDonacionRemote;
import com.data.services.ServiciosUsuarioRemote;
import com.logic.services.ServiciosLogicaDonacionRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;

public class LczDonacion {

	public LczDonacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public ServiciosDonacionRemote getRemoteFachadaLogica() throws NamingException {
		return this.lookupFachadaLogicaBean("ejb:");
	}

	/**
	 * @param args
	 */
	private ServiciosDonacionRemote lookupFachadaLogicaBean(String namespace) throws NamingException {
		Context ctx = createInitialContextlog();
		String appName = "TierDatos";
		String moduleName = "ServiciosDatos";
		String distinctName = "";
		String beanName = "ServiciosDonacion";
		String viewClassName = "com.data.services.ServiciosDonacionRemote";
		return (ServiciosDonacionRemote) ctx.lookup(namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	}

	/**
	 * @param args
	 */
	private static Context createInitialContextlog() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:9090");
		//jndiProperties.put(Context.SECURITY_PRINCIPAL, "root");
		//jndiProperties.put(Context.SECURITY_CREDENTIALS, "root");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new InitialContext(jndiProperties);
	}
}
