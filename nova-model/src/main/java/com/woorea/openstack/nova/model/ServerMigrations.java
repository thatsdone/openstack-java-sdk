package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;


public class ServerMigrations implements Iterable<ServerMigration>, Serializable {

	private List<ServerMigration> migrations;

	/**
	 * @return the id
	 */
	public List<ServerMigration> getMigrations() {
		return migrations;
	}


	/*
	 * override toString()
	 */
	@Override
	public String toString() {
		return "ServerMigrations [" + migrations + "]";
	}

	@Override
	public Iterator<ServerMigration> iterator() {
		return migrations.iterator();
	}

}
