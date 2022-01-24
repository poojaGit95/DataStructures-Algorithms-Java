package com.datastructures.sorting;

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {6,2,1,5,4};
        SelectionSort s = new SelectionSort();
        s.printList(arr);
        System.out.println("after sort ");
        s.sort(arr);

    }

    public void printList(int[] elements){
        for(int i=0; i<elements.length; i++){
            System.out.println(elements[i]+" ");
        }
    }

    public void sort(int[] elements){
        for(int i=0; i<elements.length; i++){
            for(int j=i+1; j<elements.length;j++){
                if(elements[i]>=elements[j]){
                    swap(i,j,elements);
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
