package org.junitbasic;

import java.util.Arrays;

public class MinMaxFinder {

    public int[] findMinMax(int[] arr){
        int[] arrResult = new int[]{arr[0],arr[0]};
        int startIndex = 0;
        while(startIndex<arr.length){
            if(arr[startIndex]<arrResult[0]){
                arrResult[0] = arr[startIndex];
            }
            if(arr[startIndex]>arrResult[1]){
                arrResult[1] = arr[startIndex];
            }
            startIndex++;
        }
        return arrResult;
    }

    public MinMax findMinMaxObject(int[] arr){
        MinMax minMax = new MinMax(arr[0],arr[0]);
        int startIndex = 0;
        while(startIndex<arr.length){
            if(arr[startIndex]<minMax.getMin()){
                minMax.setMin(arr[startIndex]);
            }
            if(arr[startIndex]>minMax.getMax()){
                minMax.setMax(arr[startIndex]);
            }
            startIndex++;
        }
        return minMax;
    }

    public static void main(String[] args){
        int[] intInput = new int[]{-1,-13,-14,-89};
        MinMaxFinder minMaxFinder = new MinMaxFinder();
        int[] arrRes = minMaxFinder.findMinMax(intInput);
        System.out.println(Arrays.toString(arrRes));
        MinMax minMaxRes = minMaxFinder.findMinMaxObject(intInput);
        System.out.println(minMaxRes.toString());
    }

}
