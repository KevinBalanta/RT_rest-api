package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the knowledge_areas database table.
 * 
 */
@Entity
@Table(name="knowledge_areas")
@NamedQuery(name="KnowledgeArea.findAll", query="SELECT k FROM KnowledgeArea k")
public class KnowledgeArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="area_id", unique=true, nullable=false)
	private Integer areaId;

	@Column(name="area_name", nullable=false, length=40)
	private String areaName;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="knowledgeArea")
	private List<Subject> subjects;

	public KnowledgeArea() {
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Subject addSubject(Subject subject) {
		getSubjects().add(subject);
		subject.setKnowledgeArea(this);

		return subject;
	}

	public Subject removeSubject(Subject subject) {
		getSubjects().remove(subject);
		subject.setKnowledgeArea(null);

		return subject;
	}

}