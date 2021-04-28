package geekbrain;

public class Main {

    public static void main(String[] args) {
        try {
        buildarray();
        } catch(MyArraySizeException e) {
        }
        catch(MyArrayDataException e){
        e.printStackTrace();
        }
    }

    private static void buildarray() {
        int size1;
        int size2;
        //size1 = (int) Math.random() * 10;
        //size2 = (int) Math.random() * 10;
        size1 = 4;
        size2 = 4;
        if (size1 != 4 || size2 != 4)
            throw new MyArraySizeException();
        String[][] array = new String[size1][size2];
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array[0].length; y++)
                array[i][y] = String.valueOf((int) (Math.random() * 10));
        }
        //array[2][3] = "zzz";
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array[0].length; y++){
                try {
                    sum += Integer.parseInt(array[i][y]);
                } catch (NumberFormatException e) {
                    System.out.printf("Элемент не является числом [%d][%d]\n", i, y);
                    throw new MyArrayDataException();
                }

            }

        }
        printarray(array);
       System.out.println("Сумма элементов массива равна " + sum);
    }

    private static void printarray(String[][] array) {
        for (int k = 0; k < array.length; k++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" " + array[k][j] + " ");
            }
            System.out.println();
        }
    }

    static class MyArraySizeException extends ArrayIndexOutOfBoundsException{
        public MyArraySizeException() {System.out.println("Размер массива должен быть строго 4х4!");
        }
    }
    static class MyArrayDataException extends NumberFormatException {
        }
}

