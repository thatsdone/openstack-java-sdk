package com.woorea.openstack.base.client;

import java.io.PrintStream;
import java.util.logging.Logger;

public interface OpenStackClientConnector {

	public <T> OpenStackResponse request(OpenStackRequest<T> request);
	public void setLogger(Logger output);
	public void setLogger(PrintStream output);

}
