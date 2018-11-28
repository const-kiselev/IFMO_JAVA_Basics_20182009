package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {
    int bottleTakenAtOnce;
    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        if(bottleTakenAtOnce > 99)
            throw new IllegalArgumentException();
        else if(bottleTakenAtOnce <= 0)
            throw new IllegalArgumentException();


        String result = "";
        String numOfTakenBottles = numSpelling(this.bottleTakenAtOnce);
        for(int i=99; i>0;i-=bottleTakenAtOnce){
            if(i<bottleTakenAtOnce)
                numOfTakenBottles = numSpelling(i);
            result += Integer.toString(i);
            if (i>1)
                result += " bottles of beer on the wall, " + Integer.toString(i) + " bottles of beer.\n";
            else
                result += " bottle of beer on the wall, " + Integer.toString(i) + " bottle of beer.\n";

            result += "Take " + numOfTakenBottles + " down and pass around, ";
            if(i-bottleTakenAtOnce == 1)
                result += "1 bottle of beer on the wall.\n";
            else if(i-bottleTakenAtOnce > 1)
                result += Integer.toString(i-bottleTakenAtOnce)+" bottles of beer on the wall.\n";
        }
        result += "no more bottles of beer on the wall.\n" + "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        return result;


    }

    private String numSpelling(int num){
        int first = num / 10,
                second = num%10;
        String result;
        String[] ten = {"ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"};
        String[] s = {"","one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};
        String[] f = {"", "ten", "twenty", "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety"};

        if(first !=1) {
            result = f[first];
            if(second>0 && first >0)
                result += " ";
            result += s[second];
        }
        else
            result = ten[second];
        return result;
    }

}
