import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Set;

public class FastjsonLibrary extends Library {
    public FastjsonLibrary(String filePath) {
        super(filePath);
    }

    @Override
    public Object deserializeFile() {
        try {
            File f = new File(this.deserializableFile);
            JSONObject jsonObject = JSON.parseObject(Files.readString(f.toPath()));
            //allows to iterate over entrySet not keySet, entrySet is better when iterating over all elements
            Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                Object tmpObject = entry.getValue();
//                System.out.println(tmpObject.toString());
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
        JSON.toJSONString(o);
        //JSON.toJSON(o).toString();
        //System.out.println(JSON.toJSONString(o));
    }
}
