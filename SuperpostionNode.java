package cn.list;

/**
 * @ClassName SuperpostionNode
 * @Description 判断两个链表是否有重合的结点，若无返回null;存在返回该结点
 * @Auther danni
 * @Date 2019/7/27 17:36]
 * @Version 1.0
 **/

public class SuperpostionNode {
    public int length(Node head){
        int num=0;
        Node n=head;
        while(n!=null){
            num++;
            n=n.next;
        }
        return num;
    }
    public Node getintersectionNode(Node na,Node nb){
        int len_a=this.length(na);
        int len_b=this.length(nb);
        int diff=0;
        if(len_a==len_b){
            return null;
        }
        if(len_a>len_b){
            diff=len_a-len_b;
            while(diff!=0){
                na=na.next;
                diff--;
            }
        }else{
            diff=len_b-len_a;
            while(diff!=0){
                nb=nb.next;
                diff--;
            }
        }
        while(na!=null&&nb!=null){
                na=na.next;
                nb=nb.next;
                if(na==nb){
                    return na;
                }else if(na==null||nb==null){
                    return null;
                }
            }
        return null;
    }
    public static void main(String[] args) {
        Node temp=new Node(1);
        temp.next=new Node(2);
        temp.next.next=new Node(3);
        temp.next.next.next=new Node(4);
        temp.next.next.next.next=new Node(6);
        Node node=new Node(5);
        node.next=temp.next.next.next;
        SuperpostionNode sp=new  SuperpostionNode();
        System.out.println(sp.getintersectionNode(temp,node).data);
    }
}
