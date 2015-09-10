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
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@Table(name="supplier")
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_id")
	private Integer supplierId;

	private String address;

	private String description;

	private String name;

	private String phone;

	//bi-directional many-to-one association to SupplierTag
	@OneToMany(mappedBy="supplier")
	private List<SupplierTag> supplierTags;

	public Supplier() {
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<SupplierTag> getSupplierTags() {
		return this.supplierTags;
	}

	public void setSupplierTags(List<SupplierTag> supplierTags) {
		this.supplierTags = supplierTags;
	}

	public SupplierTag addSupplierTag(SupplierTag supplierTag) {
		getSupplierTags().add(supplierTag);
		supplierTag.setSupplier(this);

		return supplierTag;
	}

	public SupplierTag removeSupplierTag(SupplierTag supplierTag) {
		getSupplierTags().remove(supplierTag);
		supplierTag.setSupplier(null);

		return supplierTag;
	}

}