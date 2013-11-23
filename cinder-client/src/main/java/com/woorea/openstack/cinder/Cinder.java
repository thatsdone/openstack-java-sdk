package com.woorea.openstack.cinder;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
/*
import com.woorea.openstack.cinder.api.ExtensionsResource;
*/
import com.woorea.openstack.cinder.api.VolumesResource;
import com.woorea.openstack.cinder.api.SnapshotsResource;

public class Cinder extends OpenStackClient {

	/*	
	private final ExtensionsResource EXTENSIONS;
	*/
	private final VolumesResource VOLUMES;

	private final SnapshotsResource SNAPSHOTS;

	public Cinder(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		/*
		EXTENSIONS = new ExtensionsResource(this);
		*/
		VOLUMES = new VolumesResource(this);
	    SNAPSHOTS = new SnapshotsResource(this);
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

	public SnapshotsResource snapshots() {
		return SNAPSHOTS;
	}

}
