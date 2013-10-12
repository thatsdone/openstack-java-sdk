package com.woorea.openstack.nova.model;

import java.io.Serializable;
//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("hypervisor")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Hypervisor implements Serializable {

	@JsonRootName("service")
	public static final class Service{

		private Integer id;

		private String host;

		public Integer getId() {
			return id;
		}

		public String getHost() {
			return host;
		}
	}

	private Integer id;

	private Service  service;

	private Integer vcpus;

	@JsonProperty("memory_mb")
	private Integer memoryMb;

	@JsonProperty("local_gb")
	private Integer localGb;

	@JsonProperty("vcpus_used")
	private Integer vcpusUsed;

	@JsonProperty("memory_mb_used")
	private Integer memoryMbUsed;
	
	@JsonProperty("local_gb_used")
	private Integer localGbUsed;

	@JsonProperty("hypervisor_type")
	private String hypervisorType;

	@JsonProperty("hypervisor_version")
	private String hypervisorVersion;

	@JsonProperty("hypervisor_hostname")
	private String hypervisorHostname;

	@JsonProperty("free_ram_mb")
	private Integer freeRamMb;

	@JsonProperty("free_disk_gb")
	private Integer freeDiskGb;

	@JsonProperty("current_workload")
	private Integer currentWorkload;

	@JsonProperty("running_vms")
	private Integer runningVms;

	//FIXME(thatsdone): Better to add a sub class like the case of 'service'
	@JsonProperty("cpu_info")
	private String cpuInfo;

	@JsonProperty("disk_available_least")
	private Integer diskAvailableLeast;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/*
	 * @return the vcpus
	 */
	public Integer getVcpus() {
		return vcpus;
	}

	/*
	 * @return the memory_mb
	 */
    public Integer getMemoryMb() {
		return memoryMb;
	}

	/*
	 * @return the local_gb
	 */
	public Integer getLocalGb() {
		return localGb;
	}

	/*
	 * @return the vcpus_used
	 */
	public Integer getVcpusUsed() {
		return vcpusUsed;
	}

	/*
	 * @return the local_gb_used
	 */
	public Integer getLocalGbUsed() {
		return  localGbUsed;
	}

	/*
	 * @return the memory_mb_used
	 */
	 public Integer getMemoryMbUsed() {
		 return  memoryMbUsed;
	 }

	/*
	 * @return the hypervisor_type
	 */
	public String getHypervisorType() {
		return hypervisorType;
	}

	/*
	 * @return the hypervisor_version
	 */
	public String getHypervisorVersion() {
		return hypervisorVersion;
	}

	/**
	 * @return the hypervisor_hostname
	 */
	public String getHypervisorHostname() {
		return hypervisorHostname;
	}

	/*
	 * @return the running_vms
	 */
	public Integer getRunningVms() {
		return runningVms;
	}

	/*
	 * @return the free_ram_mb
	 */
	public Integer getFreeRamMb() {
		return freeRamMb;
	}

	/*
	 * @return the free_disk_gb
	 */
	public Integer getFreeDiskGb() {
		return freeDiskGb;
	}

	/**
	 * @return the current_workload
	 */
	public Integer getCurrentWorkload() {
		return currentWorkload;
	}

	/**
	 * @return the cpu_info
	 */
	//FIXME(thatsdone): change the type
	public String getCpuInfo() {
		return cpuInfo;
	}

	/*
	 * @return the disk_available_least
	 */
	public Integer getDiskAvailableLeast() {
		return diskAvailableLeast;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hypervisor [id=" + id +
			", service=" + service +
			", vcpus=" + vcpus +
			", memory_mb=" + memoryMb +
			", local_gb" + localGb +
			", vcpu_used=" + vcpusUsed +
			", local_gb_used=" + localGbUsed +
			", memory_mb_used=" + memoryMbUsed +
			", hypervisor_type=" + hypervisorType +
			", hypervisor_version=" + hypervisorVersion +
			", hypervisor_hostname=" + hypervisorHostname +
			", running_vms=" + runningVms +
			", free_ram_mb=" + freeRamMb +
			", free_disk_gb=" + freeDiskGb +
			", current_workload=" + currentWorkload +
			", cpu_info=" + cpuInfo +
			", disk_available_least=" + diskAvailableLeast + "]";
	}

}


