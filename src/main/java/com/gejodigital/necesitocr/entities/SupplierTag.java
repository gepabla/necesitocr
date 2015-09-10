package com.gejodigital.necesitocr.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the supplier_tags database table.
 * 
 */
@Entity
@Table(name="supplier_tags")
@NamedQuery(name="SupplierTag.findAll", query="SELECT s FROM SupplierTag s")
public class SupplierTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_tags_id")
	private Integer supplierTagsId;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="tag_id")
	private Tag tag;

	public SupplierTag() {
	}

	public Integer getSupplierTagsId() {
		return this.supplierTagsId;
	}

	public void setSupplierTagsId(Integer supplierTagsId) {
		this.supplierTagsId = supplierTagsId;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}