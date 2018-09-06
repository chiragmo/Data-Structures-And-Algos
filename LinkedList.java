 /* This is a non-strict api based implementation of linked lists in java.
    Dont miss out the function swapIndexesValue, its really cool on data heavy linked list.
    
     The following methods are available for use:
   1. printList() ->prints all the values in the list
   2. listSize() ->returns the total number of elements
   3. isEmpty() ->return boolean if linkedList empty or not
   4. isPresent(anyNumberToBeCheckedIfPresentInListOrNot) ->return boolean
   5. insertTail(numberToBeInstertedAtTheEndOfList)
   6. insertAtIndex(numberToBeInserted, indexPosition)
   7. deleteAtIndex(indexPositionAtWhichNumberToBeDeleted)
   8. deleteValue(numberToBeDeletedInLinkedList)
   9. swapIndexesValue(lowerIndex, higherIndex) ->It does not swap the data. The references to the given index position changes in the linked list changes.
      Condition of Usage ? If each element is very data heavy, copying is time consuming.
      swapIndexesValue is used in such cases wherein only references to the elements changes.


 */
 
 class Node{
    int data;
    Node next;
}

 class LinkedList{
    static Node head = null;
    
    public static void printList() {
          Node findme = head;
        while(findme !=null) {
            System.out.println(findme.data);
            findme = findme.next;
        }
    }
    
    public static int listSize() {
            int i = 0;
          Node findme = head;
        while(findme !=null) {
            findme = findme.next;
            i++;
        }
        return i;
        
    }
    
   public static boolean isEmpty() {
    if(head == null){
        return true;
    }
    else return false;
    }
    
    public static boolean isPresent(int number) {
        Node findme = head;
        while(findme !=null) {
            if(findme.data == number) {
            return true;
            } 
            findme = findme.next;
        }
        return false;
    }
    
    public static void insertTail(int number) {
    Node n = new Node();
    n.data = number;
    n.next = null;
    if(head == null) {
        head = n;
    }
    else {
        Node findme = head;
        while(findme.next !=null) {
            findme = findme.next;
        }
        findme.next = n;
    }
    }
    
    public static void insertAtIndex(int number, int index) {
    Node n = new Node();
    n.data = number;
    n.next = null;
    
        int i = 0;
        Node findme = head;
        Node originalRefNode;
        if(index == 0) {
            head = n;
            head.next = findme;
        }
        else {
        while(findme.next !=null) {
            if(i == index) {
                originalRefNode = findme.next;
                findme.next = n;
                n.next = originalRefNode;
                break;
            }
            findme = findme.next;
            i++;
        }
        findme.next = n;
        }
    }
    
     public static void deleteAtIndex(int index) {
        int i = 1;
        Node findme = head;
        Node originalRefNode;
        int flag =0 ;
        if(index == 0) {
            head = head.next;
            flag++;
        }
        else {
        while(findme.next !=null) {
            originalRefNode = findme.next;
            if(i == index) {
                findme.next = originalRefNode.next;
                flag++;
                break;
            }
            findme = findme.next;
            i++;
        }
        if(flag == 0 ) {
        findme.next = null;
        }
        }
    }
    
    public static void deleteValue(int number) {
        Node findme = head;
        Node originalRefNode;
        int flag =0 ;
        if(findme.data == number) {
            head = head.next;
            flag++;
        }
        else {
        while(findme.next !=null) {
            originalRefNode = findme.next;
            if(findme.next.data == number) {
                findme.next = originalRefNode.next;
                flag++;
                break;
            }
            findme = findme.next;
        }
        if(flag == 0 ) {
        findme.next = null;
        }
        }
    }
    
    public static void swapIndexesValue(int index1, int index2) {
       Node findme = head;
       Node prev = null;
       int i = 0;
       int flag = 0;
       Node storePrevAdd_1 = null;
       Node storePrevAdd_2 = null;
       Node foundAdd_1 = null;
       Node foundAdd_2 = null;
       Node storeNextAdd_1 = null;
       Node storeNextAdd_2 = null;
       
       while(findme != null) {
 
           if(flag == 1 && (i == index1 || i == index2 )) {
                storePrevAdd_2 = prev;
               foundAdd_2 = findme;
               storeNextAdd_2 = findme.next; 
               flag++;
           }
           
           if(flag == 0 && (i == index1 || i == index2 )) {
               storePrevAdd_1 = prev;
               foundAdd_1 = findme;
               storeNextAdd_1 = findme.next;
               flag++;
           }
          prev = findme;
          findme = findme.next;
          i++;
       }
       
       if(storePrevAdd_1 == null && (index1 == index2+1 || index2 == index1+1)) {
           head = foundAdd_2;
           foundAdd_2.next = foundAdd_1;
           foundAdd_1.next = storeNextAdd_2;
       }
    else if(storePrevAdd_1 == null) {
        head = foundAdd_2;  
        foundAdd_2.next = storeNextAdd_1;
       storePrevAdd_2.next =  foundAdd_1;
       foundAdd_1.next = storeNextAdd_2;
    }
    
    else {
       storePrevAdd_1.next =  foundAdd_2;
       foundAdd_2.next = storeNextAdd_1;

       storePrevAdd_2.next =  foundAdd_1;
       foundAdd_1.next = storeNextAdd_2;
    }
    }
 }

public class LinkedList{

     public static void main(String []args){
        
        LinkedList li = new LinkedList();
        // some examples of using the functions listed
        System.out.println("present: "+li.isPresent(2));
        li.insertTail(1);
        System.out.println("present: "+li.isPresent(2));
         li.insertTail(2);
         li.insertTail(3);
         li.insertTail(4);
         li.insertTail(5);
         li.insertAtIndex(10,5);
        li.printList();
        li.deleteAtIndex(5);
        li.deleteValue(10);
        System.out.println("size: "+li.listSize());
        li.swapIndexesValue(0,2);
        li.printList();
     }
}

