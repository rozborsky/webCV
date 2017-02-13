package ua.rozborsky.classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by roman on 09.02.2017.
 */
public class DownloadCV {
    public DownloadCV() {
        File cvDirectory = new File("src/main/webapp/resources");
        String pathToCv = cvDirectory.getAbsolutePath();
        String cv = "cv.pdf";
        Path file = Paths.get(pathToCv, cv);

        if (Files.exists(file)) {
//            response.setContentType("application/pdf");
//            response.addHeader("Content-Disposition", "attachment; filename=roman_rozborsky_junior_java_developer.pdf");
//            try {
//                Files.copy(file, response.getOutputStream());
//                response.getOutputStream().flush();
//            } catch (IOException ex) {
//                ex.printStackTrace();//todo add log
//            }
        }
    }
}
