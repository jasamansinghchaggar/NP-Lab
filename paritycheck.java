import java.util.Scanner;
class Simpleparity{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("enter the number of data bits: ");
        int n=scanner.nextInt();
        int[] data=new int[n];
        System.out.print("enter "+n+"data bits (0 or 1): ");
        int countOnes=0;
        for(int i=0;i<n;i++){
            data[i]=scanner.nextInt();
            if(data[i]==1){
                countOnes++;
            }
        }
        System.out.print("choose parity type (1 for even,2 for odd): ");
        int choice=scanner.nextInt();
        boolean evenparity=(choice==1);
        int paritybit;
        if(evenparity){
            if(countOnes % 2==0){
                paritybit=0;
            }else{
                paritybit=1;

            }
        }else{
            if(countOnes %2==0){
                paritybit=1;
            }else{ 


            paritybit=0;
        }
    }
    System.out.print("genrated parity bit: "+paritybit);
    System.out.println("transmitted data: ");
    for(int bit:data)

    System.out.println(bit);

    System.out.print("enter receied data bits (including parity bit) : ");
    countOnes=0;
    int[] receviedData= new int [n+1];
    for(int i=0;i<=n;i++){
        receviedData[i]=scanner.nextInt();
        if(receviedData[i]==1){
            countOnes++;
        }
    }
     
     boolean isParityCorrect;
     if(evenParity){
         isParityCorrect=(countOnes%2==0);

     }else{
         isParityCorrect=(countOnes%2!=0);

     }
    if(isParityCorrect){
        System.out.println("no eror detected");
    }else{
        system.out.println("no error dectected.");

    }else{
        System.out.println("error dectected in trasmittion ");

    }
    scanner.close();
}
            }