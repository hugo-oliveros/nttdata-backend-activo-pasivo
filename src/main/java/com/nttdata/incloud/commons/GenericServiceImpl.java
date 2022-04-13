package com.nttdata.incloud.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}
	
	@Override
	public T saveAll(List<T> entities) {
		return (T) getDao().saveAll(entities);
	}
	
	@Override
	public T delete(ID id) {
		getDao().deleteById(id);
		return null;
	}

	@Override
	public T get(ID id) {
		return getDao().findById(id).get();
	}
	
	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract CrudRepository<T, ID> getDao();

}
