import util.Utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class Main {


    public static void main(String[] args) {

        Utils.waitForSeconds(1);


        int arr[] = {1,2,3};

        try {
            System.out.println(arr[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (NullPointerException t){
            t.printStackTrace();
        }catch (NoSuchElementException n){

        }catch (Exception r){
            r.printStackTrace();
        }



        System.out.println("Kod se izvrsava dalje......");


    }




}
