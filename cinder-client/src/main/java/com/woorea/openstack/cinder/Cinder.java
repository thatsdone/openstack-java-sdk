package com.woorea.openstack.cinder;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
/*
import com.woorea.openstack.cinder.api.ExtensionsResource;
*/
import com.woorea.openstack.cinder.api.VolumesResource;

public class Cinder extends OpenStackClient {

	/*	
	private final ExtensionsResource EXTENSIONS;
	*/
	private final VolumesResource VOLUMES;

	public Cinder(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		/*
		EXTENSIONS = new ExtensionsResource(this);
		*/
		VOLUMES = new VolumesResource(this);
	}
	
	public Cinder(String endpoint) {
		this(endpoint, null);
	}
	/*
	public ExtensionsResource extensions() {
		return EXTENSIONS;
	}
	*/
	public VolumesResource volumes() {
		return VOLUMES;
	}

}
