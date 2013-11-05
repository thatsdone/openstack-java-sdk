package com.woorea.openstack.cinder.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Metadata;
import com.woorea.openstack.cinder.model.Volume;
import com.woorea.openstack.cinder.model.VolumeForCreate;
import com.woorea.openstack.cinder.model.VolumeForImageCreate;
import com.woorea.openstack.cinder.model.Volumes;

public class VolumesResource {

	private final OpenStackClient CLIENT;

	public VolumesResource(OpenStackClient client) {
		CLIENT = client;
	}

	public List list(boolean detail) {
		return new List(detail);
	}

	public Create create(VolumeForCreate volume) {
		return new Create(volume);
	}

	public UploadToImage uploadToImage(VolumeForImageCreate volumeForImage) {
		return new UploadToImage(volumeForImage);
	}

	public Show show(String id) {
		return new Show(id);
	}

	public ShowMetadata showMetadata(String id) {
		return new ShowMetadata(id);
	}

	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Volumes> {

		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, detail ? "/volumes/detail"
					: "/volumes", null, Volumes.class);
		}

	}

	public class Create extends OpenStackRequest<Volume> {

		public Create(VolumeForCreate volume) {
			super(CLIENT, HttpMethod.POST, "/volumes", Entity.json(volume),
					Volume.class);
		}

	}

	// Upload volume to image service as image

	public class UploadToImage extends OpenStackRequest<Void> {

		public UploadToImage(VolumeForImageCreate volumeForImageCreate) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/volumes/")
					.append(volumeForImageCreate.getVolumeId() + "/action"),
					Entity.json(volumeForImageCreate), Void.class);
		}

	}

	public class Show extends OpenStackRequest<Volume> {

		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/volumes/")
					.append(id).toString(), null, Volume.class);
		}

	}

	public class ShowMetadata extends OpenStackRequest<Metadata> {

		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/volumes/")
					.append(id).append("/metadata").toString(), null,
					Metadata.class);
		}

	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/volumes/")
					.append(id).toString(), null, Void.class);
		}

	}

}
