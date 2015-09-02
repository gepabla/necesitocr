package com.gejodigital.necesitocr.response;

import java.util.List;

import com.gejodigital.necesitocr.dto.SupplierDTO;

public class SupplierResponse extends BaseResponse {
	private List<SupplierDTO> suppliers;

	public List<SupplierDTO> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<SupplierDTO> suppliers) {
		this.suppliers = suppliers;
	}

	
}
