package mts.teta.resizer;

import java.io.File;
import java.io.IOException;
import mts.teta.resizer.imageprocessor.BadAttributesException;

public class ClassFormat {
    File inputFile;
    private int ind = 0;
    private String tmp;
    private String newFile;
    private String widening;

    ClassFormat(String[] arg, String format) throws IOException, BadAttributesException {

        if(arg.length != 2 || arg[0] == null || arg[1] == null)
            ind = -1;
        else if (format != "PNG" && format != "JPEG")
            ind = -1;
        if (ind == -1)
            throw new BadAttributesException("Please check params!");
        tmp = inputFile.getCanonicalPath();
        ind = tmp.lastIndexOf(".");
        if(ind == tmp.length() - 1)
            throw new BadAttributesException("Error in filename.");
        widening = tmp.substring(ind, tmp.length());
        if (format == "JPEG")
            newFile = tmp.replace(widening, ".jpeg");
        else
            newFile = tmp.replace(widening, ".png");
        File test  = new File(tmp);
        if (!test.renameTo(new File(newFile)))
            throw new BadAttributesException("Error in ClassFormat.");
    }
}
