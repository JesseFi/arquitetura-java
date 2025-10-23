package br.edu.infnet.jessefigueroapi.interfaces;

import java.util.List;

public interface CrudService<T, ID> {

    T insert(T entidade);
    List<T> findAll();
    T update(ID id, T entidade);
    void delete(ID id);
    T findById(ID id);

}
