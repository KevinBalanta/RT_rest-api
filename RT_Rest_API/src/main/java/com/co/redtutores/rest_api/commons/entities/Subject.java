package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subjects database table.
 * 
 */
@Entity
@Table(name="subjects")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subject_id", unique=true, nullable=false)
	private Integer subjectId;

	@Column(name="subject_name", nullable=false, length=40)
	private String subjectName;

	//bi-directional many-to-one association to KnowledgeArea
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="area_id", nullable=false)
	private KnowledgeArea knowledgeArea;

	//bi-directional many-to-one association to TopicSubject
	@OneToMany(mappedBy="subject")
	private List<TopicSubject> topicSubjects;

	//bi-directional many-to-one association to Tutoring
	@OneToMany(mappedBy="subject")
	private List<Tutoring> tutorings;

	public Subject() {
	}

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public KnowledgeArea getKnowledgeArea() {
		return this.knowledgeArea;
	}

	public void setKnowledgeArea(KnowledgeArea knowledgeArea) {
		this.knowledgeArea = knowledgeArea;
	}

	public List<TopicSubject> getTopicSubjects() {
		return this.topicSubjects;
	}

	public void setTopicSubjects(List<TopicSubject> topicSubjects) {
		this.topicSubjects = topicSubjects;
	}

	public TopicSubject addTopicSubject(TopicSubject topicSubject) {
		getTopicSubjects().add(topicSubject);
		topicSubject.setSubject(this);

		return topicSubject;
	}

	public TopicSubject removeTopicSubject(TopicSubject topicSubject) {
		getTopicSubjects().remove(topicSubject);
		topicSubject.setSubject(null);

		return topicSubject;
	}

	public List<Tutoring> getTutorings() {
		return this.tutorings;
	}

	public void setTutorings(List<Tutoring> tutorings) {
		this.tutorings = tutorings;
	}

	public Tutoring addTutoring(Tutoring tutoring) {
		getTutorings().add(tutoring);
		tutoring.setSubject(this);

		return tutoring;
	}

	public Tutoring removeTutoring(Tutoring tutoring) {
		getTutorings().remove(tutoring);
		tutoring.setSubject(null);

		return tutoring;
	}

}