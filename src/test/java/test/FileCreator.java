package test;

import mat.Gender;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileCreator {

    public void deleteFileWithGivenPathString(String filePath) {
        // cleaning after testing
        assert filePath != null;
        File myObj = new File(filePath);
        myObj.delete();
    }

    public String createFileWithGivenTokens(List<String> searchedNames,Gender gender) {
        try {
            File resourcesDirectory = new File("src/test/resources/"+gender+".txt");
            Path resourceDirectory = Paths.get("src","test", "resources" , gender + ".txt");
            Path write = Files.write(resourceDirectory, searchedNames, StandardCharsets.UTF_8);
            return resourceDirectory.toAbsolutePath().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
