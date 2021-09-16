package co.vinod.training.programs;

import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();

        nums.add(12);
        nums.add(122);
        nums.add(89);
        nums.add(12);
        nums.add(100);
        nums.add(120);
        nums.add(122);

        System.out.println("nums is " + nums);

        nums.add(0, 500);
        System.out.println("nums is " + nums);
        nums.add(nums.size(), 1000);
        System.out.println("nums is " + nums);
        nums.remove(Integer.valueOf(12));
        System.out.println("nums is " + nums);
        List<Integer> subList = nums.subList(2, 5);
        System.out.println("subList is " + subList);
    }
}
