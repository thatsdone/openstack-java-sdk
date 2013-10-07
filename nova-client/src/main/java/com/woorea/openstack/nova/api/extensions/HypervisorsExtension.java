package com.woorea.openstack.nova.api.extensions;
import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Hypervisor;
import com.woorea.openstack.nova.model.Hypervisors;
import com.woorea.openstack.nova.model.HypervisorStatistics;

public class HypervisorsExtension {

	private final OpenStackClient CLIENT;
	
	public HypervisorsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}

	public class List extends OpenStackRequest<Hypervisors> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-hypervisors",
				  null, Hypervisors.class);
		}

	}

	public Show show(Integer id) {
		return new Show(id);
	}

	public class Show extends OpenStackRequest<Hypervisor> {

		public Show(Integer id) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/os-hypervisors/").append(id.toString()),
				  null, Hypervisor.class);
		}
	}

	public Statistics showStats() {
		return new Statistics();
	}

	public class Statistics extends OpenStackRequest<HypervisorStatistics> {

		public Statistics() {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/os-hypervisors/statistics"),
				  null, HypervisorStatistics.class);
		}
	}

}
