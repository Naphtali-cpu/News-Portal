import com.google.gson.Gson;
import dao.DB;
import dao.Sql2oUserDao;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        Sql2oUserDao userDao = new Sql2oUserDao(DB.sql2o);
        Sql2oDepartmentsDao departmentDao = new Sql2oDepartmentsDao(DB.sql2o);
        Sql2oNewsDao newsDao = new Sql2oNewsDao(DB.sql2o);
        Connection conn = DB.sql2o.open();
        Gson gson = new Gson();


//        Viewing users and adding users
        get("/users", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(userDao.getAll());//send it back to be displayed

        });

        post("/users/new","application/json",(req,res)->{
            User user = gson.fromJson(req.body(), User.class);
            if (user.getDepartmentId() != null){
                Department department = departmentDao.findById(user.getDepartmentId());
                if(department != null){
                    userDao.add(user);
                    res.status(201);
                    res.type("application/json");
                    return gson.toJson(user);
                }
                else {
                    throw new ApiException(404, String.format("This department does not exist!!"));
                }
            } else {
                userDao.add(user);
                res.status(201);
                res.type("application/json");
                return gson.toJson(user);
            }
        });

//        Adding department and viewing departments
        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());

        });

        post("/departments/new","application/json",(req,res)->{
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });


//        Viewing and adding news
        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(newsDao.getAll());

        });

        post("/news/post","application/json",(req,res)->{
            News news = gson.fromJson(req.body(), News.class);
            if (news.getDepartmentId() != null){
                Department department = departmentDao.findById(news.getDepartmentId());
                if(department != null){
                    newsDao.add(news);
                    res.status(201);
                    res.type("application/json");
                    return gson.toJson(news);
                }
                else {
                    throw new ApiException(404, String.format("The department assigned does not exist"));
                }
            } else {
                newsDao.add(news);
                res.status(201);
                res.type("application/json");
                return gson.toJson(news);
            }
        });

        get("/news/:id", "application/json", (req, res) -> {
            int postId = Integer.parseInt(req.params("id"));

            News postToFind = newsDao.findById(postId);

            if (postToFind == null){
                throw new ApiException(404, String.format("No news so far with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(postToFind);
        });

        get("/users/:id", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));

            User userToFind = userDao.findById(userId);

            if (userToFind == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(userToFind);
        });

        get("/departments/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));

            Department departmentToFind = departmentDao.findById(departmentId);

            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(departmentToFind);
        });

        get("/departments/:id/users", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentDao.getDepartmentUsers(departmentToFind));
        });

        get("/departments/:id/news", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));

            Department departmentToFind = departmentDao.findById(departmentId);

            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            else if (departmentDao.getDepartmentNews(departmentToFind).size()==0){
                return "{\"message\":\"I'm sorry, but no news posted to this department.\"}";
            }
            else {
                return gson.toJson(departmentDao.getDepartmentNews(departmentToFind));
            }
        });

        //FILTERS
        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}