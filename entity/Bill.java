package com.wiley.project.ems.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Bill implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumerId")
	private Consumer consumer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "connectionId")
	private Connections connections;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "connectionTypeId")
	private ConnectionType connectionType;

	private Timestamp dateTime;
	private int oldReading;
	private int newReading;
	private int billedUnits;
	private double totalAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Connections getConnections() {
		return connections;
	}

	public void setConnections(Connections connections) {
		this.connections = connections;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public int getOldReading() {
		return oldReading;
	}

	public void setOldReading(int oldReading) {
		this.oldReading = oldReading;
	}

	public int getNewReading() {
		return newReading;
	}

	public void setNewReading(int newReading) {
		this.newReading = newReading;
	}

	public int getBilledUnits() {
		return billedUnits;
	}

	public void setBilledUnits(int billedUnits) {
		this.billedUnits = billedUnits;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
