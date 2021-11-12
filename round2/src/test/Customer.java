package test;

import java.time.LocalDate;

public class Customer {
    public int rua;
    public String name;
    public LocalDate time;

    public Customer(int rua, String name, LocalDate time) {
        this.rua = rua;
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name" + name +
                ", rua='" + rua + '\'' +
                ", time=" + time +
                '}';
    }
}
