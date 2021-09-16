package co.vinod.training.programs;

import java.util.Arrays;

public class ArrayInsertionDemo {

    public static void main(String[] args) {
        int[] nums = {12, 334, 55, 67, 8, 24, 19, 29, 49, 29};
        System.out.println("nums is " + Arrays.toString(nums));

        nums[4] = 100; // replaced!!!
        System.out.println("nums is " + Arrays.toString(nums));

        insert(nums, 4, 200);
        System.out.println("nums is " + Arrays.toString(nums));
        insert(nums, 4, 150);
        System.out.println("nums is " + Arrays.toString(nums));
        deleteAtIndex(nums, 4);
        System.out.println("nums is " + Arrays.toString(nums));
        deleteAtIndex(nums, 4);
        System.out.println("nums is " + Arrays.toString(nums));
        deleteAtIndex(nums, 4);
        System.out.println("nums is " + Arrays.toString(nums));
    }

    static void insert(int[] data, int index, int num){
        for(int i=data.length-2; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] = num;
    }

    static void deleteAtIndex(int[] data, int index){
        for(int i=index; i<data.length-1; i++){
            data[i] = data[i+1];
        }
    }


}
