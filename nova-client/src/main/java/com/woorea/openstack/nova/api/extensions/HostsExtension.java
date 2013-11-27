package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Host;
import com.woorea.openstack.nova.model.Hosts;
import com.woorea.openstack.nova.model.HostStatus;
import com.woorea.openstack.nova.model.PowerAction;

public class HostsExtension {
	
	private final OpenStackClient CLIENT;
	
	public HostsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Show show(String id) {
		return new Show(id);
	}

	/**
	 * update()
	 * <p>
	 * Equivalent to 'nova host-update'.
	 * </p>
	 * @param host hostname
	 * @param status
	 *  Either enable or disable a host.
	 *  true means "enable", false means "disable".
	 * @param maintenance
	 *  Either put or resume host to/from maintenance.
	 *  true means "enable", false means "disable".
	 */
	public Update update(String host, boolean status, boolean maintenance) {
		return new Update(host, status, maintenance);
	}

	public enum HostAction {
		STARTUP, REBOOT, SHUTDOWN
	}

	public Action action(String host, HostAction action) {
		return new Action(host, action);
	}

	public class List extends OpenStackRequest<Hosts> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-hosts", null, Hosts.class);
		}

	}

	public class Show extends OpenStackRequest<Host> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuffer("/os-hosts/").append(id).toString(), null, Host.class);
		}
		
	}

	public class Update extends OpenStackRequest<HostStatus> {
		
		public Update(String host, boolean status, boolean maintenance) {

			super(CLIENT, HttpMethod.PUT,
				  new StringBuffer("/os-hosts/").append(host).toString(),
				  Entity.json("{\"status\": \"" +
							  (status == true ? "enable" : "disable") +
							  "\", \"maintenance_mode\": \"" +
							  (maintenance == true ? "enable" : "disable") +
							  "\"}"),
				  HostStatus.class);
		}
		
	}
	
	public class Action extends OpenStackRequest<PowerAction> {
		
		public Action(String host, HostAction action) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/os-hosts/").append(host).append("/")
				  .append((action == HostAction.STARTUP ? "startup" :
						  (action == HostAction.REBOOT ? "reboot" :
						   "shutdown")))
				  .toString(),
				  null,
				  PowerAction.class);
		}
	}
}
