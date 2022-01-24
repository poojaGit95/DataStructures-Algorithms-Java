package com.datastructures.sorting;

public class ShellSort {
    public static void main(String[] args){
        int[] arr = {6,2,1,5,4};
        ShellSort s = new ShellSort();
       // s.printList(arr);
        System.out.println("after sort ");
        s.shellSort(arr);

    }

    public void printList(int[] elements){
        for(int i=0; i<elements.length; i++){
            System.out.println(elements[i]+" ");
        }
    }

    public void insertionSort(int[] elements, int startIndex, int increment){
        for(int i=startIndex; i<elements.length; i=i+increment){
            for(int j=Math.min(i+increment, elements.length-1); j-increment>=0; j=j-increment){
                if(elements[j]<elements[j-increment]){
                    swap(j, j-increment, elements);
                }else{
                    break;
                }
            }

        }
    }

    public void shellSort(int[] elements){
        int increment = elements.length/2;
        while(increment>=1){
            for(int startIndex=0; startIndex<increment; startIndex++){
                insertionSort(elements, startIndex, increment);
            }
            increment = increment/2;
        }
        printList(elements);

    }

    public void swap(int indexi, int indexj, int[] elements){
        int temp = elements[indexi];
        elements[indexi] = elements[indexj];
        elements[indexj] = temp;
    }

}
