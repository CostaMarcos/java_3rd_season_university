/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Benevaldo
 */
public class AVLNode {

    AVLNode left, right;
    int data;
    int height;

    /* Constructor */
    public AVLNode() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    public void deleteNode(AVLNode r){
        r = null;
    }
    
    /* Constructor */
    public AVLNode(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }

    /**
     * @return the left
     */
    public AVLNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(AVLNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public AVLNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(AVLNode right) {
        this.right = right;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

}
