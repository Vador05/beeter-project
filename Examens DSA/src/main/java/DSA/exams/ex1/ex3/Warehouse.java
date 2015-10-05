package DSA.exams.ex1.ex3;

import java.io.IOException;
import java.sql.ResultSet;

/**
 * Created by kenshin on 2/10/15.
 */
public class Warehouse {
    public int code;
    public String location;
    public int capacity;

    public Warehouse(String[] args){
        code= Integer.parseInt(args[0]);
        location = args[1];
        capacity= Integer.parseInt(args[2]);
    }
    public Warehouse(ResultSet rse) throws Exception{
        code= rse.getInt(1);
        location = rse.getString(2);
        capacity= rse.getInt(3);
    }
}
