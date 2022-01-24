package com.datastructures.sorting;

public class MergeSort {

    public static void main(String[] args){
        int[] arr = {6,2,1,8,11,5,10,4};
        MergeSort m = new MergeSort();

        System.out.println("after sort ");
        m.mergeSort(arr);
        m.printList(arr);

    }

    public void printList(int[] elements){
        for(int i=0; i<elements.length; i++){
            System.out.println(elements[i]+" ");
        }
    }

    public void mergeSort(int[] elements){

        if(elements.length==1){
            return;
        }

        int mid = elements.length/2 + elements.length%2;
        int [] firstHalf = new int[mid];
        int [] secondHalf = new int[elements.length-mid];

        //splitting the array into smaller lists of firstHalf and secondHalf
        splitList(firstHalf, secondHalf, elements);

        //recurrsing till each small list is a single sorted list
        mergeSort(firstHalf);
        mergeSort(secondHalf);

        //merging the smaller lists finally to form one final merged sorted list
        mergeList(elements, firstHalf, secondHalf);


    }

    public void splitList(int[] firstHalf, int[] secondHalf, int[] elements){
        int index=0;
        int mid = firstHalf.length;
        int j=0, k=0;

        for(int i=0; i<elements.length; i++){
            if(index<mid){
                firstHalf[j]=elements[index];
                j++;
            }else{
                secondHalf[k] = elements[index];
                k++;
            }
            index++;

        }
    }

    public void mergeList(int[] elements, int[] firstHalf, int[] secondHalf){
        int mergedListIndex=0;
        int firstHalfIndex=0;
        int secondHalfIndex=0;

        while(firstHalfIndex<firstHalf.length && secondHalfIndex<secondHalf.length){
            if(firstHalf[firstHalfIndex]<secondHalf[secondHalfIndex]){
                elements[mergedListIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            }else{
                elements[mergedListIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergedListIndex++;
        }

        if(firstHalfIndex<firstHalf.length){
            while(mergedListIndex<elements.length){
                elements[mergedListIndex] = firstHalf[firstHalfIndex];
                mergedListIndex++;
                firstHalfIndex++;
            }
        }

        if(secondHalfIndex<secondHalf.length){
            while(mergedListIndex<elements.length){
                elements[mergedListIndex] = secondHalf[secondHalfIndex];
                mergedListIndex++;
                secondHalfIndex++;
            }
        }

    }

    public void swap(int indexi, int indexj, int[] elements){
        int temp = elements[indexi];
        elements[indexi] = elements[indexj];
        elements[indexj] = temp;
    }
}
