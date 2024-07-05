package com.java8Streams;import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class level1Streams 
{
	//Even number
	//Odd number
	//removing duplicates
	//generating highest number
	//getting lowest number
	//getting starts with number
	//getting starts with letter
	//getting the first element in the list
	public static void main(String[] args) {
		stremsEven(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8)));
		stremsOdd(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,45,7,9,54,3,7,5,3,3)));
		removingDuplicates(new ArrayList<Integer>(Arrays.asList(1,2,3,5,6,4,3,5,4,6,3,5,2,2,2,6,3,6,3,6,2)));
		highestNumber(new ArrayList<Integer>(Arrays.asList(1,6,8,3,5,63,636,8,3,8)));
		lowestNumber(new ArrayList<Integer>(Arrays.asList(6,8,3,5,63,636,8,3,8)));
		startsWithforNumbers(new ArrayList<Integer>(Arrays.asList(6,8,11,13,625,15,8,21,10)));
		startsWithforletters(new ArrayList<String>(Arrays.asList("prasanth","kumar","chennuri","hello","kaikaluru")));
		fistElementInList(new ArrayList<Integer>(Arrays.asList(6,8,11,13,625,15,8,21,10)));
		findCountOfElements(new ArrayList<Integer>(Arrays.asList(6,8,11,13,625,15,8,21,10)));
		test();
		test1(100);
	}
	
	public static void stremsEven(ArrayList<Integer> list)
	{
		List<Integer> resultList=new ArrayList<>();
		resultList=list.stream().filter(e->e%2==0).collect(Collectors.toList());
		System.out.println(resultList);
	}
	public static void stremsOdd(ArrayList<Integer> list)
	{
		List<Integer> resultList=new ArrayList<>();
		resultList=list.stream().filter(e->e%2!=0).collect(Collectors.toList());
		System.out.println(resultList);
	}
	public static void removingDuplicates(ArrayList<Integer> list)
	{
		System.out.println(list.stream().distinct().collect(Collectors.toList())); 
	}
	public static void highestNumber(ArrayList<Integer> list)
	{
		System.out.println(list.stream().max(Integer::compare).get()); 
	}
	public static void lowestNumber(ArrayList<Integer> list)
	{
		System.out.println(list.stream().min(Integer::compare).get()); 
	}
	public static void startsWithforNumbers(ArrayList<Integer> list)
	{
		System.out.println(list.stream().map(e->e.toString()).filter(e->e.startsWith("1")).collect(Collectors.toList()));
		System.out.println("1 contain values in sorted order");
		//System.out.println(list.stream().map(e->e.toString()).filter(e->e.startsWith("1")).map(e->Integer.valueOf(e)).sorted().collect(Collectors.toList()));
	}
	public static void startsWithforletters(ArrayList<String> list)
	{
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		System.out.println("starts with k");
		System.out.println(list.stream().sorted().filter(e->e.startsWith("k")).collect(Collectors.toList()));
		//System.out.println(list.stream().min(String::compare).get()); 
	}
	public static void fistElementInList(ArrayList<Integer> list)
	{
		System.out.println(list.stream().findFirst().get()); 
	}
	public static void findCountOfElements(ArrayList<Integer> list)
	{
		System.out.println(list.stream().count()); 
	}
	public static void test()
	{
		int[] array= {1,2,3,4,5,6,7,8};
		int number=0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=i+1;i<array.length;i++)
			{
				if(array[i]>number)
				{
					number=array[i];
				}
			}
		}
		System.out.println("Largest element["+number+"]");
		
	}
	public static void test1(int numb)
	{
		int revNumb=0;
		while(numb>0)
		{
			revNumb=revNumb*10+numb%10;
			System.out.println(revNumb);
			numb=numb/10;
			System.out.println(numb);
		}
		
	}
}
