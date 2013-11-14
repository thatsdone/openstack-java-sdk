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
	 * This class does 2 phase deserialization of an HTTP responase
	 * as a workaround. Here I mean, at first it deserializes
	 * the HTTP response into String using the executor() method
	 * of OpenStackRequest() class. And then, it deserializes
	 * the String above into a List of the class specified
	 * as Generics parameter to the class.
	 *
	 * Suppose you want to get a list of swift containers as List<Container>,
	 * create an OpenStackRequestList object by specifying like the following:
	 *
	 *    public class List extends OpenStackRequestList<Container> {...}
	 *
	 * then, execute() method of this class returns List<Container>.
	 * 
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
	 * 
	 * @return a list of the specified class R through Generics, List<R>.
	 */
  	public List<R> execute() throws Exception {
		String res = this.req.client().execute(this.req);
		try {
			List<R> obj = new ObjectMapper()
				.readValue(res, new TypeReference<List<R>>(){});
			return obj;

		} catch (Exception e) {
			//FIXME(thatsdone): Better to output as log messages.
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * queryParam() add a query parameter
	 * <p>
	 * Add a query parameter to the request path.
	 * </p>
	 *
	 * @return OpernStackRequestList<R>
	 */
	public OpenStackRequestList<R> queryParam(String key, Object value) {
		this.req.queryParam(key, value);
		return this;
    }

}

