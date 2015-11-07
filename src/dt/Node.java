/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dt;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Jackie
 */
public class Node {
    private File file = new File("src/dt/Data.xls");
    private int attribute;
    private List condition = new ArrayList();
    private String result = ""; //poisonous(p),edible(e),not defined(n)
    
    // Node indicate attribute and values of attribute involved
    public Node(int attribute, List condition){
        this.attribute = attribute;
        this.condition = condition;
        int [] position = new int [this.condition.size()];
        for (int count = 0; count < this.condition.size(); count ++){
            position [count] = getPosition(this.attribute, this.condition.get(count).toString());
        }
        int numerator = 0;
        int denominator = 0;
        for (int count = 0; count < position.length; count ++){
            numerator += readExcel(file, 11 + position[count], 5 * attribute + 3);
            denominator += readExcel(file, 11 + position[count], 5 * attribute + 5);
        }
        double ratio = (double)numerator / (double) denominator;
        
        // The accuracy of each value or condition should be more than 95%
        if (ratio <= 0.05)
            this.result = "e";
        else if (ratio >= 0.95)
            this.result = "p";
        else
            this.result = "n";
    }
    
    public List getCondition(){
        return condition;
    }
    
    public String getResult(){
        return result;
    }
    
    public int readExcel(File file, int column, int row){
        Workbook workbook = null; 
        try{
            InputStream instream = new FileInputStream(file);
            workbook = Workbook.getWorkbook(instream);   
            Sheet sheet = workbook.getSheet(0);
            Cell cell = sheet.getCell(column, row);
            return Integer.parseInt(cell.getContents());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }   
        return 0;
    }
    
    // Map the values of attributes with the positions defined or involved
    public static int getPosition(int attribute, String value){
        switch(attribute){
            case 0:
                if(value.compareTo("b") == 0)
                    return 0;
                if(value.compareTo("n") == 0)
                    return 1;
            case 1:
                if(value.compareTo("k") == 0)
                    return 0;
                if(value.compareTo("n") == 0)
                    return 1;
                if(value.compareTo("b") == 0)
                    return 2;
                if(value.compareTo("h") == 0)
                    return 3;
                if(value.compareTo("g") == 0)
                    return 4;
                if(value.compareTo("r") == 0)
                    return 5;
                if(value.compareTo("o") == 0)
                    return 6;
                if(value.compareTo("p") == 0)
                    return 7;
                if(value.compareTo("u") == 0)
                    return 8;
                if(value.compareTo("e") == 0)
                    return 9;
                if(value.compareTo("w") == 0)
                    return 10;
                if(value.compareTo("y") == 0)
                    return 11;
            case 2:
                if(value.compareTo("c") == 0)
                    return 0;
                if(value.compareTo("e") == 0)
                    return 1;
                if(value.compareTo("f") == 0)
                    return 2;
                if(value.compareTo("l") == 0)
                    return 3;
                if(value.compareTo("n") == 0)
                    return 4;
                if(value.compareTo("p") == 0)
                    return 5;
                if(value.compareTo("s") == 0)
                    return 6;
                if(value.compareTo("z") == 0)
                    return 7;
            case 3:
                if(value.compareTo("k") == 0)
                    return 0;
                if(value.compareTo("n") == 0)
                    return 1;
                if(value.compareTo("b") == 0)
                    return 2;
                if(value.compareTo("h") == 0)
                    return 3;
                if(value.compareTo("r") == 0)
                    return 4;
                if(value.compareTo("o") == 0)
                    return 5;
                if(value.compareTo("u") == 0)
                    return 6;
                if(value.compareTo("w") == 0)
                    return 7;
                if(value.compareTo("y") == 0)
                    return 8;
            case 4:
                if(value.compareTo("a") == 0)
                    return 0;
                if(value.compareTo("l") == 0)
                    return 1;
                if(value.compareTo("c") == 0)
                    return 2;
                if(value.compareTo("y") == 0)
                    return 3;
                if(value.compareTo("f") == 0)
                    return 4;
                if(value.compareTo("m") == 0)
                    return 5;
                if(value.compareTo("n") == 0)
                    return 6;
                if(value.compareTo("p") == 0)
                    return 7;
                if(value.compareTo("s") == 0)
                    return 8;
            case 5:
                if(value.compareTo("f") == 0)
                    return 0;
                if(value.compareTo("y") == 0)
                    return 1;
                if(value.compareTo("k") == 0)
                    return 2;
                if(value.compareTo("s") == 0)
                    return 3;
            case 6:
                if(value.compareTo("f") == 0)
                    return 0;
                if(value.compareTo("y") == 0)
                    return 1;
                if(value.compareTo("k") == 0)
                    return 2;
                if(value.compareTo("s") == 0)
                    return 3;
        }
        return -1;
    }
}
