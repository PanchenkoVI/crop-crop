package mts.teta.resizer;

import picocli.CommandLine;

public class ConsoleAttributes {
    @CommandLine.Parameters
    String[] arg;
    @CommandLine.Option(names = {"--resize"}, split = ",", description = "resize")
    public Integer[] re;
    @CommandLine.Option(names = {"--quality"}, description = "quality")
    public Integer[] qlt;
    @CommandLine.Option(names = {"--crop"}, split = ",", description = "crop")
    public Integer[] cp;
    @CommandLine.Option(names = {"--blur"}, description = "blur")
    public Integer[] br;
    @CommandLine.Option(names = {"--format"}, description = "format")
    public String[] ft;
}
