package com.interview.prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PreparationLevel3
{
	public static void main(String[] args)
	{
		int[] arr= {1,2,3,4,5,6,2,3,1,6};
		int[] arr1= {0,1,2,3,4,5,4,0,5,4,0,5,6};
		displayingOnlyDuplicatesNormal(arr);
		displayingOnlyDuplicatesMap(arr);
		movingZerosToEnd(arr1);
		balancingBrackets("{([])}");
		removingSpecialCharacters("*^HEL&*LO^# W&O*R#LD");
		specialCharacterCount("*^HEL&*LO^# W&O*R#LD");
	}
	public static void displayingOnlyDuplicatesNormal(int[] arr)
	{
		Arrays.sort(arr);
		int[] result=new int[arr.length];
		int count=0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==arr[i+1])
			{
				result[count]=arr[i];
				count++;
			}
		}
		arr=new int[count];
		for(int i=0;i<count;i++)
		{
			arr[i]=result[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void displayingOnlyDuplicatesMap(int[] arr)
	{
		Map<Integer,Integer> map=new HashMap<>();
		for(int element:arr)
		{
			if(map.containsKey(element))
			{
				map.put(element, map.get(element)+1);
			}
			else {
				map.put(element, 1);
			}
		}
		for(java.util.Map.Entry<Integer, Integer> entry:map.entrySet())
		{
			if(entry.getValue()==2)
			{
				System.out.print(entry.getKey()+" ");
			}
		}
		System.out.println();
	}
	public static void movingZerosToEnd(int[] arr)
	{
		int count=0;
		int[] result=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)
			{
				result[count]=arr[i];
				count++;
			}
		}
		System.out.println(Arrays.toString(result));
	}
	public static void balancingBrackets(String name)
	{
		Stack<Character> stack=new Stack<>();
		boolean isBalancing=false;
		for(char ch:name.toCharArray())
		{
			if(ch=='{' || ch=='(' || ch=='[')
			{
				stack.push(ch);
			}
			else if(ch== '}' && !(stack.isEmpty()) && stack.peek()=='{')
			{
				stack.pop();
				isBalancing=true;
			}
			else if(ch== ']' && !(stack.isEmpty()) && stack.peek()=='[')
			{
				stack.pop();
				isBalancing=true;
			}
			else if(ch== ')' && !(stack.isEmpty()) && stack.peek()=='(')
			{
				stack.pop();
				isBalancing=true;
			}
			else
			{
				isBalancing=false;
			}
		}
		System.out.println(isBalancing?"Paranthesis balanced":"paranthesis not balanced");
	}
	public static void removingSpecialCharacters(String name)
	{
		String result=name.replaceAll("[^a-zA-Z0-9 ]","");
		System.out.println(result);
	}
	public static void specialCharacterCount(String name)
	{
		String result=name.replaceAll("[^a-zA-Z0-9]","");
		int count=name.length()-result.length();
		System.out.println(count);
	}
	

}
