package ir.maktab.todo.base.repository;

import ir.maktab.todo.base.domain.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable>{

    E save(E e);

    E update(E e);

    List<E> findAll() throws SQLException;

    List<E> findAllByIds(Collection<ID> ids);

    E findByID(ID id);

    Boolean deleteById(ID id);

    Boolean isExist(ID id);

}
