public class lesson_2 {
    public static void main(String[] args) {
        int sum=0;
        String[][] Arr= {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        try {
        sum=arraySum(Arr);
        } catch (MyArraySizeException e) {
            e.info();
        }catch (MyArrayDataException e) {
            e.info();
        }

        System.out.println("Сумма: "+sum);
    }
    private static boolean isNumber(String str) {
        for (char c: str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public  static int arraySum (String[][] Array) throws MyArraySizeException, MyArrayDataException {
        int sum=0;
        if(Array.length!=4){
            throw new MyArraySizeException();
        }else if(Array[0].length!=4||Array[1].length!=4||Array[2].length!=4||Array[3].length!=4){
            throw new MyArraySizeException();}
           for(int i=0;i<4;i++){
               for(int j=0;j<4;j++){
                   if(!isNumber(Array[i][j])){
                       throw new MyArrayDataException(i,j);
                   }
                   sum+=Integer.parseInt (Array[i][j]);
               }
           }


        return sum;
    }
}
