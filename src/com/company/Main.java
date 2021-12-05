package prak_23_24_part2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
        String csv = "/home/pasta/IdeaProjects/Prak_23_24/java_files/list.csv";
        String[] line;
        int sumincome = 0;
        int sumoutgo = 0;
        Map<String, Integer> map = new HashMap<>();
        String csvSplit = ", ";

        CSVReader reader = new CSVReader(new FileReader(csv));
        while((line = reader.readNext()) != null)
        {
            if(line != null)
            {
                String[] str = Arrays.toString(line).split(csvSplit);
                String bank = str[0].replace("[", "");
                String out = str[2].replace("]", "");
                String in = str[1];
                int a = Integer.parseInt(in.trim());
                int b = Integer.parseInt(out.trim());
                sumincome = sumincome + a;
                sumoutgo = sumoutgo + b;
                if(map.containsKey(bank)) {
                    map.put(bank, map.get(bank) + b);
                }
                else{
                    map.put(bank, b);
                }
            }
        }

        System.out.println("Сумма расходов: = " + sumoutgo);
        System.out.println("Сумма доходов: = " + sumincome);
        System.out.println("Сумма расходов по организациям");
        System.out.println(map);
    }
}
