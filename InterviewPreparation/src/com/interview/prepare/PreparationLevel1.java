package com.interview.prepare;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PreparationLevel1 
{
	public static PreparationLevel1 level1;
	private PreparationLevel1() {
	}
	public static PreparationLevel1 getInstance()
	{
		if(level1==null)
		{
			level1=new PreparationLevel1();
		}
		return level1;
	}
	public static void main(String[] args) {
		sencondNonOccuringUsingMap("pprrasanth");
		sencondNonOccuring("PRASANTHP");
		Integer[] arr= {10,2,3,4,2,4,4,6,77,6,8};
		removingDuplicatesUsingSet(arr);
		removingDuplicates(arr);
		removingDuplicatesFromString("aabbccddee");
		PreparationLevel1 level1=getInstance();
		PreparationLevel1 level12=getInstance();
		System.out.println(level1==level12?"Objects are same":"Objects are not same");
		noOfOccurancesOfString("aabbccddefg");
		removingWhiteSpaces1("prasanth kumar chennuri");
		removingWhiteSpaces2("prasanth kumar chennuri");
		removingSpecialCharacters("&%#go&LHJBWLY#%hkdsb");
		reversingString1("helloWorld");
		reversingString2("helloWorld");
		Integer[] arr1= {10,3,4,5,6,6};
		reversingArray(arr1);
		fabnocciSeries();
		palindromeNumbers(121);
		palindromeString("helloworld");
		
	}
	public static void sencondNonOccuringUsingMap(String name)
	{
		int count=3;
		char result=0;
		Map<Character, Integer> map=new LinkedHashMap<>();
		for(char ch:name.toCharArray())
		{
			if (map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, val + 1);
			} else {
				map.put(ch, 1);
			}
		}
		for(java.util.Map.Entry<Character, Integer> entry:map.entrySet())
		{
			if (entry.getValue() == 1) {
				if (count - 1 != 0) {
					count--;
				} else {
					result = entry.getKey();
					break;
				}
			}
		}
		System.out.println(result==0?"2nd non occuring character not found":"2nd non occuring character "+result);
	}
	public static void sencondNonOccuring(String name)
	{
		int nthcharacter = 2;

		char result = 0;
		for (int i = 0; i < name.length(); i++) {
			int count = 0;
			for (int j = 0; j < name.length(); j++) {
				if (i != j) {
					if (name.charAt(i) == name.charAt(j)) {
						break;
					} else {
						count++;
					}
				}
			}
			if (count == name.length() - 1) {
				if ((nthcharacter - 1) == 0) {
					result = name.charAt(i);
					break;
				} else {
					nthcharacter--;
				}

			}
		}
		System.out.println(result == 0 ? "character not found" : "character "+nthcharacter+" non occuring character "+result);
	}
	public static void removingDuplicatesUsingSet(Integer[] arr)
	{
		Set<Integer> set=new HashSet<>(Arrays.asList(arr));
		int[] result=new int[set.size()];
		int temp=0;
		for(int element:set)
		{
			result[temp]=element;
			temp++;
		}
		
		System.out.println("The non duplicate Array is:"+Arrays.toString(result));
	}
	public static void removingDuplicates(Integer[] arr)
	{
		arr=bubbleSort(arr);
		int[] result=new int[arr.length];
		int count=0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]!=arr[i+1])
			{
				result[count]=arr[i];
				count++;
			}
			
		}
		if(arr[arr.length-1]!=arr[arr.length-2])
		{
			result[count]=arr[arr.length-1];
		}
		System.out.println(Arrays.toString(result)+" "+count);
		arr=new Integer[count+1];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=result[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	public static Integer[] bubbleSort(Integer[] arr)
	{
		//{1,2,3,4}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				int temp;
				if(arr[i] > arr[j])
				{
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		return arr;
	}
	public static void removingDuplicatesFromString(String name)
	{
		
		StringBuffer sb=new StringBuffer();
		for(char ch:name.toCharArray())
		{
			if(!(String.valueOf(sb).contains(String.valueOf(ch))))
			{
				sb.append(ch);
			}
		}
		System.out.println("String without duplicates: "+sb);
	}
	public static void noOfOccurancesOfString(String name)
	{
		Map<Character, Integer> map=new LinkedHashMap<>();
		for(char ch:name.toCharArray())
		{
			if(map.containsKey(ch))
			{
				int val=map.get(ch);
				map.put(ch, val+1);
			}
			else
			{
				map.put(ch, 1);
			}
		}
		System.out.println("No of occurances:["+map+"]");
	}
	public static void removingWhiteSpaces1(String name)
	{
		String result=null;
		result=name.replace(" ", "");
		System.out.println(result);
	}
	public static void removingWhiteSpaces2(String name)
	{
		StringBuffer sb=new StringBuffer();
		for(char ch:name.toCharArray())
		{
			if(ch !=' ')
			{
			    sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}
	public static void removingSpecialCharacters(String name)
	{
		String result=null;
		result=name.replaceAll("[^a-zA-Z0-9]","");
		System.out.println(result);
	}
	public static void reversingString1(String name)
	{
		StringBuffer sb=new StringBuffer(name);
		String result=sb.reverse().toString();
		System.out.println(result);
	}
	public static void reversingString2(String name)
	{
		String result ="";
		for(int i=name.length()-1;i>=0;i--)
		{
			
			result=result+String.valueOf(name.charAt(i));
		}
		System.out.println(result);
	}
	public static void reversingArray(Integer[] array)
	{
		Integer[] result=new Integer[array.length];
		for(int i=array.length-1;i>=0;i--)
		{
			result[(array.length-1)-i]=array[i];
		}
		System.out.println(Arrays.toString(result));
	}
	public static void fabnocciSeries()
	{
		int first=0;
		int second=1;
		int temp;
		for(int i=0;i<=10;i++)
		{
			temp=first+second;
			System.out.print(first+" ");
			first=second;
			second=temp;
		}
		System.out.println();
	}
	public static void palindromeNumbers(int number)
	{
		int revNumb=0;
		int originalNumb=number;
		while(number>0)
		{
			revNumb=revNumb*10+number%10;
			number=number/10;
		}
		System.out.println(originalNumb==revNumb?"palindrome":"not palindrome");
	}
	public static void palindromeString(String name)
	{
		StringBuffer sb=new StringBuffer();
		for(int i=name.length()-1;i>=0;i--)
		{
			sb.append(name.charAt(i));
		}
		System.out.println(sb.toString().equals(name)?"palindrome":"Not palindrome");
	}
	
	

}
