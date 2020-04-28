import javax.json.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class JSONPLibrary extends Library {
    public JSONPLibrary(String filePath) {
        super(filePath);
    }

    @Override
    public Object deserializeFile() {
        try {
            FileReader fileReader = new FileReader(this.deserializableFile);
            JsonReader jsonReader = Json.createReader(fileReader);
            JsonObject jsonObject = jsonReader.readObject();

            Set<Map.Entry<String, JsonValue>> entrySet = jsonObject.entrySet();
            for (Map.Entry<String, JsonValue> entry : entrySet) {
                JsonValue jsonValue = entry.getValue();
                //System.out.println(jsonValue.toString());
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
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder((JsonObject) o);
        JsonObject jsonObject = objectBuilder.build();
        jsonObject.toString();
        //System.out.println(jsonObject.toString());
    }
}
