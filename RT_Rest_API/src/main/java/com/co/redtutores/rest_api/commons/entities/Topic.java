package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topics database table.
 * 
 */
@Entity
@Table(name="topics")
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="topic_id", unique=true, nullable=false)
	private Integer topicId;

	@Column(name="topic_name", nullable=false)
	private Integer topicName;

	//bi-directional many-to-one association to TopicSubject
	@OneToMany(mappedBy="topic")
	private List<TopicSubject> topicSubjects;

	public Topic() {
	}

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getTopicName() {
		return this.topicName;
	}

	public void setTopicName(Integer topicName) {
		this.topicName = topicName;
	}

	public List<TopicSubject> getTopicSubjects() {
		return this.topicSubjects;
	}

	public void setTopicSubjects(List<TopicSubject> topicSubjects) {
		this.topicSubjects = topicSubjects;
	}

	public TopicSubject addTopicSubject(TopicSubject topicSubject) {
		getTopicSubjects().add(topicSubject);
		topicSubject.setTopic(this);

		return topicSubject;
	}

	public TopicSubject removeTopicSubject(TopicSubject topicSubject) {
		getTopicSubjects().remove(topicSubject);
		topicSubject.setTopic(null);

		return topicSubject;
	}

}