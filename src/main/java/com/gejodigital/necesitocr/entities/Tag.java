package com.gejodigital.necesitocr.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tag_id")
	private int tagId;

	private String name;

	//bi-directional many-to-one association to SupplierTag
	@OneToMany(mappedBy="tag")
	private List<SupplierTag> supplierTags;

	public Tag() {
	}

	public int getTagId() {
		return this.tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SupplierTag> getSupplierTags() {
		return this.supplierTags;
	}

	public void setSupplierTags(List<SupplierTag> supplierTags) {
		this.supplierTags = supplierTags;
	}

	public SupplierTag addSupplierTag(SupplierTag supplierTag) {
		getSupplierTags().add(supplierTag);
		supplierTag.setTag(this);

		return supplierTag;
	}

	public SupplierTag removeSupplierTag(SupplierTag supplierTag) {
		getSupplierTags().remove(supplierTag);
		supplierTag.setTag(null);

		return supplierTag;
	}

}