package com.gejodigital.necesitocr.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@Table(name="tag")
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tag_id")
	private Integer tagId;

	private String name;
	
	@Column(name="is_geo")
	private Boolean isGeo;
	
	//bi-directional many-to-one association to SupplierTag
	@OneToMany(mappedBy="tag")
	private List<SupplierTag> supplierTags;

	public Tag() {
	}

	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
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

	public Boolean getIsGeo() {
		return isGeo;
	}

	public void setIsGeo(Boolean isGeo) {
		this.isGeo = isGeo;
	}

}