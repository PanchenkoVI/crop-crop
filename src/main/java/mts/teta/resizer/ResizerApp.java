package mts.teta.resizer;

import picocli.CommandLine;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.util.concurrent.Callable;
import java.io.File;

@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true, version = "resizer 0.0.1", description = "...")

public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {
    File inputFile;

    public static void main(String... args) {
        int exitCode = runConsole(args);
        System.exit(exitCode);
    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    void setInputFile(File absolutePathInput) {}
    void setOutputFile(File absolutePathOutput) {}
    void setResizeWidth(Integer reducedPreviewWidth) {}
    void setResizeHeight(Integer reducedPreviewHeight) {}
    void setQuality(int qltt) {}

    @Override
    public Integer call() throws Exception {

        if (inputFile == null)
            throw new IIOException("Can't read input file!");
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(ImageIO.read(inputFile), this);
        return 0;
    }
}