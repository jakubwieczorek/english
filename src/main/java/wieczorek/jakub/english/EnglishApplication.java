package wieczorek.jakub.english;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wieczorek.jakub.english.service.FileParser;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class EnglishApplication implements CommandLineRunner
{
    private final FileParser fileParser;

    @Autowired
    public EnglishApplication(FileParser fileParser)
    {
        this.fileParser = fileParser;
    }

    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(EnglishApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... aArgs) throws Exception
    {
        if(aArgs.length == 0)
        {
            System.out.println("give a path and filename as argument");
            return;
        }

        String path = aArgs[0];

        List<String> lines;

        try
        {
            lines = fileParser.parseFile(path);
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        Random randomGenerator = new Random();

        while(!lines.isEmpty())
        {
            String line = lines.get(randomGenerator.nextInt(lines.size()));
            System.out.println(line);

            lines.remove(line);

            System.in.read();
        }
    }
}
