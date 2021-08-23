package dao;
import models.News;
import models.Department;

import java.util.List;

public interface NewsDao {
    List<News> getAll();

    void add(News news);

    News findById(int id);

    void update(int id, String title, String content, int departmentId);

    void deleteById(int id);
    void clearAll();
}
