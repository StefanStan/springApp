package base.beans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by StefanS on 11.05.2016.
 */
@NoRepositoryBean
@Transactional
public interface GenericRepository<T, Integer extends Serializable> extends JpaRepository<T, Integer> {

    <S extends T> S save(S s);

    <S extends T> S saveAndFlush(S s);

    T findOne(Integer integer);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
