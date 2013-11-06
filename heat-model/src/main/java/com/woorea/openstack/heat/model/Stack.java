package com.woorea.openstack.heat.model;

import java.io.Serializable;
import java.util.List;
import java.util.Iterator;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

public class Stack implements Serializable {

	private String id;
	
	@JsonProperty("stack_status")
	private String stackStatus;
	
	@JsonProperty("updated_time")
	private String updatedTime;

	@JsonProperty("creation_time")
	private String creationTime;

	@JsonProperty("stack_name")
	private String stackName;

	@JsonProperty("stack_status_reason")
	private String stackStatusReason;

	public class Link {
		private String rel;
		private String href;

		/**
		 * return the rel
		 */
		public String getRel() {
			return rel;
		}
		/**
		 * return the href
		 */
		public String getHref() {
			return href;
		}
	}

	private List<Link> links;

	private String description;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the stackStatus
	 */
	public String getStackStatus() {
		return stackStatus;
	}

	/**
	 * @return the updatedTime
	 */
	public String getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * @return the creationTime
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @return the stackName
	 */
	public String getStackName() {
		return stackName;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	@Override
	public String toString() {
		return "Stack [id=" + id +
			", stackStatus=" + stackStatus +
			", updatedTime=" + updatedTime +
			", creationTime=" + creationTime +
			", stackName=" + stackName +
			", stack_status_reason" + stackStatusReason +
			", links=" + links +
			", description=" + description + "]";
	}
	/*
	@Override
	public Iterator<Link> iterator() {
		return links.iterator();
	}
	*/
}