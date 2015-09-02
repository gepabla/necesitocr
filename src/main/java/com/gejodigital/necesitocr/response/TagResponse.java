package com.gejodigital.necesitocr.response;

import java.util.List;

import com.gejodigital.necesitocr.dto.TagDTO;

public class TagResponse extends BaseResponse {
	private List<TagDTO> tags;

	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}
}
