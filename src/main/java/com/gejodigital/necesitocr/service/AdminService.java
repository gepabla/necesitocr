package com.gejodigital.necesitocr.service;

import java.util.List;

public interface AdminService {
	public void loadDatabase(List<List<String>> inputArr);
	public void loadWordArticles(List<List<String>> inputArr);
}
