package co.vinod.training.programs;

public class ArraysDemo <T> {

    String toString(T[] arr){

        if(arr==null){
            return "null";
        }

        if(arr.length==0){
            return "[]";
        }

        String str = "[";
        for(int i=0; i<arr.length-1; i++){
            str += arr[i] + ", ";
        }
        str += arr[arr.length-1] + "]";

        return str;
    }

    static <T> String toStr(T[] arr){

        if(arr==null){
            return "null";
        }

        if(arr.length==0){
            return "[]";
        }

        String str = "[";
        for(int i=0; i<arr.length-1; i++){
            str += arr[i] + ", ";
        }
        str += arr[arr.length-1] + "]";

        return str;
    }

    public static void main(String[] args) {

        ArraysDemo<Integer> ad = new ArraysDemo<>();
        ArraysDemo<String> ads = new ArraysDemo<>();

//        Integer[] nums = {};
        Integer[] nums;
        nums = new Integer[] {12, 34, 55};
//        nums = new int[10];


        System.out.println("nums is " + ad.toString(nums));

        Integer[] data = null;
        System.out.println("data is " + ad.toString(data));

        Integer[] arr = {12, 34, 5, 6, 77, 8,9};
        System.out.println("arr is " + ad.toString(arr));

        String[] names = {"Vinod", "Kumar", "Shyam"};
        System.out.println("names is " + ads.toString(names));

        Double[] ds = {1.2, 33.4, 5.92, 33.33};
        ArraysDemo<Double> add = new ArraysDemo<>();
//        System.out.println("ds is " + add.toString(ds));

        System.out.println("arr is " + toStr(arr));
        System.out.println("data is " + toStr(data));
        System.out.println("ds is " + toStr(ds));
    }
}
