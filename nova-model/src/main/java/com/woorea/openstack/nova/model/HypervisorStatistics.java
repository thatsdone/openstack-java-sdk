package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("hypervisor_statistics")
public class HypervisorStatistics implements Serializable {

	private Integer count;

	private Integer vcpus;

	@JsonProperty("vcpus_used")
	private Integer vcpusUsed;

	@JsonProperty("memory_mb")
	private Integer memoryMb;

	@JsonProperty("memory_mb_used")
	private Integer memoryMbUsed;
	
	@JsonProperty("local_gb")
	private Integer localGb;

	@JsonProperty("local_gb_used")
	private Integer localGbUsed;

	@JsonProperty("disk_available_least")
	private Integer diskAvailableLeast;

	@JsonProperty("free_ram_mb")
	private Integer freeRamMb;

	@JsonProperty("free_disk_gb")
	private Integer freeDiskGb;

	@JsonProperty("current_workload")
	private Integer currentWorkload;

	@JsonProperty("running_vms")
	private Integer runningVms;

	/**
	 * @return the total hypervisor count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @return the
	 */
	public Integer getVcpus() {
		return vcpus;
	}

	/**
	 * @return the vcpusUsed
	 */
	public Integer getVcpusUsed() {
		return vcpusUsed;
	}

	/**
	 * @return the
	 */
	public Integer getMemoryMb() {
		return memoryMb;
	}

	/**
	 * @return the
	 */
	public Integer getMemoryMbUsed() {
		return memoryMbUsed;
	}

	/**
	 * @return the
	 */
	public Integer getLocalGb() {
		return localGb;
	}

	/**
	 * @return the
	 */
	public Integer getLocalGbUsed() {
		return localGbUsed;
	}

	/**
	 * @return the
	 */
	public Integer getDiskAvailableLeast() {
		return diskAvailableLeast;
	}

	/**
	 * @return the
	 */
	public Integer getFreeRamMb() {
		return freeRamMb;
	}

	/**
	 * @return the
	 */
	public Integer getFreeDiskGb() {
		return freeDiskGb;
	}

	/**
	 * @return the
	 */
	public Integer getCurrentWorkload() {
		return currentWorkload;
	}

	/**
	 * @return the
	 */
	public Integer getRunningVms() {
		return runningVms;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toInteger()
	 */
	@Override
	public String toString() {
		return "HypervisorStatistics [count=" + count +
		    ", vcpus=" + vcpus +
		    ", vcpus_used=" + vcpusUsed +
		    ", memory_mb=" + memoryMb +
		    ", memory_mb_used=" + memoryMbUsed +
		    ", local_gb=" + localGb +
		    ", local_gb_used=" + localGbUsed +
		    ", disk_available_least=" + diskAvailableLeast +
		    ", free_ram_mb=" + freeRamMb +
		    ", free_disk_gb=" + freeDiskGb +
		    ", current_workload=" + currentWorkload +
		    ", running_vms=" + runningVms +
		    "]";
	}
	
}
