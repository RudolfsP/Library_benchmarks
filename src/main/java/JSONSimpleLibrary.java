import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileReader;
import java.util.Map;
import java.util.Set;

public class JSONSimpleLibrary extends Library {
    public JSONSimpleLibrary(String filePath) {
        super(filePath);
    }

    @Override
    public Object deserializeFile() {

        try {
            FileReader fileReader = new FileReader(this.deserializableFile);
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(fileReader);
            //allows to iterate over entrySet not keySet, entrySet is better when iterating over all elements
            Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();

            for (Map.Entry<String, Object> entry : entrySet) {
                Object tmpObject = entry.getValue();
                //System.out.println(tmpObject.toString());
            }

            fileReader.close();
            return jsonObject;

        } catch (Exception e) {
            System.out.println("Enter correct filepath");
            System.exit(0);
        }


        return null;
    }

    @Override
    public void serializeObject(Object o) {
        JsonObject jsonObject = (JsonObject) o;
        jsonObject.toJson();
        //System.out.println(jsonObject.toJson());
    }
}
