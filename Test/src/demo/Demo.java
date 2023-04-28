package demo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
	public static void main(String args[]) {
		Map<String, Integer> map = new HashMap<>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get("C:\\Users\\my\\Desktop\\Text.txt"));

			for (String line : allLines) {
				//System.out.println(line);
				String[] fields = line.toString().split("\\|");
				String[] authors = fields[0].split(",");
				String year = fields[3];
				for (String auth : authors) {
					
					String author = auth.trim();
					if (map.containsKey(author + "," + year)) {
						map.put(author.trim() + "," + year, map.get(author + "," + year) + 1);
					} else {
						map.put(author.trim() + "," + year, 1);
					}
						
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			String[] authorYear = entry.getKey().toString().split(",");
			String author = authorYear[0];
			String year = authorYear[1];
		

			System.out.println(author +" write " + entry.getValue() +" papers in "+ year);
		}
	}
}
