package dao;
import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/newsportal", "naphtali", "1606525");
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-52-6-77-239.compute-1.amazonaws.com:5432/d8lnbh95hoj830", "qwifhkajqelgfi", "e092647dacb35df68b5f84475c01b6ec0c6de819d57d4eaa33ca02dcd91cc5e3");
}