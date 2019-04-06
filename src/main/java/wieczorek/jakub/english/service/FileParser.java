package wieczorek.jakub.english.service;

import java.io.IOException;
import java.util.List;

public interface FileParser
{
    List<String> parseFile(String aFileName) throws IOException;
}
