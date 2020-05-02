import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class paserWebmd {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("webmd_faq.json"))
        {
            //Read JSON file
            Object obj = parser.parse(reader);

            JSONArray faqs = (JSONArray) obj;
            //System.out.println(faqs);

            int count = 1;
            // Iterate over employee array
            for(int i = 0; i < faqs.size(); i++) {
                parseFAQObject((JSONObject) faqs.get(i), count);
                count++;
            }

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseFAQObject(JSONObject faq, int count)
    {
        StringBuilder builder = new StringBuilder();


//        //question
//        String question = "## intent:quest/";
//        builder.append(question);
//        builder.append(String.valueOf(count));
//        builder.append("\n");
//        builder.append("- ");
//        builder.append(faq.get("question").toString());
//        builder.append("\n");

        //answer
//        String answer = "utter_quest_";
//        builder.append(answer);
//        builder.append(String.valueOf(count));
//        builder.append(": \n");
//        builder.append("- ");
//        builder.append(faq.get("response").toString());
//        builder.append("\n");


//        // stories
//        String header = "## story_quest" + count+ "\n* quest" + count + "\n  - utter_quest";
//        builder.append(header + "_" + count + "\n");
//        builder.append("  - action_restart \n");
//        String answer = "* faq/";

        //intent
        String header = "quest";
        builder.append("- " + header+ count);


        System.out.println(builder.toString());
        
    }
}
