package com.interview.prepare;

public class Test 
{
	public static void main(String[] args) {
		int year=1800;
		System.out.println(year%4);
		System.out.println(year%400);
		System.out.println(year%100);
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400!=0)
				{
					System.out.println("leap year");
				}
				
			}
		}
	}

}
