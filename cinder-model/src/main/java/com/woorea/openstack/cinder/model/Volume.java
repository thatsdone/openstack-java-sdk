package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume")
public class Volume implements Serializable {

	private String status;
	
	@JsonProperty("display_name")
	private String displayName;
	
	private List<Map<String, Object>> attachments;

	@JsonProperty("availability_zone")	
	private String availabilityZone;

	private boolean bootable;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("os-vol-tenant-attr:tenant_id")
	private String osVolTenantAttrTenantId;

	@JsonProperty("display_description")
	private String displayDescription;

	@JsonProperty("os-vol-host-attr:host")
	private String osVolHostAttrHost;

	@JsonProperty("volume_type")
	private String volumeType;
	
	@JsonProperty("snapshot_id")
	private String snapshotId;

	@JsonProperty("source_volid")
	private String sourceVolid;
	
	private Map<String, String> metadata;

	private String id;

	private Integer size;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the attachments
	 */
	public List<Map<String, Object>> getAttachments() {
		return attachments;
	}

	/**
	 * @return the availabilityZone
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	/**
	 * @return the bootable
	 */
	public boolean getBootable() {
		return bootable;
	}

	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the description
	 */
	public String getOsVolTenantAttrTenantId() {
		return osVolTenantAttrTenantId;
	}

	/**
	 * @return the description
	 */
	public String getDisplayDescription() {
		return displayDescription;
	}

	/**
	 * @return the description
	 */
	public String getOsVolHostAttrHost() {
		return osVolHostAttrHost;
	}

	/**
	 * @return the volumeType
	 */
	public String getVolumeType() {
		return volumeType;
	}

	/**
	 * @return the snapshotId
	 */
	public String getSnapshotId() {
		return snapshotId;
	}

	/**
	 * @return the snapshotId
	 */
	public String getSourceVolid() {
		return sourceVolid;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	
}
