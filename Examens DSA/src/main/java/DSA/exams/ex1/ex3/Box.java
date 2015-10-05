package DSA.exams.ex1.ex3;

import java.sql.ResultSet;

/**
 * Created by kenshin on 2/10/15.
 */
public class Box {
    public String code;
    public String contents;
    public Double value;

    public Box (String [] args){
        code= args[0];
        contents= args[1];
        value = Double.parseDouble(args[2]);
    }
    public Box (ResultSet rse)throws Exception{
        code= rse.getString(1);
        contents= rse.getString(2);
        value = rse.getDouble(3);
    }

}
