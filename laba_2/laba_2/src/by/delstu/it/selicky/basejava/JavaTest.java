package by.delstu.it.selicky.basejava;

import person.Person;
import wrapper.*;

import javax.swing.text.BoxView;
import java.lang.Math.*;
import java.lang.reflect.Type;
import java.util.Arrays;

public class JavaTest {
    public static int sint;

    public final int int2 = 50;
    public static final int int3 = 152;


    /**
     *
     * @param args аргумент входящих данных
     * @throws java.io.FileNotFoundException проблемы с вводом или выводом
     * @return void
     *
     * */
    public static void main(String[] args) {
        /** Задание а and b*/
        Person pers = new Person();
        pers.Age=50;
        pers.getAge();

        /**
         *
         * @value 'o'
         * @see OtherClass#someMethod()
         *
         * */
        char simvl = 'o';

        int numb = 12;
        short litNumb = 11;
        byte moreLitlNumb = 7;
        long bigNumb = 370;
        boolean bool1 = true;
        double flatNumb = 7.491;

        String ansver = "hello ";
        System.out.println("string+int:\t" + (ansver + numb));

        String ansver2 = "hell";
        System.out.println("string+char:\t"+(ansver2 + simvl));

        String ansver3 = "hello ";
        System.out.println("string+double:\t"+(ansver3 + flatNumb));

        moreLitlNumb = (byte) (moreLitlNumb + numb);
        System.out.println("byte+int:\t"+(moreLitlNumb));

        numb = (int)(flatNumb + bigNumb);
        System.out.println("double+long:\t"+(numb));

        bigNumb = (numb + 2147483647l);
        System.out.println("numb+2147483647:\t"+ bigNumb);

        System.out.println("sint:\t"+sint);

        boolean bool2= false;
        System.out.println("true&&false:\t"+(bool1 && bool2));
        System.out.println("true XOR false:\t"+(bool1 ^ bool2));

        //bool1 + bool2 нельзя

        long first = 9223372036854775807l;
        long second = 0x7fff_ffff_fffl;
        System.out.println("first:\t"+(first));
        System.out.println("second:\t"+(second));

        char sim1 = 'a';
        char sim2 = '\u0061';
        char sim3 = 97;
        System.out.println("sim1:\t"+(sim1));
        System.out.println("sim2:\t"+(sim2));
        System.out.println("sim3:\t"+(sim3));
        System.out.println("sim1+sim2+sim3:\t"+(sim1+sim2+sim3));

        System.out.println("3.45%2.4:\t"+(3.45%2.4));
        System.out.println("1.0/0.0:\t"+(1.0/0.0));
        System.out.println("0.0/0.0:\t"+(0.0/0.0));
        System.out.println("log(-345):\t"+(Math.log(-345)));
        System.out.println("Float.intBitsToFloat(0x7F800000):\t"+(Float.intBitsToFloat(0x7F00000)));
        System.out.println("Float.intBitsToFloat(0x7FF800000):\t"+(Float.intBitsToFloat(0x7FF00000)));

        //десятичные 123, восьмиричные 0123, шеснадцатиричные 0х123

        /** Задание c*/
        final int int1 = 30;

        /** Задание d*/
        double pi = Math.PI;
        double e = Math.E;

        System.out.println("Pi:\t"+pi);
        System.out.println("E:\t"+e);
        System.out.println("round Pi:\t"+ Math.round(pi));
        System.out.println("round E:\t" + Math.round(e));
        System.out.println("min Pi E:\t" + Math.min(pi,e));
        System.out.println("Random:\t" + Math.random());

        /** Задание e*/
        Boolean classBool = true;
        Character classChar = 'j';
        Integer classInt = 40;
        Byte classByte = 0;
        Short classShort = 70;
        Long classLong = 120l;
        Double classDouble = 40.1;

        System.out.println("classLong<<2:\t"+(classLong<<2));
        System.out.println("classBool||true:\t"+(classBool||true));
        System.out.println("classInt+classByte:\t"+(classInt+classByte));
        System.out.println("classDouble * classLong:\t"+(classDouble * classLong));

        System.out.println("Long.MAX_VALUE:\t"+(Long.MAX_VALUE));
        System.out.println("Long.MIN_VALUE:\t"+(Long.MIN_VALUE));
        System.out.println("Double.MAX_VALUE:\t"+(Double.MAX_VALUE));
        System.out.println("Double.MIN_VALUE:\t"+(Double.MIN_VALUE));

        int startInt =40;
        Integer endInt = Integer.valueOf(startInt);
        startInt = endInt.intValue();

        byte startByte = 40;
        Byte endByte = Byte.valueOf(startByte);
        startByte = endByte.byteValue();

        Integer.parseInt("19");      //перевод из сторки в число
        Integer.toString(1233);     //перевод из числа в строку
        Integer.toHexString(19);     //перевод в шеснадцатричную форму
        Integer.compare(20,19);        //сравнение двух чисел

        /** Задание f*/
        String strNumb = "2345";
        int numb1 = Integer.valueOf(strNumb);
        int numb2 = Integer.parseInt(strNumb);

        boolean b1 = Boolean.parseBoolean(strNumb);
        boolean b2 = Boolean.valueOf(strNumb);

        byte[] bytes = strNumb.getBytes();
        strNumb = new String(bytes);

        String text1="hello";
        String text2="hello";

        for(int i = 0; i < 2; i++) {
            System.out.println(text1 == text2);
            System.out.println(text1.equals(text2));
           // System.out.println(text1.compareTo(text2));
            text2 = null;
        }

        String proxz = "Helle World";

        int i = 0;
        for(String str:proxz.split(" "))
        {
            System.out.println((++i)+") "+str);
        }
        System.out.println(proxz.contains("Wo"));
        System.out.println(proxz.hashCode());
        System.out.println(proxz.indexOf("e "));
        System.out.println(proxz.length());
        System.out.println(proxz.replace('e','o'));

        /** Задание g*/
        char[][] c1 = new char[3][];
        char[] c2[] = new char[4][];
        char c3[][] = new char[4][];

        for(i = 0; i < 3; i++)
        {
            c1[i] = new char[i+1];
        }

        System.out.println(c1.length);
        for(char[] arr:c1)
        {
            System.out.println(arr.length);
        }

        System.out.println(c2==c3);
        c2 = c3;
        boolean bool4 = c2==c3;
        System.out.println(bool4);

        for(char[] kk:c1)
        {
            for(char ll:kk)
            {
                System.out.print(ll);
            }
        }
        //c1[5][0] = 10;

        /** Задание h*/
        WrapperString wrapper = new WrapperString("hello");
        System.out.println(wrapper.getPrivateStr());
        wrapper.setPrivateStr("Hello World");
        System.out.println(wrapper.getPrivateStr());

        String help = "Hello World";

        System.out.println(wrapper.equals(help));
        System.out.println(wrapper.hashCode() );
        System.out.println(wrapper.toString());

        wrapper.replac('o','O');
        System.out.println(wrapper.getPrivateStr());

        var replaceDel = new WrapperString("Hallo all"){
            @Override
            public void replac(char oldchar, char newchar) {
                System.out.print("was = " + super.getPrivateStr());
                super.replac(oldchar, newchar);
                System.out.println("became = " + super.getPrivateStr());
            }
            public void delete(char chr)
            {
                System.out.print("was = " + super.getPrivateStr());
                super.replac(chr, ' ');
                System.out.println("became = " + super.getPrivateStr());
            }
        };

        replaceDel.replac('l', '1');
        replaceDel.delete('a');
    }
}

