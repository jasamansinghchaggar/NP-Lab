import java.util.Scanner;
public class SimpleParityCheck{
	public static void main(String[]args){
		Scanner scanner=new
		Scanner(System.in);
		
		System.out.print("Enter the number of data bits:");
int n=scaneer.nextInt();
int[]data=new int[n];

System.out.print("Enter"+n+"data bits(0or1:");
int countOnes=0;
for(int i=0; i<n; i++){
data[i]=scaneer.nextInt();
if(data[i]==1){
countOnes++;	
	}
}       


System.out.print(Choose parity type(1 for even,2 for Odd:);
int choice=scaner.nextInt();
boolean evenParity=(choice==1);

int parityBit;
if(evenParity){
	if(countOnes%2==0){
	parityBit=0;}
	eles{
		parityBit=1;
	}
}eles{
	parityBit=0;
}
	}
	
	System.out.printIn("Generated Parity Bits:"+parityBit);
	
	
	System.out.print("Transmitted Data:");
	for(int bit:data){
		System.out.print(bit);
	}
	
	System.out.print("\nEnter received data bits(including parity bit):");
	countOnes=0;
	int[]receivedData=new int[n+1];
	
	for(int i=0;i<=n;i++){
		receivedData[i]=scanner.nextInt();
		System.out.print("\nEnter received data bits(including parity bits):");
		countOnes=0;
		int[]receivedDta=int[n+1];
		
		for(int i=0;i<=n;i++){
			receivedDta[i]=scanner.nextInt();
			if(receivedData[i]==1){
				countOnes++;
		}
		}
		
		boolean isparityCorrect;
		if(evenparity){
		isParityCorrect=(countOnes%2==0);}
		else{
			isParityCorrect=(countOnes%2!=0);
		}
		if(isParityCorrect){
			Systwm.out.println("No error detected in transmission.");
		}
		eles{System.out.print("Error detected in transmission!");
		}
		scanner.close();
	}
}