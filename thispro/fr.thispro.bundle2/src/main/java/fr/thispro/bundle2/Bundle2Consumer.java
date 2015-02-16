package fr.thispro.bundle2;

import fr.thispro.bundle1.Bundle1Service;

/**
 * Public API representing an example OSGi service
 */
public class Bundle2Consumer {

	private final Bundle1Service service;

	public Bundle2Consumer(Bundle1Service service) {
		this.service = service;
	}

	public void start() {
		System.out.println(service.scramble("Text"));

		System.out.println("im started");
	}

	public void stop() {
		System.out.println("im stopped");

	}

}
