package org.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    public InsertionSortTest(){
    }
//    @Rule
//    public Timeout globalTimeout = Timeout.millis(0000); // 1 second

    @Test(timeout = 1000)
    public void simple_array_with_5_elements(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{8,6,10,1,4},0) ;
        assertArrayEquals(new int[]{1,4,6,8,10} ,res.getLast());
    }

    @Test(timeout = 1000)
    public void corner_case_of_one_element_array(){

        ArrayList<int[]> res = InsertionSort.sort(new int[]{8},0) ;

        assertArrayEquals(new int[]{8} ,res.getFirst());
    }
    @Test(timeout = 1000)
    public void corner_case_of_empty_array(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{},0) ;
        assertArrayEquals(new int[]{} ,res.getFirst());
    }
    @Test(timeout = 1000)
    public void reversed_sorted_array_manually(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{10,9,8,7,6,5,5,4,4,3,3,2,2,2,1,0,0},0) ;
        assertArrayEquals(new int[]{0,0,1,2,2,2,3,3,4,4,5,5,6,7,8,9,10} ,res.getLast());
    }

    @Test(timeout = 1000)
    public void reversed_sorted_array_randomly(){
        int[]random , resultToRandom ;
        int[][] tempArr = generate_random(1000) ;
        random = tempArr[0] ;
        resultToRandom = tempArr[1] ;
        Arrays.sort(resultToRandom);
        Arrays.sort(random );
        for(int i = 0 ; i < random.length / 2 ; i++){ // to reverse random array
            int temp = random[i] ;
            random[i] = random[random.length-1-i] ;
            random[random.length-1-i] = temp ;
        }
        ArrayList<int[]> res = InsertionSort.sort(random,0) ;
        assertArrayEquals(resultToRandom , res.getLast());
    }
    @Test(timeout = 1000)
    public void sorted_array_manually(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{0,0,1,2,2,2,3,3,4,4,5,5,6,7,8,9,10},0) ;
        assertArrayEquals(new int[]{0,0,1,2,2,2,3,3,4,4,5,5,6,7,8,9,10} ,res.getLast());
    }

    @Test(timeout = 1000)
    public void sorted_array_randomly(){
        int[]random , resultToRandom ;
        int[][] tempArr = generate_random(1000) ;
        random = tempArr[0] ;
        resultToRandom = tempArr[1] ;
        Arrays.sort(resultToRandom);
        Arrays.sort(random );
        ArrayList<int[]> res = InsertionSort.sort(random,0) ;
        assertArrayEquals(resultToRandom , res.getLast());
    }

    @Test(timeout = 1000)
    public void large_size_array(){
        int[]random , resultToRandom ;
        int[][] tempArr = generate_random(1000000) ;
        random = tempArr[0] ;
        resultToRandom = tempArr[1] ;
        Arrays.sort(resultToRandom);
        ArrayList<int[]> res = InsertionSort.sort(random,0) ;
        assertArrayEquals(resultToRandom , res.getLast());
    }
    @Test(timeout = 1000)
    public void intermediate_corrected1(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{5,2,9,1},1) ;
        assertArrayEquals(new int[]{1,2,5,9} ,res.getLast());
        assertArrayEquals(new int[]{2,5,9,1}, res.getFirst());
    }
    @Test(timeout = 1000)
    public void intermediate_corrected2(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{10,5,4,2,0,-1},1) ;
        assertArrayEquals(new int[]{5,10,4,2,0,-1}, res.get(0));
        assertArrayEquals(new int[]{4,5,10,2,0,-1}, res.get(1));
        assertArrayEquals(new int[]{2,4,5,10,0,-1}, res.get(2));
        assertArrayEquals(new int[]{0,2,4,5,10,-1}, res.get(3));
        assertArrayEquals(new int[]{-1,0,2,4,5,10}, res.get(4));
        assertArrayEquals(new int[]{-1,0,2,4,5,10} ,res.getLast());
    }
    @Test(timeout = 1000)
    public void intermediate_corrected3(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{1,2,3,4,5},1) ;
        assertArrayEquals(new int[]{1,2,3,4,5} ,res.getLast());
    }
    @Test(timeout = 1000)
    public void intermediate_corrected4(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{5,2,5,2,3},1) ;
        assertArrayEquals(new int[]{2,5,5,2,3} ,res.get(0));
        assertArrayEquals(new int[]{2,5,5,2,3} ,res.get(1));
        assertArrayEquals(new int[]{2,2,5,5,3} ,res.get(2));
        assertArrayEquals(new int[]{2,2,3,5,5} ,res.getLast());
    }
    @Test(timeout = 1000)
    public void intermediate_corrected5(){
        ArrayList<int[]> res = InsertionSort.sort(new int[]{0,2,1,6,-1},1) ;
        assertArrayEquals(new int[]{0,2,1,6,-1} ,res.get(0));
        assertArrayEquals(new int[]{0,1,2,6,-1} ,res.get(1));
        assertArrayEquals(new int[]{0,1,2,6,-1} ,res.get(2));
        assertArrayEquals(new int[]{-1,0,1,2,6} ,res.getLast());
    }

    @Test(timeout = 1000)
    public void random_arrays(){
        int trial = 30 ;
        long averageStart = System.nanoTime();
        for(int i = 0 ; i < trial ; ++i ){
            int[]random , resultToRandom ;
            int[][] tempArr = generate_random(10000) ;
            random = tempArr[0] ;
            resultToRandom = tempArr[1] ;
            Arrays.sort(resultToRandom);
            ArrayList<int[]> res = InsertionSort.sort(random,0) ;
            assertArrayEquals(resultToRandom , res.getLast());
        }
        long averageEnd = System.nanoTime();
        System.out.println("average time taken = " +((averageEnd-averageStart)/(1000000)/30) +" ms");
    }
    @Test(timeout = 100000)
    public void fixed_large_array_to_compare_between_methods(){
        int fixedSize = 100000 ;
        int[] input = new int[fixedSize] ;
        int[] compared = new int[fixedSize] ;
        for(int i = 0 ; i < fixedSize ; ++i){
            input[i] = i % 1009 ;
            compared[i] = i % 1009 ;
        }
        Arrays.sort(compared);
        ArrayList<int[]> res = InsertionSort.sort(input,0) ;
        assertArrayEquals(compared , res.getLast());
    }
    @Test(timeout = 10000000)
    public void fixed_large_array_to_compare_between_times(){
        int fixedSize = 100 ;
        int different_sizes = 10000;
        long overall_start = System.nanoTime();
        for(int j = 1 ; j <= different_sizes ; j *=2 ){
            long averageStart = System.nanoTime();
            int[] input = new int[fixedSize * j] ;
            int[] compared = new int[fixedSize * j] ;
            for(int k = 1 ; k <= 10 ; k++ ){
                long start = System.nanoTime();
                for(int i = 0 ; i < fixedSize * j ; ++i){
                    input[i] = i % (1009 + k );
                    compared[i] = i % (1009 + k ) ;
                }
                ArrayList<int[]> res = InsertionSort.sort(input,0) ;
                long end = System.nanoTime();
                Arrays.sort(compared);
                //System.out.println("time taken with size = " +(fixedSize*j) +" at trial >> " + k +"= "+(end-start)/1000000 + "ms");
                assertArrayEquals(compared , res.getLast());
            }
            long averageEnd = System.nanoTime();
            System.out.println("average time taken in size " +(fixedSize * j) +" = " + (averageEnd-averageStart)/10000000 +"ms");

        }
        long overall_end = System.nanoTime();
        System.out.println("overall time taken = " + (overall_end-overall_start)/1000000);
    }

    public int[][]generate_random (int limit_size){
        Random r =new Random() ;
        int[]random ;
        int[]resultToRandom;
        random = new int[r.nextInt(limit_size)] ;
        resultToRandom = new int[random.length] ;
        for(int i = 0 ; i < random.length ; ++i){
            random[i] = r.nextInt(limit_size * 10) ;
            resultToRandom[i] = random[i] ;
        }
        int[][] res = new int[2][random.length];
        res[0] = random ;
        res[1] = resultToRandom ;
        return res ;
    }

}