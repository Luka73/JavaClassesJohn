package aula02.contracts;

import java.util.List;

public interface IBaseRepository<TEntity, TKey> {
    void create(TEntity obj) throws Exception;
    void update(TEntity obj) throws Exception;
    void delete(TKey key) throws Exception;
    List<TEntity> findAll() throws Exception;
    TEntity findById(TKey key) throws Exception;
}
