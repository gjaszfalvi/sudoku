/*
 * Sudoku.java
 * The app checks the solution of a given sudoku grid (as an array) if correct or not
 * @author Gabor Jaszfalvi
 * 2016
 */
package Sudoku;

import Pack.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Sudoku {
    public static void main(String[] args) {
        
        // declare the sudoku grid as a single array
        int[] nums ={5,3,4,6,7,8,9,1,2,
                     6,7,2,1,9,5,3,4,8,
                     1,9,8,3,4,2,5,6,7,
                     8,5,9,7,6,1,4,2,3,
                     4,2,6,8,5,3,7,9,1,
                     7,1,3,9,2,4,8,5,6,
                     9,6,1,5,3,7,2,8,4,
                     2,8,7,4,1,9,6,3,5,
                     3,4,5,2,8,6,1,7,9};
        
        // instance variables:
        // n is the index of the element in the nums grid
        // the arraylists are used to generate arrays from the grid's rows, columns, and blocks
        // the check array is to check if all arrays consist of integers from 1 to 9
        int n=0;
        ArrayList<Integer>[] rows = new ArrayList[9];
        ArrayList<Integer>[] cols = new ArrayList[9];
        ArrayList<Integer>[] block = new ArrayList[9];
        Integer[] check = {1,2,3,4,5,6,7,8,9};
        boolean isSudoku=true;
        
        // first loop block is to generate the row and column arraylists
        for (int i = 0; i < 9; i++) {
            int m=i;
            rows[i] = new ArrayList();
            cols[i] = new ArrayList();

            for (int j = 0; j < 9; j++) {
                rows[i].add(nums[n]);
                cols[i].add(nums[m]);
                n++;
                m=m+9;
            }
            Collections.sort(rows[i]) ;
            // test print
            // System.out.println("row"+i+" "+Arrays.toString(rows[i].toArray()));      
            Collections.sort(cols[i]) ;
            // test print
            // System.out.println("col"+i+" "+Arrays.toString(cols[i].toArray()));      
        }
        
        // first loop block is to generate the block arraylists
        int c=0;
        for (int i = 0; i < 3; i++) {
            int d=i*3;
            int x=d;
            for (int j = 0; j < 3; j++) {
                block[c] = new ArrayList();                
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        block[c].add(nums[x]);
                        x++;
                    }
                    x=x+6;
                }
                Collections.sort(block[c]);
                // test print
                // System.out.println("block"+c+" "+Arrays.toString(block[c].toArray()));
                c++;    // :) java
            }            
        }

        // comparing the sorted arrays
        for (int i = 0; i < 8; i++) {
            if (!(Arrays.equals(block[i].toArray(), block[i+1].toArray()) &&
                    Arrays.equals(rows[i].toArray(), rows[i+1].toArray()) &&
                    Arrays.equals(cols[i].toArray(), cols[i+1].toArray()) &&
                    Arrays.equals(block[i].toArray(), check))) {
                isSudoku=false;
                break;
            }
        }
        
        System.out.println( isSudoku ? "SUDOKU" : "Not SUDOKU");
    }
}
