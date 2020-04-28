import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JacksonLibrary extends Library {

    public JacksonLibrary(String filePath) {
        super(filePath);
    }

    @Override
    public Object deserializeFile() {
        try {
            FileReader fileReader = new FileReader(this.deserializableFile);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(fileReader);
            Iterator<JsonNode> iterator = jsonNode.elements();

            while(iterator.hasNext()) {
                JsonNode currentNode = iterator.next();
                //System.out.println(currentNode.toPrettyString());
            }

            fileReader.close();
            return jsonNode;

        } catch (IOException e) {
            System.out.println("Enter correct filepath");
            System.exit(0);
        }
        return null;
    }

    @Override
    public void serializeObject(Object o) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValueAsString(o);
            //System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
