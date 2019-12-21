package com.webstack.instituterun.service;

import java.util.List;

import com.webstack.instituterun.dto.BatchDTO;

public interface BatchService {
	public BatchDTO save(BatchDTO batchDTO);
	public BatchDTO get(Long id);
	public List<BatchDTO> list();
}
