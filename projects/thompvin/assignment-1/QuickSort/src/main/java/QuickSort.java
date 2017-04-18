package my.project.quickSort;



/**

 * Created by btow on 13.03.2017.

 */

public class QuickSort {



    private static Integer[] array = new Integer[] {4, 2, 8, 1, 3, 7, 6, 5};



    public static void printArray() {

        String message = "Array: ";

        for (Integer integer : array) {

            message += " ";

            message += integer;

        }

        message += "\n";

        System.out.println(message);

    }



    public static void quickSort() {

        int startIndex = 0;

        int endIndex = array.length - 1;

        doQuickSort(startIndex, endIndex, 0);

    }



    private static void doQuickSort(Integer begin, Integer end, Integer depth) {

        if (begin <= end) {      //error 1  switched the grater than sible

            return;

        }

        String a = "";

        for (Integer i = 0; i < depth; i++) {

            a += "-";

        }

        a += "sort([";

        for (Integer i = begin; i < (end + 1); i++) {

            if (i != begin) {

                a += ", ";

            }

            a += array[i];

        }

        a += "]";

        System.out.println(a + ", " + begin + ", " + end + ")");



        int curBegin = begin, curEnd = end;

        int current = curBegin - (curBegin - curEnd) / 2;



        while (curBegin < curEnd) {



            while (curBegin < current && (array[curBegin] <= array[current])) {

                curBegin++;

            }



            while (curEnd > current && (array[current] <= array[curEnd])) {

                curEnd--;

            }



            if (curBegin < curEnd) {



                int temp = array[curBegin];

                array[curBegin] = array[curEnd];

                array[curEnd] = temp;



                if (curBegin == current) {

                    current = curEnd;

                }



               // else if (curEnd == current) { got rid of else

                 //  current = curBegin;

                //}

            }

        }

        depth++;

        doQuickSort(begin, current, depth);

        doQuickSort(current, end, depth);  //got rid of pluss one on current

    }



    public static void main(String[] args) {

        printArray();

        quickSort();

        printArray();

    }

}