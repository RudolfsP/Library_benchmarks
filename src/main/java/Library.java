import java.util.Calendar;

public abstract class Library {
    protected String deserializableFile;
    protected Object serializableObject;

    public Library(String filePath) {
        this.deserializableFile = filePath;
    }

    public abstract Object deserializeFile();
    public abstract void serializeObject(Object o);


    public void runDeserialize(int runCount) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < runCount; i++) {
            this.deserializeFile();
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format("%s,%s", this.getClass().getName(), (endTime - startTime)));
    }

    public void runSerialize(int runCount) {
        Object o = deserializeFile();
        long startTime = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < runCount; i++) {
            this.serializeObject(o);
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format("%s,%s", this.getClass().getName(), (endTime - startTime)));
    }

}
