package wieczorek.jakub.english.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FileParserImpl implements FileParser
{
    @Override
    public List<String> parseFile(String aFileName) throws IOException
    {
        List<String> finalLines = Files.readAllLines(Paths.get(aFileName), Charset.forName("ISO-8859-1"));

        Predicate<String> meaningLineCondition = line -> finalLines.stream().anyMatch((nothing) -> line.contains("Meaning"));

        return finalLines.stream().filter(meaningLineCondition).collect(Collectors.toList());
    }
}
