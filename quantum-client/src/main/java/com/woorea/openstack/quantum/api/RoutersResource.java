package com.woorea.openstack.quantum.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.quantum.model.Router;
import com.woorea.openstack.quantum.model.RouterForAddInterface;
import com.woorea.openstack.quantum.model.RouterForCreate;
import com.woorea.openstack.quantum.model.RouterForSetGateway;
import com.woorea.openstack.quantum.model.RouterInterface;
import com.woorea.openstack.quantum.model.GatewayInfo;
import com.woorea.openstack.quantum.model.Routers;

public class RoutersResource {

		private final OpenStackClient CLIENT;

		public RoutersResource(OpenStackClient client) {
			CLIENT = client;
		}

		public List list() {
			return new List();
		}

		public Create create(RouterForCreate router){
			return new Create(router);
		}

		public Delete delete(String netId){
			return new Delete(netId);
		}

		public Show show(String netId){
			return new Show(netId);
		}

		public class List extends OpenStackRequest<Routers> {

			public List() {
			    super(CLIENT, HttpMethod.GET, "v2.0/routers", null, Routers.class);
			}
		}

		public ListOnL3Agent listOnL3Agent(String agentId) {
			return new ListOnL3Agent(agentId);
		}

		public class ListOnL3Agent extends OpenStackRequest<Routers> {

			public ListOnL3Agent(String agentId) {
			    super(CLIENT, HttpMethod.GET,
					  new StringBuffer("v2.0/agents/").append(agentId)
					  .append("/l3-routers"), null, Routers.class);
			}
		}

		public class Query extends OpenStackRequest<Routers> {

			public Query(Router router) {
				//super(network);
//				target = target.path("v2.0").path("networks");
//				target = queryParam(target);
//				return target.request(MediaType.APPLICATION_JSON).get(Networks.class);
			}
		}
		public class Create extends OpenStackRequest<Router> {

			public Create(RouterForCreate router){
			    super(CLIENT, HttpMethod.POST, "v2.0/routers", Entity.json(router), Router.class);
			}
		}

		

		public class Show extends OpenStackRequest<Router> {

			public Show(String id) {
			    super(CLIENT, HttpMethod.GET, buildPath("v2.0/routers/", id), null, Router.class);
			}
		}

		public class Delete extends OpenStackRequest<Void> {

			public Delete(String id){
			    super(CLIENT, HttpMethod.DELETE, buildPath("v2.0/routers/", id), null, Void.class);
			}
		}
		public Attach addInterface(RouterForAddInterface interfaceToAdd){
			return new Attach(interfaceToAdd);
		}
		public class Attach extends OpenStackRequest<RouterInterface> {

			public Attach(RouterForAddInterface interfaceToAdd){
			    super(CLIENT, HttpMethod.PUT, buildPath("v2.0/routers/",interfaceToAdd.getRouterId(),"/add_router_interface"), Entity.json(interfaceToAdd),RouterInterface.class);
			}	
			
		}
		public Detach deleteInterface(RouterForAddInterface interfaceRouter) {
			return new Detach(interfaceRouter);
		}

		public class Detach extends OpenStackRequest<RouterInterface> {

			public Detach(RouterForAddInterface interfaceToAdd) {
				super(CLIENT,
					  HttpMethod.PUT,
					  buildPath("v2.0/routers/",
								interfaceToAdd.getRouterId(),
								"/remove_router_interface"),
					  Entity.json(interfaceToAdd), RouterInterface.class);
			}
		}

		public GatewaySet setGateway(String id, GatewayInfo gateway){
			return new GatewaySet(id, gateway);
		}

		public class GatewaySet extends OpenStackRequest<RouterForSetGateway> {

			public GatewaySet(String id, GatewayInfo gateway) {
				super(CLIENT,
					  HttpMethod.PUT,
					  new StringBuffer("v2.0/routers/").append(id),
					  Entity.json(gateway), RouterForSetGateway.class);
			}

		}
}
