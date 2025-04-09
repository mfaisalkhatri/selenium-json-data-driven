package io.github.mfaisalkhatri.data;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

public class RegistrationDataBuilder {

    public List<RegistrationData> registrationData (final boolean isValid)  {
        final Gson gson = new Gson ();
        final TestData testData;
        try (
            final Reader reader = new FileReader(
                Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testdata.json").toString())) {
            testData = gson.fromJson (reader, TestData.class);
        } catch (final IOException e) {
            throw new Error ("Error reading json file", e);
        }

        return testData.getRegistrationData ()
            .stream ()
            .filter (d -> d.isValid () == isValid)
            .toList ();
    }

}
