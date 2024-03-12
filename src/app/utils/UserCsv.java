package app.utils;


import java.io.*;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.Paths;
import app.config.Config;
import app.entitys.User;

public class UserCsv {
    String header;
    public LinkedHashMap<String, User> getDataCsv() throws IOException {
        LinkedHashMap<String, User> productsData = new LinkedHashMap<>();
        ArrayList<List<String>> records = readCsv();
        if (records.isEmpty()) {
            return productsData;
        }
        for (List<String> record : records) {
            productsData.put(
                    record.get(0),
                    new User(
                            record.get(0), // email
                            record.get(1), // username
                            record.get(2), // phone
                            record.get(3), // name
                            record.get(4), // salt
                            record.get(5), // passwordHash
                            Boolean.parseBoolean(record.get(6)), // isActive
                            Boolean.parseBoolean(record.get(7)), // isAdmin
                            Long.parseLong(record.get(8)), // createTimestamp
                            Long.parseLong(record.get(9)) // updateTimestamp
                    )
            );
        }
        return productsData;
    }

    private ArrayList<List<String>> readCsv() throws IOException {
        String path = Config.ABS_USER_FILE_PATH;
        List<List<String>> records = new ArrayList<>();
        String headerLine;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            header = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(Config.CSV_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        ArrayList<List<String>> units = new ArrayList<>(records);
        return units;
    }

    public void writeCsv(LinkedHashMap<String, User> users) throws IOException {
        Path pathToFile = Paths.get(Config.ABS_USER_FILE_PATH);

        try (FileWriter writer = new FileWriter(pathToFile.toAbsolutePath().toString())) {
            writer.write(header);
            writer.write("\n");
            for (Map.Entry<String, User> entry : users.entrySet()) {
                User userData = entry.getValue();
                writer.write(toCsvLine(userData));
                writer.write("\n");
            }
        }
    }

    private static String toCsvLine(User userData) {
        StringJoiner csvLine = new StringJoiner(",");
        csvLine.add(userData.getEmail())
                .add(userData.getUsername())
                .add(userData.getPhone())
                .add(userData.getName())
                .add(userData.getSalt())
                .add(userData.getPasswordHash())
                .add(String.valueOf(userData.isActive()))
                .add(String.valueOf(userData.isAdmin()))
                .add(String.valueOf(userData.getCreateTimestamp()))
                .add(String.valueOf(userData.getUpdateTimestamp()));

        return csvLine.toString();
    }
}
