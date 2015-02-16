package fr.thispro.bundle2.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fr.thispro.bundle1.Bundle1Service;
import fr.thispro.bundle2.Bundle2Consumer;

/**
 * Extension of the default OSGi bundle activator
 */
public final class Bundle2Activator implements BundleActivator {
	/**
	 * Called whenever the OSGi framework starts our bundle
	 */
	private Bundle2Consumer consumer;
	public void start(BundleContext bc) throws Exception {
		System.out.println("STARTING fr.thispro.bundle2");
		ServiceReference reference = bc.getServiceReference(Bundle1Service.class.getName());

        consumer = new Bundle2Consumer((Bundle1Service) bc.getService(reference));
	}

	/**
	 * Called whenever the OSGi framework stops our bundle
	 */
	public void stop(BundleContext bc) throws Exception {
		System.out.println("STOPPING fr.thispro.bundle2");
		consumer.stop();
		// no need to unregister our service - the OSGi framework handles it for
		// us
	}
}
