package mts.teta.resizer;

import picocli.CommandLine;

public class ConsoleAttributes {
    @CommandLine.Parameters
    public  String[] arg;
    @CommandLine.Option(names = {"--resize"}, description = "resize")
    public Integer[] reO;
    @CommandLine.Option(names = {"--quality"}, description = "quality")
    public double qltO;
    @CommandLine.Option(names = {"--crop"}, description = "crop")
    public Integer[] cpO;
    @CommandLine.Option(names = {"--blur"}, description = "blur")
    public int brO;
    @CommandLine.Option(names = {"--format"}, description = "format")
    public String ftO;
}
