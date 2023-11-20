package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudyStreams
{
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Razzy");
        names.add("Atukbey");
        names.add("Abdul");
        names.add("Yao");
        names.add("Gabriella");
        names.add("Zeni");
        names.add("Amir");

        int count  = 0;
        for(int i = 0; i < names.size(); i++)
        {
            String actual = names.get(i);
            if(actual.startsWith("A"))
            {
                count++;
            }
        }

        System.out.println(count);
    }

    @Test
    public void streamFilter()
    {

        ArrayList<String> names = new ArrayList<>();
        names.add("Razzy");
        names.add("Atukbey");
        names.add("Abdul");
        names.add("Yao");
        names.add("Gabriella");
        names.add("Zeni");
        names.add("Amir");
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        long d = Stream.of("Kusi", "Kwame", "Adjei", "Annan").filter(s ->
        {
            s.startsWith("K");
            return true;
        }).count();
        System.out.println(d);

        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap()
    {
        //print names which have last letter as "a" with Uppercase
        Stream.of("Joane", "Auiba", "Shane", "Kofi Yesu", "Arda").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        //print names which have first letter as "a" with upper case and sorted
        List<String> names1 = Arrays.asList("Joane", "Auiba", "Shane", "Kofi Yesu", "Arda");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
                .forEach(s ->System.out.println(s));
        ArrayList<String> names = new ArrayList<>();
        names.add("Razzy");
        names.add("Atukbey");
        names.add("Abdul");
        names.add("Yao");
        names.add("Gabriella");
        names.add("Zeni");
        names.add("Amir");

      //merging streams
      Stream<String> newStream =  Stream.concat(names.stream(), names1.stream());
    //  newStream.sorted().forEach(s -> System.out.println(s));
      boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Yao"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect()
    {
      List<String> newList =  Stream.of("Joane", "Auiba", "Shane", "Kofi Yesu", "Arda", "Salama", "Rafiha").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(newList.get(0));

        List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        // print unique value from the array
        values.stream().distinct().forEach(s -> System.out.println(s));
        List<Integer> sortedValue = values.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(sortedValue.get(2));

    }
}
