import java.io.*;
import java.util.*;
public class WordAnalyzer{
	public static void main(String[]args){
		StringBuilder content = new StringBuilder();
		try(BufferedReader reader=new BufferedReader(new FileReader("input.txt"))){
			String line;
			while ((line =reader.readLine())!=null){
				content.append(line).append(" ");
			}
			String text = content.toString().toLowerCase();
            text = text.replaceAll("[^a-z0-9\\s]", " ");
            String[] words = text.trim().split("\\s+");
            int totalWords = words.length;
			int totalCharacters = content.toString().trim().length();
			String[] sentences=content.toString().split("[.!?]+");
			int totalSentences = 0;
			for(String sentence : sentences){
				if(!sentence.trim().isEmpty()){
					totalSentences++;
				}
			}
			double averageLength=(double)totalWords/totalSentences;
			
            Set<String> uniqueWords = new HashSet<>();

            for (String word : words) {
                uniqueWords.add(word);
				
            }
			System.out.println("FILE CONTENT:");
			System.out.println(content);
			System.out.println("\nTotal Words: " + totalWords);

            System.out.println("Unique Words: " + uniqueWords.size());
			System.out.println("Total Characters:"+totalCharacters);
			System.out.println("Total Sentences:"+totalSentences);
			System.out.printf("Average Sentence Length:%.2f%n",averageLength);
			Map<String,Integer>frequency=new HashMap<>();
			for(String word : words){
				frequency.put(word,frequency.getOrDefault(word,0)+1);
			}
			List<Map.Entry<String,Integer>>sortedWords=new ArrayList<>(frequency.entrySet());
			sortedWords.sort((a,b) -> b.getValue().compareTo(a.getValue()));
			System.out.println("\nTOP 10 MOST FREQUENT WORDS:");
			for (int i=0;i<Math.min(10,sortedWords.size());i++){ 
				System.out.println(sortedWords.get(i).getKey()+":"+sortedWords.get(i).getValue());

			}
        }
		catch (IOException e) {
            System.out.println("Error reading file!");
        }

    }
}
		
	

		