package mts.teta.resizer;

import java.io.File;
import picocli.CommandLine;
import javax.imageio.IIOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true, version = "resizer 0.0.1", description = "...")

public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {
    File inputFile;
    File outputFile;

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    private String[] getString() {
        if(arg == null) {
            arg = new String[2];
        }
        return arg;
    }

    private Integer[] getInter() {
        if(reO == null) {
            reO = new Integer[2];
        }
        return reO;
    }

    public void setInputFile(File file) {
        if(file.exists()) {
            inputFile = file;
            getString();
            arg[0] = file.getName();
        }
    }

    public void setOutputFile(File file) {
        outputFile = file;
        getString();
        arg[1] = file.getName();
    }

    public void setResizeWidth(Integer reducedPreviewWidth) {
        getInter();
        reO[0] = reducedPreviewWidth;
    }

    public void setResizeHeight(Integer reducedPreviewHeight) {
        getInter();
        reO[1] = reducedPreviewHeight;
    }

    public void setQuality(int qt) {
        qltO = qt;
    }

    @Override
    public Integer call() throws Exception {

        if (inputFile == null)
            throw new IIOException("Can't read input file!");
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(this);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = runConsole(args);
        System.exit(exitCode);
    }
}