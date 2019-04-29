public class main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        System.out.println("method");
        method();
        System.out.println("multimethod");
        multimethod();
    }

    public static void method() {
        float[] arr = new float[size];
        fullarr(arr);
        long a = System.currentTimeMillis();
        calculation(arr,size,0 );
        System.out.println("time: "+(System.currentTimeMillis() - a));


    }

    public static void multimethod() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        fullarr(arr);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        new Thread(() -> main.calculation(a1, h,0)).run();
        new Thread(() -> main.calculation(a2, h, h)).run();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("time: "+(System.currentTimeMillis() - a));

    }
    public static void fullarr(float[] arr){
        for (int i=0;i<arr.length;i++){
            arr[i]=1;
        }
    }

    public static void calculation(float[] arr, int sizes, int offset){
        for (int i=0;i<sizes;i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i+offset) / 5) * Math.cos(0.2f + (i+offset) / 5) * Math.cos(0.4f + (i+offset) / 2));
        }

    }
}
