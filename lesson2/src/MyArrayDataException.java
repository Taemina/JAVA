public class MyArrayDataException extends Exception  {
    int i;
    int j;
   public MyArrayDataException(int i,int j){
        this.i=i;
       this.j=j;
    }
    public void info(){
        System.out.println("В ячейке ["+i+"]["+j+"] не число ");
    }
}
