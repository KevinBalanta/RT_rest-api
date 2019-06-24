package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@Table(name="state")
@NamedQuery(name="Phase.findAll", query="SELECT p FROM Phase p")
public class Phase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_id", unique=true, nullable=false)
	private Integer stateId;

	@Column(name="state_name", length=40)
	private String stateName;

	//bi-directional many-to-one association to StateType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_type_id", nullable=false)
	private StateType stateType;

	public Phase() {
	}

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public StateType getStateType() {
		return this.stateType;
	}

	public void setStateType(StateType stateType) {
		this.stateType = stateType;
	}

}