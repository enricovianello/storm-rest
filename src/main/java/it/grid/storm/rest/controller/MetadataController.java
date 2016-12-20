package it.grid.storm.rest.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataController {

  private static final String CHECKSUM = "checksum";

  @RequestMapping(value = "/metadata/", method = RequestMethod.GET)
  public String getFileMetadata(@RequestParam("path") final String path) throws IOException {
    Path filePath = Paths.get(path);

    StringBuffer out = new StringBuffer();
    out.append("GET " + filePath + "</br>");
    out.append("exists: " + Files.exists(filePath) + "</br>");
    if (Files.exists(filePath)) {

      UserDefinedFileAttributeView view = Files
          .getFileAttributeView(filePath, UserDefinedFileAttributeView.class);
      view.write(CHECKSUM, Charset.defaultCharset().encode("text/html"));
      
//      Files.setAttribute(filePath, CHECKSUM, "ADLER32:eajkrsj2", LinkOption.NOFOLLOW_LINKS);

      out.append("is.directory: " + Files.isDirectory(filePath) + "</br>");

      String checksum = (String) Files.getAttribute(filePath, CHECKSUM, LinkOption.NOFOLLOW_LINKS);
      out.append("checksum: " + checksum + "</br>");
    }

    return out.toString();
  }

}
