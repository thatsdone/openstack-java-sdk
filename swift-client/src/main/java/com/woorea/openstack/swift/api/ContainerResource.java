package com.woorea.openstack.swift.api;

import java.util.Map;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackRequestList;
import com.woorea.openstack.base.client.OpenStackRequestOps;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.swift.model.ObjectDownload;
import com.woorea.openstack.swift.model.ObjectForUpload;
import com.woorea.openstack.swift.model.Object;

public class ContainerResource {
	
	private final OpenStackClient CLIENT;
	
	private String container;
	
	public ContainerResource(OpenStackClient client, String container) {
		CLIENT = client;
		this.container = container;
	}
	
	public List list() {
		return new List(container, null);
	}
	
	public CreateDirectory createDirectory(String path) {
		return new CreateDirectory(container, path);
	}
	
	public Show show(String path) {
		return new Show(container, path);
	}
	
	public Upload upload(ObjectForUpload objectForUpload) {
		return new Upload(objectForUpload);
	}
	
	public Download download(String path) {
		return new Download(container, path);
	}
	
	public Delete delete(String path) {
		return new Delete(container, path);
	}
	
	public class List extends OpenStackRequestList<com.woorea.openstack.swift.model.Object> {

		public List(String containerName, Map<String, String> filters) {

			super(CLIENT,
				  HttpMethod.GET,
				  new StringBuffer("/").append(containerName),
				  null,
				  com.woorea.openstack.swift.model.Object.class);

			//FIXME(thatsdone): handle 'filter'
//			for(String filter : new String[]{"prefix","delimiter","path","marker"}) {
//				if(filters.get(filter) != null) {
//					target = target.queryParam(filter, filters.get(filter));
//				}
//			}
//			return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Object>>(){});
		}
		
	}

	//FIXME(thatsdone): Do we really need this?
	public class CreateDirectory extends OpenStackRequest<Void> {

		private String container;
		
		private String path;
		
		public CreateDirectory(String container, String path) {
			this.container = container;
			this.path = path;
//			endpoint.path(container).path(path).request().put(Entity.entity(new byte[1],"application/directory"));
		}
		
	}
	
	public class Show extends OpenStackRequestOps<Void> {

		// HEAD /v1/{account}/{container}/{object}
		public Show(String containerName, String objectName) {
			super(CLIENT, HttpMethod.HEAD,
				  new StringBuffer("/")
				  .append(containerName).append("/").append(objectName),
				  null, Void.class);
		}

	}
	
	public class Upload extends OpenStackRequestOps<Void> {

		// PUT /v1/{account}/{container}/{object}
		public Upload(ObjectForUpload objectForUpload) {
			super(CLIENT, HttpMethod.PUT,
				  new StringBuffer("/")
				  .append(objectForUpload.getContainer())
				  .append("/").append(objectForUpload.getName()),
				  Entity.stream(objectForUpload.getInputStream()),
				  Void.class);

			//FIXME(thatsdone): handle 'properties'
//			for(String key : objectForUpload.getProperties().keySet()) {
//				invocationBuilder.header("x-object-meta-" + key, objectForUpload.getProperties().get(key));
//			}
//			return invocationBuilder.put(Entity.entity(objectForUpload.getInputStream(), MediaType.APPLICATION_OCTET_STREAM), Response.class);
		}

	}
	
	public class Download extends OpenStackRequestOps<ObjectDownload> {

		// GET /v1/{account}/{container}/{object}
		public Download(String containerName, String objectName) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/")
				  .append(containerName).append("/").append(objectName),
				  null,
				  ObjectDownload.class);
		}

		@Override
		public ObjectDownload execute() {
			OpenStackResponse response = CLIENT.request(this);
			ObjectDownload objectDownload = new ObjectDownload();
			objectDownload.setInputStream(response.getInputStream());
			return objectDownload;
		}

	}
	
	public class Delete extends OpenStackRequestOps<Void> {

		public Delete(String containerName, String objectName) {
			super(CLIENT, HttpMethod.DELETE,
				  new StringBuffer("/").append(containerName)
				  .append("/").append(objectName),
				  null, Void.class);
		}

	}

}
