package com.interview.prepare;

public class PreparationLevel4 
{
	public static void main(String[] args) 
	{
		findNthNonRepeatingElement("aabbcdeeffgh",2);
	}
	public static void findNthNonRepeatingElement(String name,int NthElement)
	{
		//aabbcdeeffgh
		int nthElement=0;
		for(int i=0;i<name.length();i++)
		{
			int count=name.length()-1;
			for(int j=0;j<name.length();j++)
			{
				if(i!=j)
				{
					if(name.charAt(i)==name.charAt(j))
					{
						break;
					}
					else
					{
						count--;
					}
				}
				if(count==0)
				{
					nthElement++;
				}
			}
			if(count==0 && NthElement==nthElement)
			{
				System.out.println(name.charAt(i));
				break;
			}
			
		}
	}

}
