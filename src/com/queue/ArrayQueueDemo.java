package com.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        // 接受用户输入
        char key=' ';
        Scanner scannn = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据");
            System.out.println("g(get)：取出数据");
            System.out.println("h(head)：显示队列头");
            key = scannn.next().charAt(0);// 接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    System.out.println("程序退出~");
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scannn.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    int getValue = queue.getQueue();
                    System.out.println(getValue);
                    break;
                case 'h':
                    int headValue = queue.showHeadQueue();
                    System.out.println(headValue);
                    break;
            }
        }
    }
}
class ArrayQueue{
    // 数组最大值
    int maxSize;
    // 队列头
    int front;
    // 队列尾
    int rear;
    // 数组
    int [] array;

    // 对象初始化
    public ArrayQueue(int arrMaxsize) {
        maxSize  = arrMaxsize;
        array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    // 判断当前数组是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
        // 3 3 1
    }
    // 判断队列是否为空
    public boolean isNull(){
        return rear == front;
    }
    // 添加数据
    public void addQueue(int data){
        if(isFull()){
            System.out.println("队列已满，无法继续添加数据");
            return;
        }
        rear++;
        array[rear] = data;
    }
    // 取出数据
    public int getQueue(){
        // 如果队列为空
        if(isNull()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        front++;    // 将front后移一位
        return array[front];    // 返回当前的值
    }
    // 显示队列所有数据
    public void showQueue(){
        // 如果队列为空
        if(isNull()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,array[i]);
        }
    }

    // 只显示队列头的数据
    public int showHeadQueue(){
        // 如果队列为空
        if(isNull()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        return array[front+1];
    }

    // 查看队列中有效的数据个数
    public int showDataNumber(){
        if(isNull()){
            System.out.println("队列为空");
            return 0;
        }
        return (rear+maxSize-front)%maxSize;
    }
}