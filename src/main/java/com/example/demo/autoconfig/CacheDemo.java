package com.example.demo.autoconfig;

public class CacheDemo<K, T> {

  public static void main(String[] args) {
    CacheDemo<String, String> cacheDemo = new CacheDemo<>(5);
    for (int i = 1; i < 10; i++) {
      cacheDemo.put(String.valueOf(i), String.valueOf(i));
      System.out.println(cacheDemo.toString());
    }
    System.out.println(cacheDemo.get("9"));
  }

  public void put(K k, T val) {
    Node<K, T> node = new Node<>(k, val, null, null);
    ;
    if (size == 0) {
      first = node;
    } else if (size == 1) {
      last = node;
      first.next = last;
      last.pre = first;
    } else {
      Node oldLast = last;
      oldLast.next = node;
      node.pre = oldLast;
      last = node;
    }
    if (size >= maxSize) {
      Node newFirst = first.next;
      newFirst.pre = null;
      first = newFirst;
    } else {
      size++;
    }
  }

  public T get(K k) {
    Node<K, T> result;
    if ((result = this.first) == null) {
      return null;
    }
    do {
      if (result.key.equals(k)) {
        return result.item;
      }
    } while ((result = result.next) != null);
    return null;
  }

  public CacheDemo(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public String toString() {
    return "CacheDemo{" +
        "first=" + (first == null ? null : first.toString()) +
        ", last=" + (last == null ? null : last.toString()) +
        ", size=" + size +
        ", maxSize=" + maxSize +
        '}';
  }

  private Node<K, T> first;
  private Node<K, T> last;
  private int size;
  private int maxSize;

  public Node<K, T> getFirst() {
    return first;
  }

  public void setFirst(Node<K, T> first) {
    this.first = first;
  }

  public Node<K, T> getLast() {
    return last;
  }

  public void setLast(Node<K, T> last) {
    this.last = last;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }

  private class Node<K, T> {
    private K key;
    private T item;
    private Node<K, T> pre;
    private Node<K, T> next;

    public Node(K key, T item, Node<K, T> pre, Node<K, T> next) {
      this.key = key;
      this.item = item;
      this.pre = pre;
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node{" +
          "key=" + key +
          ", item=" + item +
          '}';
    }

    public K getKey() {
      return key;
    }

    public void setKey(K key) {
      this.key = key;
    }

    public T getItem() {
      return item;
    }

    public void setItem(T item) {
      this.item = item;
    }

    public Node<K, T> getPre() {
      return pre;
    }

    public void setPre(Node<K, T> pre) {
      this.pre = pre;
    }

    public Node<K, T> getNext() {
      return next;
    }

    public void setNext(Node<K, T> next) {
      this.next = next;
    }
  }
}
