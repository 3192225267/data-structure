package com.queue;

import java.util.Scanner;

public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
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

class CircleQueue{
    // 数组最大值
    int maxSize;
    // 队列头
    int front;
    // 队列尾
    int rear;
    // 数组
    int [] array;

    // 对象初始化
    public CircleQueue(int arrMaxsize) {
        maxSize  = arrMaxsize;
        array = new int[maxSize];
//        front = 0;    int属性默认值为0，可以不用写
//        rear = 0;
    }

    // 判断当前数组是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
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
        // 直接将数据加入
        array[rear] = data;
        // 将real后移吗，为了防止数组越界，这里需要取模
        rear=(rear+1)%maxSize;
    }

    // 取出数据
    public int getQueue(){
        // 如果队列为空
        if(isNull()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        int value=array[front];
        front=(front+1)%maxSize;    // 将front后移一位
        return value;    // 返回当前的值
    }

    // 显示队列所有数据
    public void showQueue(){
        // 如果队列为空
        if(isNull()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,array[i%maxSize]);
        }
    }

    public int size(){
        return  (rear+maxSize-front)%maxSize;
    }
    // 只显示队列头的数据
    public int showHeadQueue(){
        // 如果队列为空
        if(isNull()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        return array[front];
    }
}
