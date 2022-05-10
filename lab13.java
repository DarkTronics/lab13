import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class lab13 {

	public ArrayList<Integer> list = new ArrayList<>();
	
	public void readData(String filename)
	{
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while((inn = input.readLine()) != null)
			{
				int a = Integer.parseInt(inn);
				list.add(a);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
	public long getTotalCount()
	{
		//Integer[] list3 = list.stream().filter(x -> x != null).toArray(Integer[]::new);
		//System.out.println("list3");
		long a = list.stream().filter(x -> x != null).count();
		return a;
	}
	public long getOddCount()
	{
		//Integer[] list3 = list.stream().filter(x -> x % 2 != 0).toArray(Integer[]::new);
		long a = list.stream().filter(x -> x % 2 != 0).count();
		return a;
	}
	public long getEvenCount()
	{
		//Integer[] list3 = list.stream().filter(x -> x % 2 == 0).toArray(Integer[]::new);
		long a = list.stream().filter(x -> x % 2 == 0).count();
		return a;
	}
	public long getDistinctGreaterThanFiveCount()
	{
		//Integer[] list3 = list.stream().distinct().filter(x -> x > 5).toArray(Integer[]::new);
		long a = list.stream().distinct().filter(x -> x > 5).count();
		return a;
	}
	public Integer[] getResult1()
	{
		Integer[] list3 = list.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
		return list3;
	}
	public Integer[] getResult2()
	{
		Integer[] listSorted = list.stream().map(x -> x*x*3).limit(50).toArray(Integer[]::new);
		return listSorted;
	}
	public Integer[] getResult3()
	{
		Integer[] a = list.stream().filter(x -> x % 2 != 0).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
		return a;
	}
}
