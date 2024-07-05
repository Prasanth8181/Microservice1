package com.interview.prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class IntelizignInterviewPreparation 
{
	public static void main(String[] args)
	{
		int[] arr= {1,5,7,4,8,3,2,3,5};
		Integer[] arr1= {5,12,7,7,6,4,7,3,8,3,3,83,5,3,3,2,1};
		removingDuplicatesFromArray(arr);
		removingDuplicatesFromCollections(arr1);
		removingDuplicatesString("aabbcc");
		removingWhiteSpacesFromString("Prasanth Kumar Chennuri");
		removingSpecialCharacterFromString("#@%%^(&P^$^R%#A%#S%#%A%#N%#%T##H");
		noOfOccurancesInAString("prasanthkumar");
		findNthOccuranceElement("aabc",1);
		findNthOccuranceElementUsingCollection("PPRASANTH",2);
	}
	public static void removingDuplicatesFromArray(int[] arr)
	{
		bubbleSort(arr);
		int[] resultArray=new int[arr.length];
		int count=0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]!=arr[i+1])
			{
				resultArray[count]=arr[i];
				count++;
			}
		}
		if(arr[arr.length-1]!=resultArray[count-1])
		{
			resultArray[count]=arr[arr.length-1];
		}
		arr=new int[count];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=resultArray[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void removingDuplicatesFromCollections(Integer[] arr)
	{
		Set<Integer> set=new HashSet<Integer>(Arrays.asList(arr));
		System.out.println(set);
	}
	public static int[] bubbleSort(int [] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				int temp=arr[i];
				if(arr[i]>arr[j])
				{
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	public static void removingDuplicatesString(String str)
	{
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();i++)
		{
			if(!(sb.toString().contains(String.valueOf(str.charAt(i)))))
			{
				sb.append(str.charAt(i));
			}
		}
		System.out.println(sb.toString());
	}
	public static void removingWhiteSpacesFromString(String str)
	{
		String result=str.replace(" ", "");
		System.out.println(result);
	}
	public static void removingSpecialCharacterFromString(String str)
	{
		String result=str.replaceAll("[^a-zA-Z ]", "");
		System.out.println(result);
	}
	public static void noOfOccurancesInAString(String str)
	{
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(char ch:str.toCharArray())
		{
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch)+1);
			}
			else
			{
				map.put(ch, 1);
			}
		}
		System.out.println(map);
	}
	public static void findNthOccuranceElement(String str,int NthElement)
	{
		int NthElementCount=0;
		char result = 0;
		for(int i=0;i<str.length();i++)
		{
			int count=0;
			for(int j=0;j<str.length();j++)
			{
				if(i!=j)
				{
					if(str.charAt(i)==str.charAt(j)) {
						break;
					}
					else
					{
						count++;
					}
				}
			}
			if(count==str.length()-1)
			{
				result=str.charAt(i);
				NthElementCount++;
				if(NthElementCount==NthElement)
				{
					break;
				}
			}
			
		}
		System.out.println(result!=0?"The "+NthElement+" non occuring element is ["+result+"]":"No value found");
		
	}
	public static void findNthOccuranceElementUsingCollection(String str, int nthElement)
	{
		int count=0;
		Map<Character, Integer> map=new LinkedHashMap<Character, Integer>();	
		for(char ch:str.toCharArray())
		{
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch)+1);
			}
			else
			{
				map.put(ch, 1);
			}
		}
		for(Entry<Character, Integer> entry:map.entrySet())
		{
			
			if(entry.getValue()==1)
			{
				count=count+1;
				if(count==nthElement)
				{
					System.out.println("The "+nthElement+" non occuring element is ["+entry.getKey());
				}
			}
		}
	}
	

}
