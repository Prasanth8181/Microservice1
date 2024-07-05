package com.interview.prepare;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PreparationLevel2
{
	public static void main(String[] args)
	{
		primeOrNot(17);
		changeCase("hello world");
		int[] arr= {10,20,30,40};
		rotateArrayLeft(arr,2);
		int[] arr1= {10,20,30,40,50,60};
		rotateArrayRight(arr1,3);
		leapOrNot(2024);
		armstrongOrNot(10);
		factorialNumber(4);
		stringWordsReverse("prasanth kumar chennuri");
	}
	public static void primeOrNot(int numb)
	{
		int count=0;
		if (numb != 1)
		{
			for (int i = 2; i < numb; i++)
			{
				if(numb%i==0)
				{
					count++;
					break;
				}
			}
			System.out.println(count>0?"Not Prime Number":"Prime Number");
		}
		else
		{
			System.out.println("1 is not prime number");
		}
	}
	public static void changeCase(String name)
	{
		//"hello world"
		String[] arr=name.split(" ");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<arr.length;i++)
		{
			String temp=arr[i];
			for(int j=0;j<temp.length();j++)
			{
				if(j==0)
				{
					char ch=temp.charAt(j);
					sb.append(String.valueOf(Character.toUpperCase(ch)));
				}
				else
				{
					sb.append(temp.charAt(j));
				}
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
	public static void rotateArrayLeft(int[] arr,int n)
	{
		//{10,20,30,40}
		//{30,40,10,20}
		for(int i=0;i<n;i++)
		{
			int temp=arr[0];
			for(int j=0;j<arr.length-1;j++)
			{
				arr[j]=arr[j+1];
			}
			arr[arr.length-1]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void rotateArrayRight(int[] arr,int n)
	{
		//{10,20,30,40}
		//{30,40,10,20}
		for(int i=0;i<n;i++)
		{
			int temp=arr[arr.length-1];
			for(int j=arr.length-1;j>0;j--)
			{
				arr[j]=arr[j-1];
			}
			arr[0]=temp;
			
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void leapOrNot(long year)
	{
		if(year%4==0 && year%400==0 || year%100!=0)
		{
			System.out.println("Leap year");
		}
		else
		{
			System.out.println("Not leap year");
		}
	}
	public static void armstrongOrNot(int number)
	{
		int revNumber=0;
		int cubeSum=0;
		int originalNumb=number;
		while(number!=0)
		{
			revNumber=number%10;
			cubeSum=(int) (cubeSum+Math.pow(revNumber, 3));
			number=number/10;
		}
		System.out.println(originalNumb==cubeSum?"Armstrong number":"Not Armstrong Number");
	}
	public static void factorialNumber(int number)
	{
		int temp=1;
		for(int i=1;i<=number;i++)
		{
			temp=temp*i;
		}
		System.out.println(String.format("Factorial of "+number+" is ["+temp+"]"));
	}
	public static void stringWordsReverse(String name)
	{
		String[] split=name.split(" ");
		StringBuffer sb=new StringBuffer();
		for(int i=split.length-1;i>=0;i--)
		{
			sb.append(split[i]);
			if(i!=0)
			{
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}

}
