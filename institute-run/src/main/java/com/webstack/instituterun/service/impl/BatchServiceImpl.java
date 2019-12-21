package com.webstack.instituterun.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstack.instituterun.dto.BatchDTO;
import com.webstack.instituterun.entity.Batch;
import com.webstack.instituterun.mapper.BatchMapper;
import com.webstack.instituterun.repository.BatchRepository;
import com.webstack.instituterun.service.BatchService;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchMapper batchMapper;

	@Autowired
	private BatchRepository batchRepository;

	public BatchDTO save(BatchDTO batchDTO) {
		Batch batch = batchMapper.toEntity(batchDTO);
		BatchDTO result = batchMapper.toDto(batchRepository.save(batch));
		return result;
	}

	public BatchDTO update(BatchDTO batchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public List<BatchDTO> list() {
		// TODO Auto-generated method stub
		return batchRepository.findAll().stream().map(batchMapper::toDto).collect(Collectors.toList());
	}

	public BatchDTO get(Long id) {
		// TODO Auto-generated method stub
		return batchMapper.toDto(batchRepository.getOne(id));
	}

}
