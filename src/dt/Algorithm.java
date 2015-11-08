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
public class Algorithm {
    
    public static void main(String args[]){
        // TODO code application logic here
        // Calculate the entropy and return the most result of splitting with maximum gain ratio involved
        List result = new ArrayList();
        result = Entropy.result();
        
        // Seven attributes
        Node [] attribute0 = new Node[getCharNumber(result.get(0).toString())];
        Node [] attribute1 = new Node[getCharNumber(result.get(1).toString())];
        Node [] attribute2 = new Node[getCharNumber(result.get(2).toString())];
        Node [] attribute3 = new Node[getCharNumber(result.get(3).toString())];
        Node [] attribute4 = new Node[getCharNumber(result.get(4).toString())];
        Node [] attribute5 = new Node[getCharNumber(result.get(5).toString())];
        Node [] attribute6 = new Node[getCharNumber(result.get(6).toString())];
        
        // Set up different values for atributes with lists
        for (int countA = 0; countA < 7; countA ++){
            List condition0 = new ArrayList();
            List condition1 = new ArrayList();
            List condition2 = new ArrayList();
            List condition3 = new ArrayList();
            List condition4 = new ArrayList();
            List condition5 = new ArrayList();
            List condition6 = new ArrayList();
            List condition7 = new ArrayList();
            List condition8 = new ArrayList();
            List condition9 = new ArrayList();
        
            String [] condition = result.get(countA).toString().split("-");
            for (int countC = 0; countC < condition.length; countC ++){
                switch(condition[countC].charAt(0)){
                    case '0':
                        if(countA == 0)
                            condition0.add(getValue(countA,countC));
                        if(countA == 1)
                            condition0.add(getValue(countA,countC));
                        if(countA == 2)
                            condition0.add(getValue(countA,countC));
                        if(countA == 3)
                            condition0.add(getValue(countA,countC));
                        if(countA == 4)
                            condition0.add(getValue(countA,countC));
                        if(countA == 5)
                            condition0.add(getValue(countA,countC));
                        if(countA == 6)
                            condition0.add(getValue(countA,countC));
                        break;
                    case '1':
                        if(countA == 0)
                            condition1.add(getValue(countA,countC));
                        if(countA == 1)
                            condition1.add(getValue(countA,countC));
                        if(countA == 2)
                            condition1.add(getValue(countA,countC));
                        if(countA == 3)
                            condition1.add(getValue(countA,countC));
                        if(countA == 4)
                            condition1.add(getValue(countA,countC));
                        if(countA == 5)
                            condition1.add(getValue(countA,countC));
                        if(countA == 6)
                            condition1.add(getValue(countA,countC));
                        break;
                    case '2':
                        if(countA == 0)
                            condition2.add(getValue(countA,countC));
                        if(countA == 1)
                            condition2.add(getValue(countA,countC));
                        if(countA == 2)
                            condition2.add(getValue(countA,countC));
                        if(countA == 3)
                            condition2.add(getValue(countA,countC));
                        if(countA == 4)
                            condition2.add(getValue(countA,countC));
                        if(countA == 5)
                            condition2.add(getValue(countA,countC));
                        if(countA == 6)
                            condition2.add(getValue(countA,countC));
                        break;
                    case '3':
                        if(countA == 0)
                            condition3.add(getValue(countA,countC));
                        if(countA == 1)
                            condition3.add(getValue(countA,countC));
                        if(countA == 2)
                            condition3.add(getValue(countA,countC));
                        if(countA == 3)
                            condition3.add(getValue(countA,countC));
                        if(countA == 4)
                            condition3.add(getValue(countA,countC));
                        if(countA == 5)
                            condition3.add(getValue(countA,countC));
                        if(countA == 6)
                            condition3.add(getValue(countA,countC));
                        break;
                    case '4':
                        if(countA == 0)
                            condition4.add(getValue(countA,countC));
                        if(countA == 1)
                            condition4.add(getValue(countA,countC));
                        if(countA == 2)
                            condition4.add(getValue(countA,countC));
                        if(countA == 3)
                            condition4.add(getValue(countA,countC));
                        if(countA == 4)
                            condition4.add(getValue(countA,countC));
                        if(countA == 5)
                            condition4.add(getValue(countA,countC));
                        if(countA == 6)
                            condition4.add(getValue(countA,countC));
                        break;
                    case '5':
                        if(countA == 0)
                            condition5.add(getValue(countA,countC));
                        if(countA == 1)
                            condition5.add(getValue(countA,countC));
                        if(countA == 2)
                            condition5.add(getValue(countA,countC));
                        if(countA == 3)
                            condition5.add(getValue(countA,countC));
                        if(countA == 4)
                            condition5.add(getValue(countA,countC));
                        if(countA == 5)
                            condition5.add(getValue(countA,countC));
                        if(countA == 6)
                            condition5.add(getValue(countA,countC));
                        break;
                    case '6':
                        if(countA == 0)
                            condition6.add(getValue(countA,countC));
                        if(countA == 1)
                            condition6.add(getValue(countA,countC));
                        if(countA == 2)
                            condition6.add(getValue(countA,countC));
                        if(countA == 3)
                            condition6.add(getValue(countA,countC));
                        if(countA == 4)
                            condition6.add(getValue(countA,countC));
                        if(countA == 5)
                            condition6.add(getValue(countA,countC));
                        if(countA == 6)
                            condition6.add(getValue(countA,countC));
                        break;
                    case '7':
                        if(countA == 0)
                            condition7.add(getValue(countA,countC));
                        if(countA == 1)
                            condition7.add(getValue(countA,countC));
                        if(countA == 2)
                            condition7.add(getValue(countA,countC));
                        if(countA == 3)
                            condition7.add(getValue(countA,countC));
                        if(countA == 4)
                            condition7.add(getValue(countA,countC));
                        if(countA == 5)
                            condition7.add(getValue(countA,countC));
                        if(countA == 6)
                            condition7.add(getValue(countA,countC));
                        break;
                    case '8':
                        if(countA == 0)
                            condition8.add(getValue(countA,countC));
                        if(countA == 1)
                            condition8.add(getValue(countA,countC));
                        if(countA == 2)
                            condition8.add(getValue(countA,countC));
                        if(countA == 3)
                            condition8.add(getValue(countA,countC));
                        if(countA == 4)
                            condition8.add(getValue(countA,countC));
                        if(countA == 5)
                            condition8.add(getValue(countA,countC));
                        if(countA == 6)
                            condition8.add(getValue(countA,countC));
                        break;
                    case '9':
                        if(countA == 0)
                            condition9.add(getValue(countA,countC));
                        if(countA == 1)
                            condition9.add(getValue(countA,countC));
                        if(countA == 2)
                            condition9.add(getValue(countA,countC));
                        if(countA == 3)
                            condition9.add(getValue(countA,countC));
                        if(countA == 4)
                            condition9.add(getValue(countA,countC));
                        if(countA == 5)
                            condition9.add(getValue(countA,countC));
                        if(countA == 6)
                            condition9.add(getValue(countA,countC));
                        break;
                }
            }
            
            // For each attribute, set the split nodes for each value of the attribute
            switch(countA){
                case(0):
                    if(!condition0.isEmpty())
                        attribute0[0] = new Node(0,condition0);
                    if(!condition1.isEmpty())
                        attribute0[1] = new Node(0,condition1);
                    if(!condition2.isEmpty())
                        attribute0[2] = new Node(0,condition2);
                    if(!condition3.isEmpty())
                        attribute0[3] = new Node(0,condition3);
                    if(!condition4.isEmpty())
                        attribute0[4] = new Node(0,condition4);
                    if(!condition5.isEmpty())
                        attribute0[5] = new Node(0,condition5);
                    if(!condition6.isEmpty())
                        attribute0[6] = new Node(0,condition6);
                    if(!condition7.isEmpty())
                        attribute0[7] = new Node(0,condition7);
                    if(!condition8.isEmpty())
                        attribute0[8] = new Node(0,condition8);
                    if(!condition9.isEmpty())
                        attribute0[9] = new Node(0,condition9);
                    break;
                case(1):
                    if(!condition0.isEmpty())
                        attribute1[0] = new Node(1,condition0);
                    if(!condition1.isEmpty())
                        attribute1[1] = new Node(1,condition1);
                    if(!condition2.isEmpty())
                        attribute1[2] = new Node(1,condition2);
                    if(!condition3.isEmpty())
                        attribute1[3] = new Node(1,condition3);
                    if(!condition4.isEmpty())
                        attribute1[4] = new Node(1,condition4);
                    if(!condition5.isEmpty())
                        attribute1[5] = new Node(1,condition5);
                    if(!condition6.isEmpty())
                        attribute1[6] = new Node(1,condition6);
                    if(!condition7.isEmpty())
                        attribute1[7] = new Node(1,condition7);
                    if(!condition8.isEmpty())
                        attribute1[8] = new Node(1,condition8);
                    if(!condition9.isEmpty())
                        attribute1[9] = new Node(1,condition9);
                    break;
                case(2):
                    if(!condition0.isEmpty())
                        attribute2[0] = new Node(2,condition0);
                    if(!condition1.isEmpty())
                        attribute2[1] = new Node(2,condition1);
                    if(!condition2.isEmpty())
                        attribute2[2] = new Node(2,condition2);
                    if(!condition3.isEmpty())
                        attribute2[3] = new Node(2,condition3);
                    if(!condition4.isEmpty())
                        attribute2[4] = new Node(2,condition4);
                    if(!condition5.isEmpty())
                        attribute2[5] = new Node(2,condition5);
                    if(!condition6.isEmpty())
                        attribute2[6] = new Node(2,condition6);
                    if(!condition7.isEmpty())
                        attribute2[7] = new Node(2,condition7);
                    if(!condition8.isEmpty())
                        attribute2[8] = new Node(2,condition8);
                    if(!condition9.isEmpty())
                        attribute2[9] = new Node(2,condition9);
                    break;
                case(3):
                    if(!condition0.isEmpty())
                        attribute3[0] = new Node(3,condition0);
                    if(!condition1.isEmpty())
                        attribute3[1] = new Node(3,condition1);
                    if(!condition2.isEmpty())
                        attribute3[2] = new Node(3,condition2);
                    if(!condition3.isEmpty())
                        attribute3[3] = new Node(3,condition3);
                    if(!condition4.isEmpty())
                        attribute3[4] = new Node(3,condition4);
                    if(!condition5.isEmpty())
                        attribute3[5] = new Node(3,condition5);
                    if(!condition6.isEmpty())
                        attribute3[6] = new Node(3,condition6);
                    if(!condition7.isEmpty())
                        attribute3[7] = new Node(3,condition7);
                    if(!condition8.isEmpty())
                        attribute3[8] = new Node(3,condition8);
                    if(!condition9.isEmpty())
                        attribute3[9] = new Node(3,condition9);
                    break;
                case(4):
                    if(!condition0.isEmpty())
                        attribute4[0] = new Node(4,condition0);
                    if(!condition1.isEmpty())
                        attribute4[1] = new Node(4,condition1);
                    if(!condition2.isEmpty())
                        attribute4[2] = new Node(4,condition2);
                    if(!condition3.isEmpty())
                        attribute4[3] = new Node(4,condition3);
                    if(!condition4.isEmpty())
                        attribute4[4] = new Node(4,condition4);
                    if(!condition5.isEmpty())
                        attribute4[5] = new Node(4,condition5);
                    if(!condition6.isEmpty())
                        attribute4[6] = new Node(4,condition6);
                    if(!condition7.isEmpty())
                        attribute4[7] = new Node(4,condition7);
                    if(!condition8.isEmpty())
                        attribute4[8] = new Node(4,condition8);
                    if(!condition9.isEmpty())
                        attribute4[9] = new Node(4,condition9);
                    break;
                case(5):
                    if(!condition0.isEmpty())
                        attribute5[0] = new Node(5,condition0);
                    if(!condition1.isEmpty())
                        attribute5[1] = new Node(5,condition1);
                    if(!condition2.isEmpty())
                        attribute5[2] = new Node(5,condition2);
                    if(!condition3.isEmpty())
                        attribute5[3] = new Node(5,condition3);
                    if(!condition4.isEmpty())
                        attribute5[4] = new Node(5,condition4);
                    if(!condition5.isEmpty())
                        attribute5[5] = new Node(5,condition5);
                    if(!condition6.isEmpty())
                        attribute5[6] = new Node(5,condition6);
                    if(!condition7.isEmpty())
                        attribute5[7] = new Node(5,condition7);
                    if(!condition8.isEmpty())
                        attribute5[8] = new Node(5,condition8);
                    if(!condition9.isEmpty())
                        attribute5[9] = new Node(5,condition9);
                    break;
                case(6):
                    if(!condition0.isEmpty())
                        attribute6[0] = new Node(6,condition0);
                    if(!condition1.isEmpty())
                        attribute6[1] = new Node(6,condition1);
                    if(!condition2.isEmpty())
                        attribute6[2] = new Node(6,condition2);
                    if(!condition3.isEmpty())
                        attribute6[3] = new Node(6,condition3);
                    if(!condition4.isEmpty())
                        attribute6[4] = new Node(6,condition4);
                    if(!condition5.isEmpty())
                        attribute6[5] = new Node(6,condition5);
                    if(!condition6.isEmpty())
                        attribute6[6] = new Node(6,condition6);
                    if(!condition7.isEmpty())
                        attribute6[7] = new Node(6,condition7);
                    if(!condition8.isEmpty())
                        attribute6[8] = new Node(6,condition8);
                    if(!condition9.isEmpty())
                        attribute6[9] = new Node(6,condition9);
                    break;
            }
        }
        
        File file = new File("src/dt/Data.xls");
        int success = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int total = 2438;
        
        // Testing here:
        String [][] testingValue = readExcel(file);
        for (int countT = 0; countT < 2438; countT ++){
            for (int count0 = 0; count0 < attribute0.length; count0 ++){
                if(attribute0[count0].getCondition().contains(testingValue[0][countT])){
                    if(attribute0[count0].getResult().compareTo("n") == 0){
                        for (int count1 = 0; count1 < attribute1.length; count1 ++){
                            if(attribute1[count1].getCondition().contains(testingValue[1][countT])){
                                if(attribute1[count1].getResult().compareTo("n") == 0){
                                    for (int count2 = 0; count2 < attribute2.length; count2 ++){
                                        if(attribute2[count2].getCondition().contains(testingValue[2][countT])){
                                            if(attribute2[count2].getResult().compareTo("n") == 0){
                                                for (int count3 = 0; count3 < attribute3.length; count3 ++){
                                                    if(attribute3[count3].getCondition().contains(testingValue[3][countT])){
                                                        if(attribute3[count3].getResult().compareTo("n") == 0){
                                                            for (int count4 = 0; count4 < attribute4.length; count4 ++){
                                                                if(attribute4[count4].getCondition().contains(testingValue[4][countT])){
                                                                    if(attribute4[count4].getResult().compareTo("n") == 0){
                                                                        for (int count5 = 0; count5 < attribute5.length; count5 ++){
                                                                            if(attribute5[count5].getCondition().contains(testingValue[5][countT])){
                                                                                if(attribute5[count5].getResult().compareTo("n") == 0){
                                                                                    for (int count6 = 0; count6 < attribute6.length; count6 ++){
                                                                                        if(attribute6[count6].getCondition().contains(testingValue[6][countT])){
                                                                                            // If the value is still not defined until the last attribute, the result will be defined as poisonous, because cannot eat if not defined
                                                                                            if(attribute6[count6].getResult().compareTo("n") == 0){
                                                                                                if(testingValue[7][countT].compareTo("p") == 0){
                                                                                                    success++;
                                                                                                    d++;
                                                                                                }else{
                                                                                                    b++;
                                                                                                }
                                                                                            }else{
                                                                                                // If the predict result is the same as given by testing value, then success+1
                                                                                                if(attribute6[count6].getResult().compareTo(testingValue[7][countT]) == 0){
                                                                                                    success++;
                                                                                                    if(testingValue[7][countT].compareTo("p") == 0)
                                                                                                        d++;
                                                                                                    else
                                                                                                        a++;
                                                                                                // Else, the result is not the same, value b and c will be involved
                                                                                                }else{
                                                                                                    if(testingValue[7][countT].compareTo("e") == 0)
                                                                                                        b++;
                                                                                                    else
                                                                                                        c++;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    // Same as above
                                                                                    if(attribute5[count5].getResult().compareTo(testingValue[7][countT]) == 0){
                                                                                        success++;
                                                                                        if(testingValue[7][countT].compareTo("p") == 0)
                                                                                            d++;
                                                                                        else
                                                                                            a++;
                                                                                    }else{
                                                                                        if(testingValue[7][countT].compareTo("e") == 0)
                                                                                            b++;
                                                                                        else
                                                                                            c++;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }else{
                                                                        // Same as above
                                                                        if(attribute4[count4].getResult().compareTo(testingValue[7][countT]) == 0){
                                                                            success++;
                                                                            if(testingValue[7][countT].compareTo("p") == 0)
                                                                                d++;
                                                                            else
                                                                                a++;
                                                                        }else{
                                                                            if(testingValue[7][countT].compareTo("e") == 0)
                                                                                b++;
                                                                            else
                                                                                c++;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }else{
                                                            // Same as above
                                                            if(attribute3[count3].getResult().compareTo(testingValue[7][countT]) == 0){
                                                                success++;
                                                                if(testingValue[7][countT].compareTo("p") == 0)
                                                                    d++;
                                                                else
                                                                    a++;
                                                            }else{
                                                                if(testingValue[7][countT].compareTo("e") == 0)
                                                                    b++;
                                                                else
                                                                    c++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                // Same as above
                                                if(attribute2[count2].getResult().compareTo(testingValue[7][countT]) == 0){
                                                    success++;
                                                    if(testingValue[7][countT].compareTo("p") == 0)
                                                        d++;
                                                    else
                                                        a++;
                                                }else{
                                                    if(testingValue[7][countT].compareTo("e") == 0)
                                                        b++;
                                                    else
                                                        c++;
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    // Same as above
                                    if(attribute1[count1].getResult().compareTo(testingValue[7][countT]) == 0){
                                        success++;
                                        if(testingValue[7][countT].compareTo("p") == 0)
                                            d++;
                                        else
                                            a++;
                                    }else{
                                        if(testingValue[7][countT].compareTo("e") == 0)
                                            b++;
                                        else
                                            c++;
                                    }
                                }
                            }
                        }
                    }else{
                        // Same as above
                        if(attribute0[count0].getResult().compareTo(testingValue[7][countT]) == 0){
                            success++;
                            if(testingValue[7][countT].compareTo("p") == 0)
                                d++;
                            else
                                a++;
                        }else{
                            if(testingValue[7][countT].compareTo("e") == 0)
                                b++;
                            else
                                c++;
                        }
                    }
                }
            }
        }
        System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
        System.out.println("Accuracy = " + success + " / " + total + " = " + (double)success/(double)total);
        System.out.println("Precision (Edible) = " + (double)a/(double)(a+c));
        System.out.println("Precision (Poisonous) = " + (double)d/(double)(d+b));
        System.out.println("Recall (Edible) = " + (double)a/(double)(a+b));
        System.out.println("Recall (Poisonous) = " + (double)d/(double)(d+c));
        System.out.println("F-Measure (Edible) = " + (double)(2*a)/(double)(2*a+b+c));
        System.out.println("F-Measure (Poisonous) = " + (double)(2*d)/(double)(2*d+b+c));
    }
    
    public static String [][] readExcel(File file){
        Workbook workbook = null; 
        String [][] testingValue = new String [8][2438];
        try{
            InputStream instream = new FileInputStream(file);
            workbook = Workbook.getWorkbook(instream);   
            Sheet sheet = workbook.getSheet(1);
            for (int column = 0; column < 8; column ++){
                for (int row = 1; row < 2439; row ++){
                    Cell cell = sheet.getCell(column, row);
                    String value = cell.getContents().toString();
                    testingValue[column][row - 1] = value;
                }
            }
            return testingValue;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }   
        return testingValue;
    }
    
    public static int getCharNumber(String input){
        String [] chars = input.split("-");
        int max = 0;
        for(int count = 0; count < chars.length; count ++){
            int temp = Integer.parseInt(chars[count]);
            if (temp > max)
                max = temp;
        }
        return max+1;
    }
    
    // Get value according to the position and order defined previously
    public static String getValue(int attribute, int value){
        switch(attribute){
            case 0:
                if(value == 0)
                    return "b";
                if(value == 1)
                    return "n";
            case 1:
                if(value == 0)
                    return "k";
                if(value == 1)
                    return "n";
                if(value == 2)
                    return "b";
                if(value == 3)
                    return "h";
                if(value == 4)
                    return "g";
                if(value == 5)
                    return "r";
                if(value == 6)
                    return "o";
                if(value == 7)
                    return "p";
                if(value == 8)
                    return "u";
                if(value == 9)
                    return "e";
                if(value == 10)
                    return "w";
                if(value == 11)
                    return "y";
            case 2:
                if(value == 0)
                    return "c";
                if(value == 1)
                    return "e";
                if(value == 2)
                    return "f";
                if(value == 3)
                    return "l";
                if(value == 4)
                    return "n";
                if(value == 5)
                    return "p";
                if(value == 6)
                    return "s";
                if(value == 7)
                    return "z";
            case 3:
                if(value == 0)
                    return "k";
                if(value == 1)
                    return "n";
                if(value == 2)
                    return "b";
                if(value == 3)
                    return "h";
                if(value == 4)
                    return "r";
                if(value == 5)
                    return "o";
                if(value == 6)
                    return "u";
                if(value == 7)
                    return "w";
                if(value == 8)
                    return "y";
            case 4:
                if(value == 0)
                    return "a";
                if(value == 1)
                    return "l";
                if(value == 2)
                    return "c";
                if(value == 3)
                    return "y";
                if(value == 4)
                    return "f";
                if(value == 5)
                    return "m";
                if(value == 6)
                    return "n";
                if(value == 7)
                    return "p";
                if(value == 8)
                    return "s";
            case 5:
                if(value == 0)
                    return "f";
                if(value == 1)
                    return "y";
                if(value == 2)
                    return "k";
                if(value == 3)
                    return "s";
            case 6:
                if(value == 0)
                    return "f";
                if(value == 1)
                    return "y";
                if(value == 2)
                    return "k";
                if(value == 3)
                    return "s";
        }
        return "";
    }
}