package mainpack.dao;

import mainpack.domain.Memory;

import java.util.List;

/**
 * Created by Pavlo Kozhukhar on 11.12.2014.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List<Memory> findAll();
}
