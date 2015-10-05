package DSA.exams.ex1.ex3;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by kenshin on 2/10/15.
 */
public class WarehouseDAO {
    /**Suposo que la connexio a la base de dades ja esta establerta
     * juntament amb l'estatement corresponent*/
    private ResultSet resultSet = null;
private Statement statement;
    public List<Box> getBoxes (Warehouse h) throws Exception{
        resultSet = statement.executeQuery("SELECT * FROM Box WHERE Warehouse="+h.code+";");//Warehouses.Code = Boxes.Warehouse
        return crearLBox(resultSet);
    }

    public List<Warehouse> getAllWarehouses() throws Exception{
        resultSet = statement.executeQuery("SELECT * FROM Warehouses;");
        return crearLWare(resultSet);

    }

    public void deleteBox(Box box) throws Exception{
        resultSet = statement.executeQuery("DELETE * FROM Box WHERE Code="+box.code+";");

    }

    private List<Warehouse> crearLWare(ResultSet res)throws Exception{
        List<Warehouse> all=new List<Warehouse>();
        do {
            Warehouse h = new Warehouse(res.next());
            all.add(h);
        }  while(res.next()!=null);//NO es aixi pero no tinc temps per arreglar-ho
    }
    private List<Box> crearLBox(ResultSet res)throws Exception{
        List<Box> all=new List<Box>();
        do {
            Box b = new Box(res.next());
            all.add(b);
        }  while(res.next()!=null);//NO es aixi pero no tinc temps per arreglar-ho
    }
}
