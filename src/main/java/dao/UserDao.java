package dao;
import models.User;
import java.util.List;

public interface UserDao {
    List<User> getAll();

    void add(User user);

    User findById(int id);

    void update(int id, String name, String bio, String position, String role, int departmentId);

    void deleteById(int id);
    void clearAll();
}
