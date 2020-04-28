import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static com.google.gson.JsonParser.parseReader;

public class GsonLibrary extends Library {
    public GsonLibrary(String filePath) {
        super(filePath);
    }

    @Override
    public Object deserializeFile() {
        try {
            FileReader fileReader = new FileReader(this.deserializableFile);
            JsonElement jsonElement = parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //allows to iterate over entrySet not keySet, entrySet is better when iterating over all elements
            Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
            for (Map.Entry<String, JsonElement> entry : entrySet) {
                JsonElement value = entry.getValue();
                //System.out.println(value.toString());
            }

            fileReader.close();
            return jsonObject;

        } catch (IOException e) {
            System.out.println("Enter correct filepath");
            System.exit(0);
        }
        return null;
    }

    @Override
    public void serializeObject(Object o) {
        Gson gson = new GsonBuilder().create();
        gson.toJson(o);
        //System.out.println(gson.toJson(o));
    }
}
