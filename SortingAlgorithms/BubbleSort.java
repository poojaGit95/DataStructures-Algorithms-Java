package com.datastructures.sorting;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {6,2,1,5,4};
        BubbleSort b= new BubbleSort();
        b.printList(arr);
        System.out.println("after sort ");
        b.sort(arr);

    }

    public void printList(int[] elements){
        for(int i=0; i<elements.length; i++){
            System.out.println(elements[i]+" ");
        }
    }

    public void sort(int[] elements){
        for(int i=0; i<elements.length; i++){
            boolean swapped=false;
            for(int j=0; j<elements.length-1;j++){
                if(elements[j]>=elements[j+1]){
                    swap(j,j+1,elements);
                    swapped=true;
                }
            }
            if(!swapped){
                break;
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
