package com.woorea.openstack.swift.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackRequestOps;

public class AccountResource {
	
	private final OpenStackClient CLIENT;
	
	public AccountResource(OpenStackClient client) {
		CLIENT = client;
	}

	public ShowAccount showAccount() {
		return new ShowAccount();

	}

	public class ShowAccount extends OpenStackRequestOps<Void> {

		public ShowAccount() {
			super(CLIENT, HttpMethod.HEAD, "", null, Void.class);
		}

	}

}
