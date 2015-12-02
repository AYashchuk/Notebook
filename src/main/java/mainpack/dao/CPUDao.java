package mainpack.dao;

import mainpack.domain.CPU;

import java.util.List;

/**
 * @author Yashchuk A.F.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List<CPU> findAll();
}
