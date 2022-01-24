package com.datastructures.sorting;

public class QuickSort {

    public static void main(String[] args){
        int[] arr = {6,2,1,8,11,5,10,4};
        QuickSort q= new QuickSort();
        System.out.println("after sort ");
        q.quickSort(arr, 0, arr.length-1);
        q.printList(arr);

    }

    public void printList(int[] elements){
        for(int i=0; i<elements.length; i++){
            System.out.println(elements[i]+" ");
        }
    }

    public void quickSort(int[] elements, int low, int high){
       if(low>=high){
           return;
       }

       int partitionIndex = getPivotIndex(elements, low, high);
       quickSort(elements, low, partitionIndex-1);
       quickSort(elements, partitionIndex+1, high);
    }

    public int getPivotIndex(int[] elements, int low, int high){
        int l = low;
        int h = high;
        int partition = elements[low];
        while(l<h){

            while(elements[l]<=partition && l<h){
                l++;
             }

             while(elements[h]>partition){
                h--;
             }

            if(l<h){
                 swap(l, h, elements);
            }
        }
        swap(low, h, elements);

        return h;


    }

    public void swap(int indexi, int indexj, int[] elements){
        int temp = elements[indexi];
        elements[indexi] = elements[indexj];
        elements[indexj] = temp;
    }
}
