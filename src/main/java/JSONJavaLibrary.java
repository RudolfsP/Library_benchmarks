import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

public class JSONJavaLibrary extends Library {
    public JSONJavaLibrary(String filePath) {
        super(filePath);
    }

    @Override
    public Object deserializeFile() {
        try {
            File f = new File(this.deserializableFile);
            JSONObject jsonObject = new JSONObject(Files.readString(f.toPath()));
            Set<String> keySet = jsonObject.keySet();

            for(String key : keySet){
                Object tempObj = jsonObject.get(key);
                //System.out.println(jsonObject.get(key));
            }

            return jsonObject;

        } catch (IOException e) {
            System.out.println("Enter correct filepath");
            System.exit(0);
        }
        return null;
    }

    @Override
    public void serializeObject(Object o) {
        JSONObject jsonObject = (JSONObject) o;
        jsonObject.toString();
        //System.out.println(jsonObject.toString());
    }
}
