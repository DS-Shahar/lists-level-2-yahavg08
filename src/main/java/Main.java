import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = {5, 8, 1, 12, 6,8, 9};
        int[] arr1 = {10, 22, 33, 40, 50, 60, 70};

       Node<Integer> L1 = buildList(arr);
       Node<Integer> L2 = buildList(arr1);


      System.out.println("ex1:" + ex1(L1, L2));
      System.out.println("ex2:" + ex2(L1));
      System.out.println("ex3:" + ex3(L1, 8));
      System.out.println("ex4:" + ex4(L1));
      System.out.println("ex5:" + ex5(L1));
    }

    public static Node<Integer> buildList(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> current = head;
        for (int i = 1; i < arr.length; i++) {
            current.setNext(new Node<>(arr[i]));
            current = current.getNext();
        }
        return head;
    }
    
    public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2) {
    		    Node<Integer> dummy = new Node<>(-1);
    		    Node<Integer> current = dummy;

    		    while (l1 != null && l2 != null) {
    		        if (l1.getValue() <= l2.getValue()) {
    		            current.setNext(l1);
    		            l1 = l1.getNext();
    		        } else {
    		            current.setNext(l2);
    		            l2 = l2.getNext();
    		        }
    		        current = current.getNext();
    		    }

    		    if (l1 != null) {
    		        current.setNext(l1);
    		    } else if (l2 != null) {
    		        current.setNext(l2);
    		    }
    		    return dummy.getNext();
    	 }
    	 
    	 
    	 
    	 public static Node<Integer> ex2(Node<Integer> head) {
    		    if (head == null || head.getNext() == null) {
    		        return head;
    		    }

    		    Node<Integer> current = head;
    		    Node<Integer> next = null;
    		    int temp;

    		    while (current != null) {
    		        next = current.getNext();
    		        while (next != null) {
    		            if (current.getValue() > next.getValue()) {
    		                temp = current.getValue();
    		                current.setValue(next.getValue());
    		                next.setValue(temp);
    		            }
    		            next = next.getNext();
    		        }
    		        current = current.getNext();
    		    }

    		    return head;
    		}
    	 public static int ex3(Node<Integer> L1, int num) {
    		    int count = 0, temp = 0;
    		    while (L1 != null) {
    		        if (L1.getValue() != num) {
    		            count++;
    		        } else {
    		            temp += count;
    		            count = 0;
    		        }
    		        L1 = L1.getNext();
    		    }
    		    if (temp == 0) {
    		        return -1;
    		    }
    		    return temp;
    		}
    	 public static boolean ex4(Node<Integer> L1) {
    		 boolean flag= true;
    		 Node<Integer> current = L1;
 		     Node<Integer> next = null;
    		 while (current!= null) {
    			 next = current.getNext();
    			 while (next!= null) {
    			  if (current.getValue().equals(next.getValue())) {
    				 return false;
    			 }
    			 next= next.getNext();
    		 }
    			 current=current.getNext();
    		 }
    		 return true;
    	 }
    	 
    	 public static Node<Integer> ex5(Node<Integer> L1) {
    		    if (L1 == null || L1.getNext() == null) {
    		        return L1;
    		    }
    		    Node<Integer> current = L1;
    		    while (current != null) {
    		        Node<Integer> runner = current;
    		        while (runner.getNext() != null) {
    		            if (current.getValue().equals(runner.getNext().getValue())) {
    		                runner.setNext(runner.getNext().getNext());
    		            } else {
    		                runner = runner.getNext();
    		            }
    		        }
    		        current = current.getNext();
    		    }
    		    return L1;
    		}
}
