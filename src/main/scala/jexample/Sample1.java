//测试前请更换包名为example,放到jexample是为了防止与scala冲突
package jexample;

class Sample1 {
    // --- Native methods
    public native int intMethod(int n);
    public native boolean booleanMethod(boolean bool);
    public native String stringMethod(String text);
    public native int intArrayMethod(int[] intArray);
    
    static{
    	System.loadLibrary("Sample1");
    }

    // --- Main method to test our native library
    public static void main(String[] args) {
        
        Sample1 sample = new Sample1();
        int square = sample.intMethod(5);
        boolean bool = sample.booleanMethod(true);
        String text = sample.stringMethod("java");
        int sum = sample.intArrayMethod(new int[] {1, 1, 2, 3, 5, 8, 13});
        System.out.println("intMethod: " + square);
        System.out.println("booleanMethod: " + bool);
        System.out.println("stringMethod: " + text);
        System.out.println("intArrayMethod: " + sum);
        System.out.println("执行完毕");
    }
}
