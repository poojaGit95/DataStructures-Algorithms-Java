package com.datastructures.sorting;

public class InsertionSort {

    public static void main(String[] args){
        int[] arr = {6,2,1,5,4};
        InsertionSort i= new InsertionSort();
        i.printList(arr);
        System.out.println("after sort ");
        i.sort(arr);

    }

    public void printList(int[] elements){
        for(int i=0; i<elements.length; i++){
            System.out.println(elements[i]+" ");
        }
    }

    public void sort(int[] elements){
        for(int i=0; i<elements.length-1; i++){
//            for(int j=i+1;j>0;j--){
//                if(elements[j]<elements[j-1]){
//                    swap(j, j-1, elements);
//                }
//            }

            for(int j=0;j<=i;j++){
                if(elements[j]>elements[j+1]){
                    swap(j, j+1, elements);
                }
            }
        }
        printList(elements);
    }

    public void swap(int indexi, int indexj, int[] elements){
        int temp = elements[indexi];
        elements[indexi] = elements[indexj];
        elements[indexj] = temp;
    }
}
