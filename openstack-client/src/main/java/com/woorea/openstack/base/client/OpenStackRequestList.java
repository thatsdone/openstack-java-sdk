package com.woorea.openstack.base.client;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.Entity;

import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.List;

public class OpenStackRequestList<R> {

	private final OpenStackRequest<String> req;

	/**
	 * OpenStackRequestList() constructor
	 * <p>
	 * Note that OpenStackRequest class is not the super class of this class.
	 * </p>
	 *
	 * @param client		Instance of OpenStackClient class
	 * @param method		HTTP Method in enum HttpMethod
	 * @param path			resource path (cannot be null, use "" instead)
	 * @param entity		parameter (can be null)
	 * @param returnType	returnType without List<> e.g., Container
	 */
	public OpenStackRequestList (OpenStackClient client,
								 HttpMethod method,
								 CharSequence path,
								 Entity<?> entity,
								 Class<R> returnType) {

		this.req = new OpenStackRequest(client);
		this.req.method(method);
		this.req.path(path.toString());
		this.req.entity(entity, "application/json");
		this.req.returnType(String.class);
	}

	/**
	 * execute() HTTP request executor
	 * <p>
	 * Issues an HTTP request and deserialize the response as specified
	 * type R to this class. Calls execute() of OpenStackRequest class.
	 * </p>
	 */
  	public List<R> execute() throws Exception {
		String res = this.req.client().execute(this.req);
		try {
			List<R> swiftObj =
				new ObjectMapper().readValue(res,
								 new TypeReference<List<R>>(){});
			return swiftObj;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * queryParam() add a query parameter
	 * <p>
	 * Add a query parameter to the request path.
	 * </p>
	 */
	public OpenStackRequestList<R> queryParam(String key, Object value) {
		this.req.queryParam(key, value);
		return this;
    }

}

