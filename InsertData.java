import java.io.*;

public class InsertData {

    public static void insertData() throws IOException {

        File file = new File("Data_Student.csv");

        // Step 1: Check if ID already exists
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        boolean id103Exists = false;
        boolean id104Exists = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("103,")) {
                id103Exists = true;
            }
            if (line.startsWith("104,")) {
                id104Exists = true;
            }
        }
        reader.close();

        // Step 2: Insert only if not present
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        if (!id103Exists) {
            writer.write("103,Khushie,AIML,87,77,92,89,88\n");
            System.out.println("Inserted ID 103");
        } else {
            System.out.println("ID 103 already exists, skipping...");
        }

        if (!id104Exists) {
            writer.write("104,Shriya,AIML,89,87,95,96,90\n");
            System.out.println("Inserted ID 104");
        } else {
            System.out.println("ID 104 already exists, skipping...");
        }

        writer.close();
    }
}