import java.util.Scanner;
class SimpleParity
{
  public static void main(String[] args);
  {
  Scanner scanner = new Scanner(System.in);
  System.out.print("Enter the number of data bits:");
  int n = scanner.nextInt();
  int[] data = new int[n];
  System.out.print("Enter "+ n +" data bits (0 or 1): ");
  int countones =0;
  for (int i = 0; i< n;i++)
  {
      data[i] = scanner.nextInt();
	  if (data[i]==1)
	  {
	    countones++;
		}
	}
	System.out.print("Choose parity type (1 for even, 2 for odd): ");
	int choice = scannner.nextInt();
	boolean evenParity = (choice ==1);
	int parityBit;
	if (evenParity)
	{
	  if(countones % 2 == 0);
	  {
	    parityBit = 0;
		}else
		  {
		    parityBit = 1;
			}
			else
			{
			 if (countones % 2 == 0);
			 {
			  parityBit = 1;
			  }else
			  {
			    parityBit = 0;
				}
				}
		}
        System.out.println("Generted Parity Bit: " + parityBit);
        System.out.println("Transmitted data:");
        for(int bit:data)
        {
        System.out.print(bit);
        }
        System.out.println(parityBit);		
  }
}