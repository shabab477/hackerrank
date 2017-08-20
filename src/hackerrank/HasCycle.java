/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author 14101138
 */
public class HasCycle {
    
    boolean hasCycle(Node head) {
    
        Node tort = head;
        Node hare = null;
        if(head != null){
            hare = head.next;

        }else{
            return false;
        }
        while(tort.next != null && hare.next != null && hare.next.next != null)
        {
            if(tort == hare)
                return true;
            tort = tort.next;
            hare = hare.next.next;
        }

        return false;
    }
    
}

class Node {
    int data;
    Node next;
}
