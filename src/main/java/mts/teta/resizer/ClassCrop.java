package mts.teta.resizer;

import java.io.File;
import marvin.io.MarvinImageIO;
import marvin.image.MarvinImage;
import static marvinplugins.MarvinPluginCollection.crop;
import mts.teta.resizer.imageprocessor.BadAttributesException;

public class ClassCrop {
    private int flag = 0;
    private MarvinImage mnImage;

    ClassCrop(Integer[] crop, String arg, File inputFile, File outputFile) throws BadAttributesException {

        if (crop.length != 4 || inputFile == null)
            flag = -1;
        else if (crop[0] < 0 || crop[1] < 0)
            flag = -1;
        else if (crop[0] > 2147483647 || crop[1] > 2147483647)
            flag = -1;
        if (flag == -1)
            throw new BadAttributesException("Please check params!");
        if(outputFile != null) {
            mnImage = MarvinImageIO.loadImage(arg);}
        else {
            outputFile = new File(arg);
            mnImage = MarvinImageIO.loadImage(outputFile.getName());
        }
        crop(mnImage.clone(), mnImage, crop[0], crop[1], crop[2], crop[3]);
        MarvinImageIO.saveImage(mnImage,outputFile.getName());
    }
}
