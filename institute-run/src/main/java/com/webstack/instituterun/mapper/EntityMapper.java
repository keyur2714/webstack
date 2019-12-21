package com.webstack.instituterun.mapper;

import java.util.List;

public interface EntityMapper<D, E> {
	public E toEntity(D dto);

	public D toDto(E entiry);

	public List<E> toEntity(List<D> dtolistList);

	public List<D> toDto(List<E> entityList);
}
