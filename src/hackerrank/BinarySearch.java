/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Shabab
 */

//1 4 5 1 4 5 3 2
//4
//4
//2 2 4 3
public class BinarySearch {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            Item a[] = new Item[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = new Item(in.nextInt(), a_i + 1);
            }
            match(m, a);
        }
    }
    
    public static void match(int money, Item[] array)
    {
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));
        int limit = money / 2;
        int searchMoney = money - 1;
        while(searchMoney >= limit)
        {
            ItemWrapper wrapperLeftFactor = binarySearch(0, array.length - 1, searchMoney, array);
            
            if(wrapperLeftFactor != null)
            {
                int pos = wrapperLeftFactor.getSortArrayPosition();
                Item[] mArray = new Item[array.length - 1];
                //System.out.println("pos is " + pos);
                for(int c = 0, i = 0; c < array.length; )
                {
                    if(c != pos)
                    {
                        mArray[i] = array[c];
                        i++;
                    }
                    c++;
                }
                
                //System.out.println("Found " + searchMoney + " at " + wrapperLeftFactor.getSortArrayPosition());
                int leftOver = money - searchMoney;
                ItemWrapper wrapperRightFactor = binarySearch(0, mArray.length - 1, leftOver, mArray);
                if(wrapperRightFactor != null)
                {
                    int leftPos = wrapperLeftFactor.getPosition();
                    int rightPos = wrapperRightFactor.getPosition();
                    System.out.println((leftPos < rightPos? leftPos: rightPos) + " " + (leftPos > rightPos? leftPos: rightPos));
                    break;
                }
            }
            searchMoney--;
        }
    }
    
    static ItemWrapper binarySearch(int left, int right, int val, Item array[])
    {
        if(left >= right)
        {
            if(array[left].getValue() == val)
            {
                return new ItemWrapper(array[left].getValue(), array[left].getPosition(), left);
            }
            return null;
        }
        
        int mid = (left + right) / 2;
        
        if(array[left].getValue() == val)
        {
            return new ItemWrapper(array[left].getValue(), array[left].getPosition(), left);
        }
        
        if(array[right].getValue() == val)
        {
            return new ItemWrapper(array[right].getValue(), array[right].getPosition(), right);
        
        }
        
        if(array[mid].getValue() == val)
        {
            return new ItemWrapper(array[mid].getValue(), array[mid].getPosition(), mid);
        
        }
        
        if(val < array[mid].getValue())
        {
            return binarySearch(left + 1, mid - 1, val, array);
        }
        
        return binarySearch(mid + 1, right - 1, val, array);
    }
    
    
}

class ItemWrapper
{
    private int value;
    private int position;
    private int sortArrayPosition;

    public ItemWrapper(int value, int position, int sortArrayPosition) {
        this.value = value;
        this.position = position;
        this.sortArrayPosition = sortArrayPosition;
    }
    
    

    public int getValue() {
        return value;
    }

    public int getPosition() {
        return position;
    }

    public int getSortArrayPosition() {
        return sortArrayPosition;
    }
    
    
}

class Item implements Comparable<Item>
{
    private int value;
    private int position;

    public Item(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int compareTo(Item o) {
        return  getValue() - o.getValue();
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(getValue());
    }
    
}
