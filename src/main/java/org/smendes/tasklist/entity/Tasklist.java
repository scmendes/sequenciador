package org.smendes.tasklist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Tasklist {

	private @Id @GeneratedValue Long id;
	private String title;
	private String description;
	private boolean done;
	private String key;
	private String createDate;
	private String editDate;
	private String doneDate;

	private Integer errorTotalFiles = null;
	private Integer mergeTotalFiles = null;
	private Integer newTotalFiles = null;
	private Integer procTotalFiles = null;
	private Integer tempTotalFiles = null;

	public Integer getErrorTotalFiles() {
		return errorTotalFiles;
	}

	public void setErrorTotalFiles(Integer errorTotalFiles) {
		this.errorTotalFiles = errorTotalFiles;
	}

	public Integer getMergeTotalFiles() {
		return mergeTotalFiles;
	}

	public void setMergeTotalFiles(Integer mergeTotalFiles) {
		this.mergeTotalFiles = mergeTotalFiles;
	}

	public Integer getNewTotalFiles() {
		return newTotalFiles;
	}

	public void setNewTotalFiles(Integer newTotalFiles) {
		this.newTotalFiles = newTotalFiles;
	}

	public Integer getProcTotalFiles() {
		return procTotalFiles;
	}

	public void setProcTotalFiles(Integer procTotalFiles) {
		this.procTotalFiles = procTotalFiles;
	}

	public Integer getTempTotalFiles() {
		return tempTotalFiles;
	}

	public void setTempTotalFiles(Integer tempTotalFiles) {
		this.tempTotalFiles = tempTotalFiles;
	}

	public Tasklist() {
	}

	public Tasklist(String title, String description) {
		this.title = title;
		this.description = description;
		this.done = false;
	}

	@Override
	public String toString() {
		return "Tasklist [id=" + id + ", title=" + title + ", description=" + description + ", done=" + done + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getKey() {
		return id.toString();
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}
}