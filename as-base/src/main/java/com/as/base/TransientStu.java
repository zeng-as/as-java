package com.as.base;

import com.sun.org.apache.xml.internal.serializer.Serializer;
import com.sun.org.apache.xml.internal.serializer.ToTextStream;
import com.sun.org.apache.xml.internal.serializer.ToXMLStream;

import java.io.*;
import java.text.MessageFormat;

/**
 * @author as.
 * @since 2021/1/8
 */
public class TransientStu {
    static class ClassA implements Serializable {
        private static final long serialVersionUID = -5715450331618672663L;

        int a;
        transient String b;

        public ClassA(int a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "ClassA{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassA a = new ClassA(1, "asd");
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\88452\\Desktop\\ClassA.txt"));
        oos.writeObject(a);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\88452\\Desktop\\ClassA.txt"));
        ClassA o = (ClassA) ois.readObject();
        System.out.println(o.b);
        System.out.println(o);
    }
}
