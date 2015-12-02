package mainpack.dao;

import mainpack.domain.Notebook;
import mainpack.domain.Vendor;

import java.util.List;

/**
 * @author Yashchuk A.F.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();

    List<Notebook> findAll(int start, int portion);
    List<Notebook> findLeft(int amount);
    List<Notebook> findByCPUVendor(Vendor cpuVendor);
    List<Notebook> findSold();
}
