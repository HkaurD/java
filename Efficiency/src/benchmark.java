public class benchmark {
    public static void main(String[] args){
        int[] nums1 = new int[1000000];
        int[] nums2 = new int[1000000];

        long before = System.nanoTime();     // System.currentTimeMillis()
        for(int i = 0; i < 1000000; i++){
            nums1[i] = nums2[i];
        }

        long after = System.nanoTime();     // System.currentTimeMillis()
        System.out.println(after - before);

        before = System.nanoTime();
        System.arraycopy(nums1, 0, nums2, 0, 1000000);
        after = System.nanoTime();
        System.out.println(after - before); // arraycopy is almost 10 times faster
    }
}
