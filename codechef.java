package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeChef{
    public static void main (String[] args)
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of values : ");

            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {

                arr[i] = sc.nextInt();
            }

            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            Queue<Integer> q = new java.util.LinkedList<>();

            for (int i = 0; i < n; i++) {

                if (s1.isEmpty() || arr[i] < s1.peek()) {

                    s1.push(arr[i]);
                    printList(s1, s2, q);
                } else if (s2.isEmpty() || arr[i] > s2.peek()) {

                    s2.push(arr[i]);
                    printList(s1, s2, q);
                } else {

                    if (Math.abs(arr[i] - s1.peek()) < Math.abs(arr[i] - s2.peek())) {

                        while (arr[i] >= s1.peek()) {

                            q.offer(s1.pop());

                        }

                        s1.push(arr[i]);
                        printList(s1, s2, q);


                        while (!q.isEmpty()) {

                            int a = q.poll();
                            q.offer(a);
                            s1.push(q.poll());

                        }
                    } else {

                        while (arr[i] <= s2.peek()) {

                            q.offer(s2.peek());
                            s2.pop();
                            if(s2.isEmpty())
                                break;

                        }

                        s2.push(arr[i]);
                        printList(s1, s2, q);

                        while (!q.isEmpty()) {

                            int b = q.poll();
                            q.offer(b);
                            s2.push(q.poll());

                        }

                    }


                }
            } //for loop ends

            Queue<Integer> q1 = new java.util.LinkedList<Integer>();

            //reversing s2

            while (!s2.isEmpty()) {

                q1.offer(s2.pop());
                printList(s1, s2, q);


            }

            while (!q1.isEmpty()) {

                s2.push(q1.poll());
                printList(s1, s2, q);
            }

            //checking s1 and s2 and enqueueing in q

            int SIZE = n;

            while (SIZE-- > 0) {

                while (!s1.isEmpty() && !s2.isEmpty()) {

                    if (s1.peek() > s2.peek()) {

                        q.offer(s2.pop());
                        printList(s1, s2, q);
                    } else {

                        q.offer(s1.pop());
                        printList(s1, s2, q);
                    }
                }

                if (s1.isEmpty()) {

                    q.offer(s2.pop());
                    printList(s1, s2, q);
                }

                if (s2.isEmpty()) {

                    q.offer(s1.pop());
                    printList(s1, s2, q);
                }
            }

        }catch(Exception e){
            return;
        }
    }

    static void printList(Stack <Integer> s1,Stack<Integer>s2,Queue <Integer> q)
    {
        Iterator iterator = q.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        Stack<Integer> clone1 = (Stack<Integer>)s1.clone();
        Stack<Integer> clone2 = (Stack<Integer>)s2.clone();

        while(!clone1.isEmpty())
        {
            System.out.print(clone1.pop()+" ");
        }
        System.out.println();
        while(!clone2.isEmpty())
        {
            System.out.print(clone2.pop()+" ");
        }
        System.out.println();
    }
}

