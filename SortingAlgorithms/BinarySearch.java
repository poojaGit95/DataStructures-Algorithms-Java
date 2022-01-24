package com.datastructures.sorting;

public class BinarySearch {



        public static void main(String[] args){
            int[] arr = {10, 12, 15, 20, 25, 30};
            BinarySearch s = new BinarySearch();
            s.printList(arr);

            int keyIndex = s.search(arr, 12);
            System.out.println("The key elemets index is: "+ keyIndex);

        }

        public void printList(int[] elements){
            for(int i=0; i<elements.length; i++){
                System.out.print(elements[i]+" ");
            }
        }

        public int search(int[] elements, int key){
           int l = 0;
           int h = elements.length-1;
           int mid;

           while(l<=h){
               mid = (l+h)/2;
               if(key==elements[mid]){
                   return mid;
               }else if(key< elements[mid]){
                   h = mid-1;
               }else{
                   l = mid+1;
               }
           }

           return -1;

        }

}
