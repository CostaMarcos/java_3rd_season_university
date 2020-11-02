/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public abstract class Node {

    protected Node left, right;
    protected int numericKey;
    protected String stringKey;
    protected int height;

    protected Node() {
        left = null;
        right = null;
        numericKey = 0;
        stringKey = "";
        height = 0;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * @return the integerKey
     */
    public long getNumericKey() {
        return numericKey;
    }

    /**
     * @param numericKey the integerKey to set
     */
    public void setNumericKey(int numericKey) {
        this.numericKey = numericKey;
    }

    /**
     * @return the stringKey
     */
    public String getStringKey() {
        return stringKey;
    }

    /**
     * @param stringKey the stringKey to set
     */
    public void setStringKey(String stringKey) {
        this.stringKey = stringKey;
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
