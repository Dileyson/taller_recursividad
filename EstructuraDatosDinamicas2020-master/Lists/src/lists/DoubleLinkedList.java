/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author samaniw
 */
public class DoubleLinkedList<T extends Number & Comparable<T>> implements Ilist<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoubleLinkedList() {
        head = tail = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Determinar si un dato ingresado por el usuario existe en la lista.
     * @param d Dato a buscar
     * @return Verdadero si lo encuentra
     */
    public boolean exist(T d){
    	for (DoubleNode<T> i = head; i != null; i = i.getNextNode()) {
    		if(d.intValue()==i.getData().intValue()) {
    			return true;
    			}         
        }       
        return false;
    }

    @Override
    public void add(T d) {

        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            DoubleNode<T> newNode = new DoubleNode<>(null, d, head);
            head.setPreviousNode(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            DoubleNode<T> newNode = new DoubleNode<>(tail, d, null);
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addOrdered(T d) {

        if (isEmpty() || head.getData().compareTo(d) > 0) {
            add(d);
            return; 
        }

        if (tail.getData().compareTo(d) < 0) {
            addLast(d);
            return;
        }

        DoubleNode<T> current = head;
        while (current.getData().compareTo(d) < 0) {
            current = current.getNextNode();
        }
        DoubleNode<T> anterior = current.getPreviousNode();
        DoubleNode<T> newNode = new DoubleNode<>(anterior, d, current);
        anterior.setNextNode(newNode);
        current.setPreviousNode(newNode);
        size--;
    }

    @Override
    public void delete() {
    	if (isEmpty()) {
            System.out.println("Lista vacia");
    	}else if (head == tail) {
            head = tail = null;
    	}else {
    		head.getNextNode().setPreviousNode(head);
    		head = head.getNextNode();
    	}
    	size--;
    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else if (head == tail) {
            head = tail = null;
        } else {
            
            tail.getPreviousNode().setNextNode(null);
            tail = tail.getPreviousNode();
        }
        size--;

    }

    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String data = "";
            for (DoubleNode<T> i = head; i != null; i = i.getNextNode()) {
                data += i.getData() + " ";
            }
            return data;

        }
        
    }

    
    public int getSize() {
        return size;
    }

}
