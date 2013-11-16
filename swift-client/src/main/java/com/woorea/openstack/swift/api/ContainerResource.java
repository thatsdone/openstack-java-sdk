package com.woorea.openstack.swift.api;

import java.util.Map;


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

		private String containerName;
		
		private Map<String, String> filters;
		
		public List(String containerName, Map<String, String> filters) {

			super(CLIENT,
				  HttpMethod.GET,
				  new StringBuffer("/").append(containerName),
				  null,
				  com.woorea.openstack.swift.model.Object.class);

			//this.containerName = containerName;
			//			this.filters = filters;

			//returnType(new TypeToken<List<Object>>(){});
//			target = target.path(containerName);
//			for(String filter : new String[]{"prefix","delimiter","path","marker"}) {
//				if(filters.get(filter) != null) {
//					target = target.queryParam(filter, filters.get(filter));
//				}
//			}
//			return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Object>>(){});
		}
		
	}

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

		private String containerName;
		
		private String objectName;
		

		// HEAD /v1/{account}/{container}/{object}
		public Show(String containerName, String objectName) {
			super(CLIENT, HttpMethod.HEAD,
				  new StringBuffer("/")
				  .append(containerName).append("/").append(objectName),
				  null, Void.class);
		}

	}
	
	public class Upload extends OpenStackRequest<OpenStackResponse> {

		private ObjectForUpload objectForUpload;
		
		public Upload(ObjectForUpload objectForUpload) {
			this.objectForUpload = objectForUpload;
//			Invocation.Builder invocationBuilder = target.path(objectForUpload.getContainer()).path(objectForUpload.getName()).request(MediaType.APPLICATION_JSON);
//			for(String key : objectForUpload.getProperties().keySet()) {
//				invocationBuilder.header("x-object-meta-" + key, objectForUpload.getProperties().get(key));
//			}
//			return invocationBuilder.put(Entity.entity(objectForUpload.getInputStream(), MediaType.APPLICATION_OCTET_STREAM), Response.class);
		}

	}
	
	public class Download extends OpenStackRequest<ObjectDownload> {

		private String containerName;
		
		private String objectName;
		
		public Download(String containerName, String objectName) {
			this.containerName = containerName;
			this.objectName = objectName;
//			Response response = target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).get();
//			ObjectDownload objectDownload = new ObjectDownload();
//			objectDownload.setInputStream((InputStream) response.getEntity());
//			return objectDownload;
		}

	}

	
	public class Delete extends OpenStackRequest<Void> {

		private String containerName;
		
		private String objectName;
		
		public Delete(String containerName, String objectName) {
			this.containerName = containerName;
			this.objectName = objectName;
			//return target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).delete();
		}

	}

}
