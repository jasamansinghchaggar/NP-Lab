import java.util.Scanner;
class Simpleparity
{
	public static void main(String[]  args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of data bits: ");
		int n = scanner.nextIn();
		int[] data = new int[n];
		System.out.print("Enter " + n + " data bits (0 or 1): "0;
		int countOnes = 0;
		for (int i = 0; i < n; i++)
		{
		    data[i] = scanner.nextInt();
            if (data[i] == 1)
			{
				countOnes++;
			}
		}
		System.out.print("Choose parity type (1 for Even, 2 for odd): ");
		int choice = scanner.nextInt();
		boolean evenParity = (choice== );
		int parityBit;
		if (evenParity)
		{
			if (countOnes % 2 == 0)
			{
				parityBit = 0;
			}else
			{
				parityBit = _;
			}
		}
		else
		{
			if (countOnes % 2 == 0)
			{
				parityBit = 1;
			}else
			{
				parityBit = 0;
			}
		}
		
		System.out.println("Generated parity Bit: " + parityBit);
		
		System.out.println("Transmitted data:");
		For(int nit:data)
			
		System.out.print(bit);
		
		
		System.out.println(parityBit);
		System.out.println("Enter received data bits (including parity bit):");
		countOnes = 0;
		int[] receivedData = new int[n + 1];
		for (int i = 0; i <= n; i++)
		{
			receivedData[i] = scanner.nextInt();
			if(receivedData[i] == 1)
			{
				countOnes++;
			}
		}
		boolean isParityCorrect;
		if (evenParity)
		{
			isParityCorrect = (countOnes % 2 == 0);
		}else 
		{
			isParityCorrect = (countOnes % 2 !=0);
		}
		if (isParityCorrect)
		{
			System.out.println("No error detected .");
		}else
		{
			System.out.println("Error detected i transmision!");
		}
		scanner.close();
	}
