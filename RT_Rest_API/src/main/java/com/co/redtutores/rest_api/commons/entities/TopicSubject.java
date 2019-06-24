package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the topic_subject database table.
 * 
 */
@Entity
@Table(name="topic_subject")
@NamedQuery(name="TopicSubject.findAll", query="SELECT t FROM TopicSubject t")
public class TopicSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="topic_sbjct_id", unique=true, nullable=false)
	private Integer topicSbjctId;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subject_id", nullable=false)
	private Subject subject;

	//bi-directional many-to-one association to Topic
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="topic_id", nullable=false)
	private Topic topic;

	public TopicSubject() {
	}

	public Integer getTopicSbjctId() {
		return this.topicSbjctId;
	}

	public void setTopicSbjctId(Integer topicSbjctId) {
		this.topicSbjctId = topicSbjctId;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}