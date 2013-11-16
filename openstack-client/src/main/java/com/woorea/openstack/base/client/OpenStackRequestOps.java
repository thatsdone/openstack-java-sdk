package com.woorea.openstack.base.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


/**
 * OpenStackRequestOps
 * <p>
 * This class is a simple extension of OpenStackRequest with:
 *   getResponse(), and
 *   getResponseBody() which is an equivalent of execute().
 *
 * Response headers can be retrieved by calling:
 *
 *   swiftClient.containers().show(containerName).getResponse().headers();
 *
 * in case of 'swift stat CONTAINER' for example.
 * 
 * Note that this class still depends on a modification to OpenStackRequest
 * adding 'client' getter at least.
 * <p>
 */
public class OpenStackRequestOps<R> extends OpenStackRequest<R> {
    
	/**
	 * <p>
	 * OpenStackRequestOps() constructor
	 * </p>
	 *
	 * @param client		Instance of OpenStackClient class
	 * @param method		HTTP Method in enum HttpMethod
	 * @param path			resource path (cannot be null, use "" instead)
	 * @param entity		parameter (can be null)
	 * @param returnType	returnType without List<> e.g., Container
	 */
	public OpenStackRequestOps(OpenStackClient client,
							   HttpMethod method,
							   CharSequence path,
							   Entity<?> entity,
							   Class<R> returnType) {

		super(client, method, path, entity, returnType);
	}

	public OpenStackResponse getResponse() {
		return this.client().request(this);
	}

	/** 
	 * getResponseBody
	 * <p>
	 * equivalent of 'execute()'
	 * </p>
	 */
	public R getResponseBody() {
		return this.client().execute(this);
	}

	/** 
	 * queryParam
	 * <p>
	 * wrapper for queryParam of super class
	 * </p>
	 */
	public OpenStackRequestOps<R> queryParam(String key, Object value) {
		super.queryParam(key, value);
		return this;
	}

}
