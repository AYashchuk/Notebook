package mainpack.dao;

import mainpack.domain.CPU;

import java.util.List;

/**
 * Created by Pavlo Kozhukhar on 11.12.2014.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List<CPU> findAll();
}
