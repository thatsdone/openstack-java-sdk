package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;


public class ServerMigration implements Serializable {

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("dest_compute")
	private String destCompute;

	@JsonProperty("dest_node")
	private String destNode;

	private Integer id;

	@JsonProperty("instance_uuid")
	private String instanceUuid;

	@JsonProperty("new_instance_type_id")
	private Integer newInstanceTypeId;

	@JsonProperty("old_instance_type_id")
	private Integer oldInstanceTypeId;

	@JsonProperty("source_compute")
	private String sourceCompute;

	private String status;

	@JsonProperty("updated_at")
	private String updatedAt;

	/**
	 * @return createdAt (created_at)
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return destCompute (dest_compute)
	 */
	public String getDestCompute() {
		return destCompute;
	}

	/**
	 * @return destNode (dest_node)
	 */
	public String getDestNode() {
		return destNode;
	}

	/**
	 * @return id (id)
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return instanceUuid (instance_uuid)
	 */
	public String getInstanceUuid() {
		return instanceUuid;
	}

	/**
	 * @return newInstanceTypeId (new_instance_type_id)
	 */
	public Integer getNewInstanceTypeId() {
		return newInstanceTypeId;
	}

	/**
	 * @return oldInstanceTypeId (old_instance_type_id)
	 */
	public Integer getOldInstanceTypeId() {
		return oldInstanceTypeId;
	}

	/**
	 * @return sourceCompute (source_compute)
	 */
	public String getSourceCompute() {
		return sourceCompute;
	}

	/**
	 * @return status (status)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return updatedAt (updated_at)
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}

	/*
	 * override toString()
	 */
	@Override
	public String toString() {
		return "ServerMigration [createdAt=" + createdAt +
			", destCompute=" + destCompute +
			", destNode=" + destNode +
			", id=" + id +
			", instanceUuid=" + instanceUuid +
			", newInstanceTypeId=" + newInstanceTypeId +
			", oldInstanceTypeId=" + oldInstanceTypeId +
			", sourceCompute=" + sourceCompute +
			", status=" + status +
			", updatedAt=" + updatedAt +
			"]";
	}
}
