package mainpack.dao;

import mainpack.domain.Notebook;
import mainpack.domain.Store;

import java.util.List;

/**
 * Created by Pavlo Kozhukhar on 11.12.2014.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long id);
    boolean update(Store store);
    boolean delete(Store store);
    List<Store> findAll();

    Store findByNote(Notebook notebook);
}
