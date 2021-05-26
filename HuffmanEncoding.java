package algorithms;
import java.util.*;
class Node{
    int freq;
    char val;
    String ans="";
    Node right,left;
    Node(char val,int freq){
        this.freq=freq;
        this.val=val;
    }
}
class LNode{
    Node data;
    LNode next;
    LNode(Node data){
        this.data=data;
    }
}
public class HuffmannCoding {
    LNode head=null,temp,old,n;
    void insert(char c,int freq){
        temp=old=head;
        n=new LNode(new Node(c,freq));
        if(head==null){
            head=n;
        }
        else{
            if(head.data.freq>freq){
                n.next=head;
                head=n;
            }
            else{
                while(temp!=null && temp.data.freq<=freq){
                    old=temp;
                    temp=temp.next;
                }
                old.next=n;
                n.next=temp;
            }
        }
    }
    void insertNode(LNode n){
        temp=head;
        if(head==null){
            head=n;
        }
        else{
            if(head.data.freq>n.data.freq){
                n.next=head;
                head=n;
            }
            else{
                while(temp!=null && temp.data.freq<=n.data.freq){
                    old=temp;
                    temp=temp.next;
                }
                old.next=n;
                n.next=temp;
            }
        }
    }
    void display(){
        temp=head;
        while(temp!=null){
            System.out.println(temp.data.val+" "+temp.data.freq);
            temp=temp.next;
        }
        System.out.println();
    }
    void start(){
        while(head.next!=null){
            temp=head;
            LNode first,second;
            first=temp;
            second=temp.next;
            head=head.next.next;
            first.next=second.next=null;
            n=new LNode(new Node(' ',first.data.freq+second.data.freq));
            n.data.left=first.data;
            n.data.right=second.data;
            this.insertNode(n);
        }
    }
    void preOrderTraversal(Node temp){
        if(temp==null){
            return;
        }
        this.preOrderTraversal(temp.left);
        System.out.println("Data->"+temp.val);
        this.preOrderTraversal(temp.right);
    }
    public static void main(String[] args) {
        HuffmannCoding obj=new HuffmannCoding();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the string : ");
        String input=scanner.nextLine();
        LinkedHashMap<Character,Integer> d=new LinkedHashMap<Character,Integer>();
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(d.get(c)==null){
                d.put(c,1);
            }
            else{
                d.replace(c,(Integer)d.get(c)+1);
            }
        }
        for(Character c:d.keySet()){
            obj.insert(c,d.get(c));
        }
        obj.start();
        obj.display();
        obj.preOrderTraversal(obj.head.data);
    }
}
