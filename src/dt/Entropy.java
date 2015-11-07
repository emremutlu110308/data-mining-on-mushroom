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
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;

/**
 *
 * @author Jackie
 */
public class Entropy {
    /**
     * @param args the command line arguments
     */
    private static File file = new File("src/dt/Data.xls");
    
    // Prepare counts of poisonous(p) and edible(e) for different values and different attributes.
    private static int [] p1 = {readExcel(file,11,3),readExcel(file,12,3),readExcel(file,13,3)};
    private static int [] e1 = {readExcel(file,11,4),readExcel(file,12,4),readExcel(file,13,4)};
    private static int [] sum1 = {readExcel(file,11,5),readExcel(file,12,5),readExcel(file,13,5)};
    
    private static int [] p2 = {readExcel(file,11,8),readExcel(file,12,8),readExcel(file,13,8),readExcel(file,14,8),readExcel(file,15,8),
        readExcel(file,16,8),readExcel(file,17,8),readExcel(file,18,8),readExcel(file,19,8),readExcel(file,20,8),readExcel(file,21,8),readExcel(file,22,8),readExcel(file,23,8)};
    private static int [] e2 = {readExcel(file,11,9),readExcel(file,12,9),readExcel(file,13,9),readExcel(file,14,9),readExcel(file,15,9),
        readExcel(file,16,9),readExcel(file,17,9),readExcel(file,18,9),readExcel(file,19,9),readExcel(file,20,9),readExcel(file,21,9),readExcel(file,22,9),readExcel(file,23,9)};
    private static int [] sum2 = {readExcel(file,11,10),readExcel(file,12,10),readExcel(file,13,10),readExcel(file,14,10),readExcel(file,15,10),
        readExcel(file,16,10),readExcel(file,17,10),readExcel(file,18,10),readExcel(file,19,10),readExcel(file,20,10),readExcel(file,21,10),readExcel(file,22,10),readExcel(file,23,10)};
    
    private static int [] p3 = {readExcel(file,11,13),readExcel(file,12,13),readExcel(file,13,13),readExcel(file,14,13),readExcel(file,15,13),
        readExcel(file,16,13),readExcel(file,17,13),readExcel(file,18,13),readExcel(file,19,13)};
    private static int [] e3 = {readExcel(file,11,14),readExcel(file,12,14),readExcel(file,13,14),readExcel(file,14,14),readExcel(file,15,14),
        readExcel(file,16,14),readExcel(file,17,14),readExcel(file,18,14),readExcel(file,19,14)};
    private static int [] sum3 = {readExcel(file,11,15),readExcel(file,12,15),readExcel(file,13,15),readExcel(file,14,15),readExcel(file,15,15),
        readExcel(file,16,15),readExcel(file,17,15),readExcel(file,18,15),readExcel(file,19,15)};
    
    private static int [] p4 = {readExcel(file,11,18),readExcel(file,12,18),readExcel(file,13,18),readExcel(file,14,18),readExcel(file,15,18),
        readExcel(file,16,18),readExcel(file,17,18),readExcel(file,18,18),readExcel(file,19,18),readExcel(file,20,18)};
    private static int [] e4 = {readExcel(file,11,19),readExcel(file,12,19),readExcel(file,13,19),readExcel(file,14,19),readExcel(file,15,19),
        readExcel(file,16,19),readExcel(file,17,19),readExcel(file,18,19),readExcel(file,19,19),readExcel(file,20,19)};
    private static int [] sum4 = {readExcel(file,11,20),readExcel(file,12,20),readExcel(file,13,20),readExcel(file,14,20),readExcel(file,15,20),
        readExcel(file,16,20),readExcel(file,17,20),readExcel(file,18,20),readExcel(file,19,20),readExcel(file,20,20)};
    
    private static int [] p5 = {readExcel(file,11,23),readExcel(file,12,23),readExcel(file,13,23),readExcel(file,14,23),readExcel(file,15,23),
        readExcel(file,16,23),readExcel(file,17,23),readExcel(file,18,23),readExcel(file,19,23),readExcel(file,20,23)};
    private static int [] e5 = {readExcel(file,11,24),readExcel(file,12,24),readExcel(file,13,24),readExcel(file,14,24),readExcel(file,15,24),
        readExcel(file,16,24),readExcel(file,17,24),readExcel(file,18,24),readExcel(file,19,24),readExcel(file,20,24)};
    private static int [] sum5 = {readExcel(file,11,25),readExcel(file,12,25),readExcel(file,13,25),readExcel(file,14,25),readExcel(file,15,25),
        readExcel(file,16,25),readExcel(file,17,25),readExcel(file,18,25),readExcel(file,19,25),readExcel(file,20,25)};
    
    private static int [] p6 = {readExcel(file,11,28),readExcel(file,12,28),readExcel(file,13,28),readExcel(file,14,28),readExcel(file,15,28)};
    private static int [] e6 = {readExcel(file,11,29),readExcel(file,12,29),readExcel(file,13,29),readExcel(file,14,29),readExcel(file,15,29)};
    private static int [] sum6 = {readExcel(file,11,30),readExcel(file,12,30),readExcel(file,13,30),readExcel(file,14,30),readExcel(file,15,30)};
    
    private static int [] p7 = {readExcel(file,11,33),readExcel(file,12,33),readExcel(file,13,33),readExcel(file,14,33),readExcel(file,15,33)};
    private static int [] e7 = {readExcel(file,11,34),readExcel(file,12,34),readExcel(file,13,34),readExcel(file,14,34),readExcel(file,15,34)};
    private static int [] sum7 = {readExcel(file,11,35),readExcel(file,12,35),readExcel(file,13,35),readExcel(file,14,35),readExcel(file,15,35)};
    
    private static List entropyResult = new ArrayList();
    
    public static List result() {
        // TODO code application logic here
        
        // Check the node splits with maximum gain ratio
        // Attribute 1
        double maxGain = 0;
        double temp = 0.0;
        String maxSplit = "";
        for (int count0 = 0; count0 < 1; count0 ++){
            for (int count1 = 0; count1 < 2; count1 ++){
                temp = result1(count0,count1);
                if(temp > maxGain){
                    maxGain = temp;
                    maxSplit = "" + count0 + "-" + count1;
                }
            }
        }
        System.out.println("MAX1: ");
        System.out.println(maxGain + " " + maxSplit);
        entropyResult.add(maxSplit);
        
        //Attribute 2
        maxGain = 0.0;
        temp = 0.0;
        maxSplit = "";
        for (int count0 = 0; count0 < 1; count0 ++){
            for (int count1 = 0; count1 < 2; count1 ++){
                for (int count2 = 0; count2 < 3; count2 ++){
                    for (int count3 = 0; count3 < 4; count3 ++){
                        for (int count4 = 0; count4 < 5; count4 ++){
                            for (int count5 = 0; count5 < 6; count5 ++){
                                for (int count6 = 0; count6 < 7; count6 ++){
                                    for (int count7 = 0; count7 < 8; count7 ++){
                                        for (int count8 = 0; count8 < 9; count8 ++){
                                            for (int count9 = 0; count9 < 10; count9 ++){
                                                for (int count10 = 0; count10 < 11; count10 ++){
                                                    for (int count11 = 0; count11 < 12; count11 ++){
                                                        temp = result2(count0,count1,count2,count3,count4,count5,count6,count7,count8,count9,count10,count11);
                                                        if(temp > maxGain){
                                                            maxGain = temp;
                                                            maxSplit = "" + count0 + "-" + count1 + "-" + count2 + "-" + count3 + "-" + count4 + "-" + count5 + "-" + count6 + "-" + count7 + "-" + count8 + "-" + count9 + "-" + count10 + "-" + count11;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("MAX2: ");
        System.out.println(maxGain + " " + maxSplit);
        entropyResult.add(maxSplit);
        
        // Attribute 3
        maxGain = 0.0;
        temp = 0.0;
        maxSplit = "";
        for (int count0 = 0; count0 < 1; count0 ++){
            for (int count1 = 0; count1 < 2; count1 ++){
                for (int count2 = 0; count2 < 3; count2 ++){
                    for (int count3 = 0; count3 < 4; count3 ++){
                        for (int count4 = 0; count4 < 5; count4 ++){
                            for (int count5 = 0; count5 < 6; count5 ++){
                                for (int count6 = 0; count6 < 7; count6 ++){
                                    for (int count7 = 0; count7 < 8; count7 ++){
                                        temp = result3(count0,count1,count2,count3,count4,count5,count6,count7);
                                        if(temp > maxGain){
                                            maxGain = temp;
                                            maxSplit = "" + count0 + "-" + count1 + "-" + count2 + "-" + count3 + "-" + count4 + "-" + count5 + "-" + count6 + "-" + count7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("MAX3: ");
        System.out.println(maxGain + " " + maxSplit);
        entropyResult.add(maxSplit);
        
        // Attribute 4
        maxGain = 0.0;
        temp = 0.0;
        maxSplit = "";
        for (int count0 = 0; count0 < 1; count0 ++){
            for (int count1 = 0; count1 < 2; count1 ++){
                for (int count2 = 0; count2 < 3; count2 ++){
                    for (int count3 = 0; count3 < 4; count3 ++){
                        for (int count4 = 0; count4 < 5; count4 ++){
                            for (int count5 = 0; count5 < 6; count5 ++){
                                for (int count6 = 0; count6 < 7; count6 ++){
                                    for (int count7 = 0; count7 < 8; count7 ++){
                                        for (int count8 = 0; count8 < 9; count8 ++){
                                            temp = result4(count0,count1,count2,count3,count4,count5,count6,count7,count8);
                                            if(temp > maxGain){
                                                maxGain = temp;
                                                maxSplit = "" + count0 + "-" + count1 + "-" + count2 + "-" + count3 + "-" + count4 + "-" + count5 + "-" + count6 + "-" + count7 + "-" + count8;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("MAX4: ");
        System.out.println(maxGain + " " + maxSplit);
        entropyResult.add(maxSplit);
        
        // Attribute 5
        maxGain = 0.0;
        temp = 0.0;
        maxSplit = "";
        for (int count0 = 0; count0 < 1; count0 ++){
            for (int count1 = 0; count1 < 2; count1 ++){
                for (int count2 = 0; count2 < 3; count2 ++){
                    for (int count3 = 0; count3 < 4; count3 ++){
                        for (int count4 = 0; count4 < 5; count4 ++){
                            for (int count5 = 0; count5 < 6; count5 ++){
                                for (int count6 = 0; count6 < 7; count6 ++){
                                    for (int count7 = 0; count7 < 8; count7 ++){
                                        for (int count8 = 0; count8 < 9; count8 ++){
                                            temp = result5(count0,count1,count2,count3,count4,count5,count6,count7,count8);
                                            if(temp > maxGain){
                                                maxGain = temp;
                                                maxSplit = "" + count0 + "-" + count1 + "-" + count2 + "-" + count3 + "-" + count4 + "-" + count5 + "-" + count6 + "-" + count7 + "-" + count8;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("MAX5: ");
        System.out.println(maxGain + " " + maxSplit);
        entropyResult.add(maxSplit);
        
        // Attribute 6
        maxGain = 0.0;
        temp = 0.0;
        maxSplit = "";
        for (int count0 = 0; count0 < 1; count0 ++){
            for (int count1 = 0; count1 < 2; count1 ++){
                for (int count2 = 0; count2 < 3; count2 ++){
                    for (int count3 = 0; count3 < 4; count3 ++){
                        temp = result6(count0,count1,count2,count3);
                        if(temp > maxGain){
                            maxGain = temp;
                            maxSplit = "" + count0 + "-" + count1 + "-" + count2 + "-" + count3;
                        }
                    }
                }
            }
        }
        System.out.println("MAX6: ");
        System.out.println(maxGain + " " + maxSplit);
        entropyResult.add(maxSplit);
        
        // Attribute 7
        maxGain = 0.0;
        temp = 0.0;
        maxSplit = "";
        for (int count0 = 0; count0 < 1; count0 ++){
            for (int count1 = 0; count1 < 2; count1 ++){
                for (int count2 = 0; count2 < 3; count2 ++){
                    for (int count3 = 0; count3 < 4; count3 ++){
                        temp = result7(count0,count1,count2,count3);
                        if(temp > maxGain){
                            maxGain = temp;
                            maxSplit = "" + count0 + "-" + count1 + "-" + count2 + "-" + count3;
                        }
                    }
                }
            }
        }
        System.out.println("MAX7: ");
        System.out.println(maxGain + " " + maxSplit);
        entropyResult.add(maxSplit);
        
        return entropyResult;
    } 
    
    // Read specific value from excel file
    public static int readExcel(File file, int column, int row){
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
    
    // Check gain ratio for attribute 1
    public static double result1(int b, int n){
        int [] countP = {0,0};
        int [] countE = {0,0};
        int [] countSum = {0,0};
        double [] entropy = {0.0,0.0};
        double [] ratio = {0.0,0.0};
        
        countP[b] = countP[b] + p1[0];
        countE[b] = countE[b] + e1[0];
        countSum[b] = countSum[b] + sum1[0];
        countP[n] = countP[n] + p1[1];
        countE[n] = countE[n] + e1[1];
        countSum[n] = countSum[n] + sum1[1];
        
        int count = 0;
        for (count = 0; count < 2; count ++){
            if((double)countP[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else if ((double)countE[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else{
                entropy[count] = ((double)(-1)) * ((double)countP[count] / (double)countSum[count] * Math.log((double)countP[count] / (double)countSum[count]) / Math.log(2) + 
                    (double)countE[count] / (double)countSum[count] * Math.log((double)countE[count] / (double)countSum[count]) / Math.log(2));
            }
            ratio[count] = (double)countSum[count] / (double) sum1[2];
        }
        
        double gainSplit = ((double)(-1)) * ((double)p1[2] / (double)sum1[2] * Math.log((double)p1[2] / (double)sum1[2]) / Math.log(2) + 
                    (double)e1[2] / (double)sum1[2] * Math.log((double)e1[2] / (double)sum1[2]) / Math.log(2));
        double splitInfo = 0.0;
        
        for (count = 0; count < 2; count ++){
            gainSplit += ((double)(-1)) * ratio[count] * entropy[count];
            if(ratio[count] == 0.0){
                splitInfo += ((double)(-1)) * ratio[count] * 0 / Math.log(2);
            }else{
                splitInfo += ((double)(-1)) * ratio[count] * Math.log(ratio[count]) / Math.log(2);
            }
        }
        
        double gainRatio = gainSplit / splitInfo;
        if (splitInfo == 0.0){
            gainRatio = 0;
        }
        return gainRatio;
    }
    
    // Check gain ratio for attribute 2
    public static double result2(int k, int n, int b, int h, int g, int r, int o, int p, int u, int e, int w, int y){
        int [] countP = {0,0,0,0,0,0,0,0,0,0,0,0};
        int [] countE = {0,0,0,0,0,0,0,0,0,0,0,0};
        int [] countSum = {0,0,0,0,0,0,0,0,0,0,0,0};
        double [] entropy = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        double [] ratio = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        countP[k] = countP[k] + p2[0];
        countE[k] = countE[k] + e2[0];
        countSum[k] = countSum[k] + sum2[0];
        countP[n] = countP[n] + p2[1];
        countE[n] = countE[n] + e2[1];
        countSum[n] = countSum[n] + sum2[1];
        countP[b] = countP[b] + p2[2];
        countE[b] = countE[b] + e2[2];
        countSum[b] = countSum[b] + sum2[2];
        countP[h] = countP[h] + p2[3];
        countE[h] = countE[h] + e2[3];
        countSum[h] = countSum[h] + sum2[3];
        countP[g] = countP[g] + p2[4];
        countE[g] = countE[g] + e2[4];
        countSum[g] = countSum[g] + sum2[4];
        countP[r] = countP[r] + p2[5];
        countE[r] = countE[r] + e2[5];
        countSum[r] = countSum[r] + sum2[5];
        countP[o] = countP[o] + p2[6];
        countE[o] = countE[o] + e2[6];
        countSum[o] = countSum[o] + sum2[6];
        countP[p] = countP[p] + p2[7];
        countE[p] = countE[p] + e2[7];
        countSum[p] = countSum[p] + sum2[7];
        countP[u] = countP[u] + p2[8];
        countE[u] = countE[u] + e2[8];
        countSum[u] = countSum[u] + sum2[8];
        countP[e] = countP[e] + p2[9];
        countE[e] = countE[e] + e2[9];
        countSum[e] = countSum[e] + sum2[9];
        countP[w] = countP[w] + p2[10];
        countE[w] = countE[w] + e2[10];
        countSum[w] = countSum[w] + sum2[10];
        countP[y] = countP[y] + p2[11];
        countE[y] = countE[y] + e2[11];
        countSum[y] = countSum[y] + sum2[11];
        
        int count = 0;
        for (count = 0; count < 12; count ++){
            if((double)countP[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else if ((double)countE[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else{
                entropy[count] = ((double)(-1)) * ((double)countP[count] / (double)countSum[count] * Math.log((double)countP[count] / (double)countSum[count]) / Math.log(2) + 
                    (double)countE[count] / (double)countSum[count] * Math.log((double)countE[count] / (double)countSum[count]) / Math.log(2));
            }
            ratio[count] = (double)countSum[count] / (double) sum2[12];
        }
        
        double gainSplit = ((double)(-1)) * ((double)p2[12] / (double)sum2[12] * Math.log((double)p2[12] / (double)sum2[12]) / Math.log(2) + 
                    (double)e2[12] / (double)sum2[12] * Math.log((double)e2[12] / (double)sum2[12]) / Math.log(2));
        double splitInfo = 0.0;
        
        for (count = 0; count < 12; count ++){
            gainSplit += ((double)(-1)) * ratio[count] * entropy[count];
            if(ratio[count] == 0.0){
                splitInfo += ((double)(-1)) * ratio[count] * 0 / Math.log(2);
            }else{
                splitInfo += ((double)(-1)) * ratio[count] * Math.log(ratio[count]) / Math.log(2);
            }
        }
        
        double gainRatio = gainSplit / splitInfo;
        if (splitInfo == 0.0){
            gainRatio = 0;
        }
        return gainRatio;
    }
    
    // Check gain ratio for attribute 3
    public static double result3(int c, int e, int f, int l, int n, int p, int s, int z){
        int [] countP = {0,0,0,0,0,0,0,0};
        int [] countE = {0,0,0,0,0,0,0,0};
        int [] countSum = {0,0,0,0,0,0,0,0};
        double [] entropy = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        double [] ratio = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        countP[c] = countP[c] + p3[0];
        countE[c] = countE[c] + e3[0];
        countSum[c] = countSum[c] + sum3[0];
        countP[e] = countP[e] + p3[1];
        countE[e] = countE[e] + e3[1];
        countSum[e] = countSum[e] + sum3[1];
        countP[f] = countP[f] + p3[2];
        countE[f] = countE[f] + e3[2];
        countSum[f] = countSum[f] + sum3[2];
        countP[l] = countP[l] + p3[3];
        countE[l] = countE[l] + e3[3];
        countSum[l] = countSum[l] + sum3[3];
        countP[n] = countP[n] + p3[4];
        countE[n] = countE[n] + e3[4];
        countSum[n] = countSum[n] + sum3[4];
        countP[p] = countP[p] + p3[5];
        countE[p] = countE[p] + e3[5];
        countSum[p] = countSum[p] + sum3[5];
        countP[s] = countP[s] + p3[6];
        countE[s] = countE[s] + e3[6];
        countSum[s] = countSum[s] + sum3[6];
        countP[z] = countP[z] + p3[7];
        countE[z] = countE[z] + e3[7];
        countSum[z] = countSum[z] + sum3[7];
        
        int count = 0;
        for (count = 0; count < 8; count ++){
            if((double)countP[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else if ((double)countE[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else{
                entropy[count] = ((double)(-1)) * ((double)countP[count] / (double)countSum[count] * Math.log((double)countP[count] / (double)countSum[count]) / Math.log(2) + 
                    (double)countE[count] / (double)countSum[count] * Math.log((double)countE[count] / (double)countSum[count]) / Math.log(2));
            }
            ratio[count] = (double)countSum[count] / (double) sum3[8];
        }
        
        double gainSplit = ((double)(-1)) * ((double)p3[8] / (double)sum3[8] * Math.log((double)p3[8] / (double)sum3[8]) / Math.log(2) + 
                    (double)e3[8] / (double)sum3[8] * Math.log((double)e3[8] / (double)sum3[8]) / Math.log(2));
        double splitInfo = 0.0;
        
        for (count = 0; count < 8; count ++){
            gainSplit += ((double)(-1)) * ratio[count] * entropy[count];
            if(ratio[count] == 0.0){
                splitInfo += ((double)(-1)) * ratio[count] * 0 / Math.log(2);
            }else{
                splitInfo += ((double)(-1)) * ratio[count] * Math.log(ratio[count]) / Math.log(2);
            }
        }
        
        double gainRatio = gainSplit / splitInfo;
        if (splitInfo == 0.0){
            gainRatio = 0;
        }
        return gainRatio;
    }
    
    // Check gain ratio for attribute 4
    public static double result4(int k, int n, int b, int h, int r, int o, int u, int w, int y){
        int [] countP = {0,0,0,0,0,0,0,0,0};
        int [] countE = {0,0,0,0,0,0,0,0,0};
        int [] countSum = {0,0,0,0,0,0,0,0,0};
        double [] entropy = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        double [] ratio = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        countP[k] = countP[k] + p4[0];
        countE[k] = countE[k] + e4[0];
        countSum[k] = countSum[k] + sum4[0];
        countP[n] = countP[n] + p4[1];
        countE[n] = countE[n] + e4[1];
        countSum[n] = countSum[n] + sum4[1];
        countP[b] = countP[b] + p4[2];
        countE[b] = countE[b] + e4[2];
        countSum[b] = countSum[b] + sum4[2];
        countP[h] = countP[h] + p4[3];
        countE[h] = countE[h] + e4[3];
        countSum[h] = countSum[h] + sum4[3];
        countP[r] = countP[r] + p4[4];
        countE[r] = countE[r] + e4[4];
        countSum[r] = countSum[r] + sum4[4];
        countP[o] = countP[o] + p4[5];
        countE[o] = countE[o] + e4[5];
        countSum[o] = countSum[o] + sum4[5];
        countP[u] = countP[u] + p4[6];
        countE[u] = countE[u] + e4[6];
        countSum[u] = countSum[u] + sum4[6];
        countP[w] = countP[w] + p4[7];
        countE[w] = countE[w] + e4[7];
        countSum[w] = countSum[w] + sum4[7];
        countP[y] = countP[y] + p4[8];
        countE[y] = countE[y] + e4[8];
        countSum[y] = countSum[y] + sum4[8];
        
        int count = 0;
        for (count = 0; count < 9; count ++){
            if((double)countP[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else if ((double)countE[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else{
                entropy[count] = ((double)(-1)) * ((double)countP[count] / (double)countSum[count] * Math.log((double)countP[count] / (double)countSum[count]) / Math.log(2) + 
                    (double)countE[count] / (double)countSum[count] * Math.log((double)countE[count] / (double)countSum[count]) / Math.log(2));
            }
            ratio[count] = (double)countSum[count] / (double) sum4[9];
        }
        
        double gainSplit = ((double)(-1)) * ((double)p4[9] / (double)sum4[9] * Math.log((double)p4[9] / (double)sum4[9]) / Math.log(2) + 
                    (double)e4[9] / (double)sum4[9] * Math.log((double)e4[9] / (double)sum4[9]) / Math.log(2));
        double splitInfo = 0.0;
        
        for (count = 0; count < 9; count ++){
            gainSplit += ((double)(-1)) * ratio[count] * entropy[count];
            if(ratio[count] == 0.0){
                splitInfo += ((double)(-1)) * ratio[count] * 0 / Math.log(2);
            }else{
                splitInfo += ((double)(-1)) * ratio[count] * Math.log(ratio[count]) / Math.log(2);
            }
        }
        
        double gainRatio = gainSplit / splitInfo;
        if (splitInfo == 0.0){
            gainRatio = 0;
        }
        return gainRatio;
    }
    
    // Check gain ratio for attribute 5
    public static double result5(int a, int l, int c, int y, int f, int m, int n, int p, int s){
        int [] countP = {0,0,0,0,0,0,0,0,0};
        int [] countE = {0,0,0,0,0,0,0,0,0};
        int [] countSum = {0,0,0,0,0,0,0,0,0};
        double [] entropy = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        double [] ratio = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        countP[a] = countP[a] + p5[0];
        countE[a] = countE[a] + e5[0];
        countSum[a] = countSum[a] + sum5[0];
        countP[l] = countP[l] + p5[1];
        countE[l] = countE[l] + e5[1];
        countSum[l] = countSum[l] + sum5[1];
        countP[c] = countP[c] + p5[2];
        countE[c] = countE[c] + e5[2];
        countSum[c] = countSum[c] + sum5[2];
        countP[y] = countP[y] + p5[3];
        countE[y] = countE[y] + e5[3];
        countSum[y] = countSum[y] + sum5[3];
        countP[f] = countP[f] + p5[4];
        countE[f] = countE[f] + e5[4];
        countSum[f] = countSum[f] + sum5[4];
        countP[m] = countP[m] + p5[5];
        countE[m] = countE[m] + e5[5];
        countSum[m] = countSum[m] + sum5[5];
        countP[n] = countP[n] + p5[6];
        countE[n] = countE[n] + e5[6];
        countSum[n] = countSum[n] + sum5[6];
        countP[p] = countP[p] + p5[7];
        countE[p] = countE[p] + e5[7];
        countSum[p] = countSum[p] + sum5[7];
        countP[s] = countP[s] + p5[8];
        countE[s] = countE[s] + e5[8];
        countSum[s] = countSum[s] + sum5[8];
        
        int count = 0;
        for (count = 0; count < 9; count ++){
            if((double)countP[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else if ((double)countE[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else{
                entropy[count] = ((double)(-1)) * ((double)countP[count] / (double)countSum[count] * Math.log((double)countP[count] / (double)countSum[count]) / Math.log(2) + 
                    (double)countE[count] / (double)countSum[count] * Math.log((double)countE[count] / (double)countSum[count]) / Math.log(2));
            }
            ratio[count] = (double)countSum[count] / (double) sum5[9];
        }
        
        double gainSplit = ((double)(-1)) * ((double)p5[9] / (double)sum5[9] * Math.log((double)p5[9] / (double)sum5[9]) / Math.log(2) + 
                    (double)e5[9] / (double)sum5[9] * Math.log((double)e5[9] / (double)sum5[9]) / Math.log(2));
        double splitInfo = 0.0;
        
        for (count = 0; count < 9; count ++){
            gainSplit += ((double)(-1)) * ratio[count] * entropy[count];
            if(ratio[count] == 0.0){
                splitInfo += ((double)(-1)) * ratio[count] * 0 / Math.log(2);
            }else{
                splitInfo += ((double)(-1)) * ratio[count] * Math.log(ratio[count]) / Math.log(2);
            }
        }
        
        double gainRatio = gainSplit / splitInfo;
        if (splitInfo == 0.0){
            gainRatio = 0;
        }
        return gainRatio;
    }
    
    // Check gain ratio for attribute 6
    public static double result6(int f, int y, int k, int s){
        int [] countP = {0,0,0,0};
        int [] countE = {0,0,0,0};
        int [] countSum = {0,0,0,0};
        double [] entropy = {0.0,0.0,0.0,0.0};
        double [] ratio = {0.0,0.0,0.0,0.0};
        countP[f] = countP[f] + p6[0];
        countE[f] = countE[f] + e6[0];
        countSum[f] = countSum[f] + sum6[0];
        countP[y] = countP[y] + p6[1];
        countE[y] = countE[y] + e6[1];
        countSum[y] = countSum[y] + sum6[1];
        countP[k] = countP[k] + p6[2];
        countE[k] = countE[k] + e6[2];
        countSum[k] = countSum[k] + sum6[2];
        countP[s] = countP[s] + p6[3];
        countE[s] = countE[s] + e6[3];
        countSum[s] = countSum[s] + sum6[3];
        
        int count = 0;
        for (count = 0; count < 4; count ++){
            if((double)countP[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else if ((double)countE[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else{
                entropy[count] = ((double)(-1)) * ((double)countP[count] / (double)countSum[count] * Math.log((double)countP[count] / (double)countSum[count]) / Math.log(2) + 
                    (double)countE[count] / (double)countSum[count] * Math.log((double)countE[count] / (double)countSum[count]) / Math.log(2));
            }
            ratio[count] = (double)countSum[count] / (double) sum6[4];
        }
        
        double gainSplit = ((double)(-1)) * ((double)p6[4] / (double)sum6[4] * Math.log((double)p6[4] / (double)sum6[4]) / Math.log(2) + 
                    (double)e6[4] / (double)sum6[4] * Math.log((double)e6[4] / (double)sum6[4]) / Math.log(2));
        double splitInfo = 0.0;
        
        for (count = 0; count < 4; count ++){
            gainSplit += ((double)(-1)) * ratio[count] * entropy[count];
            if(ratio[count] == 0.0){
                splitInfo += ((double)(-1)) * ratio[count] * 0 / Math.log(2);
            }else{
                splitInfo += ((double)(-1)) * ratio[count] * Math.log(ratio[count]) / Math.log(2);
            }
        }
        
        double gainRatio = gainSplit / splitInfo;
        if (splitInfo == 0.0){
            gainRatio = 0;
        }
        return gainRatio;
    }
    
    // Check gain ratio for attribute 7
    public static double result7(int f, int y, int k, int s){
        int [] countP = {0,0,0,0};
        int [] countE = {0,0,0,0};
        int [] countSum = {0,0,0,0};
        double [] entropy = {0.0,0.0,0.0,0.0};
        double [] ratio = {0.0,0.0,0.0,0.0};
        countP[f] = countP[f] + p7[0];
        countE[f] = countE[f] + e7[0];
        countSum[f] = countSum[f] + sum7[0];
        countP[y] = countP[y] + p7[1];
        countE[y] = countE[y] + e2[1];
        countSum[y] = countSum[y] + sum7[1];
        countP[k] = countP[k] + p7[2];
        countE[k] = countE[k] + e7[2];
        countSum[k] = countSum[k] + sum7[2];
        countP[s] = countP[s] + p7[3];
        countE[s] = countE[s] + e7[3];
        countSum[s] = countSum[s] + sum7[3];
        
        int count = 0;
        for (count = 0; count < 4; count ++){
            if((double)countP[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else if ((double)countE[count] == 0.0 || (double)countSum[count] == 0.0){
                entropy[count] = 0.0;
            }else{
                entropy[count] = ((double)(-1)) * ((double)countP[count] / (double)countSum[count] * Math.log((double)countP[count] / (double)countSum[count]) / Math.log(2) + 
                    (double)countE[count] / (double)countSum[count] * Math.log((double)countE[count] / (double)countSum[count]) / Math.log(2));
            }
            ratio[count] = (double)countSum[count] / (double) sum7[4];
        }
        
        double gainSplit = ((double)(-1)) * ((double)p7[4] / (double)sum7[4] * Math.log((double)p7[4] / (double)sum7[4]) / Math.log(2) + 
                    (double)e7[4] / (double)sum7[4] * Math.log((double)e7[4] / (double)sum7[4]) / Math.log(2));
        double splitInfo = 0.0;
        
        for (count = 0; count < 4; count ++){
            gainSplit += ((double)(-1)) * ratio[count] * entropy[count];
            if(ratio[count] == 0.0){
                splitInfo += ((double)(-1)) * ratio[count] * 0 / Math.log(2);
            }else{
                splitInfo += ((double)(-1)) * ratio[count] * Math.log(ratio[count]) / Math.log(2);
            }
        }
        
        double gainRatio = gainSplit / splitInfo;
        if (splitInfo == 0.0){
            gainRatio = 0;
        }
        return gainRatio;
    }
    
    public static int countDifferent(int [] input){
        List different = new ArrayList();
        for (int count = 0; count < input.length; count ++){
            if (!different.contains(input[count]))
                different.add(input[count]);
        }
        return different.size();
    }
}
