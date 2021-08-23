package dao;
import models.Department;
import models.User;
import  models.News;
import java.util.List;

public interface DepartmentDao {
    void add(Department department);

    Department findById(int id);

    List<Department> getAll();
    List<User> getDepartmentUsers(Department department);
    List<News> getDepartmentNews(Department department);

    void update(int id, String name, String bio);
}
