package cn.hn.sort;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-12-2 下午9:08
 * @desc : TODO
 */
public class AllSorts {

    //封装交换位置方法。
    public static void swap(int arr[],int a , int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void pt(int arr[]){
        for(int a:arr)
            System.out.print(a+" ");
        System.out.println();
    }

    //有的同学可能会用这个函数进行交换，这个函数在C++中是可用的，而在Java中是无效的。
    /**
     原因：
     java中基本数据类型为值传递(pass in value)
     swap_error中的参数a与b是形参，调用此方法的arr[j],arr[j+1]为实参
     调用此方法后，实参将值传递给形参a,b  由形参a,b再进行值的互换。
     由于是不是引用传递而是值传递，在调用此方法后，其arr[j],arr[j+1]实际并没有发生变化。
     */
    public static void swap_error(int a , int b){
        int temp = a;
        a = b;
        b = temp;
    }


    /**
     * 冒泡排序
     *
     * @param arr
     */

    public static void popSort(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static void quickSort1(int[] arr, int start, int end) {
        if (start > end){
            return;
        }

        int index;
        int head = start+1;
        int tail = end;

        /**
         * 危险的出现死循环
         */
        while (head < tail){
            if(head<tail && arr[start] > arr[head]) head++;
            if(head<tail && arr[start] < arr[tail]) tail--;
            if (arr[head] > arr[start] && arr[start] < arr[tail]){
                if (head <  tail){
                    swap(arr,head,tail);
                    head++;
                    tail--;
                }
            }
        }

        swap(arr,start,head);
        index = head ;
        quickSort1(arr,start,index-1);
        quickSort1(arr,index+1,end);
    }

    private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        /**
         * 关键点
         */
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);
    }


    public static void insertSort(int[] arr){


    }



    public static void main(String[] args) {
        int[] a = {6, 1, 9, 2, 3, 11, 15,4};
//        AllSorts.popSort(a);
        pt(a);
        quickSort(a,0,a.length-1);
        pt(a);


//        for (int i = 0; i <a.length ; i++) {
//            System.out.println(a[i]);
//        }
    }

}
