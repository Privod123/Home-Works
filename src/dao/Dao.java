package dao;

import java.util.List;

public interface Dao {
    boolean add(Object obj);
    void delete(int id);
    void update(int id, Object obj);
    List<Object> getAll();
    Object getById(int id);
}
