package com.funney.funney_android.data;

/**
 * Created by keita on 2017/10/21.
 */

public class Transaction {
    /**
     * 取引データのオブジェクト
     * 仕様がかたまり次第変更
     */

    private String timestamp;
    private String name;
    private int value;

    public Transaction(String time, String name, int val) {
        this.timestamp = time;
        this.name = name;
        this.value = val;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
