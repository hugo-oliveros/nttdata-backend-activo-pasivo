package com.nttdata.incloud.commons;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {

	T save(T entity);

	T saveAll(List<T> entity);

	T delete(ID id);

	T get(ID id);

	List<T> getAll();
}
