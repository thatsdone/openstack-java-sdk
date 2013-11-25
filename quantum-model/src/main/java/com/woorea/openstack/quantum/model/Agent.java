package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent implements Serializable{

    //GET /v2.0/agents(.json)

	public class DhcpAgentConfigurations {
		private Integer ports;
		private Integer dhcp_lease_time;
		private Integer networks;
		private String dhcp_driver;
		private boolean use_namespaces;
		private Integer subnets;
	}

	public class L3AgentConfigurations {
		private Integer ex_gw_ports;
		private String router_id;
		private String gateway_external_network_id;
		private boolean handle_internal_only_routers;
		private boolean use_namespaces;
		private Integer routers;
		private Integer interfaces;
		private Integer floating_ips;
		private String interface_driver;
	}

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("stated_at")
	private String startedAt;

	@JsonProperty("agent_type")
	private String agentType;

	private String binary;

	private String description;

	@JsonProperty("admin_state_up")
	private boolean adminStateUp;

	@JsonProperty("heartbeat_timestamp")
	private String heartbeatTimestamp;

	private boolean alive;

	private String id;

	private String topic;

	private String host;

	//FIXME(thatsdone): network configuration is not mappable to Java Object.
	//private AgentConfigurations configurations;
	private Map<String, String> configurations;


	/**
	 * @return the
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the startedAt
	 */
	public String getStartedAt() {
		return startedAt;
	}

	/**
	 * @return the agentType
	 */
	public String getAgentType() {
		return agentType;
	}

	/**
	 * @return the binary
	 */
	public String getBinary() {
		return binary;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the adminStateUp
	 */
	public boolean getAdminStateUp() {
		return adminStateUp;
	}

	/**
	 * @return the heartbeatTimestamp
	 */
	public String getHeartbeatTimestamp() {
		return heartbeatTimestamp;
	}

	/**
	 * @return the alive
	 */
	public boolean getAlive() {
		return  alive;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the host
	 */
	public Map<String, String> getConfigurations() {
		return configurations;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agent [id=" + id + 
			", createdAt=" + createdAt +
			", startedAt=" + startedAt +
			", agentType=" + agentType +
			", binary=" + binary +
			", description=" + description +
			", adminStateUp=" + adminStateUp +
			", heartbeatTimestamp=" + heartbeatTimestamp +
			", alive=" + alive +
			", id=" + id +
			", topic=" + topic +
			", host=" + host +
			", configrations=" + configurations + "]";
	}
}
