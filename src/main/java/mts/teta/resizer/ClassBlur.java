package mts.teta.resizer;

import java.io.File;
import marvin.io.MarvinImageIO;
import marvin.image.MarvinImage;
import mts.teta.resizer.imageprocessor.BadAttributesException;
import static marvinplugins.MarvinPluginCollection.gaussianBlur;

public class ClassBlur {
    private int i = 0;
    private MarvinImage mnImage;

    ClassBlur(int blur, File inputFile, File outputFile, String arg) throws BadAttributesException {

        if (inputFile == null)
            i = -1;
        else if (blur < 0 || blur > 2147483647)
            i = -1;
        if (i == -1)
            throw new BadAttributesException("Please check params!");
        if(outputFile == null) {
            outputFile = new File(arg);
            mnImage = MarvinImageIO.loadImage(outputFile.getName());
        }
        else
            mnImage = MarvinImageIO.loadImage(arg);
        gaussianBlur(mnImage.clone(), mnImage, blur);
        MarvinImageIO.saveImage(mnImage, outputFile.getName());
    }
}